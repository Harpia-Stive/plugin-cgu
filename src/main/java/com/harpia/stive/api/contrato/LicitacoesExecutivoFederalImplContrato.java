package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.domain.model.EmpenhoComprasDTO;
import com.harpia.stive.domain.model.ItemLicitacaoDTO;
import com.harpia.stive.domain.model.LicitacaoDTO;
import com.harpia.stive.domain.model.ParticipanteLicitacaoDTO;
import com.harpia.stive.util.Util;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class LicitacoesExecutivoFederalImplContrato {

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
    //#VERIFICAR contato responsavel: tipo
    public Resultado retornaResultadoLicitacoesExecutivoFederal(LicitacaoDTO licitacao, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Licitação");
        resultado.setReferencia(licitacao.getLicitacao().getNumero());

        if (licitacao == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Número", "numero", 2, licitacao.getLicitacao().getNumero(), "4"));
        campos.add(adicionaCampo("Objeto", "objeto", 2, licitacao.getLicitacao().getObjeto(), "12"));
        campos.add(adicionaCampo("N° Processo", "numeroprocesso", 2, licitacao.getLicitacao().getNumeroProcesso(), "4"));
        campos.add(adicionaCampo("Contato Responsável", "contatorespons", 4, licitacao.getLicitacao().getContatoResponsavel(), "4"));

        campos.add(adicionaCampo("Data Resultado Compra", "dataresulcompra", 5, licitacao.getDataResultadoCompra(), "4"));
        campos.add(adicionaCampo("Data Abertura", "dataabertura", 5, licitacao.getDataAbertura(), "4"));
        campos.add(adicionaCampo("Data Referência", "datareferencia", 5, licitacao.getDataReferencia(), "4"));
        campos.add(adicionaCampo("Data Publicação", "datapublicacao", 5, licitacao.getDataPublicacao(), "4"));
        campos.add(adicionaCampo("Situação Compra", "situacaocompra", 2, licitacao.getSituacaoCompra(), "4"));
        campos.add(adicionaCampo("Modalidade Licitação", "modalidade", 2, licitacao.getModalidadeLicitacao(), "4"));
        campos.add(adicionaCampo("Instrumento Legal", "instrumlegal", 2, licitacao.getInstrumentoLegal(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, licitacao.getValor(), "4"));

        campos.add(adicionaCampo("Cód. IBGE do Município", "codigbemun", 2, licitacao.getMunicipio().getCodigoIBGE(), "4"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomecodigbemun", 2, licitacao.getMunicipio().getNomeIBGE(), "4"));
        campos.add(adicionaCampo("Código Região do Município", "codregiaomun", 2, licitacao.getMunicipio().getCodigoRegiao(), "4"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, licitacao.getMunicipio().getNomeRegiao(), "4"));
        campos.add(adicionaCampo("País", "paismun", 2, licitacao.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Município", "siglamun", 2, licitacao.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Município", "nomemun", 2, licitacao.getMunicipio().getUf().getNome(), "4"));

        campos.add(adicionaCampo("Cód. Unid. Gestora Compra", "codunigest", 2, licitacao.getUnidadeGestora().getCodigo(), "4"));
        campos.add(adicionaCampo("Nome Unid. Gestora Compra", "nomeUnidadeGestora", 2, licitacao.getUnidadeGestora().getNome(), "4"));
        campos.add(adicionaCampo("Descrição Poder Unid. Gestora Compra", "descpoderunges", 2, licitacao.getUnidadeGestora().getDescricaoPoder(), "4"));
        campos.add(adicionaCampo("Cód. SIAFI da Unid. Gestora Compra", "coorvincsiaunge", 2, licitacao.getUnidadeGestora().getOrgaoVinculado().getCodigoSIAFI(), "4"));
        campos.add(adicionaCampo("CNPJ do Órgão Vinc. a Unid. Gestora Compra", "cnpjorvincunge", 3, licitacao.getUnidadeGestora().getOrgaoVinculado().getCnpj(), "4"));
        campos.add(adicionaCampo("Sigla Órgão Vinc. Unid. Gestora Compra", "siglorgvinunige", 2, licitacao.getUnidadeGestora().getOrgaoVinculado().getSigla(), "4"));
        campos.add(adicionaCampo("Nome Órgão Vinc. Unid. Gestora Compra", "nomeorvicunidge", 2, licitacao.getUnidadeGestora().getOrgaoVinculado().getNome(), "6"));
        campos.add(adicionaCampo("Cód. Órgão Max. Unid. Gestora Compra", "coorgmaxunidege", 2, licitacao.getUnidadeGestora().getOrgaoMaximo().getCodigo(), "4"));
        campos.add(adicionaCampo("Sigla Órgão Max. Unid. Gestora Compra", "siorgmaxunges", 2, licitacao.getUnidadeGestora().getOrgaoMaximo().getSigla(), "4"));
        campos.add(adicionaCampo("Nome Órgão Max. Unid. Gestora da Compra", "nomeormaxunges", 2, licitacao.getUnidadeGestora().getOrgaoMaximo().getNome(), "4"));

        resultado.setCampos(campos);

        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_licitacoes" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_LICITACOES_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_LICITACOES_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Participantes");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("busca", "participantes");
        mapPayload.put("modalidade", licitacao.getModalidadeLicitacao());
        mapPayload.put("numero", licitacao.getLicitacao().getNumero());
        mapPayload.put("codigoUG", licitacao.getUnidadeGestora().getCodigo());
        mapPayload.put("cpf", cpf);
        mapPayload.put("cnpj", cnpj);

        botao.setPayload(mapPayload);

        botoes.add(botao);

        //
        botao = new Botao();
        //referencia = "govbr" + "$" + "govbr_licitacoes" + "$" + filtro;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Itens");

        mapPayload = new HashMap<>();

        mapPayload.put("id", licitacao.getId());
        mapPayload.put("busca", "itens");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        //
        botao = new Botao();
        //referencia = "govbr" + "$" + "govbr_licitacoes" + "$" + filtro;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Empenhos");

        mapPayload = new HashMap<>();

        mapPayload.put("modalidade", licitacao.getModalidadeLicitacao());
        mapPayload.put("numero", licitacao.getLicitacao().getNumero());
        mapPayload.put("codigoUG", licitacao.getUnidadeGestora().getCodigo());
        mapPayload.put("cpf", cpf);
        mapPayload.put("cnpj", cnpj);

        mapPayload.put("busca", "empenhos");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        botao = new Botao();
        //referencia = "govbr" + "$" + "govbr_licitacoes" + "$" + filtro;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Contratos Relacionados");

        mapPayload = new HashMap<>();

        mapPayload.put("modalidade", licitacao.getModalidadeLicitacao());
        mapPayload.put("numero", licitacao.getLicitacao().getNumero());
        mapPayload.put("codigoUG", licitacao.getUnidadeGestora().getCodigo());
        mapPayload.put("cpf", cpf);
        mapPayload.put("cnpj", cnpj);

        mapPayload.put("busca", "relacionados");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setBotoes(botoes);

        return resultado;
    }

    //#VERIFICAR CPF/CNPJ vencedor: tipo
    public Resultado retornaResultadoLicitacoesExecutivoFederalItens(ItemLicitacaoDTO item, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Item");
        resultado.setReferencia(item.getNumero());

        if (item == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Código", "codigo", 2, item.getCodigoItemCompra(), "4"));
        campos.add(adicionaCampo("Número", "numero", 2, item.getNumero(), "4"));
        campos.add(adicionaCampo("Descrição", "descricao", 2, item.getDescricao(), "4"));
        campos.add(adicionaCampo("Quantidade", "quantidade", 2, item.getQuantidade(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, item.getValor(), "4"));

        if (StringUtils.isNoneBlank(item.getCpfCnpjVencedor()) && !item.getCpfCnpjVencedor().contains("*")) {
            campos.add(adicionaCampo("CNPJ Vencedor", "cnpj", 3, item.getCpfCnpjVencedor(), "4"));
        } else {
            campos.add(adicionaCampo("CNPJ Vencedor", "cnpj", 2, item.getCpfCnpjVencedor(), "4"));
        }

        if (StringUtils.isNoneBlank(item.getCpfCnpjVencedor()) && !item.getCpfCnpjVencedor().contains("*")) {
            campos.add(adicionaCampo("CPF Vencedor", "cpf", 1, item.getCpfCnpjVencedor(), "4"));
        } else {
            campos.add(adicionaCampo("CPF Vencedor", "cpf", 2, item.getCpfCnpjVencedor(), "4"));
        }

        campos.add(adicionaCampo("Tipo Pessoa Vencedor", "tipopessoa", 2, item.getTipoPessoa(), "4"));
        campos.add(adicionaCampo("Id Vencedor", "idvencedor", 2, item.getIdVencedor(), "4"));
        campos.add(adicionaCampo("Nome Vencedor", "nomevencedor", 4, item.getNome(), "6"));
        campos.add(adicionaCampo("Descrição Complementar", "desccomplementa", 2, item.getDescComplementarItemCompra(), "4"));
        campos.add(adicionaCampo("Descrição Unidade", "descunid", 2, item.getDescUnidadeFornecimento(), "12"));

        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    //#VERIFICAR CPF/CNPJ participante: tipo
    public Resultado retornaResultadoLicitacoesExecutivoFederalParticipante(ParticipanteLicitacaoDTO participante, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Participante");
        resultado.setReferencia(participante.getIdParticipante());

        if (participante == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Tipo", "tipoparticipant", 2, participante.getTipoParticipante(), "4"));

        if (StringUtils.isNoneBlank(participante.getCpfCnpj()) && !participante.getCpfCnpj().contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, participante.getCpfCnpj(), "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, participante.getCpfCnpj(), "4"));
        }

        if (StringUtils.isNoneBlank(participante.getCpfCnpj()) && !participante.getCpfCnpj().contains("*")) {
            campos.add(adicionaCampo("CNPJ", "cnpj", 3, participante.getCpfCnpj(), "4"));
        } else {
            campos.add(adicionaCampo("CNPJ", "cnpj", 3, participante.getCpfCnpj(), "4"));
        }

        campos.add(adicionaCampo("Nome", "nome", 4, participante.getNome(), "4"));

        resultado.setCampos(campos);

        return resultado;
    }

    public Resultado retornaResultadoLicitacoesExecutivoFederalEmpenho(EmpenhoComprasDTO empenho, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Empenho");
        resultado.setReferencia(empenho.getEmpenhoResumido());

        if (empenho == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Empenho", "empenho", 2, empenho.getEmpenho(), "4"));
        //campos.add(adicionaCampo("Empenho Resumido", "empenhoresumido", 2, empenho.getEmpenhoResumido(), "4"));
        campos.add(adicionaCampo("Data Emissão", "dataemissao", 5, empenho.getDataEmissao(), "4"));
        campos.add(adicionaCampo("Observação", "observacao", 2, empenho.getObservacao(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, empenho.getValor(), "4"));

        resultado.setCampos(campos);

        return resultado;
    }

    public Resultado retornaResultadoLicitacoesExecutivoFederalContratos(EmpenhoComprasDTO empenho, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Contratos Rel");
        resultado.setReferencia(empenho.getEmpenhoResumido());

        if (empenho == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Empenho", "empenho", 2, empenho.getEmpenho(), "4"));
        //campos.add(adicionaCampo("Empenho Resumido", "empenhoresumido", 2, empenho.getEmpenhoResumido(), "4"));
        campos.add(adicionaCampo("Data Emissão", "dataemissao", 5, empenho.getDataEmissao(), "4"));
        campos.add(adicionaCampo("Observação", "observacao", 2, empenho.getObservacao(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, empenho.getValor(), "4"));

        resultado.setCampos(campos);

        return resultado;
    }

}
