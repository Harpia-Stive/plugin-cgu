package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.ServidorImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.config.AtualizaParametros;
import com.harpia.stive.domain.model.CadastroServidorDTO;
import com.harpia.stive.domain.model.RemuneracaoDTO;
import com.harpia.stive.domain.model.RubricaDTO;
import com.harpia.stive.domain.model.ServidorRemuneracaoDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.ServidoresDoPoderExecutivoFederalApi;
import com.harpia.stive.util.Util;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServidorResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private ServidoresDoPoderExecutivoFederalApi servidorApi = new ServidoresDoPoderExecutivoFederalApi();

    private ServidorImplContrato servidorImplContrato = new ServidorImplContrato();

    @ApiOperation(value = "Consulta Servidor do Executivo Federal")
    //"consulta/govbr/govbr_servidores/busca"
    @RequestMapping(value = ContratoApi.CONSULTA_SERVIDORES_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaServidor(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "idServidorAposentadoPensionista", required = false) Integer idServidorAposentadoPensionista,
            @RequestParam(value = "mesAno", required = false) String mesAno,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores #RequestParam# cpf: " + cpf + ", id: " + idServidorAposentadoPensionista + ", mesAno: " + mesAno);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores #RequestBody# " + request);

        String codigoFuncaoCargo = null;
        String nome = null;
        String orgaoServidorExercicio = null;
        String orgaoServidorLotacao = null;
        Integer situacaoServidor = null;
        Integer tipoServidor = null;

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (idServidorAposentadoPensionista == null) {
                idServidorAposentadoPensionista = param.getIdServidorAposentadoPensionista();
            }

            if (StringUtils.isBlank(mesAno)) {
                mesAno = param.getMesAno();
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

        }

        int pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        final Integer finalId = idServidorAposentadoPensionista;

        //Verifica se vai retornar o dados do servidor ou da remuneracao
        if (StringUtils.isBlank(busca) || busca.equals("servidores")) {

            //Retorna os dados do servidor
            ApiResponse<CadastroServidorDTO> retornoApiGov = null;
            List<CadastroServidorDTO> servidores = new ArrayList<>();
            ApiResponse<List<CadastroServidorDTO>> servidorWithHttpInfo = null;

            do {

                try {

                    servidorWithHttpInfo = servidorApi.dadosServidoresUsingGETWithHttpInfo(chaveApiDados, pagina,
                            codigoFuncaoCargo, cpf, nome, orgaoServidorExercicio, orgaoServidorLotacao,
                            situacaoServidor, tipoServidor);

                    if (servidorWithHttpInfo.getData().size() > 0) {
                        servidores.addAll(servidorWithHttpInfo.getData());
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (servidorWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (CadastroServidorDTO s : servidores) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoServidor(s, cpf, mesAno, "cpf"));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("remuneracao")) {

            //Retorna a remuneracao do servidor
            if (StringUtils.isBlank(mesAno)) {
                mesAno = AtualizaParametros.getAnoMesRemuneracaoServidores().toString();
            }

            Integer anoMes = Util.trataMesAno(mesAno);

            CadastroServidorDTO retorno = null;

            List<ServidorRemuneracaoDTO> listRetorno = new ArrayList<>();
            ApiResponse<List<ServidorRemuneracaoDTO>> remuneracaoWithHttpInfo = null;

            do {

                try {

                    remuneracaoWithHttpInfo = servidorApi.remuneracoesServidoresUsingGETWithHttpInfo(chaveApiDados, anoMes, pagina, cpf, idServidorAposentadoPensionista);

                    if (!remuneracaoWithHttpInfo.getData().isEmpty()) {
                        listRetorno.addAll(remuneracaoWithHttpInfo.getData());
                    }

                } catch (ApiException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (remuneracaoWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (ServidorRemuneracaoDTO s : listRetorno) {

                if (s.getRemuneracoesDTO() != null) {
                    
                    for (RemuneracaoDTO r : s.getRemuneracoesDTO()) {

                        if (r != null) {

                            try {

                                resultados.add(servidorImplContrato.retornaResultadoRemuneracaoServidor(r, cpf, mesAno, idServidorAposentadoPensionista));

                            } catch (NoSuchAlgorithmException ex) {

                                Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                        }

                    }
                }
            }

            //Rubricas
        } else if (StringUtils.isNotBlank(busca) && busca.equals("rubrica")) {

            //Retorna as rubricas da remuneracao do servidor
            if (StringUtils.isBlank(mesAno)) {
                mesAno = AtualizaParametros.getAnoMesRemuneracaoServidores().toString();
            }

            Integer anoMes = Util.trataMesAno(mesAno);

            CadastroServidorDTO retorno = null;

            List<ServidorRemuneracaoDTO> listRetorno = new ArrayList<>();
            ApiResponse<List<ServidorRemuneracaoDTO>> remuneracaoWithHttpInfo = null;

            do {

                try {

                    remuneracaoWithHttpInfo = servidorApi.remuneracoesServidoresUsingGETWithHttpInfo(chaveApiDados, anoMes, pagina, cpf, idServidorAposentadoPensionista);

                    if (!remuneracaoWithHttpInfo.getData().isEmpty()) {
                        listRetorno.addAll(remuneracaoWithHttpInfo.getData());
                    }

                } catch (ApiException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (remuneracaoWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            List<ServidorRemuneracaoDTO> remenuracoesServidorFilter = listRetorno.stream().filter(rem -> rem.getServidor().getId().equals(finalId)).collect(Collectors.toList());

            for (ServidorRemuneracaoDTO s : listRetorno) {

                for (RemuneracaoDTO r : s.getRemuneracoesDTO()) {

                    for (RubricaDTO ru : r.getRubricas())

                    try {

                        resultados.add(servidorImplContrato.retornaResultadoRubricaRemuneracaoServidor(ru, cpf, mesAno, idServidorAposentadoPensionista, "cpf"));

                    } catch (NoSuchAlgorithmException ex) {

                        Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }

            }
        }

        Retorno retorno = new Retorno();
        retorno.setVersaoProtocolo(ContratoApi.VERSAO_PROTOCOLO);
 
        if (resultados.size() < 1) {

            retorno.setResultado(new ArrayList<>());
            return new ResponseEntity<>(retorno, HttpStatus.OK);

        }

       
        retorno.setResultado(resultados);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
