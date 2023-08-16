package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.PepImplContrato;
import com.harpia.stive.api.contrato.ServidorImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.PEPDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.ServidoresDoPoderExecutivoFederalApi;
import com.harpia.stive.util.Util;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
public class PepResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private ServidoresDoPoderExecutivoFederalApi servidorApi = new ServidoresDoPoderExecutivoFederalApi();

    private ServidorImplContrato servidorImplContrato = new ServidorImplContrato();
    private PepImplContrato pepImplContrato = new PepImplContrato();

    @ApiOperation(value = "Consulta Peps do Executivo Federal")
    @RequestMapping(value = "govbr/peps/busca", method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaPep(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores #RequestParam# cpf: " + cpf + ", busca: " + busca + ", nome: " + nome);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: transparencia-gov-br_servidores #RequestBody# " + request);

        ObjectMapper objectMapper = new ObjectMapper();

        if (request != null) {

            objectMapper.configure(Feature.ALLOW_COMMENTS, true);
            Parametros param = objectMapper.readValue(request, Parametros.class);

            if (StringUtils.isBlank(cpf)) {
                cpf = Util.getNumerics(param.getCpf());
            }

            if (StringUtils.isBlank(nome)) {
                nome = param.getNome();
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

            if (StringUtils.isBlank(busca)) {
                busca = param.getBusca();
            }

        }

        int pagina = 1;

        List<Resultado> resultados = new ArrayList<>();

        //Retorna os dados do pepe
        List<PEPDTO> peps = new ArrayList<>();
        List<PEPDTO> pepsTemp = new ArrayList<>();
        ApiResponse<List<PEPDTO>> pepesWithHttpInfo = null;

        do {

            try {

                pepsTemp = servidorApi.dadosPEPsUsingGET(chaveApiDados, pagina, cpf,
                        null, null, null, null, null, nome, null);
                
                if (pepsTemp.size() > 0) {
                        peps.addAll(pepsTemp);
                    }

            } catch (Exception ex) {

                Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            pagina++;

        } while (pepsTemp.size() == Util.TAMANHO_PADRAO_PAGINA_API);

        for (PEPDTO s : peps) {

            try {

                resultados.add(pepImplContrato.retornaResultadoPep(s, cpf));

            } catch (NoSuchAlgorithmException ex) {

                Logger.getLogger(ServidorResource.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (ParseException ex) {
                Logger.getLogger(PepResource.class.getName()).log(Level.SEVERE, null, ex);
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
