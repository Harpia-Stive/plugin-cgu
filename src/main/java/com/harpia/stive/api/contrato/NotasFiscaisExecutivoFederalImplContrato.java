package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.EventoNotaFiscalDTO;
import com.harpia.stive.domain.model.ItemNotaFiscalDTO;
import com.harpia.stive.domain.model.NotaFiscalDTO;
import com.harpia.stive.util.Util;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class NotasFiscaisExecutivoFederalImplContrato {

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
    public Resultado retornaResultadoNotasFiscaisExecutivoFederal(NotaFiscalDTO nota, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Nota Fiscal");
        resultado.setReferencia(nota.getChaveNotaFiscal());

        if (nota == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Data da emissão", "dataemissao", 5, Util.formataData(nota.getDataEmissao()), "4"));
        campos.add(adicionaCampo("Tipo Evento Mais Rcente", "tipoeventrecent", 2, nota.getTipoEventoMaisRecente().substring(0, 10), "4"));
        campos.add(adicionaCampo("Data Evento Mais Recente", "dttipoevrecente", 5, Util.formataData(nota.getDataTipoEventoMaisRecente().substring(0, 10)), "4"));

        campos.add(adicionaCampo("Número", "numero", 2, nota.getNumero(), "4"));
        campos.add(adicionaCampo("Série", "serie", 2, nota.getSerie(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, nota.getValorNotaFiscal(), "4"));

        if (StringUtils.isNoneBlank(nota.getCnpjFornecedor()) && !nota.getCnpjFornecedor().contains("*")) {
            campos.add(adicionaCampo("CNPJ do Fornecedor", "cnpjfornecedor", 3, nota.getCnpjFornecedor(), "6"));
        } else {
            campos.add(adicionaCampo("CNPJ do Fornecedor", "cnpjfornecedor", 2, nota.getCnpjFornecedor(), "6"));
        }

        campos.add(adicionaCampo("Município do Fornecedor", "munfornecedor", 2, nota.getMunicipioFornecedor(), "6"));

        campos.add(adicionaCampo("Nome do Fornecedor", "nomefornecedor", 4, nota.getNomeFornecedor(), "12"));

        campos.add(adicionaCampo("Orgão Destinatario", "orgaodestinat", 2, nota.getOrgaoDestinatario(), "6"));
        campos.add(adicionaCampo("Cádigo Órgão Destinatário", "codorgaodest", 2, nota.getCodigoOrgaoDestinatario(), "6"));

        campos.add(adicionaCampo("Órgão Superior Destinatário", "orgaosupdest", 2, nota.getOrgaoSuperiorDestinatario(), "6"));
        campos.add(adicionaCampo("Código Órgão Superior Destinatário", "codorgsupedest", 2, nota.getCodigoOrgaoSuperiorDestinatario(), "6"));

        campos.add(adicionaCampo("Chave", "chave", 2, nota.getChaveNotaFiscal(), "12"));

        Date currentDate = new Date();

        if (nota.getDataEmissao() != null) {

            try {

                Long timeStamp = Util.getTimeStamp(nota.getDataEmissao());

                if (timeStamp != null) {
                    timeline.add(adicionaTimeLine(Util.getTimeStamp(nota.getDataEmissao().substring(0, 10)),
                            nota.getNomeFornecedor() + "    emitiu nota fiscal de nº " + nota.getNumero() + " para " + nota.getOrgaoDestinatario()));

                }

            } catch (ParseException ex) {
                Logger.getLogger(SancoesImplContrato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        resultado.setCampos(campos);
        resultado.setTimeline(timeline);

        //
        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_notas_fiscais" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_NOTA_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_NOTA_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Itens");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("chaveUnicaNotaFiscal", nota.getChaveNotaFiscal());
        mapPayload.put("busca", "itens");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        //
        botao = new Botao();
        //referencia = "govbr" + "$" + "govbr_notas_fiscais" + "$" + filtro;
        referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Eventos");

        mapPayload = new HashMap<>();

        mapPayload.put("chaveUnicaNotaFiscal", nota.getChaveNotaFiscal());
        mapPayload.put("busca", "eventos");

        botao.setPayload(mapPayload);

        botoes.add(botao);
        //

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoNotasFiscaisExecutivoFederalItens(ItemNotaFiscalDTO a, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Item");
        resultado.setReferencia(a.getCodigoNcmSh());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Número do Produto", "numeroproduto", 2, a.getNumeroProduto(), "4"));
        campos.add(adicionaCampo("Quantidade", "quantidade", 2, a.getQuantidade(), "4"));
        campos.add(adicionaCampo("Unidade", "unidade", 2, a.getUnidade(), "4"));

        campos.add(adicionaCampo("Valor Unitário", "valorunitario", 2, a.getValorUnitario(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, a.getValor(), "4"));
        campos.add(adicionaCampo("CFOP", "cfop", 2, a.getCfop(), "4"));

        campos.add(adicionaCampo("Desc. Produto/Serviço", "descricaoProdutoServico", 2, a.getDescricaoProdutoServico(), "6"));
        campos.add(adicionaCampo("Cod. NCM (Nomeclatura Comum Mercosul)", "codigoNcmSh", 2, a.getCodigoNcmSh(), "6"));

        campos.add(adicionaCampo("NCM/SH", "ncmSh", 2, a.getNcmSh(), "12"));

        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoNotasFiscaisExecutivoFederalEvento(EventoNotaFiscalDTO a, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
         List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Evento");
        resultado.setReferencia(a.getEvento());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Data Evento", "dataevento", 5, Util.formataData(a.getDataEvento()), "6"));
        campos.add(adicionaCampo("Tipo Evento", "tipoevento", 2, a.getTipoEvento(), "6"));
        campos.add(adicionaCampo("Evento", "evento", 2, a.getEvento(), "6"));
        campos.add(adicionaCampo("Motivo", "motivo", 2, a.getMotivo(), "12"));


        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

}
