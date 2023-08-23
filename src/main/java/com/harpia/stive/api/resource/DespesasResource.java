package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.DespesasImplContrato;
import com.harpia.stive.api.contrato.PepImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.DespesasPorDocumentoDTO;
import com.harpia.stive.domain.model.DocumentoRelacionadoDTO;
import com.harpia.stive.service.client.ApiClient;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.DespesasPblicasApi;
import com.harpia.stive.util.Util;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.Year;
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
public class DespesasResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private DespesasPblicasApi despesasPblicasApi = new DespesasPblicasApi();

    private DespesasImplContrato servidorImplContrato = new DespesasImplContrato();
    private PepImplContrato pepImplContrato = new PepImplContrato();

    ApiClient apiClient = new ApiClient();

    @ApiOperation(value = "Consulta Peps do Executivo Federal")
    @RequestMapping(value = ContratoApi.CONSULTA_EMPENHOS_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaDespesasEmpenho(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "documento", required = false) String documento,
            @RequestParam(value = "ano", required = false) Integer ano,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_empenhos "
                + "#RequestParam# cpf: " + cpf + ", busca: " + busca + ", cnpj: " + cnpj + " ano: " + ano + " documento: " + documento);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_empenhos #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            } else {
                cpf = Util.getNumerics(cpf);
            }

            if (StringUtils.isBlank(cnpj)) {
                cnpj = Util.getNumerics(param.getCnpj());
            } else {
                cnpj = Util.getNumerics(cnpj);
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

            if (StringUtils.isBlank(documento)) {
                documento = param.getDocumento();
            }

            if (ano == null) {
                ano = param.getAno();
            }

        }

         if (ano != null) {
            ano = Year.now().getValue() -1;
        }

        String cpfCnpj = null;

        if (StringUtils.isNotBlank(cnpj)) {
            cpfCnpj = cnpj;
        } else {
            cpfCnpj = cpf;
        }

        int fase = 1;//Empenho
        int ordenacaoResultado = 4;

        despesasPblicasApi.getApiClient().setConnectTimeout(50 * 1000);
        despesasPblicasApi.getApiClient().setReadTimeout(50 * 1000);

        int pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("empenho")) {

            List<DespesasPorDocumentoDTO> docs = new ArrayList<>();
            List<DespesasPorDocumentoDTO> despesasAux = new ArrayList<>();
            ApiResponse<List<DespesasPorDocumentoDTO>> docsWithHttpInfo = null;

            do {

                try {

                    despesasAux = despesasPblicasApi.documentosPorFavorecidoUsingGET(ano, chaveApiDados, cpfCnpj, fase, pagina, null, ordenacaoResultado, null);

                    if (despesasAux.size() > 0) {
                        docs.addAll(despesasAux);
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (despesasAux.size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (DespesasPorDocumentoDTO s : docs) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoDespesa(s, cpfCnpj, fase));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("documento")) {

            try {

                DespesasPorDocumentoDTO doc = null;

                doc = despesasPblicasApi.documentoPorCodigoUsingGET(chaveApiDados, documento);

                resultados.add(servidorImplContrato.retornaResultadoDespesa(doc, null, fase));

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(DespesasResource.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("doc_relacionados")) {

            List<DocumentoRelacionadoDTO> docsLiqRela = new ArrayList<>();
            List<DocumentoRelacionadoDTO> liquidacoes = new ArrayList<>();
            ApiResponse<List<DocumentoRelacionadoDTO>> docsWithHttpInfo = null;

            do {

                try {

                    liquidacoes = despesasPblicasApi.documentosRelacionadosUsingGET(chaveApiDados, documento, fase);

                    if (liquidacoes.size() > 0) {
                        docsLiqRela.addAll(liquidacoes);
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (liquidacoes.size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (DocumentoRelacionadoDTO s : docsLiqRela) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoDocumentosRelacionados(s, fase));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta Peps do Executivo Federal")
    @RequestMapping(value = ContratoApi.CONSULTA_LIQUIDACAO_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaDespesasLiquidacao(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "documento", required = false) String documento,
            @RequestParam(value = "ano", required = false) Integer ano,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_liquidacoes "
                + "#RequestParam# cpf: " + cpf + ", busca: " + busca + ", cnpj: " + cnpj + " ano: " + ano + " documento: " + documento);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_liquidacoes #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            } else {
                cpf = Util.getNumerics(cpf);
            }

            if (StringUtils.isBlank(cnpj)) {
                cnpj = Util.getNumerics(param.getCnpj());
            } else {
                cnpj = Util.getNumerics(cnpj);
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

            if (StringUtils.isBlank(documento)) {
                documento = param.getDocumento();
            }

            if (ano == null) {
                ano = param.getAno();
            }

        }

        if (ano != null) {
            ano = Year.now().getValue() -1;
        }

        String cpfCnpj = null;

        if (StringUtils.isNotBlank(cnpj)) {
            cpfCnpj = cnpj;
        } else {
            cpfCnpj = cpf;
        }

        int fase = 2;//Liquidação
        int ordenacaoResultado = 4; //Data mais recente

        despesasPblicasApi.getApiClient().setConnectTimeout(50 * 1000);
        despesasPblicasApi.getApiClient().setReadTimeout(50 * 1000);

        int pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("liquidacao")) {

            List<DespesasPorDocumentoDTO> docs = new ArrayList<>();
            List<DespesasPorDocumentoDTO> despesasAux = new ArrayList<>();
            ApiResponse<List<DespesasPorDocumentoDTO>> docsWithHttpInfo = null;

            do {

                try {

                    despesasAux = despesasPblicasApi.documentosPorFavorecidoUsingGET(ano, chaveApiDados, cpfCnpj, fase, pagina, null, ordenacaoResultado, null);

                    if (despesasAux.size() > 0) {
                        docs.addAll(despesasAux);
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (despesasAux.size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (DespesasPorDocumentoDTO s : docs) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoDespesa(s, cpfCnpj, fase));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("documento")) {

            try {

                DespesasPorDocumentoDTO doc = null;

                doc = despesasPblicasApi.documentoPorCodigoUsingGET(chaveApiDados, documento);

                resultados.add(servidorImplContrato.retornaResultadoDespesa(doc, null, fase));

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(DespesasResource.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("doc_relacionados")) {

            List<DocumentoRelacionadoDTO> docsLiqRela = new ArrayList<>();
            List<DocumentoRelacionadoDTO> liquidacoes = new ArrayList<>();
            ApiResponse<List<DocumentoRelacionadoDTO>> docsWithHttpInfo = null;

            do {

                try {

                    liquidacoes = despesasPblicasApi.documentosRelacionadosUsingGET(chaveApiDados, documento, fase);

                    if (liquidacoes.size() > 0) {
                        docsLiqRela.addAll(liquidacoes);
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (liquidacoes.size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (DocumentoRelacionadoDTO s : docsLiqRela) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoDocumentosRelacionados(s, fase));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta Peps do Executivo Federal")
    @RequestMapping(value = ContratoApi.CONSULTA_PAGAMENTO_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaDespesasPagamento(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "documento", required = false) String documento,
            @RequestParam(value = "ano", required = false) Integer ano,
            @RequestBody String request
    ) throws IOException, ApiException, NoSuchAlgorithmException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores "
                + "#RequestParam# cpf: " + cpf + ", busca: " + busca + ", cnpj: " + cnpj + " ano: " + ano + " documento: " + documento);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            } else {
                cpf = Util.getNumerics(cpf);
            }

            if (StringUtils.isBlank(cnpj)) {
                cnpj = Util.getNumerics(param.getCnpj());
            } else {
                cnpj = Util.getNumerics(cnpj);
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

            if (StringUtils.isBlank(documento)) {
                documento = param.getDocumento();
            }

            if (ano == null) {
                ano = param.getAno();
            }

        }

         if (ano != null) {
            ano = Year.now().getValue() -1;
        }

        String cpfCnpj = null;

        if (StringUtils.isNotBlank(cnpj)) {
            cpfCnpj = cnpj;
        } else {
            cpfCnpj = cpf;
        }

        int fase = 3;//Pagamento
        int ordenacaoResultado = 4;

        despesasPblicasApi.getApiClient().setConnectTimeout(50 * 1000);
        despesasPblicasApi.getApiClient().setReadTimeout(50 * 1000);

        int pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("pagamento")) {

            List<DespesasPorDocumentoDTO> docs = new ArrayList<>();
            List<DespesasPorDocumentoDTO> despesasAux = new ArrayList<>();
            ApiResponse<List<DespesasPorDocumentoDTO>> docsWithHttpInfo = null;

            do {

                try {

                    despesasAux = despesasPblicasApi.documentosPorFavorecidoUsingGET(ano, chaveApiDados, cpfCnpj, fase, pagina, null, ordenacaoResultado, null);

                    if (despesasAux.size() > 0) {
                        docs.addAll(despesasAux);
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (despesasAux.size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (DespesasPorDocumentoDTO s : docs) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoDespesa(s, cpfCnpj, fase));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("documento")) {

            DespesasPorDocumentoDTO doc = null;

            doc = despesasPblicasApi.documentoPorCodigoUsingGET(chaveApiDados, documento);

            resultados.add(servidorImplContrato.retornaResultadoDespesa(doc, null, fase));

        } else if (StringUtils.isNotBlank(busca) && busca.equals("doc_relacionados")) {

            List<DocumentoRelacionadoDTO> docspagRela = new ArrayList<>();
            List<DocumentoRelacionadoDTO> pagamentos = new ArrayList<>();
            ApiResponse<List<DocumentoRelacionadoDTO>> docsWithHttpInfo = null;

            do {

                try {

                    pagamentos = despesasPblicasApi.documentosRelacionadosUsingGET(chaveApiDados, documento, fase);

                    if (pagamentos.size() > 0) {
                        docspagRela.addAll(pagamentos);
                    }

                } catch (Exception ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (pagamentos.size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (DocumentoRelacionadoDTO s : docspagRela) {

                try {

                    resultados.add(servidorImplContrato.retornaResultadoDocumentosRelacionados(s, fase));

                } catch (NoSuchAlgorithmException ex) {

                    Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
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
