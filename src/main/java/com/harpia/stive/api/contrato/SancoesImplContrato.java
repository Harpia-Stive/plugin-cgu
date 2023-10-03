package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.AcordosLenienciaDTO;
import com.harpia.stive.domain.model.CeafDTO;
import com.harpia.stive.domain.model.CeisDTO;
import com.harpia.stive.domain.model.CepimDTO;
import com.harpia.stive.domain.model.CnepDTO;
import com.harpia.stive.domain.model.CodigoDescricaoDTO;
import com.harpia.stive.domain.model.EmpresaSancionadaDTO;
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

public class SancoesImplContrato {

    private static Integer x = 1;

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
    public Resultado retornaResultadoAcordoLeniencia(AcordosLenienciaDTO a) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Acord Leniência");
        resultado.setReferencia(a.getId().toString());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Data Ínicio", "datainicio", 2, Util.formataData(a.getDataInicioAcordo()), "6"));
        campos.add(adicionaCampo("Data Fim", "datafim", 2, Util.formataData(a.getDataFimAcordo()), "6"));

        campos.add(adicionaCampo("Situação Acordo", "ituacaoacordo", 2, a.getSituacaoAcordo(), "6"));
        campos.add(adicionaCampo("Total de Empresas Sancionadas", "quantidade", 2, a.getQuantidade(), "6"));

        campos.add(adicionaCampo("Órgão Responsável", "orgaorespons", 2, a.getOrgaoResponsavel(), "12"));

        Date currentDate = new Date();

