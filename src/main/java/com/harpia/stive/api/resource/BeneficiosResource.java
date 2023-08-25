package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.BeneficiosImplContrato;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.AuxilioEmergencialDTO;
import com.harpia.stive.domain.model.BPCDTO;
import com.harpia.stive.domain.model.BolsaFamiliaDTO;
import com.harpia.stive.domain.model.NovoBolsaFamiliaPagoDTO;
import com.harpia.stive.domain.model.PetiDTO;
import com.harpia.stive.domain.model.SafraDTO;
import com.harpia.stive.domain.model.SeguroDefesoDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.BenefciosApi;
import com.harpia.stive.util.Util;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
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
public class BeneficiosResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private BenefciosApi beneficiosApi = new BenefciosApi();

    private BeneficiosImplContrato beneficiosImplContrato = new BeneficiosImplContrato();

    @ApiOperation(value = "Consulta Seguro Defeso")
    @RequestMapping(value = ContratoApi.CONSULTA_SEGURODEFESO_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaSeguroDefeso(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_seguro_defeso #RequestParam# cpf: " + cpf + ", nis: " + nis);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_seguro_defeso #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }
        }

        int pagina = 1;

        String codigo = null;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<SeguroDefesoDTO> seguros = new ArrayList<>();

        ApiResponse<List<SeguroDefesoDTO>> segurosUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                segurosUsingGET = beneficiosApi.seguroDefesosPorCodigoUsingGETWithHttpInfo(chaveApiDados, codigo, pagina);

            } catch (Exception e) {
                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (!segurosUsingGET.getData().isEmpty()) {
                seguros.addAll(segurosUsingGET.getData());
            }

            pagina++;

        } while (segurosUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (SeguroDefesoDTO s : seguros) {

            try {
                resultados.add(beneficiosImplContrato.retornaResultadoSeguroDefeso(s, cpf));
            } catch (ParseException ex) {
                Logger.getLogger(BeneficiosResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta garantia Safra")
    @RequestMapping(value = ContratoApi.CONSULTA_GARANTIASAFRA_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaGarantiaSafra(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_garantia_safra #RequestParam# cpf: " + cpf + ", nis: " + nis);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_garantia_safra #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }
        }

        Integer pagina = 1;

        String codigo = null;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<SafraDTO> safras = new ArrayList<>();

        ApiResponse<List<SafraDTO>> safrasUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                safrasUsingGET = beneficiosApi.safraPorNisOuCPFUsingGETWithHttpInfo(chaveApiDados, codigo, pagina);

                if (!safrasUsingGET.getData().isEmpty()) {
                    safras.addAll(safrasUsingGET.getData());
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (safrasUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (SafraDTO s : safras) {

            try {
                resultados.add(beneficiosImplContrato.retornaResultadoGarantiaSafra(s, cpf));
            } catch (ParseException ex) {
                Logger.getLogger(BeneficiosResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta BPC - Beneficiario")
    @RequestMapping(value = ContratoApi.CONSULTA_BPC_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaBpc(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_bpc #RequestParam# cpf: " + cpf + ", nis: " + nis);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_bpc #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }
        }

        String codigo = null;
        int pagina = 1;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<BPCDTO> bpcs = new ArrayList<>();

        ApiResponse<List<BPCDTO>> bpcsUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                bpcsUsingGET = beneficiosApi.bpcPorNisOuCPFUsingGETWithHttpInfo(chaveApiDados, codigo, pagina);

                if (!bpcsUsingGET.getData().isEmpty()) {
                    bpcs.addAll(bpcsUsingGET.getData());
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (bpcsUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (BPCDTO bpc : bpcs) {

            try {
                resultados.add(beneficiosImplContrato.retornaResultadoBpc(bpc, cpf));
            } catch (ParseException ex) {
                Logger.getLogger(BeneficiosResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta PETI - Beneficiario")
    @RequestMapping(value = ContratoApi.CONSULTA_PETI_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaPeti(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_peti #RequestParam# cpf: " + cpf + ", nis: " + nis);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_peti #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }

        }

        Integer pagina = 1;

        String codigo = null;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<PetiDTO> petis = new ArrayList<>();

        ApiResponse<List<PetiDTO>> petisUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                petisUsingGET = beneficiosApi.petiUsingGETWithHttpInfo(chaveApiDados, codigo, pagina);

                if (!petisUsingGET.getData().isEmpty()) {
                    petis.addAll(petisUsingGET.getData());
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (petisUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (PetiDTO p : petis) {

            try {
                resultados.add(beneficiosImplContrato.retornaResultadoPeti(p, cpf));
            } catch (ParseException ex) {
                Logger.getLogger(BeneficiosResource.class.getName()).log(Level.SEVERE, null, ex);
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

    @ApiOperation(value = "Consulta Auxilio Emergencial - Beneficiario")
    @RequestMapping(value = ContratoApi.CONSULTA_AUXEMERGENCIAL_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaAuxilioEmergencial(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_auxilio_emergencial #RequestParam# cpf: " + cpf + ", nis: " + nis);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_auxilio_emergencial #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }
        }

        Integer pagina = 1;

        String codigo = null;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<AuxilioEmergencialDTO> emergenciais = new ArrayList<>();

        ApiResponse<List<AuxilioEmergencialDTO>> emergenciaisUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                emergenciaisUsingGET = beneficiosApi.auxilioEmergencialPorNisOuCPFUsingGETWithHttpInfo(chaveApiDados, pagina, codigo, codigo);

                if (!emergenciaisUsingGET.getData().isEmpty()) {
                    emergenciais.addAll(emergenciaisUsingGET.getData());
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (emergenciaisUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (AuxilioEmergencialDTO a : emergenciais) {

            resultados.add(beneficiosImplContrato.retornaResultadoAuxilioEmergencial(a, cpf));
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

    //#Verificar o mesAno Padrao para o bolsa familia
    @ApiOperation(value = "Consulta Bolsa Familia - Beneficiario")
    @RequestMapping(value = ContratoApi.CONSULTA_BOLSAFAMILIA_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaBolsaFamilia(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestParam(value = "mesAno", required = false) String mesAno,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_bolsa_familia #RequestParam# cpf: " + cpf + ", nis: " + nis + ", mesAno: " + mesAno);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_bolsa_familia #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (StringUtils.isNotBlank(request)){

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }

            if (StringUtils.isBlank(mesAno)){
                mesAno = param.getMesAno();
            }
        }
        
        
        /*
            Se o mesAno nao for informado utilizara como padrao 10/2021 (ultimo pagamento do beneficio, foi substituido pelo auxilio Brasil)
        */
        if (StringUtils.isBlank(mesAno)){
            mesAno = ContratoApi.MES_ANO_REF_BOLSAFAMILIA;
        }

        Integer anoMes = Util.trataMesAno(mesAno);

        String codigo = null;

        int pagina = 1;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<BolsaFamiliaDTO> bolsas = new ArrayList<>();

        ApiResponse<List<BolsaFamiliaDTO>> bolsasUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                bolsasUsingGET = beneficiosApi.bolsaFamiliaDisponivelPorCpfOuNisUsingGETWithHttpInfo(chaveApiDados, codigo, 1, null, anoMes);

                if (!bolsasUsingGET.getData().isEmpty()) {
                    bolsas.addAll(bolsasUsingGET.getData());
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (bolsasUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (BolsaFamiliaDTO a : bolsas) {

            try {
                resultados.add(beneficiosImplContrato.retornaResultadoBolsaFamilia(a, cpf));
            } catch (ParseException ex) {
                Logger.getLogger(BeneficiosResource.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    //#Verificar o mesAno Padrao para o novo bolsa familia
    @ApiOperation(value = "Consulta Bolsa Familia - Beneficiario")
    @RequestMapping(value = ContratoApi.CONSULTA_NOVOBOLSAFAM_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaNovoBolsaFamilia(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nis", required = false) String nis,
            @RequestParam(value = "mesAno", required = false) String mesAno,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_novo_bolsa_familia #RequestParam# cpf: " + cpf + ", nis: " + nis + ", mesAno: " + mesAno);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_novo_bolsa_familia #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nis)) {
                nis = Util.getNumerics(param.getNis());
            }

            if (mesAno == null) {
                mesAno = param.getMesAno();
            }
        }
        
        Integer anoMes = null;
        
        //Ano mes opcional
        if (StringUtils.isNotBlank(mesAno)){
             anoMes = Util.trataMesAno(mesAno);
        }


        String codigo = null;

        int pagina = 1;

        if (!StringUtils.isBlank(cpf)) {
            codigo = cpf;
        } else {
            codigo = nis;
        }

        List<NovoBolsaFamiliaPagoDTO> bolsas = new ArrayList<>();

        ApiResponse<List<NovoBolsaFamiliaPagoDTO>> bolsasUsingGET = null;

        List<Resultado> resultados = new ArrayList<>();

        do {

            try {

                bolsasUsingGET = beneficiosApi.novoBolsaFamiliaSacadoPorNisUsingGETWithHttpInfo(chaveApiDados, nis, pagina, null, anoMes);

                if (!bolsasUsingGET.getData().isEmpty()) {
                    bolsas.addAll(bolsasUsingGET.getData());
                }

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (bolsasUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);//Tamanho atual da pagina vindo da API

        for (NovoBolsaFamiliaPagoDTO a : bolsas) {

            try {
                resultados.add(beneficiosImplContrato.retornaResultadoNovoBolsaFamilia(a, cpf));
            } catch (ParseException ex) {
                Logger.getLogger(BeneficiosResource.class.getName()).log(Level.SEVERE, null, ex);
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
