package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.DespesasPorDocumentoDTO;
import com.harpia.stive.domain.model.DocumentoRelacionadoDTO;
import com.harpia.stive.util.Util;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class DespesasImplContrato {

    public static ContratoApi contratoApi = new ContratoApi();

    private Resultado resultado;

    /*
       1    CPF
       2    TEXTO
       3    CNPJ
       4    NOME
       5    DATA
       6    TELEFONE
       7    PLACA
       8    LINK
       9    HTML
     */
    public Resultado retornaResultadoDespesa(DespesasPorDocumentoDTO a, String cpfCnpj, int fase) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento(a.getFase());
        resultado.setReferencia(a.getDocumentoResumido());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Data", "data", 5, a.getData(), "4"));
        campos.add(adicionaCampo("Fase", "fase", 2, a.getFase(), "4"));
        campos.add(adicionaCampo("Código UG", "codigoUg", 2, a.getCodigoUg(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, a.getValor(), "4"));
        campos.add(adicionaCampo("UF Favorecido", "uffavorecido", 2, a.getUfFavorecido(), "4"));
        campos.add(adicionaCampo("Nome Favorecido", "nomefavorecido", 4, a.getNomeFavorecido(), "4"));

        if (Util.isCNPJ(a.getCodigoFavorecido())) {
            campos.add(adicionaCampo("CNPJ Favorecido", "codfavorecido", 3, a.getCodigoFavorecido(), "4"));
        } else if (Util.isCPF(a.getCodigoFavorecido())) {
            campos.add(adicionaCampo("CPF Favorecido", "codfavorecido", 1, a.getCodigoFavorecido(), "4"));
        } else if (StringUtils.isNotBlank(a.getCodigoFavorecido())) {
            campos.add(adicionaCampo("Código Favorecido", "codfavorecido", 2, a.getCodigoFavorecido(), "4"));
        } else {
            campos.add(adicionaCampo("Código Favorecido", "codfavorecido", 2, cpfCnpj, "4"));
        }

        campos.add(adicionaCampo("Favorecido", "favorecido", 2, a.getFavorecido(), "12"));
        //campos.add(adicionaCampo("Favorecido Lista Faturas", "favorelistafat", 5, a.get, "4"));
        //campos.add(adicionaCampo("Favorecido Intermediário", "favorecidointe", 5, a.get, "4"));
        campos.add(adicionaCampo("Autor", "autor", 2, a.getAutor(), "4"));
        campos.add(adicionaCampo("Plano Orcamentário", "planoorcamentar", 2, a.getPlanoOrcamentario(), "6"));
        campos.add(adicionaCampo("Número Processo", "numeroprocesso", 2, a.getNumeroProcesso(), "4"));
        campos.add(adicionaCampo("Modalidade", "modalidade", 2, a.getModalidade(), "4"));
        campos.add(adicionaCampo("Elemento", "elemento", 2, a.getElemento(), "4"));
        campos.add(adicionaCampo("Grupo", "grupo", 2, a.getGrupo(), "4"));
        campos.add(adicionaCampo("Categoria", "categoria", 2, a.getCategoria(), "4"));
        campos.add(adicionaCampo("Espécie", "especie", 2, a.getEspecie(), "4"));
        campos.add(adicionaCampo("Localizador Gasto", "localigasto", 2, a.getLocalizadorGasto(), "4"));
        campos.add(adicionaCampo("Subtitulo", "subtitulo", 2, a.getSubTitulo().trim(), "6"));
        campos.add(adicionaCampo("Ação", "acao", 2, a.getAcao(), "6"));
        campos.add(adicionaCampo("Programa", "programa", 2, a.getPrograma(), "6"));
        campos.add(adicionaCampo("Subfunção", "subfuncao", 2, a.getSubfuncao(), "4"));
        campos.add(adicionaCampo("Função", "funcao", 2, a.getFuncao(), "4"));
        campos.add(adicionaCampo("Observação", "observacao", 2, a.getObservacao().trim(), "12"));
        campos.add(adicionaCampo("Documento Resumido", "docresumido", 2, a.getDocumentoResumido(), "4"));
        campos.add(adicionaCampo("Documento", "documento", 2, a.getDocumento(), "4"));
        campos.add(adicionaCampo("Órgao Superior", "orgaosuperior", 2, a.getOrgaoSuperior(), "4"));
        campos.add(adicionaCampo("Código Órgão Superior", "codorsup", 2, a.getCodigoOrgaoSuperior(), "4"));
        campos.add(adicionaCampo("Órgão", "orgao", 2, a.getOrgao(), a.getOrgao()));
        campos.add(adicionaCampo("Código Orgão", "codigoorgao", 2, a.getCodigoOrgao(), "4"));
        campos.add(adicionaCampo("Código UO", "uo", 2, a.getUo(), "4"));
        campos.add(adicionaCampo("UG", "ug", 2, a.getUg(), "4"));

        botao = new Botao();

        Map<String, Object> mapPayload = new HashMap<>();

        if (fase == 1) {//empenho

            String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_EMPENHOS_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_EMPENHOS_ENDPOINT;
            botao.setReferencia(Util.md5(referencia));
            botao.setRotulo("Documentos Relacionados");

            mapPayload = new HashMap<>();

            mapPayload.put("busca", "doc_relacionados");
            mapPayload.put("documento", a.getDocumento());

        } else if (fase == 2) {//liquidacao

            String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_LIQUIDACAO_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_LIQUIDACAO_ENDPOINT;
            botao.setReferencia(Util.md5(referencia));
            botao.setRotulo("Documentos Relacionados");

            mapPayload = new HashMap<>();

            mapPayload.put("busca", "doc_relacionados");
            mapPayload.put("documento", a.getDocumento());

        }

        botao.setPayload(mapPayload);

        botoes.add(botao);

        if (a.getData() != null) {

            try {

                Long timeStamp = Util.getTimeStamp(a.getData());

                if (timeStamp != null) {
                    timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getData()), "Foi favorecido de " + a.getFase() + " " + a.getDocumento()
                            + " com " + a.getOrgao()));
                }

            } catch (ParseException ex) {
                Logger.getLogger(SancoesImplContrato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        resultado.setCampos(campos);
        resultado.setTimeline(timeline);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoDocumentosRelacionados(DocumentoRelacionadoDTO a, int fase) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento(a.getFase());
        resultado.setReferencia(a.getDocumentoResumido());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Data", "data", 5, a.getData(), "4"));
        campos.add(adicionaCampo("Fase", "fase", 2, a.getFase(), "4"));
        campos.add(adicionaCampo("Documento", "documento", 2, a.getDocumento(), "4"));
        campos.add(adicionaCampo("Documento Resumido", "documentores", 2, a.getDocumentoResumido(), "4"));
        campos.add(adicionaCampo("Espécie", "especie", 2, a.getEspecie(), "4"));
        campos.add(adicionaCampo("Favorecido", "favorecido", 4, a.getFavorecido(), "12"));
        campos.add(adicionaCampo("Elemento Despesa", "elemento", 2, a.getElementoDespesa(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, a.getValor(), "4"));
        campos.add(adicionaCampo("Órgao Superior", "orgaosuperior", 2, a.getOrgaoSuperior(), "4"));
        campos.add(adicionaCampo("Unidade Gestora", "unigestora", 2, a.getUnidadeGestora(), "4"));
        campos.add(adicionaCampo("Órgão Vinculado", "orgvinc", 2, a.getOrgaoVinculado(), "4"));

        botao = new Botao();

        Map<String, Object> mapPayload = new HashMap<>();

        if (StringUtils.isNotBlank(a.getFase()) && a.getFase().equalsIgnoreCase("Liquidação")) {//liquidacao

            String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_LIQUIDACAO_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_LIQUIDACAO_ENDPOINT;
            botao.setReferencia(Util.md5(referencia));
            botao.setRotulo("Buscar " + a.getFase());

            mapPayload = new HashMap<>();

            mapPayload.put("busca", "documento");
            mapPayload.put("documento", a.getDocumento());
            botao.setPayload(mapPayload);

            botoes.add(botao);
        }

        resultado.setCampos(campos);
        resultado.setTimeline(timeline);
        resultado.setBotoes(botoes);

        return resultado;
    }
}