        try {
            //
            if (currentDate.getTime() > Util.getTimeStamp(a.getDataInicioAcordo())) {

                timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataInicioAcordo()), "Ínicio de Acordo de Leniência"));

            } else {

                timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataInicioAcordo()), "Ínicio de Acordo de Leniência"));
            }

            //
            if (currentDate.getTime() > Util.getTimeStamp(a.getDataInicioAcordo())) {

                timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataInicioAcordo()), "Témino de Acordo de Leniência"));

            } else {

                timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataInicioAcordo()), "Témino de Acordo de Leniência"));
            }

        } catch (ParseException ex) {
            Logger.getLogger(SancoesImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);

        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_acordos_leniencia" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_ACORDOLENIENCIA_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_ACORDOLENIENCIA_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Empresas");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("id", a.getId());
        mapPayload.put("busca", "empresas");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoAcordoLenienciaEmpresas(EmpresaSancionadaDTO s) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Acordo Leniência");
        resultado.setReferencia(x.toString() + "I");
        x++;

        if (s == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Nome Informado", "nome", 4, s.getNomeInformadoOrgaoResponsavel(), "12"));
        campos.add(adicionaCampo("Razão Social", "razaosocial", 4, s.getRazaoSocial(), "12"));
        campos.add(adicionaCampo("Nome Fantasia", "fantasia", 4, s.getNomeFantasia(), "6"));

        if (StringUtils.isNoneBlank(s.getCnpj()) && !s.getCnpj().contains("*")) {
            campos.add(adicionaCampo("CNPJ", "cnpj", 3, s.getCnpj(), "6"));
        } else {
            campos.add(adicionaCampo("CNPJ", "cnpj", 3, s.getCnpj(), "6"));
        }

        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoCepim(CepimDTO a, String filtro) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("CEPIM");
        resultado.setReferencia(a.getId().toString());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("CNPJ", "cnpj", 3, a.getPessoaJuridica().getCnpjFormatado(), "4"));
        campos.add(adicionaCampo("CPF", "cpf", 1, a.getPessoaJuridica().getCpfFormatado(), "4"));
        campos.add(adicionaCampo("N° Inscrição Social", "nis", 2, a.getPessoaJuridica().getNumeroInscricaoSocial(), "4"));

        campos.add(adicionaCampo("Número Convênio", "numeroconvenio", 2, a.getConvenio().getNumero(), "4"));
        campos.add(adicionaCampo("Data de Referência", "datareferencia", 5, Util.formataData(a.getDataReferencia()), "4"));
        campos.add(adicionaCampo("Código Convênio", "codigoconvenio", 2, a.getConvenio().getCodigo(), "4"));

        campos.add(adicionaCampo("Tipo", "tipo", 2, a.getPessoaJuridica().getTipo(), "6"));

        campos.add(adicionaCampo("Nome", "nome", 2, a.getPessoaJuridica().getNome(), "12"));

        campos.add(adicionaCampo("Razão Social", "razaosocial", 2, a.getPessoaJuridica().getRazaoSocialReceita(), "12"));

        campos.add(adicionaCampo("Nome Fantasia", "nomefantasia", 2, a.getPessoaJuridica().getNomeFantasiaReceita(), "12"));

        campos.add(adicionaCampo("Objeto Convênio", "objetoconvenio", 2, a.getConvenio().getObjeto(), "12"));

        campos.add(adicionaCampo("Motivo", "motivo", 2, a.getMotivo(), "12"));

        campos.add(adicionaCampo("Nome Órgão Superior", "nomeorgsuperior", 2, a.getOrgaoSuperior().getNome(), "12"));

        campos.add(adicionaCampo("Código SIAFI Órgão Superior", "codsiafiorgosup", 2, a.getOrgaoSuperior().getCodigoSIAFI(), "4"));
        campos.add(adicionaCampo("Cnpj Órgão Superior", "cnpjorgSup", 2, a.getOrgaoSuperior().getCnpj(), "4"));
        campos.add(adicionaCampo("Sigla Órgão Superior", "siglaorgaosup", 2, a.getOrgaoSuperior().getSigla(), "4"));

        campos.add(adicionaCampo("Descrição Poder Órgão Superior", "descpoderorgsup", 2, a.getOrgaoSuperior().getDescricaoPoder(), "4"));
        campos.add(adicionaCampo("Código Órgão Máximo", "codorgmaxorgsup", 2, a.getOrgaoSuperior().getOrgaoMaximo().getCodigo(), "4"));
        campos.add(adicionaCampo("Sigla Órgão Máximo", "sigorgmaxorgsup", 2, a.getOrgaoSuperior().getOrgaoMaximo().getSigla(), "4"));

        campos.add(adicionaCampo("Nome Órgão Máximo", "nomorgmaxorgsup", 2, a.getOrgaoSuperior().getOrgaoMaximo().getNome(), "12"));

        Date currentDate = new Date();

        try {
            //
            if (currentDate.getTime() > Util.getTimeStamp(a.getDataReferencia())) {

                timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataReferencia()), a.getPessoaJuridica().getNome()
                        + " teve o nome incluído no CEPIM"));

            } else {

                timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataReferencia()), a.getPessoaJuridica().getNome()
                        + " teve o nome incluído no CEPIM"));
            }

        } catch (ParseException ex) {
            Logger.getLogger(ContratosExecutivoFederalImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);

        return resultado;
    }

    public Resultado retornaResultadoCeis(CeisDTO a, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("CEIS");
        resultado.setReferencia(a.getNumeroProcesso());

        if (a == null) {
            return resultado;
        }

        String cpfAux = null;
        String cnpjAux = null;

        if (StringUtils.isNotBlank(cpf)) {

            cpfAux = cpf;
            cnpjAux = a.getPessoa().getCnpjFormatado();

        } else if (StringUtils.isNotBlank(cnpj)) {

            cpfAux = a.getPessoa().getCpfFormatado();
            cnpjAux = cnpj;
        }

        campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        campos.add(adicionaCampo("CNPJ", "cnpj", 3, cnpjAux, "4"));
        campos.add(adicionaCampo("N° Inscrição Social", "nis", 2, a.getPessoa().getNumeroInscricaoSocial(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 2, a.getPessoa().getNome(), "12"));

        campos.add(adicionaCampo("Razão Social", "razaosocial", 2, a.getPessoa().getRazaoSocialReceita(), "12"));

        campos.add(adicionaCampo("Nome Fantasia", "nomefantasia", 2, a.getPessoa().getNomeFantasiaReceita(), "12"));

        campos.add(adicionaCampo("Tipo", "tipo", 2, a.getPessoa().getTipo(), "4"));
        campos.add(adicionaCampo("Data de Referência", "datareferencia", 5, Util.formataData(a.getDataReferencia()), "4"));
        campos.add(adicionaCampo("Data Ínicio Sanção", "datainicio", 5, Util.formataData(a.getDataInicioSancao()), "4"));

        campos.add(adicionaCampo("Data Fim Sançaõ", "datadim", 5, Util.formataData(a.getDataFimSancao()), "4"));
        campos.add(adicionaCampo("Número Processo", "numeroprocesso", 2, a.getNumeroProcesso(), "4"));
        campos.add(adicionaCampo("Data Publicação Sanção", "datapublicacao", 5, Util.formataData(a.getDataPublicacaoSancao()), "4"));

        campos.add(adicionaCampo("Data Transitado Julgado", "datatransitado", 5, Util.formataData(a.getDataTransitadoJulgado()), "4"));
        campos.add(adicionaCampo("Data Origem Informação", "dataorigeminfo", 5, Util.formataData(a.getDataOrigemInformacao()), "4"));
        campos.add(adicionaCampo("Telefone Fonte Sanção", "telefonefonte", 6, a.getFonteSancao().getTelefoneContato(), "4"));

        campos.add(adicionaCampo("Tipo Sanção", "tipo", 2, a.getTipoSancao().getDescricaoPortal(), "6"));
        campos.add(adicionaCampo("Nome Fonte Sanção", "nomefonte", 2, a.getFonteSancao().getNomeExibicao(), "6"));

        campos.add(adicionaCampo("Endereço Fonte Sanção", "enderecofonte", 2, a.getFonteSancao().getEnderecoContato(), "12"));

        campos.add(adicionaCampo("Texto Publicação", "textopubli", 2, a.getTextoPublicacao(), "12"));

        campos.add(adicionaCampo("Link Publicação", "linkpub", 2, a.getLinkPublicacao(), "12"));

        campos.add(adicionaCampo("Detalhamento Publicação", "detalhamentoPub", 2, a.getDetalhamentoPublicacao(), "12"));

        campos.add(adicionaCampo("Abragência Definida Decisão Judicial", "abrandefdecijud", 2, a.getAbrangenciaDefinidaDecisaoJudicial(), "4"));
        campos.add(adicionaCampo("Informação Adicional Órgão Julgador", "infoadiorgsanc", 2, a.getInformacoesAdicionaisDoOrgaoSancionador(), "4"));
        campos.add(adicionaCampo("Nome Órgão Sancionador", "nomeorgasanc", 2, a.getOrgaoSancionador().getNome(), "12"));

        campos.add(adicionaCampo("Sigla UF Órgão Sancionador", "uforgsanc", 2, a.getOrgaoSancionador().getSiglaUf(), "4"));
        campos.add(adicionaCampo("Poder Órgão Sancionador", "poderorgasanc", 2, a.getOrgaoSancionador().getPoder(), "4"));

        campos.add(adicionaCampo("Código Sancionado", "codforsanc", 2, a.getSancionado().getCodigoFormatado(), "4"));
        campos.add(adicionaCampo("Nome Sancionado", "nomesancion", 2, a.getSancionado(), "12"));

        Date currentDate = new Date();

        try {
            //

            //
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataInicioSancao()),
                    "Ínicio das sanções em decorrência do cadastramento no CEIS"));

            //
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataFimSancao()),
                    "Término das Sanções em decorrência do cadastramento no CEIS"));

            //
            if (a.getDataPublicacaoSancao() != null) {

                Long timeStamp = Util.getTimeStamp(a.getDataPublicacaoSancao());

                if (timeStamp != null) {

                    if (currentDate.getTime() > Util.getTimeStamp(a.getDataPublicacaoSancao())) {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataPublicacaoSancao()), "Sanções publicadas no DOU"));

                    } else {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataPublicacaoSancao()), "Publicação das Sanções no DOU"));
                    }
                }
            }

            if (a.getDataTransitadoJulgado() != null) {

                Long timeStamp = Util.getTimeStamp(a.getDataTransitadoJulgado());

                if (timeStamp != null) {

                    if (currentDate.getTime() > Util.getTimeStamp(a.getDataTransitadoJulgado())) {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataTransitadoJulgado()), "Processo que gerou as sanções transitado em jugado"));

                    } else {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataTransitadoJulgado()), "Processo que gerará as sanções transitado em jugado"));
                    }
                }
            }

            /*if (currentDate.getTime() > Util.getTimeStamp(a.getDataOrigemInformacao())) {
            
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataOrigemInformacao()), " Origem das Informações"));
            
            } else {
            
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataOrigemInformacao()), " Origem das Informações"));
            }*/
        } catch (ParseException ex) {
            Logger.getLogger(ContratosExecutivoFederalImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);

        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_ceis" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CEIS_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CEIS_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Fundamentação");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("id", a.getId());
        mapPayload.put("cnpj", cnpj);
        mapPayload.put("cpf", cpf);
        mapPayload.put("busca", "fundamentacao");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoCeisFundamentacao(CodigoDescricaoDTO a, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("CEPIM");
        resultado.setReferencia(x.toString());
        x++;

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Código", "codigo", 2, a.getCodigo(), "12"));
        campos.add(adicionaCampo("Descrição", "descricao", 2, a.getDescricao(), "12"));

        resultado.setCampos(campos);

        return resultado;
    }

    public Resultado retornaResultadoCnep(CnepDTO a, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("CNEP");
        resultado.setReferencia(a.getNumeroProcesso());

        if (a == null) {
            return resultado;
        }

        String cpfAux = null;
        String cnpjAux = null;

        if (StringUtils.isNotBlank(cpf)) {

            cpfAux = cpf;
            cnpjAux = a.getPessoa().getCnpjFormatado();

        } else if (StringUtils.isNotBlank(cnpj)) {

            cpfAux = a.getPessoa().getCpfFormatado();
            cnpjAux = cnpj;
        }

        campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        campos.add(adicionaCampo("CNPJ", "cnpj", 3, a.getPessoa().getCnpjFormatado(), "4"));
        campos.add(adicionaCampo("N° Inscrição Social", "nis", 2, a.getPessoa().getNumeroInscricaoSocial(), "4"));

        campos.add(adicionaCampo("Nome", "nomeceis", 2, a.getPessoa().getNome(), "6"));
        campos.add(adicionaCampo("Razão Social", "razaosocial", 4, a.getPessoa().getRazaoSocialReceita(), "6"));
        campos.add(adicionaCampo("Nome Fantasia", "nomefantasia", 4, a.getPessoa().getNomeFantasiaReceita(), "6"));
        campos.add(adicionaCampo("Tipo", "tipo", 2, a.getPessoa().getTipo(), "6"));

        campos.add(adicionaCampo("Multa", "multa", 2, a.getValorMulta(), "4"));
        campos.add(adicionaCampo("Data de Referência", "datafefe", 5, Util.formataData(a.getDataReferencia()), "4"));
        campos.add(adicionaCampo("Data Ínicio Sanção", "datainicio", 5, Util.formataData(a.getDataInicioSancao()), "4"));
        campos.add(adicionaCampo("Data Fim Sançaõ", "datafim", 5, Util.formataData(a.getDataFimSancao()), "4"));
        campos.add(adicionaCampo("Data Publicação Sanção", "datapublic", 2, Util.formataData(a.getDataPublicacaoSancao()), "4"));
        campos.add(adicionaCampo("Data Transitado Julgado", "datatransi", 2, Util.formataData(a.getDataTransitadoJulgado()), "4"));
        campos.add(adicionaCampo("Data Origem Informação", "dataorigem", 2, Util.formataData(a.getDataOrigemInformacao()), "4"));
        campos.add(adicionaCampo("Tipo Sanção", "tiposancao", 2, a.getTipoSancao().getDescricaoPortal(), "4"));
        campos.add(adicionaCampo("Nome Fonte Sanção", "nomefonte", 2, a.getFonteSancao().getNomeExibicao(), "4"));
        campos.add(adicionaCampo("Telefone Fonte Sanção", "telefone", 6, a.getFonteSancao().getTelefoneContato(), "6"));
        campos.add(adicionaCampo("Código Sancionado", "codigosanci", 2, a.getSancionado().getCodigoFormatado(), "6"));
        campos.add(adicionaCampo("Endereço Fonte Sanção", "enderecocontato", 2, a.getFonteSancao().getEnderecoContato(), "12"));

        campos.add(adicionaCampo("Nome Sancionado", "nomesancion", 4, a.getSancionado().getNome(), "12"));

        campos.add(adicionaCampo("Link Publicação", "linkpublicacao", 8, a.getLinkPublicacao(), "12"));

        campos.add(adicionaCampo("Detalhamento Publicação", "detalpubl", 2, a.getDetalhamentoPublicacao(), "6"));
        campos.add(adicionaCampo("Texto Publicação", "textopubl", 2, a.getTextoPublicacao(), "6"));

        campos.add(adicionaCampo("Número Processo", "numeroproces", 2, a.getNumeroProcesso(), "6"));
        campos.add(adicionaCampo("Abragência Definida Decisão Judicial", "abrandecisao", 2, a.getAbrangenciaDefinidaDecisaoJudicial(), "6"));
        campos.add(adicionaCampo("Informação Adicional Órgão Julgador", "infoorgsanc", 2, a.getInformacoesAdicionaisDoOrgaoSancionador(), "6"));

        campos.add(adicionaCampo("Nome Órgão Sancionador", "nomeorgaosancio", 2, a.getOrgaoSancionador().getNome(), "6"));
        campos.add(adicionaCampo("Sigla UF Órgão Sancionador", "uforgaoSancio", 2, a.getOrgaoSancionador().getSiglaUf(), "6"));
        campos.add(adicionaCampo("Poder Órgão Sancionador", "poderorgaoSanci", 2, a.getOrgaoSancionador().getPoder(), "6"));

        /*
                campos.add(adicionaCampo("Data de Referência", "datafefe", 5, a.getDataReferencia(), "4"));
        campos.add(adicionaCampo("Data Ínicio Sanção", "datainicio", 5, a.getDataInicioSancao(), "4"));
        campos.add(adicionaCampo("Data Fim Sançaõ", "datafim", 5, a.getDataFimSancao(), "4"));
        campos.add(adicionaCampo("Data Publicação Sanção", "datapublic", 2, a.getDataPublicacaoSancao(), "4"));
        campos.add(adicionaCampo("Data Transitado Julgado", "datatransi", 2, a.getDataTransitadoJulgado(), "4"));
        campos.add(adicionaCampo("Data Origem Informação", "dataorigem", 2, a.getDataOrigemInformacao(), "4"));
         */
        Date currentDate = new Date();

        try {
            //

            //
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataInicioSancao()),
                    "Ínicio das sanções em decorrência do cadastramento no CNEP"));

            //
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataFimSancao()),
                    "Término das Sanções em decorrência do cadastramento no CNEP"));

            //
            if (a.getDataPublicacaoSancao() != null) {

                Long timeStamp = Util.getTimeStamp(a.getDataPublicacaoSancao());

                if (timeStamp != null) {

                    if (currentDate.getTime() > Util.getTimeStamp(a.getDataPublicacaoSancao())) {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataPublicacaoSancao()), "Sanções publicadas no DOU"));

                    } else {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataPublicacaoSancao()), "Publicação das Sanções no DOU"));
                    }
                }
            }

            if (a.getDataTransitadoJulgado() != null) {

                Long timeStamp = Util.getTimeStamp(a.getDataTransitadoJulgado());

                if (timeStamp != null) {

                    if (currentDate.getTime() > Util.getTimeStamp(a.getDataTransitadoJulgado())) {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataTransitadoJulgado()), "Processo que gerou as sanções transitado em jugado"));

                    } else {

                        timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataTransitadoJulgado()), "Processo que gerará as sanções transitado em jugado"));
                    }
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(ContratosExecutivoFederalImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setCampos(campos);

        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_cnep" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CNEP_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CNEP_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Fundamentação");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("id", a.getId());
        mapPayload.put("cnpj", cnpj);
        mapPayload.put("cpf", cpf);
        mapPayload.put("busca", "fundamentacao");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setTimeline(timeline);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoCnepFundamentacao(CodigoDescricaoDTO a, String cpf, String cnpj) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("CNEP");
        resultado.setReferencia(x.toString());
        x++;

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Código", "codigo", 2, a.getCodigo(), "12"));
        campos.add(adicionaCampo("Descrição", "descricao", 2, a.getDescricao(), "12"));

        resultado.setCampos(campos);

        return resultado;
    }

    public Resultado retornaResultadoCeaf(CeafDTO a, String cpf) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("CEAF");
        resultado.setReferencia(Util.formataData(a.getDataReferencia()));

        if (a == null) {
            return resultado;
        }

        String cpfAux = null;
        String cnpjAux = null;

        if (StringUtils.isNotBlank(cpf)) {

            cpfAux = cpf;
            cnpjAux = a.getPessoa().getCnpjFormatado();

        } else {

            cnpjAux = a.getPessoa().getCnpjFormatado();
            cpfAux = a.getPessoa().getCpfFormatado();
        }

        campos.add(adicionaCampo("Data da Publicação", "datapublic", 5, Util.formataData(a.getDataPublicacao()), "4"));
        campos.add(adicionaCampo("Data de Referência", "datarefer", 5, Util.formataData(a.getDataReferencia()), "4"));
        campos.add(adicionaCampo("Cargo Efetivo", "cargoefeti", 2, a.getCargoEfetivo(), "4"));
        campos.add(adicionaCampo("Código Cargo Comissão", "codcargcomi", 2, a.getCodigoCargoComissao(), "4"));
        campos.add(adicionaCampo("Cargo Comissão", "cargocomissao", 2, a.getCargoComissao(), "4"));
        campos.add(adicionaCampo("CPF", "cpfpessoa", 1, cpfAux, "4"));
        campos.add(adicionaCampo("CNPJ", "cnpjpessoa", 3, cnpjAux, "4"));
        campos.add(adicionaCampo("N° Inscrição Social", "nis", 2, a.getPessoa().getNumeroInscricaoSocial(), "4"));
        campos.add(adicionaCampo("Tipo Pessoa", "tipopessoa", 2, a.getPessoa().getTipo(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 4, a.getPessoa().getNome(), "12"));

        campos.add(adicionaCampo("Razão Social", "razaosocial", 4, a.getPessoa().getRazaoSocialReceita(), "12"));

        campos.add(adicionaCampo("Nome Fantasia", "fantasia", 4, a.getPessoa().getNomeFantasiaReceita(), "12"));

        campos.add(adicionaCampo("Descrição Punição", "descricaopun", 2, a.getTipoPunicao().getDescricao(), "4"));
        campos.add(adicionaCampo("N° Processo", "processopun", 2, a.getPunicao().getProcesso(), "4"));
        campos.add(adicionaCampo("Portaria", "portariapun", 2, a.getPunicao().getPortaria(), "4"));
        campos.add(adicionaCampo("Página DOU", "paginadoupun", 2, a.getPunicao().getPaginaDOU(), "4"));
        campos.add(adicionaCampo("Seção DOU", "secaodoupun", 2, a.getPunicao().getSecaoDOU(), "4"));
        campos.add(adicionaCampo("Sigla da Pasta de Lotação", "siglaorglot", 2, a.getOrgaoLotacao().getSiglaDaPasta(), "4"));

        campos.add(adicionaCampo("Nome do Órgão de Lotação", "nomeorglot", 2, a.getOrgaoLotacao().getNome(), "12"));

        campos.add(adicionaCampo("Código IBGE de Lotação", "codibgelot", 2, a.getUfLotacaoPessoa().getCodigoIBGE(), "6"));
        campos.add(adicionaCampo("Sigla do Órgão de Lotação", "siglaorgaolot", 2, a.getOrgaoLotacao().getSigla(), "6"));
        campos.add(adicionaCampo("Código CNPJ Estado de Lotação", "codcnpjestpes", 2, a.getUfLotacaoPessoa().getCodigoCNPJEstado(), "6"));
        campos.add(adicionaCampo("Sigla Estado de Lotação", "siglauflotpes", 2, a.getUfLotacaoPessoa().getUf().getSigla(), "6"));
        campos.add(adicionaCampo("Nome Estado de Lotação", "nomeuflotpes", 2, a.getUfLotacaoPessoa().getUf().getNome(), "6"));

        /*
            campos.add(adicionaCampo("Data da Publicação", "datapublic", 5, Util.formataData(a.getDataPublicacao()), "4"));
            campos.add(adicionaCampo("Data de Referência", "datarefer", 5, Util.formataData(a.getDataReferencia()), "4"));
         */
        Date currentDate = new Date();

        if (a.getDataPublicacao() != null) {

            try {

                Long timeStamp = Util.getTimeStamp(a.getDataPublicacao());

                if (timeStamp != null) {
                    timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDataPublicacao()), "Públicaçao CEAF no DOU"));

                }

            } catch (ParseException ex) {
                Logger.getLogger(SancoesImplContrato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);

        botao = new Botao();
        //String referencia = "govbr" + "$" + "govbr_ceaf" + "$" + filtro;
        String referencia = com.harpia.stive.api.contrato.ContratoApi.FONTE_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CEAF_REF + "$" + com.harpia.stive.api.contrato.ContratoApi.CONSULTA_CEAF_ENDPOINT;
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Fundamentação");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("id", a.getId());
        mapPayload.put("cpf", cpf);
        mapPayload.put("busca", "fundamentacao");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoCeafFundamentacao(CodigoDescricaoDTO a, String cpf) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("CEAF");
        resultado.setReferencia(x.toString());
        x++;

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Código", "codigo", 2, a.getCodigo(), "12"));
        campos.add(adicionaCampo("Descrição", "descricao", 2, a.getDescricao(), "12"));

        resultado.setCampos(campos);

        return resultado;
    }

}
