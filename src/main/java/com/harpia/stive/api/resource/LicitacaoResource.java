package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.ContratosExecutivoFederalImplContrato;
import com.harpia.stive.api.contrato.LicitacoesExecutivoFederalImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.ContratoDTO;
import com.harpia.stive.domain.model.EmpenhoComprasDTO;
import com.harpia.stive.domain.model.ItemLicitacaoDTO;
import com.harpia.stive.domain.model.LicitacaoDTO;
import com.harpia.stive.domain.model.ParticipanteLicitacaoDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.LicitaesDoPoderExecutivoFederalApi;
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
public class LicitacaoResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private LicitaesDoPoderExecutivoFederalApi licitacoesApi = new LicitaesDoPoderExecutivoFederalApi();
    private ContratosExecutivoFederalImplContrato contratosExecutivoFederalImplContrato = new ContratosExecutivoFederalImplContrato();
    private LicitacoesExecutivoFederalImplContrato licitacoesExecutivoFederalImplContrato = new LicitacoesExecutivoFederalImplContrato();

    @ApiOperation(value = "Consulta Licitacoes do Executivo Federal")
    @RequestMapping(value = ContratoApi.CONSULTA_LICITACOES_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaLicitacoes(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "numeroProcesso", required = false) String numeroProcesso,
            @RequestParam(value = "modalidade", required = false) String modalidade,
            @RequestParam(value = "codigoUG", required = false) String codigoUG,
            @RequestParam(value = "numero", required = false) String numero,
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_licitacoes_id "
                + "#RequestParam# id: " + id + ", numeroProcesso: " + numeroProcesso + ", modalidade: " + modalidade
                + ", codigoUG: " + codigoUG + ", numero: " + numero);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_licitacoes_id #RequestBody# " + request);

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

            if (id == null) {
                id = param.getId();
            }

            if (numeroProcesso == null) {
                numeroProcesso = param.getNumeroProcesso();
            }

            if (modalidade == null) {
                modalidade = param.getModalidade();
            }

            if (codigoUG == null) {
                codigoUG = param.getCodigoUG();
            }

            if (numero == null) {
                numero = param.getNumero();
            }

            if (busca == null) {
                busca = param.getBusca();
            }

            if (cpf == null) {
                cpf = param.getCpf();
            }

            if (cnpj == null) {
                cnpj = param.getCnpj();
            }

        }

        Integer pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        if ((StringUtils.isBlank(busca) || busca.equals("licitacao")) && id != null) {

            List<LicitacaoDTO> licitacoes = new ArrayList<>();
            ApiResponse<LicitacaoDTO> licitacaoUsingGETWithHttpInfo = null;

            try {

                licitacaoUsingGETWithHttpInfo = licitacoesApi.licitacaoUsingGETWithHttpInfo(chaveApiDados, id);
                licitacoes.add(licitacaoUsingGETWithHttpInfo.getData());

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else if ((StringUtils.isBlank(busca) || busca.equals("licitacao")) && StringUtils.isNotBlank(numeroProcesso)) {

            List<LicitacaoDTO> licitacoes = new ArrayList<>();
            ApiResponse<List<LicitacaoDTO>> licitacaoUsingGETWithHttpInfo = null;

            try {

                licitacaoUsingGETWithHttpInfo = licitacoesApi.licitacoesPorProcessoUsingGETWithHttpInfo(chaveApiDados, numeroProcesso);
                licitacoes.addAll(licitacaoUsingGETWithHttpInfo.getData());

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            for (LicitacaoDTO i : licitacoes) {

                try {

                    resultados.add(licitacoesExecutivoFederalImplContrato.retornaResultadoLicitacoesExecutivoFederal(i, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("participantes")
                && StringUtils.isNotBlank(modalidade) && StringUtils.isNotBlank(codigoUG)
                && StringUtils.isNotBlank(numero)) {

            List<ParticipanteLicitacaoDTO> participantes = new ArrayList<>();

            ApiResponse<List<ParticipanteLicitacaoDTO>> participantesUsingGET = null;

            do {

                try {

                    participantesUsingGET = licitacoesApi.participantesUsingGETWithHttpInfo(chaveApiDados, Util.getCodigoModidadeLicitacao(modalidade), codigoUG, numero, pagina);

                    if (!participantesUsingGET.getData().isEmpty()) {
                        participantes.addAll(participantesUsingGET.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (participantesUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

            for (ParticipanteLicitacaoDTO i : participantes) {

                try {

                    resultados.add(licitacoesExecutivoFederalImplContrato.retornaResultadoLicitacoesExecutivoFederalParticipante(i, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("empenhos")
                && StringUtils.isNotBlank(modalidade) && StringUtils.isNotBlank(codigoUG)
                && StringUtils.isNotBlank(numero)) {

            List<EmpenhoComprasDTO> empenhos = new ArrayList<>();

            ApiResponse<List<EmpenhoComprasDTO>> empenhosUsingGET = null;

            do {

                try {

                    empenhosUsingGET = licitacoesApi.empenhosUsingGETWithHttpInfo(chaveApiDados, Util.getCodigoModidadeLicitacao(modalidade), codigoUG, numero, pagina);

                    if (!empenhosUsingGET.getData().isEmpty()) {
                        empenhos.addAll(empenhosUsingGET.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (empenhosUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

            for (EmpenhoComprasDTO i : empenhos) {

                try {

                    resultados.add(licitacoesExecutivoFederalImplContrato.retornaResultadoLicitacoesExecutivoFederalEmpenho(i, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("itens") && id != null) {

            List<ItemLicitacaoDTO> itens = new ArrayList<>();

            ApiResponse<List<ItemLicitacaoDTO>> itensUsingGET = null;

            do {

                try {

                    itensUsingGET = licitacoesApi.itensLicitadosUsingGETWithHttpInfo(chaveApiDados, id, pagina);

                    if (!itensUsingGET.getData().isEmpty()) {
                        itens.addAll(itensUsingGET.getData());
                    }

                } catch (Exception e) {
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (itensUsingGET.getData().size() == 15);//Tamanho atual da pagina vindo da API

            for (ItemLicitacaoDTO i : itens) {

                try {

                    resultados.add(licitacoesExecutivoFederalImplContrato.retornaResultadoLicitacoesExecutivoFederalItens(i, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("relacionados")
                && StringUtils.isNotBlank(modalidade) && StringUtils.isNotBlank(codigoUG)
                && StringUtils.isNotBlank(numero)) {

            List<ContratoDTO> itens = new ArrayList<>();
            List<ContratoDTO> contratos = new ArrayList<>();

            ApiResponse<List<ContratoDTO>> itensUsingGET = null;

            do {

                try {

                    itens = licitacoesApi.contratosRelacionadosUsingGET(chaveApiDados, modalidade, codigoUG, numero);

                    if (!itens.isEmpty()) {
                        contratos.addAll(itens);
                    }

                } catch (Exception e) {
                    Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (itensUsingGET.getData().size() == 15);//Tamanho atual da pagina vindo da API

            for (ContratoDTO i : itens) {

                try {

                    resultados.add(contratosExecutivoFederalImplContrato.retornaResultadoContratosExecutivoFederal(i, null, null));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
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
