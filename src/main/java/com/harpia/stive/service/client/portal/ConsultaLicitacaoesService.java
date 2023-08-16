package com.harpia.stive.service.client.portal;

import com.harpia.stive.domain.model.AcordosLenienciaDTO;
import com.harpia.stive.domain.model.CnepDTO;
import com.harpia.stive.domain.model.portal.FornecedorResumo;
import com.harpia.stive.domain.model.portal.PortalRecordListaLicitacao;
import com.harpia.stive.domain.model.portal.SancoesDto;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author Fernando
 */
@Service
public class ConsultaLicitacaoesService {

    @Autowired
    private WebClient webClientPortalTransparencia;

    @Autowired
    private WebClient webClientApiDados;

    public PortalRecordListaLicitacao listaParticipanteLicitacao(Integer tamanhoPagina, String cpf_cnpj) {

        List<FornecedorResumo> idsFornecedor = buscaFornecedorResumo(cpf_cnpj);

        PortalRecordListaLicitacao dados = null;
        PortalRecordListaLicitacao recordsLicitacao = new PortalRecordListaLicitacao();

        idsFornecedor.forEach(r -> System.out.println(" teste: " + r.getId()));

        for (FornecedorResumo f : idsFornecedor) {

            System.out.println("f " + f.getId());
            Map<String, String> uriParam = new LinkedHashMap<>();
            uriParam.put("idFornecedor", f.getId());

            dados = this.webClientPortalTransparencia.get().uri(uriBuilder -> uriBuilder
                    .path("/pessoa-juridica/{idFornecedor}/participante-licitacao/resultado")
                    .queryParam("paginacaoSimples", "false")
                    .queryParam("tamanhoPagina", "150")
                    .queryParam("colunaOrdenacao", "numeroLicitacao")
                    .queryParam("colunasSelecionadas", "linkDetalhamento%2Corgao%2CunidadeGestora%2CnumeroLicitacao%2CdataAbertura")
                    .queryParam("id", f.getId())
                    .build(f.getId()))
                    .retrieve()
                    .bodyToMono(PortalRecordListaLicitacao.class)
                    .log()
                    .block();

            System.out.println("dados " + dados);

            if (recordsLicitacao == null || recordsLicitacao.getData() == null) {

                recordsLicitacao = new PortalRecordListaLicitacao();
                recordsLicitacao.setData(dados.getData());
            } else {
                recordsLicitacao.getData().addAll(dados.getData());
            }
        }

        return recordsLicitacao;
    }

    public void consulSancoesCnpj() {

        Mono<AcordosLenienciaDTO[]> acordosLeniencia = this.webClientApiDados.get()
                .uri(uriBuilder -> uriBuilder
                .path("/acordos-leniencia/")
                .queryParam("cnpjSancionado", "15102288000182")
                .queryParam("pagina", "1")
                .build())
                .header("chave-api-dados", "91fdd26452bc4475d946b05eab1a3254")
                .retrieve()
                .bodyToMono(AcordosLenienciaDTO[].class);

        Mono<CnepDTO[]> cnep = webClientApiDados.get()
                .uri(uriBuilder -> uriBuilder
                .path("/cnep")
                .queryParam("codigoSancionado", "23.232.527/0001-47")
                .queryParam("pagina", "1")
                .build())
                .header("chave-api-dados", "91fdd26452bc4475d946b05eab1a3254")
                .retrieve()
                .bodyToMono(CnepDTO[].class);

        SancoesDto block = Mono.zip(acordosLeniencia, cnep).map(tuple -> {
            //System.out.println("tuple.getT1() " + tuple.getT1().toString());
            //System.out.println("tuple.getT2()" + Arrays.asList(tuple.getT2()).toString());

            SancoesDto s = new SancoesDto();
            s.setAcordos(Arrays.asList(tuple.getT1()));
            s.setCneps(Arrays.asList(tuple.getT2()));

            return s;

        }).block();
        System.out.println("block " + block);

    }

    private List<FornecedorResumo> buscaFornecedorResumo(String cpf_cnpj) {

        Mono<FornecedorResumo[]> response = this.webClientPortalTransparencia.get().uri(uriBuilder -> uriBuilder
                .path("/criterios/contratos/fornecedor/autocomplete")
                .queryParam("q", cpf_cnpj)
                .build())
                .retrieve()
                .bodyToMono(FornecedorResumo[].class)
                .log();

        FornecedorResumo[] fornecedorResumos = response.block();

        return Arrays.stream(fornecedorResumos)
                .collect(Collectors.toList());
    }

}
