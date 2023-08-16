package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.ContratosExecutivoFederalImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.ContratoDTO;
import com.harpia.stive.domain.model.EmpenhoComprasDTO;
import com.harpia.stive.domain.model.ItemContratadoDTO;
import com.harpia.stive.domain.model.TermoAditivoDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.ContratosDoPoderExecutivoFederalApi;
import com.harpia.stive.util.Util;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ContratosResource {

    private static final Integer TAMANHO_PAGINA = 10;
     //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private ContratosDoPoderExecutivoFederalApi contratosApi = new ContratosDoPoderExecutivoFederalApi();

    private ContratosExecutivoFederalImplContrato contratosExecutivoFederalImplContrato = new ContratosExecutivoFederalImplContrato();

    @ApiOperation(value = "Consulta Servidor do Executivo Federal")

    @RequestMapping(value = ContratoApi.CONSULTA_CONTRATOS_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaContratos(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores #RequestParam# cpf: " + cpf + ", id: " + id + ", cnpj: " + cnpj + ", busca: " + busca);

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

            if (StringUtils.isBlank(cnpj)) {
                cnpj = Util.getNumerics(param.getCnpj());
            }

            if (id == null) {
                id = param.getId();
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

        }

        int pagina = 1;

        String cpf_cnpj = null;

        if (cpf != null) {
            cpf_cnpj = cpf;
        } else {
            cpf_cnpj = cnpj;
        }

        List<Resultado> resultados = new ArrayList<>();

        final Integer finalId = id;

        if (StringUtils.isBlank(busca) || busca.equals("contratos")) {

            List<ContratoDTO> contratosPorCpfCnpj = new ArrayList<>();

            ApiResponse<List<ContratoDTO>> contratoPorCpfCnpjUsingGET = null;

            do {

                try {

                    contratoPorCpfCnpjUsingGET = contratosApi.contratoPorCpfCnpjUsingGETWithHttpInfo(chaveApiDados, cpf_cnpj, pagina);

                    if (contratoPorCpfCnpjUsingGET.getData().size() > 0) {
                        contratosPorCpfCnpj.addAll(contratoPorCpfCnpjUsingGET.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (contratoPorCpfCnpjUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

            for (ContratoDTO s : contratosPorCpfCnpj) {

                try {

                    resultados.add(contratosExecutivoFederalImplContrato.retornaResultadoContratosExecutivoFederal(s, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ContratosResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("itens")) {

            List<ItemContratadoDTO> itemContratados = new ArrayList<>();

            ApiResponse<List<ItemContratadoDTO>> itensContratadosUsingGET = null;

            do {

                try {

                    itensContratadosUsingGET = contratosApi.itensContratadosUsingGETWithHttpInfo(chaveApiDados, id, pagina);

                    if (!itensContratadosUsingGET.getData().isEmpty()) {
                        itemContratados.addAll(itensContratadosUsingGET.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (itensContratadosUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

            for (ItemContratadoDTO s : itemContratados) {

                try {

                    resultados.add(contratosExecutivoFederalImplContrato.retornaResultadoContratosExecutivoFederalItens(s, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ContratosResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

            //Aditivos
        } else if (StringUtils.isNotBlank(busca) && busca.equals("aditivos")) {

            ApiResponse<List<TermoAditivoDTO>> termosAditivosDoContratoUsingGET = null;

            try {

                termosAditivosDoContratoUsingGET = contratosApi.termosAditivosDoContratoUsingGETWithHttpInfo(chaveApiDados, id);

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("empenhos")) {

            ApiResponse<List<EmpenhoComprasDTO>> empenhos = null;

            try {

                empenhos = contratosApi.documentosRelacionadosAoContratoUsingGETWithHttpInfo(chaveApiDados, id);

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            for (EmpenhoComprasDTO e : empenhos.getData()) {

                try {

                    resultados.add(contratosExecutivoFederalImplContrato.retornaResultadoContratosExecutivoFederalEmpenho(e, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ContratosResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
