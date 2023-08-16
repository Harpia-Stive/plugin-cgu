package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.ContratoDTO;
import com.harpia.stive.domain.model.EmpenhoComprasDTO;
import com.harpia.stive.domain.model.ItemContratadoDTO;
import com.harpia.stive.domain.model.TermoAditivoDTO;
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

public class ContratosExecutivoFederalImplContrato {

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
    public Resultado retornaResultadoContratosExecutivoFederal(ContratoDTO contrato, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Contrato");
        resultado.setReferencia(contrato.getNumero());

        if (contrato == null) {
            return resultado;
        }

        if (StringUtils.isNoneBlank(cpf) && !cpf.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpf, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpf, "4"));
        }

        campos.add(adicionaCampo("Número", "numero", 2, contrato.getNumero(), "4"));
        campos.add(adicionaCampo("Número Processo", "numeroproc", 2, contrato.getNumeroProcesso(), "4"));
        campos.add(adicionaCampo("Situação Contrato", "situacao", 2, contrato.getSituacaoContrato(), "4"));

        campos.add(adicionaCampo("Modalidade Compra", "modalidade", 2, contrato.getModalidadeCompra(), "4"));
        campos.add(adicionaCampo("Data Assinatura", "dataassi", 5, Util.formataData(contrato.getDataAssinatura()), "4"));
        campos.add(adicionaCampo("Data Publicação DOU", "datapub", 5, Util.formataData(contrato.getDataPublicacaoDOU()), "4"));

        campos.add(adicionaCampo("Data Início Vigencia", "datainicio", 5, Util.formataData(contrato.getDataInicioVigencia()), "4"));
        campos.add(adicionaCampo("Data Fim Vigência", "datafimvig", 5, Util.formataData(contrato.getDataFimVigencia()), "4"));
        campos.add(adicionaCampo("Valor Inicial Compra", "valorinivig", 2, contrato.getValorInicialCompra(), "4"));

        campos.add(adicionaCampo("Valor Final Compra", "valorfinalcom", 2, contrato.getValorFinalCompra(), "4"));
        campos.add(adicionaCampo("Nº Compra", "numerocompra", 2, contrato.getCompra().getNumero(), "4"));

        if (StringUtils.isNoneBlank(contrato.getFornecedor().getCpfFormatado()) && !contrato.getFornecedor().getCpfFormatado().contains("*")) {
            campos.add(adicionaCampo("CPF Fornecedor", "cpf", 1, contrato.getFornecedor().getCpfFormatado(), "4"));
        } else {
            campos.add(adicionaCampo("CPF Fornecedor", "cpf", 2, contrato.getFornecedor().getCpfFormatado(), "4"));
        }

        if (StringUtils.isNoneBlank(contrato.getFornecedor().getCnpjFormatado()) && !contrato.getFornecedor().getCnpjFormatado().contains("*")) {
            campos.add(adicionaCampo("CNPJ Fornecedor", "cnpj", 3, contrato.getFornecedor().getCnpjFormatado(), "4"));
        } else {
            campos.add(adicionaCampo("CNPJ Fornecedor", "cnpj", 3, contrato.getFornecedor().getCnpjFormatado(), "4"));
        }

        campos.add(adicionaCampo("Nº Incrição Social Fornecedor", "nis", 2, contrato.getFornecedor().getNumeroInscricaoSocial(), "6"));
        campos.add(adicionaCampo("Tipo Fornecedor", "tipofornecedor", 2, contrato.getFornecedor().getTipo(), "4"));

        campos.add(adicionaCampo("Nome Fornecedor", "nomefornecedor", 4, contrato.getFornecedor().getNome(), "6"));

        campos.add(adicionaCampo("Razão Social Fornecedor", "razaosocial", 4, contrato.getFornecedor().getRazaoSocialReceita(), "6"));

        campos.add(adicionaCampo("Nome Fantasia Fornecedor", "nomefantasia", 4, contrato.getFornecedor().getNomeFantasiaReceita(), "6"));

        campos.add(adicionaCampo("Objeto", "objeto", 2, contrato.getObjeto(), "12"));
        campos.add(adicionaCampo("Fundamento Legal", "fundlegal", 2, contrato.getFundamentoLegal(), "12"));

        campos.add(adicionaCampo("N° Processo Compra", "numeroproccomp", 2, contrato.getCompra().getNumeroProcesso(), "4"));
        campos.add(adicionaCampo("Contato Respons. Compra", "contatoresp", 4, contrato.getCompra().getContatoResponsavel(), "4"));

        campos.add(adicionaCampo("Nome Unid. Gestora  Compra", "nnounigest", 2, contrato.getUnidadeGestora().getNome(), "4"));
        campos.add(adicionaCampo("Descrição Poder Unid. Gestora Compra", "descpoungescom", 2, contrato.getUnidadeGestora().getDescricaoPoder(), "4"));

        campos.add(adicionaCampo("Código Unid. Gestora Compra", "codunidgest", 2, contrato.getUnidadeGestora().getCodigo(), "4"));
        campos.add(adicionaCampo("Código SIAFI da Unid. Gestora da Compra", "codorgungecom", 2, contrato.getUnidadeGestora().getOrgaoVinculado().getCodigoSIAFI(), "4"));

        campos.add(adicionaCampo("CNPJ do Órgão Vinc. a Unid. Gestora da Compra", "cnpjorgvinunge", 2, contrato.getUnidadeGestora().getOrgaoVinculado().getCnpj(), "4"));
        campos.add(adicionaCampo("Sigla Órgão Vinc. Unid. Gestora da Compra", "siglaorviunge", 2, contrato.getUnidadeGestora().getOrgaoVinculado().getSigla(), "4"));

        campos.add(adicionaCampo("Nome Órgão Vinc. Unid. Gestora da Compra", "noorgvinungeco", 2, contrato.getUnidadeGestora().getOrgaoVinculado().getNome(), "4"));

        campos.add(adicionaCampo("Código Órgão Max. Unid. Gestora da Compra", "codorungemax", 2, contrato.getUnidadeGestora().getOrgaoMaximo().getCodigo(), "4"));
        campos.add(adicionaCampo("Sigla Órgão Max. Unid. Gestora da Compra", "sigorgmaxungeco", 2, contrato.getUnidadeGestora().getOrgaoMaximo().getSigla(), "4"));

        campos.add(adicionaCampo("Nome Órgão Max. Unid. Gestora da Compra", "nomeormaungesco", 2, contrato.getUnidadeGestora().getOrgaoMaximo().getNome(), "6"));

        campos.add(adicionaCampo("Objeto Compra", "objetoCompra", 2, contrato.getCompra().getObjeto(), "6"));
        
        
        Date currentDate = new Date();
        
        try {
            
            
            if (currentDate.getTime() > Util.getTimeStamp(contrato.getDataAssinatura())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataAssinatura()), contrato.getFornecedor().getNome().trim()
                        + " teve o contrato de nº " + contrato.getNumero() +  " assinado"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataAssinatura()), contrato.getFornecedor().getNome().trim()
                        + " tem um contrato de nº " + contrato.getNumero() + " com previsão de assinatura"));
            }
            
            
            //
            if (currentDate.getTime() > Util.getTimeStamp(contrato.getDataPublicacaoDOU())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataPublicacaoDOU()), contrato.getFornecedor().getNome().trim()
                        + " teve o contrato de nº " + contrato.getNumero() +  " publicado no DOU"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataPublicacaoDOU()), contrato.getFornecedor().getNome().trim()
                        + " tem um contrato de nº " + contrato.getNumero() + " com previsão de publicaçao no DOU"));
            }
            
            
            //
            if (currentDate.getTime() > Util.getTimeStamp(contrato.getDataInicioVigencia())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataInicioVigencia()), contrato.getFornecedor().getNome().trim()
                        + " teve um contrato de nº " + contrato.getNumero() +  " que entrou em vigência"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataInicioVigencia()), contrato.getFornecedor().getNome().trim()
                       + " tem um contrato de nº " + contrato.getNumero() + " com previsão de entrar em vigor"));
            }
            
            
            //
            if (currentDate.getTime() > Util.getTimeStamp(contrato.getDataFimVigencia())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataInicioVigencia()), contrato.getFornecedor().getNome().trim()
                        + " tem um contrato de nº " + contrato.getNumero() +  " que perdeu a vigência"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(contrato.getDataInicioVigencia()), contrato.getFornecedor().getNome().trim()
                       + " tem um contrato de nº " + contrato.getNumero() +  " que perderá a vigência"));
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(BeneficiosImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);

        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_contratos" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Itens");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("id", contrato.getId());
        mapPayload.put("busca", "itens");
        mapPayload.put("cpf", cpf);
        mapPayload.put("cnpj", cnpj);

        botao.setPayload(mapPayload);

        botoes.add(botao);

        botao = new Botao();
        //referencia = "govbr" + "$" + "govbr_contratos" + "$" + filtro;
        referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Aditivos");

        mapPayload = new HashMap<>();

        mapPayload.put("id", contrato.getId());
        mapPayload.put("busca", "aditivos");
        mapPayload.put("cpf", cpf);
        mapPayload.put("cnpj", cnpj);

        botao.setPayload(mapPayload);

        botoes.add(botao);

        if (contrato != null && contrato.getCompra() != null && StringUtils.isNotBlank(contrato.getCompra().getNumeroProcesso())) {

            botao = new Botao();
            //referencia = "govbr" + "$" + "govbr_contratos" + "$" + filtro;
            referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CONTRATOS_ENDPOINT;
            botao.setReferencia(Util.md5(referencia));
            botao.setRotulo("Ver Licitação");

            mapPayload = new HashMap<>();

            mapPayload.put("numeroProcesso", contrato.getCompra().getNumeroProcesso());
            mapPayload.put("cpf", cpf);
            mapPayload.put("cnpj", cnpj);
            mapPayload.put("busca", "licitacao");

            botao.setPayload(mapPayload);

            botoes.add(botao);
        }

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoContratosExecutivoFederalItens(ItemContratadoDTO itemContratadoDTO, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Item");
        resultado.setReferencia(itemContratadoDTO.getNumero());

        if (itemContratadoDTO == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Número", "numeroItem", 2, itemContratadoDTO.getNumero(), "6"));
        campos.add(adicionaCampo("Descrição", "descricao", 2, itemContratadoDTO.getDescricao(), "6"));

        campos.add(adicionaCampo("Quantidade", "quantidade", 2, itemContratadoDTO.getQuantidade(), "6"));
        campos.add(adicionaCampo("Valor", "valor", 2, itemContratadoDTO.getValor(), "6"));
        campos.add(adicionaCampo("Descrição Complementar", "desccomplement", 2, itemContratadoDTO.getDescComplementarItemCompra(), "12"));

        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoContratosExecutivoFederalTermoAditivo(TermoAditivoDTO termo, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Aditivo");
        resultado.setReferencia(termo.getNumero().toString());

        if (termo == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Data Publicação", "datapublicacao", 5, Util.formataData(termo.getDataPublicacao()), "4"));
        campos.add(adicionaCampo("Número", "numero", 2, termo.getNumero(), "4"));
        campos.add(adicionaCampo("Objeto", "objeto", 2, termo.getObjetoAditivo(), "4"));
        
        Date currentDate = new Date();
        
        try {
            //
            if (currentDate.getTime() > Util.getTimeStamp(termo.getDataPublicacao())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(termo.getDataPublicacao()), cnpj
                        + " teve um termo aditivo de nº " + termo.getNumero() +  " publicado no DOU"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(termo.getDataPublicacao()), cnpj
                        + " tem um termo aditivo com o nº " + termo.getNumero() + " com previsão de publicaçao no DOU"));
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(ContratosExecutivoFederalImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

            resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoContratosExecutivoFederalEmpenho(EmpenhoComprasDTO empenho, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Empenho");
        resultado.setReferencia(empenho.getDataEmissao());

        if (empenho == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Empenho", "empenho", 2, empenho.getEmpenho(), "4"));
        campos.add(adicionaCampo("Empenho Resumido", "empenhoresumido", 2, empenho.getEmpenhoResumido(), "4"));
        campos.add(adicionaCampo("Data Emissão", "dataemissao", 5, Util.formataData(empenho.getDataEmissao()), "4"));
        campos.add(adicionaCampo("Observação", "observacao", 2, empenho.getObservacao(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, empenho.getValor(), "4"));
        
        Date currentDate = new Date();
        
        try {
            //
            if (currentDate.getTime() > Util.getTimeStamp(empenho.getDataEmissao())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(empenho.getDataEmissao()), cnpj
                        + " teve um empenho emitido"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp(empenho.getDataEmissao()), cnpj
                        + " tem um empenho com previsão de emissão"));
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(ContratosExecutivoFederalImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

}
