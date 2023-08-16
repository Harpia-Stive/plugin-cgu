package com.harpia.stive.api.resource;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harpia.stive.api.contrato.ContratoApi;
import com.harpia.stive.api.contrato.NotasFiscaisExecutivoFederalImplContrato;
import com.harpia.stive.api.model.Parametros;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Retorno;
import com.harpia.stive.domain.model.DetalheNotaFiscalDTO;
import com.harpia.stive.domain.model.EventoNotaFiscalDTO;
import com.harpia.stive.domain.model.ItemNotaFiscalDTO;
import com.harpia.stive.domain.model.NotaFiscalDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.NotasFiscaisApi;
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
public class NotasFiscaisResource {

    private static final Integer TAMANHO_PAGINA = 10;
    //private final String chaveApiDados = System.getenv("TRANSPARENCIA");
    private final String chaveApiDados = ContratoApi.CHAVE_API_PORTAL_TRANSPARENCIA;

    @Autowired
    private HttpServletRequest request;

    private NotasFiscaisApi notasFiscaisApi = new NotasFiscaisApi();

    private NotasFiscaisExecutivoFederalImplContrato notasFiscaisExecutivoFederalImplContrato = new NotasFiscaisExecutivoFederalImplContrato();

    @ApiOperation(value = "Consulta Notas Fiscais do Executivo Federal")
    //"consulta/govbr/govbr_servidores/busca"
    @RequestMapping(value = ContratoApi.CONSULTA_NOTA_URL, method = RequestMethod.POST, consumes = {"text/html", "application/x-www-form-urlencoded", "application/json"})
    public ResponseEntity<Object> consultaNotasFiscais(
            @RequestParam(value = "cnpj", required = false) String cnpj,
            @RequestParam(value = "chaveUnicaNotaFiscal", required = false) String chaveUnicaNotaFiscal,
            @RequestParam(value = "busca", required = false) String busca,
            @RequestBody String request
    ) throws IOException, ApiException {

        request = request.replaceAll("\\\\", "").replace("\"{\"", "{\"").replace("}\"", "}");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_notas_fiscais #RequestParam# cnpj: " + cnpj + ", busca: " + busca + chaveUnicaNotaFiscal);

        System.out.println(timestamp + "\t" + this.request.getRemoteHost() + "\tFuncionalidade: consulta/govbr/govbr_notas_fiscais #RequestBody# " + request);

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

            if (cnpj == null) {
                cnpj = Util.getNumerics(param.getCnpj());
            }

            if (nome == null) {
                nome = param.getNome();
            }

            if (busca == null) {
                busca = param.getBusca();
            }

            if (chaveUnicaNotaFiscal == null) {
                chaveUnicaNotaFiscal = param.getChaveUnicaNotaFiscal();
            }
        }

        Integer pagina = 1;
        List<Resultado> resultados = new ArrayList<>();

        if (StringUtils.isBlank(busca) || busca.equals("contratos")) {

            ApiResponse<List<NotaFiscalDTO>> notasFiscaisUsingGET = null;

            List<NotaFiscalDTO> notas = new ArrayList<>();

            do {

                try {

                    notasFiscaisUsingGET = notasFiscaisApi.notasFiscaisUsingGETWithHttpInfo(chaveApiDados, pagina, cnpj, codigoFuncaoCargo, nome);

                    if (notasFiscaisUsingGET.getData().size() > 0) {
                        notas.addAll(notasFiscaisUsingGET.getData());
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: " + e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                pagina++;

            } while (notasFiscaisUsingGET.getData().size() == Util.TAMANHO_PADRAO_PAGINA_API);

            for (NotaFiscalDTO e : notas) {

                try {

                    resultados.add(notasFiscaisExecutivoFederalImplContrato.retornaResultadoNotasFiscaisExecutivoFederal(e, cnpj));

                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ContratosResource.class.getName()).log(Level.SEVERE, null, ex);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("itens")) {

            ApiResponse<DetalheNotaFiscalDTO> notasFiscaisUsingGET = null;

            try {

                notasFiscaisUsingGET = notasFiscaisApi.notaFiscalUsingGETWithHttpInfo(chaveApiDados, chaveUnicaNotaFiscal);

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            List<DetalheNotaFiscalDTO> lista = new ArrayList<>();
            lista.add(notasFiscaisUsingGET.getData());

            for (DetalheNotaFiscalDTO d : lista) {

                for (ItemNotaFiscalDTO i : d.getItensNotaFiscal()) {

                    try {

                        resultados.add(notasFiscaisExecutivoFederalImplContrato.retornaResultadoNotasFiscaisExecutivoFederalItens(i, cnpj));

                    } catch (NoSuchAlgorithmException ex) {

                        Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
                        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }

        } else if (StringUtils.isNotBlank(busca) && busca.equals("eventos")) {

            ApiResponse<DetalheNotaFiscalDTO> notasFiscaisUsingGET = null;

            try {

                notasFiscaisUsingGET = notasFiscaisApi.notaFiscalUsingGETWithHttpInfo(chaveApiDados, chaveUnicaNotaFiscal);

            } catch (Exception e) {

                System.out.println("ERROR: " + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            List<DetalheNotaFiscalDTO> lista = new ArrayList<>();
            lista.add(notasFiscaisUsingGET.getData());

            for (DetalheNotaFiscalDTO d : lista) {

                for (EventoNotaFiscalDTO e : d.getEventosNotaFiscal()) {

                    try {

                        resultados.add(notasFiscaisExecutivoFederalImplContrato.retornaResultadoNotasFiscaisExecutivoFederalEvento(e, cnpj));

                    } catch (NoSuchAlgorithmException ex) {

                        Logger.getLogger(NotasFiscaisResource.class.getName()).log(Level.SEVERE, null, ex);
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
