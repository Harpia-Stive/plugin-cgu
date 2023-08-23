package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.CadastroServidorDTO;
import com.harpia.stive.domain.model.RemuneracaoDTO;
import com.harpia.stive.domain.model.RubricaDTO;
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

public class ServidorImplContrato {

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
    public Resultado retornaResultadoServidor(CadastroServidorDTO a, String cpf, String mesAno, String filtro) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();

        resultado = new Resultado();

        resultado.setDocumento("Servidor Federal");
        resultado.setReferencia(a.getServidor().getId().toString());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("NIS", "ninscrsocial", 2, a.getServidor().getPessoa().getNumeroInscricaoSocial(), "4"));

        if (a.getServidor() != null && a.getServidor().getPessoa() != null && StringUtils.isNotBlank(a.getServidor().getPessoa().getTipo()) && !(a.getServidor().getPessoa().getTipo().equalsIgnoreCase("Pessoa Física"))) {

            campos.add(adicionaCampo("Tipo Pessoa", "tipopessoa", 2, a.getServidor().getPessoa().getTipo(), "4"));
            campos.add(adicionaCampo("CNPJ", "cnpj", 3, a.getServidor().getPessoa().getCnpjFormatado(), "4"));
            campos.add(adicionaCampo("Situação", "situacao", 2, a.getServidor().getSituacao(), "4"));
            campos.add(adicionaCampo("Razão Social", "razaosocial", 4, a.getServidor().getPessoa().getRazaoSocialReceita(), "6"));
            campos.add(adicionaCampo("Nome Fantasia", "nomefantasia", 4, a.getServidor().getPessoa().getNomeFantasiaReceita(), "6"));

        } else {

            campos.add(adicionaCampo("Cpf", "cpf", 1, cpf, "4"));
            campos.add(adicionaCampo("Nome", "nome", 4, a.getServidor().getPessoa().getNome(), "12"));
            campos.add(adicionaCampo("Situação", "situacao", 2, a.getServidor().getSituacao(), "4"));
            campos.add(adicionaCampo("CPF - Servidor Inativo Instituidor Pensão", "cpfservinatinstuidorpensao", 1, a.getServidor().getServidorInativoInstuidorPensao().getCpfFormatado(), "4"));
            campos.add(adicionaCampo("NOME - Servidor Inativo Instituidor Pensão", "nomeservinatinstuidorpensao", 4, a.getServidor().getServidorInativoInstuidorPensao().getNome(), "4"));
            campos.add(adicionaCampo("CPF Pensionista/Representante", "pensionistarepresentantecpf", 1, a.getServidor().getPensionistaRepresentante().getCpfFormatado(), "4"));
            campos.add(adicionaCampo("Pensionista/Representante", "pensionistarepresentantenome", 4, a.getServidor().getPensionistaRepresentante().getNome(), "4"));

        }

        campos.add(adicionaCampo("Tipo Servidor", "tiposervidor", 2, a.getServidor().getTipoServidor(), "4"));
        campos.add(adicionaCampo("Afastado", "afastado", 2, a.getServidor().getFlagAfastado(), "4"));
        campos.add(adicionaCampo("Função", "funcao", 2, a.getServidor().getFuncao().getDescricaoFuncaoCargo(), "4"));

        campos.add(adicionaCampo("Matrícula", "matricula", 2, a.getServidor().getCodigoMatriculaFormatado(), "4"));
        campos.add(adicionaCampo("Estado Exercício", "estadoexerc", 2, a.getServidor().getEstadoExercicio().getNome(), "4"));
        campos.add(adicionaCampo("Sigla Estado Exercício", "siglaestadoexercicio", 2, a.getServidor().getEstadoExercicio().getSigla(), "4"));

        campos.add(adicionaCampo("Órgão Exercício", "orgaoexercicionome", 2, a.getServidor().getOrgaoServidorExercicio().getNome(), "4"));
        campos.add(adicionaCampo("Órgão Exerc. Sigla", "orgaoexerciciosigla", 2, a.getServidor().getOrgaoServidorExercicio().getSigla(), "4"));
        campos.add(adicionaCampo("Cód. Órgão Exerc.", "codorgaoexerc", 2, a.getServidor().getOrgaoServidorExercicio().getCodigo(), "4"));

        campos.add(adicionaCampo("Órgão Exerc. Vinc.", "orgaoexercvinculado", 2, a.getServidor().getOrgaoServidorExercicio().getNomeOrgaoVinculado(), "4"));
        campos.add(adicionaCampo("Cód. Órgão Exerc. Vinc.", "codorgaoexercvinculado", 2, a.getServidor().getOrgaoServidorExercicio().getCodigoOrgaoVinculado(), "4"));
        campos.add(adicionaCampo("Órgão Lotação", "orgaolotacao", 2, a.getServidor().getOrgaoServidorLotacao().getNome(), "4"));

        campos.add(adicionaCampo("Órgão Lotação Sigla", "orgaolotacaosigla", 2, a.getServidor().getOrgaoServidorLotacao().getSigla(), "4"));
        campos.add(adicionaCampo("Cód. Órgão Lotação", "codorgaolotacao", 2, a.getServidor().getOrgaoServidorLotacao().getCodigo(), "4"));
        campos.add(adicionaCampo("Órgão Lotação Vinc.", "orgaolotacaovinculado", 2, a.getServidor().getOrgaoServidorLotacao().getNomeOrgaoVinculado(), "4"));

        campos.add(adicionaCampo("Cód Órgão Lotação Vinc.", "codigoorgaovinculado", 2, a.getServidor().getOrgaoServidorLotacao().getCodigoOrgaoVinculado(), "4"));

        resultado.setCampos(campos);

        String referencia = ContratoApi.FONTE_REF + "$" + ContratoApi.CONSULTA_SERVIDORES_REF + "$" + ContratoApi.CONSULTA_SERVIDORES_ENDPOINT;

        botao = new Botao();
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Remuneração");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("idServidorAposentadoPensionista", a.getServidor().getIdServidorAposentadoPensionista());
        mapPayload.put("cpf", cpf);
        mapPayload.put("mesAno", mesAno);
        mapPayload.put("busca", "remuneracao");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoRemuneracaoServidor(RemuneracaoDTO a, String cpf, String mesAno, int idServidor) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("Remuneração");
        resultado.setReferencia("Remuneração " + a.getMesAnoPorExtenso());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Mês Referência", "mesref", 5, Util.formataData(a.getSkMesReferencia()), "4"));
        campos.add(adicionaCampo("Mês Ano", "mesano", 2, a.getMesAno(), "4"));

    

        
        Date currentDate = new Date();

        if (a.getSkMesReferencia() != null) {

            try {

                Long timeStamp = Util.getTimeStamp(a.getSkMesReferencia());

                if (timeStamp != null) {
                    timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getSkMesReferencia()), "Recebimento de salário"));

                }

            } catch (ParseException ex) {
                Logger.getLogger(SancoesImplContrato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        resultado.setTimeline(timeline);
        resultado.setCampos(campos);
        
        
        

        String referencia = ContratoApi.FONTE_REF + "$" + ContratoApi.CONSULTA_SERVIDORES_REF + "$" + ContratoApi.CONSULTA_SERVIDORES_ENDPOINT;

        botao = new Botao();
        botao.setReferencia(Util.md5(referencia));
        botao.setRotulo("Ver Rubricas");

        Map<String, Object> mapPayload = new HashMap<>();

        mapPayload.put("idServidorAposentadoPensionista", idServidor);
        mapPayload.put("cpf", cpf);
        mapPayload.put("mesAno", mesAno);
        mapPayload.put("busca", "rubrica");

        botao.setPayload(mapPayload);

        botoes.add(botao);

        resultado.setBotoes(botoes);

        return resultado;
    }

    public Resultado retornaResultadoRubricaRemuneracaoServidor(RubricaDTO a, String cpf, String mesAno, int idServidor, String filtro) throws NoSuchAlgorithmException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        Campo campo = new Campo();
        List<Timeline> timeline = new ArrayList<>();

        resultado = new Resultado();

        resultado.setDocumento("RUBRICA");
        resultado.setReferencia("Código Rubrica: " + a.getCodigo());

        if (a == null) {
            return resultado;
        }

        campos.add(adicionaCampo("Descrição", "descricaorubrica", 2, a.getDescricao(), "4"));
        campos.add(adicionaCampo("Mês Referência", "mesrefrubrica", 5, Util.formataData(a.getSkMesReferencia()), "4"));

        campos.add(adicionaCampo("Valor", "valorrubrica", 2, a.getValor(), "4"));
        campos.add(adicionaCampo("Valor em Dólar", "Valordolarrubrica", 2, a.getValorDolar(), "4"));

        
        
        resultado.setTimeline(timeline);
        
        resultado.setCampos(campos);
        resultado.setBotoes(botoes);

        return resultado;
    }

}
