package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.AuxilioEmergencialDTO;
import com.harpia.stive.domain.model.BPCDTO;
import com.harpia.stive.domain.model.BolsaFamiliaDTO;
import com.harpia.stive.domain.model.NovoBolsaFamiliaPagoDTO;
import com.harpia.stive.domain.model.PetiDTO;
import com.harpia.stive.domain.model.SafraDTO;
import com.harpia.stive.domain.model.SeguroDefesoDTO;
import com.harpia.stive.util.Util;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class BeneficiosImplContrato {

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
    public Resultado retornaResultadoSeguroDefeso(SeguroDefesoDTO seguro, String cpf) throws ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Seguro Defeso");
        resultado.setReferencia(Util.formataData(seguro.getDataEmissaoParcela()));

        if (seguro == null) {
            return resultado;
        }

        String cpfAux;

        if (cpf != null) {
            cpfAux = cpf;
        } else {
            cpfAux = seguro.getPessoaSeguroDefeso().getCpfFormatado();
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("Mês Referência", "mesref", 5, Util.formataData(seguro.getDataMesReferencia()), "4"));
        campos.add(adicionaCampo("Data Saque", "datasaque", 5, Util.formataData(seguro.getDataSaque()), "4"));
        campos.add(adicionaCampo("Data Emissão Parcela", "dataemissãoparcela", 5, Util.formataData(seguro.getDataEmissaoParcela()), "4"));

        campos.add(adicionaCampo("Situacão", "situacao", 2, seguro.getSituacao(), "6"));
        campos.add(adicionaCampo("RGP", "rgp", 2, seguro.getRgp(), "6"));

        campos.add(adicionaCampo("Parcela", "parcela", 2, seguro.getParcela(), "6"));
        campos.add(adicionaCampo("Valor", "valor", 2, seguro.getValor(), "6"));

        campos.add(adicionaCampo("NIS", "nis", 2, seguro.getPessoaSeguroDefeso().getNis(), "6"));

        campos.add(adicionaCampo("Portaria", "portaria", 2, seguro.getPortaria(), "12"));

        campos.add(adicionaCampo("Nome", "nome", 4, seguro.getPessoaSeguroDefeso().getNome(), "12"));

        campos.add(adicionaCampo("Código IBGE do Município", "codigoibgemun", 2, seguro.getMunicipio().getCodigoIBGE(), "6"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, seguro.getMunicipio().getNomeIBGE(), "6"));

        campos.add(adicionaCampo("Código Região do Município", "codregiaomun", 2, seguro.getMunicipio().getCodigoRegiao(), "6"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, seguro.getMunicipio().getNomeRegiao(), "6"));

        campos.add(adicionaCampo("País", "pais", 2, seguro.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Estado", "siglaestado", 2, seguro.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Estado", "nomeestado", 2, seguro.getMunicipio().getUf().getNome(), "4"));

        Date currentDate = new Date();

        /*if (currentDate.getTime() > Util.getTimeStamp(seguro.getDataEmissaoParcela())) {
        timeline.add(adicionaTimeLine(Util.getTimeStamp(seguro.getDataEmissaoParcela()), seguro.getPessoaSeguroDefeso().getNome().trim()
        + " teve a parcela de nº " + seguro.getParcela() + " do Benefício Seguro Defeso Emitida, cujo a portaria é " + seguro.getPortaria()));
        } else {
        timeline.add(adicionaTimeLine(Util.getTimeStamp(seguro.getDataEmissaoParcela()), seguro.getPessoaSeguroDefeso().getNome().trim()
        + " terá a parcela de nº " + seguro.getParcela() + " do Benefício Seguro Defeso Emitida, cujo a portaria é " + seguro.getPortaria()));
        }
        
        //
        if (currentDate.getTime() > Util.getTimeStamp(seguro.getDataMesReferencia())) {
        timeline.add(adicionaTimeLine(Util.getTimeStamp(seguro.getDataMesReferencia()), seguro.getPessoaSeguroDefeso().getNome().trim()
        + " teve a parcela de nº " + seguro.getParcela() + "  do Benefício Seguro Defeso disponibilizada"));
        } else {
        timeline.add(adicionaTimeLine(Util.getTimeStamp(seguro.getDataMesReferencia()), seguro.getPessoaSeguroDefeso().getNome().trim()
        + " terá a parcela de nº " + seguro.getParcela() + "  do Benefício Seguro Defeso disponibilizada"));
        }*/

        //
        if (currentDate.getTime() > Util.getTimeStamp(seguro.getDataSaque())) {
            timeline.add(adicionaTimeLine(Util.getTimeStamp(seguro.getDataSaque()), seguro.getPessoaSeguroDefeso().getNome().trim()
                    + " sacou a parcela de nº " + seguro.getParcela() + " do Benefício Seguro Defeso tendo como munícipio de refefência " + seguro.getMunicipio().getNomeIBGE()));
        } else {
            timeline.add(adicionaTimeLine(Util.getTimeStamp(seguro.getDataSaque()), seguro.getPessoaSeguroDefeso().getNome().trim()
                    + " poderá sacar sacou a parcela de nº " + seguro.getParcela() + " do Benefício Seguro Defeso tendo como munícipio de refefência " + seguro.getMunicipio().getNomeIBGE()));
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoBolsaFamilia(BolsaFamiliaDTO bolsa, String cpf) throws ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Bolsa Família");
        resultado.setReferencia(Util.formataData(bolsa.getDataMesCompetencia()));

        if (bolsa == null) {
            return resultado;
        }

        String cpfAux;
        String codigo;

        if (StringUtils.isNotBlank(cpf)) {

            cpfAux = cpf;
            codigo = cpf;

        } else {

            codigo = bolsa.getTitularBolsaFamilia().getNis();
            cpfAux = bolsa.getTitularBolsaFamilia().getCpfFormatado();
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("Mês Competencia", "mescompetencia", 5, Util.formataData(bolsa.getDataMesCompetencia()), "4"));
        campos.add(adicionaCampo("Data Referência", "datareferencia", 5, Util.formataData(bolsa.getDataMesReferencia()), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, bolsa.getValor(), "4"));

        campos.add(adicionaCampo("NIS", "nis", 2, bolsa.getTitularBolsaFamilia().getNis(), "4"));
        campos.add(adicionaCampo("Nº Dependentes", "ndependentes", 2, bolsa.getQuantidadeDependentes(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 4, bolsa.getTitularBolsaFamilia().getNome(), "12"));

        campos.add(adicionaCampo("Código IBGE do Município", "codigoibgemun", 2, bolsa.getMunicipio().getCodigoIBGE(), "6"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, bolsa.getMunicipio().getNomeIBGE(), "6"));

        campos.add(adicionaCampo("Código Região do Município", "codigoregiaomun", 2, bolsa.getMunicipio().getCodigoRegiao(), "6"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, bolsa.getMunicipio().getNomeRegiao(), "6"));

        campos.add(adicionaCampo("País", "pais", 2, bolsa.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Estado", "siglaestado", 2, bolsa.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Estado", "nomeestado", 2, bolsa.getMunicipio().getUf().getNome(), "4"));

        Date currentDate = new Date();

        if (currentDate.getTime() > Util.getTimeStamp(bolsa.getDataMesReferencia())) {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(bolsa.getDataMesReferencia()), bolsa.getTitularBolsaFamilia().getNome().trim()
                    + " recebeu o Benefício Bolsa Família"));
        } else {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(bolsa.getDataMesReferencia()), bolsa.getTitularBolsaFamilia().getNome().trim()
                    + " receberá o Benefício Bolsa Família disponibilizado"));
        }

        /*        //
        if (currentDate.getTime() > Util.getTimeStamp(bolsa.getDataMesCompetencia())) {
        
        timeline.add(adicionaTimeLine(Util.getTimeStamp(bolsa.getDataMesCompetencia()), bolsa.getTitularBolsaFamilia().getNome().trim()
        + " ganhou direito ao Benefício Bolsa Família"));
        } else {
        
        timeline.add(adicionaTimeLine(Util.getTimeStamp(bolsa.getDataMesCompetencia()), bolsa.getTitularBolsaFamilia().getNome().trim()
        + " terá direito ao Benefício Bolsa Família"));
        }*/

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }
    
    
    public Resultado retornaResultadoNovoBolsaFamilia(NovoBolsaFamiliaPagoDTO bolsa, String cpf) throws ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Novo Bolsa Fam.");
        resultado.setReferencia(Util.formataData(Util.formataData(bolsa.getDataMesCompetencia().toString())));

        if (bolsa == null) {
            return resultado;
        }

        String cpfAux;
        String codigo;

        if (StringUtils.isNotBlank(cpf)) {

            cpfAux = cpf;
            codigo = cpf;

        } else {

            codigo = bolsa.getBeneficiarioNovoBolsaFamilia().getNis();
            cpfAux = bolsa.getBeneficiarioNovoBolsaFamilia().getCpfFormatado();
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("Mês Competencia", "mescompetencia", 5, Util.formataData(bolsa.getDataMesCompetencia().toString()), "4"));
        campos.add(adicionaCampo("Data Referência", "datareferencia", 5, Util.formataData(bolsa.getDataMesCompetencia().toString()), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, bolsa.getValorSaque(), "4"));

        campos.add(adicionaCampo("NIS", "nis", 2, bolsa.getBeneficiarioNovoBolsaFamilia().getNis(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 4, bolsa.getBeneficiarioNovoBolsaFamilia().getNome(), "12"));

        campos.add(adicionaCampo("Código IBGE do Município", "codigoibgemun", 2, bolsa.getMunicipio().getCodigoIBGE(), "6"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, bolsa.getMunicipio().getNomeIBGE(), "6"));

        campos.add(adicionaCampo("Código Região do Município", "codigoregiaomun", 2, bolsa.getMunicipio().getCodigoRegiao(), "6"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, bolsa.getMunicipio().getNomeRegiao(), "6"));

        campos.add(adicionaCampo("País", "pais", 2, bolsa.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Estado", "siglaestado", 2, bolsa.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Estado", "nomeestado", 2, bolsa.getMunicipio().getUf().getNome(), "4"));

        Date currentDate = new Date();

        if (currentDate.getTime() > Util.getTimeStamp(bolsa.getDataMesReferencia().toString())) {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(bolsa.getDataMesReferencia().toString()), bolsa.getBeneficiarioNovoBolsaFamilia().getNome().trim()
                    + " recebeu o Benefício Novo Bolsa Família"));
        } else {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(bolsa.getDataMesReferencia().toString()), bolsa.getBeneficiarioNovoBolsaFamilia().getNome().trim()
                    + " receberá o Benefício Novo Bolsa Família disponibilizado"));
        }


        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoGarantiaSafra(SafraDTO safra, String cpf) throws ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Garantia Safra");
        resultado.setReferencia(Util.formataData(safra.getDataMesReferencia()));

        if (safra == null) {
            return resultado;
        }

        String cpfAux;
        String codigo;

        if (StringUtils.isNotBlank(cpf)) {

            cpfAux = cpf;
            codigo = cpf;

        } else {

            codigo = safra.getBeneficiarioSafra().getNis();
            cpfAux = safra.getBeneficiarioSafra().getCpfFormatado();
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("Mes Referência", "mesreferencia", 5, Util.formataData(safra.getDataMesReferencia()), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, safra.getValor(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 4, safra.getBeneficiarioSafra().getNome(), "6"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, safra.getMunicipio().getNomeIBGE(), "6"));
        campos.add(adicionaCampo("País", "pais", 2, safra.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Código IBGE do Município", "codibgemun", 2, safra.getMunicipio().getCodigoIBGE(), "4"));
        campos.add(adicionaCampo("NIS", "nis", 2, safra.getBeneficiarioSafra().getNis(), "4"));

        campos.add(adicionaCampo("Código Região do Município", "codregiaomun", 2, safra.getMunicipio().getCodigoRegiao(), "4"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, safra.getMunicipio().getNomeRegiao(), "4"));

        campos.add(adicionaCampo("Sigla do Estado", "siglaestado", 2, safra.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Estado", "nomeestado", 2, safra.getMunicipio().getUf().getNome(), "4"));

        Date currentDate = new Date();

        if (currentDate.getTime() > Util.getTimeStamp(safra.getDataMesReferencia())) {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(safra.getDataMesReferencia()), safra.getBeneficiarioSafra().getNome().trim()
                    + " recebeu o Benefício garantia Safra"));

        } else {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(safra.getDataMesReferencia()), safra.getBeneficiarioSafra().getNome().trim()
                    + " receberá o Benefício garantia Safra"));
        }

        resultado.setCampos(campos);
        resultado.setTimeline(timeline);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoBpc(BPCDTO bpc, String cpf) throws ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("BPC");
        resultado.setReferencia(Util.formataData(bpc.getDataMesCompetencia()));

        if (bpc == null) {
            return resultado;
        }

        String cpfAux;
        String codigo;
        String cpfResp;
        String cpfBeneficiario;

        if (cpf != null) {

            cpfAux = cpf;
            codigo = cpf;

        } else {

            codigo = bpc.getBeneficiario().getNis();
            cpfAux = bpc.getBeneficiario().getCpfFormatado();
        }

        cpfResp = Util.getNumerics(bpc.getBeneficiario().getCpfFormatado());
        cpfBeneficiario = Util.getNumerics(bpc.getBeneficiario().getCpfFormatado());
        cpf = Util.getNumerics(cpf);

        //responsavel = beneficiario
        if (cpfResp.equals(cpfBeneficiario)) {
            cpfResp = cpfAux;

            //resposnavel = cpf parametro
        } else if (cpfResp.equals(cpf.substring(3, 6))) {
            cpfResp = cpf;
            cpfAux = bpc.getBeneficiario().getCpfFormatado();

            //beneficiario igual cpf parametro
        } else {
            cpfResp = bpc.getBeneficiario().getCpfFormatado();
            cpfAux = cpf;
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("Mês Referência", "datareferencia", 5, Util.formataData(bpc.getDataMesCompetencia()), "4"));
        campos.add(adicionaCampo("Mes Competência", "mescompetencia", 5, Util.formataData(bpc.getDataMesReferencia()), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, bpc.getValor(), "4"));

        campos.add(adicionaCampo("Concedido Judicialmente", "concedidojud", 2, bpc.isConcedidoJudicialmente(), "4"));
        campos.add(adicionaCampo("Menor de 16 anos", "menor16anos", 2, bpc.isMenor16anos(), "4"));

        campos.add(adicionaCampo("NIS", "nis", 2, bpc.getBeneficiario().getNis(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 4, bpc.getBeneficiario().getNome(), "6"));

        if (StringUtils.isNoneBlank(cpfResp) && !cpfResp.contains("*")) {
            campos.add(adicionaCampo("CPF Representnte Legal", "cpfrepresenlegal", 1, cpfResp, "4"));
        } else {
            campos.add(adicionaCampo("CPF Representnte Legal", "cpfrepresenlegal", 2, cpfResp, "4"));
        }

        campos.add(adicionaCampo("NIS Representante Legal", "nisrepresenlegal", 2, bpc.getBeneficiario().getNisRepresentanteLegal(), "6"));

        campos.add(adicionaCampo("Nome Representante Legal", "nomerepresenlegal", 4, bpc.getBeneficiario().getNomeRepresentanteLegal(), "12"));

        campos.add(adicionaCampo("Código IBGE do Município", "codigoibgemun", 2, bpc.getMunicipio().getCodigoIBGE(), "6"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, bpc.getMunicipio().getNomeIBGE(), "6"));

        campos.add(adicionaCampo("Código Região do Município", "codigoregiaomun", 2, bpc.getMunicipio().getCodigoRegiao(), "6"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, bpc.getMunicipio().getNomeRegiao(), "6"));

        campos.add(adicionaCampo("País", "pais", 2, bpc.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Estado", "sigla", 2, bpc.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Estado", "nomeestado", 2, bpc.getMunicipio().getUf().getNome(), "4"));

        
        Date currentDate = new Date();
        
        if (currentDate.getTime() > Util.getTimeStamp(bpc.getDataMesReferencia())) {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(bpc.getDataMesReferencia()), bpc.getBeneficiario().getNome().trim()
                    + " recebeu o Benefício de Prestação Continuada"));

        } else {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(bpc.getDataMesReferencia()), bpc.getBeneficiario().getNome().trim()
                    + " receberá o Benefício de Prestação Continuada (BPC)"));
        }
        
        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoPeti(PetiDTO peti, String cpf) throws ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("PETI");
        resultado.setReferencia(Util.formataData(peti.getDataMesReferencia()));

        if (peti == null) {
            return resultado;
        }

        String cpfAux;
        String codigo;

        if (cpf != null) {

            cpfAux = cpf;
            codigo = cpf;

        } else {

            codigo = peti.getBeneficiarioPeti().getNis();
            cpfAux = peti.getBeneficiarioPeti().getCpfFormatado();
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("Mês Referência", "dataref", 5, Util.formataData(peti.getDataMesReferencia()), "4"));
        campos.add(adicionaCampo("Data Disponibilização", "datadisponibilizacao", 5, Util.formataData(peti.getDataDisponibilizacaoRecurso()), "4"));
        campos.add(adicionaCampo("Valor", "valorPeti", 2, peti.getValor(), "4"));

        campos.add(adicionaCampo("Situação", "situacao", 2, peti.getSituacao(), "4"));

        campos.add(adicionaCampo("NIS", "nis", 2, peti.getBeneficiarioPeti().getNis(), "4"));

        campos.add(adicionaCampo("Nome", "nome", 4, peti.getBeneficiarioPeti().getNome(), "12"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, peti.getMunicipio().getNomeIBGE(), "6"));
        campos.add(adicionaCampo("Código IBGE do Município", "codigoibgemun", 2, peti.getMunicipio().getCodigoIBGE(), "4"));

        campos.add(adicionaCampo("Código Região do Município", "codigoregiaomun", 2, peti.getMunicipio().getCodigoRegiao(), "4"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, peti.getMunicipio().getNomeRegiao(), "4"));

        campos.add(adicionaCampo("País", "pais", 2, peti.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Estado", "siglaestado", 2, peti.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Estado", "nomeestado", 2, peti.getMunicipio().getUf().getNome(), "4"));
        
        
        Date currentDate = new Date();
        
        if (currentDate.getTime() > Util.getTimeStamp(peti.getDataMesReferencia())) {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(peti.getDataMesReferencia()), peti.getBeneficiarioPeti().getNome().trim()
                    + " recebeu parcela do Programa de Erradicação do Trabalho Infantil (PETI)"));

        } else {

            timeline.add(adicionaTimeLine(Util.getTimeStamp(peti.getDataMesReferencia()), peti.getBeneficiarioPeti().getNome().trim()
                    + " receberá parcela do Programa de Erradicação do Trabalho Infantil (PETI)"));
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoAuxilioEmergencial(AuxilioEmergencialDTO emergencial, String cpf) {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("AUX EMERGENCIAL");
        resultado.setReferencia(emergencial.getMesDisponibilizacao());

        if (emergencial == null) {
            return resultado;
        }

        String cpfAux;
        String cpfResp;
        String codigo;
        String cpfBeneficiario;

        if (cpf != null) {

            cpfAux = cpf;
            codigo = cpf;

        } else {

            codigo = emergencial.getBeneficiario().getNis();
            cpfAux = emergencial.getBeneficiario().getCpfFormatado();
        }

        cpfResp = Util.getNumerics(emergencial.getResponsavelAuxilioEmergencial().getCpfFormatado());
        cpfBeneficiario = Util.getNumerics(emergencial.getBeneficiario().getCpfFormatado());
        cpf = Util.getNumerics(cpf);

        //responsavel = beneficiario
        if (cpfResp.equals(cpfBeneficiario)) {
            cpfResp = cpfAux;

            //resposnavel = cpf parametro
        } else if (cpfResp.equals(cpf.substring(3, 6))) {
            cpfResp = cpf;
            cpfAux = emergencial.getBeneficiario().getCpfFormatado();

            //beneficiario igual cpf parametro
        } else {
            cpfResp = emergencial.getResponsavelAuxilioEmergencial().getCpfFormatado();
            cpfAux = cpf;
        }

        //
        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux, "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux, "4"));
        }

        campos.add(adicionaCampo("NIS", "nis", 2, emergencial.getBeneficiario().getNis(), "4"));
        campos.add(adicionaCampo("Nome", "nome", 4, emergencial.getBeneficiario().getNome(), "4"));
        campos.add(adicionaCampo("Número Parcela", "numeroparcela", 2, emergencial.getNumeroParcela(), "4"));
        campos.add(adicionaCampo("Valor", "valor", 2, emergencial.getValor(), "4"));

        if (StringUtils.isNoneBlank(cpfResp) && !cpfResp.contains("*")) {
            campos.add(adicionaCampo("CPF Responsável", "cpfresp", 1, cpfResp, "4"));
        } else {
            campos.add(adicionaCampo("CPF Responsável", "cpfresp", 2, cpfResp, "4"));
        }

        campos.add(adicionaCampo("NIS Responsável", "nisresp", 2, emergencial.getResponsavelAuxilioEmergencial().getNis(), "4"));
        campos.add(adicionaCampo("Nome Responsável", "nomeresp", 4, emergencial.getResponsavelAuxilioEmergencial().getNome(), "4"));

        campos.add(adicionaCampo("Mês Disponibilização", "mesdisp", 5, Util.formataData("01/" + emergencial.getMesDisponibilizacao()), "4"));
        campos.add(adicionaCampo("Situação Auxílio", "sitaux", 2, emergencial.getSituacaoAuxilioEmergencial(), "4"));

        campos.add(adicionaCampo("Código IBGE do Município", "codibgemun", 2, emergencial.getMunicipio().getCodigoIBGE(), "4"));
        campos.add(adicionaCampo("Nome IBGE do Município", "nomeibgemun", 2, emergencial.getMunicipio().getNomeIBGE(), "4"));
        campos.add(adicionaCampo("Código Região do Município", "codregiamun", 2, emergencial.getMunicipio().getCodigoRegiao(), "4"));
        campos.add(adicionaCampo("Nome Região do Município", "nomeregiaomun", 2, emergencial.getMunicipio().getNomeRegiao(), "4"));
        campos.add(adicionaCampo("País", "pais", 2, emergencial.getMunicipio().getPais(), "4"));
        campos.add(adicionaCampo("Sigla do Município", "siglamun", 2, emergencial.getMunicipio().getUf().getSigla(), "4"));
        campos.add(adicionaCampo("Nome do Município", "nomemun", 2, emergencial.getMunicipio().getUf().getNome(), "4"));
        
        Date currentDate = new Date();
        
        try {
            if (currentDate.getTime() > Util.getTimeStamp("01/" + emergencial.getMesDisponibilizacao())) {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp("01/" + emergencial.getMesDisponibilizacao()), emergencial.getBeneficiario().getNome().trim()
                        + " recebeu a parcela de nº " + emergencial.getNumeroParcela() +  " do Auxílio Emergencial"));
                
            } else {
                
                timeline.add(adicionaTimeLine(Util.getTimeStamp("01/" + emergencial.getMesDisponibilizacao()), emergencial.getBeneficiario().getNome().trim()
                        + " receberá a parcela de nº " + emergencial.getNumeroParcela() +  " do Auxílio Emergencial"));
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(BeneficiosImplContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

}
