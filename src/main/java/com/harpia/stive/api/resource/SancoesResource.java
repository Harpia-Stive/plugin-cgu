package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.SancoesImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.AcordosLenienciaDTO;
import com.harpia.stive.domain.model.CeafDTO;
import com.harpia.stive.domain.model.CeisDTO;
import com.harpia.stive.domain.model.CepimDTO;
import com.harpia.stive.domain.model.CnepDTO;
import com.harpia.stive.domain.model.CodigoDescricaoDTO;
import com.harpia.stive.domain.model.EmpresaSancionadaDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.SanesApi;
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
public class SancoesResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private SanesApi sanesApi = new SanesApi();

    private SancoesImplContrato sancoesImplContrato = new SancoesImplContrato();

    @ApiOperation(value = "Consulta Acordos de Leniência")
    @RequestMapping(value = ContratoApi.CONSULTA_ACORDOLENIENCIA_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaAcordoLeniencia(
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_govbr_sancoes_leniencia #RequestParam# CNPJ/cpf: " + cnpj + ", id: " + id + ", busca: " + busca);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_govbr_sancoes_leniencia #RequestBody# " + request);

        String cnpjSancionado = null, dataFinalSancao = null, dataInicialSancao = null, nomeSancionado = null, situacao = null;

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (cnpj == null) {
                cnpj = Util.getNumerics(param.getCnpj());
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

            if (id == null) {
                id = param.getId();
            }
        }

        Integer pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("acordos")) {

            ApiResponse<List<AcordosLenienciaDTO>> acordosWithHttpInfo = null;

            List<AcordosLenienciaDTO> acordos = new ArrayList<>();

            do {

                try {

                    acordosWithHttpInfo = sanesApi.acordosLenienciaUsingGETWithHttpInfo(chaveApiDados, pagina, cnpj, dataFinalSancao, dataInicialSancao, nomeSancionado, situacao);

                    if (acordosWithHttpInfo.getData().size() > 0) {
                        acordos.addAll(acordosWithHttpInfo.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (acordosWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (AcordosLenienciaDTO a : acordos) {

                try {
                    resultados.add(sancoesImplContrato.retornaResultadoAcordoLeniencia(a));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

            //
        } else if (StringUtils.isNotBlank(busca) && busca.equals("empresas")) {

            ApiResponse<AcordosLenienciaDTO> retorno = null;
            List<AcordosLenienciaDTO> listRetorno = new ArrayList<>();

            try {

                retorno = sanesApi.acordoLenienciaUsingGETWithHttpInfo(chaveApiDados, id);

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            listRetorno.add(retorno.getData());

            for (AcordosLenienciaDTO a : listRetorno) {

                for (EmpresaSancionadaDTO e : a.getSancoes()) {
                    try {
                        resultados.add(sancoesImplContrato.retornaResultadoAcordoLenienciaEmpresas(e));
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
                        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }

        }

        Retorno retorno = new Retorno();

        if (resultados.size() < 1) {

            return new ResponseEntity<>(retorno, HttpStatus.OK);

        }

        retorno.setVersaoProtocolo(ContratoApi.VERSAO_PROTOCOLO);
        retorno.setResultado(resultados);

        return new ResponseEntity<>(retorno, HttpStatus.OK);

    }

    @ApiOperation(value = "CEAF - Consulta Cadastros de Expulsões da Administração Pública")
    @RequestMapping(value = ContratoApi.CONSULTA_CEAF_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaCeaf(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_ceaf #RequestParam# cpf: " + cpf + ", id: " + id + ", busca: " + busca);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_ceaf #RequestBody# " + request);

        String nome = null;
        String cnpjSancionado = null, dataFinalSancao = null, dataInicialSancao = null, nomeSancionado = null, situacao = null;

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (cpf == null) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (id == null) {
                id = param.getId();
            }

            if (busca == null) {
                busca = param.getBusca();
            }

        }

        Integer pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("ceafs")) {

            CeafDTO retorno = null;

            ApiResponse<List<CeafDTO>> ceafsWithHttpInfoApi = null;
            List<CeafDTO> ceafs = new ArrayList<>();

            do {

                try {

                    ceafsWithHttpInfoApi = sanesApi.ceafUsingGET1WithHttpInfo(chaveApiDados, pagina, cpf, dataFinalSancao, dataInicialSancao, nomeSancionado, situacao);

                    if (ceafsWithHttpInfoApi.getData().size() > 0) {
                        ceafs.addAll(ceafsWithHttpInfoApi.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (ceafsWithHttpInfoApi.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (CeafDTO a : ceafs) {

                try {
                    resultados.add(sancoesImplContrato.retornaResultadoCeaf(a, cpf));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("fundamentacao")) {

            ApiResponse<CeafDTO> retorno = null;

            try {

                retorno = sanesApi.ceafUsingGETWithHttpInfo(chaveApiDados, id);

                for (CodigoDescricaoDTO a : retorno.getData().getFundamentacao()) {
                    resultados.add(sancoesImplContrato.retornaResultadoCeafFundamentacao(a, cpf));
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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

    @ApiOperation(value = "CEIS - Cadastro de Empresas Inidôneas e Suspensas")
    @RequestMapping(value = ContratoApi.CONSULTA_CEIS_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaCeis(
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_ceis #RequestParam# cnpj: " + cnpj + ", cpf: " + cpf + ", busca: " + busca + ", id: " + id);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_ceis #RequestBody# " + request);

        String nome = null;
        String nomeSancionado = null, orgaoEntidade = null;

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (cnpj == null) {
                cnpj = Util.getNumerics(param.getCnpj());
            }

            if (cpf == null) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (busca == null) {
                busca = param.getBusca();
            }

            if (id == null) {
                id = param.getId();
            }
        }

        Integer pagina = 1;

        String codigo = null;

        if (cnpj == null) {
            codigo = cpf;
        } else {
            codigo = cnpj;
        }

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("ceafs")) {

            ApiResponse<List<CeisDTO>> ceisWithHttpInfo = null;
            List<CeisDTO> ceis = new ArrayList<>();

            do {

                try {

                    ceisWithHttpInfo = sanesApi.ceisUsingGET1WithHttpInfo(chaveApiDados, pagina, codigo, orgaoEntidade, nomeSancionado, nomeSancionado, nomeSancionado);

                    if (ceisWithHttpInfo.getData().size() > 0) {
                        ceis.addAll(ceisWithHttpInfo.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (ceisWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (CeisDTO a : ceis) {

                try {

                    resultados.add(sancoesImplContrato.retornaResultadoCeis(a, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("fundamentacao")) {

            final Integer finalId = id;
            ApiResponse<List<CeisDTO>> ceisWithHttpInfo = null;
            List<CeisDTO> ceis = new ArrayList<>();

            do {

                try {

                    ceisWithHttpInfo = sanesApi.ceisUsingGET1WithHttpInfo(chaveApiDados, pagina, codigo, orgaoEntidade, nomeSancionado, nomeSancionado, nomeSancionado);

                    if (ceisWithHttpInfo.getData().size() > 0) {
                        ceis.addAll(ceisWithHttpInfo.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (ceisWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            List<CeisDTO> resultFilter = ceis.stream().filter(itemCeis -> itemCeis.getId().equals(finalId)).collect(Collectors.toList());

            for (CeisDTO a : resultFilter) {

                for (CodigoDescricaoDTO f : a.getFundamentacao()) {

                    try {

                        resultados.add(sancoesImplContrato.retornaResultadoCeisFundamentacao(f, cpf, cnpj));

                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "CNEP - Cadastro Nacional de Empresas Punidas")
    @RequestMapping(value = ContratoApi.CONSULTA_CNEP_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaCnep(
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_ceis #RequestParam# cnpj: " + cnpj + ", cpf: " + cpf + ", busca: " + busca + ", id: " + id);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_cnep #RequestBody# " + request);

        String nome = null;
        String nomeSancionado = null, orgaoEntidade = null;

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (cnpj == null) {
                cnpj = Util.getNumerics(param.getCnpj());
            }

            if (cpf == null) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (busca == null) {
                busca = param.getBusca();
            }

            if (id == null) {
                id = param.getId();
            }
        }

        Integer pagina = 1;

        String codigo = null;

        if (cnpj == null) {
            codigo = cpf;
        } else {
            codigo = cnpj;
        }

        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("cneps")) {

            ApiResponse<List<CnepDTO>> cnepsWithHttpInfo = null;
            List<CnepDTO> cneps = new ArrayList<>();

            do {

                try {

                    cnepsWithHttpInfo = sanesApi.cnepUsingGET1WithHttpInfo(chaveApiDados, pagina, codigo, orgaoEntidade, nomeSancionado, nomeSancionado, nomeSancionado);

                    if (cnepsWithHttpInfo.getData().size() > 0) {
                        cneps.addAll(cnepsWithHttpInfo.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (cnepsWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (CnepDTO a : cneps) {

                try {

                    resultados.add(sancoesImplContrato.retornaResultadoCnep(a, cpf, cnpj));

                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("fundamentacao")) {

            final Integer finalId = id;

            ApiResponse<List<CnepDTO>> cnepsWithHttpInfo = null;
            List<CnepDTO> cneps = new ArrayList<>();

            do {

                try {

                    cnepsWithHttpInfo = sanesApi.cnepUsingGET1WithHttpInfo(chaveApiDados, pagina, codigo, orgaoEntidade, nomeSancionado, nomeSancionado, nomeSancionado);

                    if (cnepsWithHttpInfo.getData().size() > 0) {
                        cneps.addAll(cnepsWithHttpInfo.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (cnepsWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            List<CnepDTO> result = cneps.stream().filter(itemCeis -> itemCeis.getId().equals(finalId)).collect(Collectors.toList());

            for (CnepDTO c : result) {

                for (CodigoDescricaoDTO f : c.getFundamentacao()) {

                    try {

                        resultados.add(sancoesImplContrato.retornaResultadoCnepFundamentacao(f, cpf, cnpj));

                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta Cadastro de Entidades Privadas sem Fins Lucrativos Impedidas (CEPIM)")
    @RequestMapping(value = ContratoApi.CONSULTA_CEPIM_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaCepim(
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_cepim #RequestParam# cnpj: " + cnpj);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_sancoes_cepim #RequestBody# " + request);

        String nome = null;
        String nomeSancionado = null, orgaoEntidade = null;

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (cnpj == null) {
                cnpj = Util.getNumerics(param.getCnpj());
            }
        }

        Integer pagina = 1;
        ApiResponse<List<CepimDTO>> cepimWithHttpInfo = null;

        List<CepimDTO> cepins = new ArrayList<>();

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                cepimWithHttpInfo = sanesApi.cepimUsingGET1WithHttpInfo(chaveApiDados, pagina, cnpj, nomeSancionado, orgaoEntidade, nomeSancionado);

                if (cepimWithHttpInfo.getData().size() > 0) {
                    cepins.addAll(cepimWithHttpInfo.getData());
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (cepimWithHttpInfo.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

        for (CepimDTO c : cepins) {

            try {

                resultados.add(sancoesImplContrato.retornaResultadoCepim(c, cnpj));

            } catch (NoSuchAlgorithmException ex) {

                Logger.getLogger(SancoesResource.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
