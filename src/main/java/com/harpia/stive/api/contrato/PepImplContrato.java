package com.harpia.stive.api.contrato;

import static com.harpia.stive.api.contrato.DicionarioDados.adicionaCampo;
import static com.harpia.stive.api.contrato.DicionarioDados.adicionaTimeLine;
import com.harpia.stive.api.model.Botao;
import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Resultado;
import com.harpia.stive.api.model.Timeline;
import com.harpia.stive.domain.model.PEPDTO;
import com.harpia.stive.util.Util;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PepImplContrato {

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
    public Resultado retornaResultadoPep(PEPDTO a, String cpf) throws NoSuchAlgorithmException, ParseException, ParseException, ParseException {

        List<Botao> botoes = new ArrayList<>();
        Botao botao = new Botao();
        List<Campo> campos = new ArrayList<>();
        List<Timeline> timeline = new ArrayList<>();
        
        resultado = new Resultado();

        resultado.setDocumento("PEP");
        resultado.setReferencia(a.getDescricaoFuncao().trim());

        if (a == null) {
            return resultado;
        }

        String cpfAux;

        if (cpf != null) {
            cpfAux = cpf;
        } else {
            cpfAux = a.getCpf();
        }

        if (StringUtils.isNoneBlank(cpfAux) && !cpfAux.contains("*")) {
            campos.add(adicionaCampo("CPF", "cpf", 1, cpfAux.trim(), "4"));
        } else {
            campos.add(adicionaCampo("CPF", "cpf", 2, cpfAux.trim(), "4"));
        }

        campos.add(adicionaCampo("Nome", "nome", 4, a.getNome().trim(), "4"));
        campos.add(adicionaCampo("Sigla Função", "siglafunc", 2, a.getSiglaFuncao().trim(), "4"));
        campos.add(adicionaCampo("Descrição Função", "nomefantasia", 2, a.getDescricaoFuncao().trim(), "6"));
        campos.add(adicionaCampo("Nível Função", "nivelfuncao", 2, a.getNivelFuncao().trim(), "4"));
        campos.add(adicionaCampo("Código Órgão", "codorgao", 2, a.getCodOrgao().trim(), "4"));
        campos.add(adicionaCampo("Nome Órgão", "nomeorgao", 4, a.getNomeOrgao().trim(), "4"));
        campos.add(adicionaCampo("Ínicio Exercício", "iniexerc", 5, Util.formataData(a.getDtInicioExercicio()), "4"));
        campos.add(adicionaCampo("Fim Exercício", "fimexerc", 5, Util.formataData(a.getDtFimExercicio()), "4"));
        campos.add(adicionaCampo("Fim Carência", "fimcaren", 5, Util.formataData(a.getDtFimCarencia()), "4"));
        
        resultado.setCampos(campos);
        
        Date currentDate = new Date();
        
        
        if (currentDate.getTime() > Util.getTimeStamp(a.getDtInicioExercicio())){
            
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDtInicioExercicio()),
                    a.getNome().trim() + " iniciou exercício da função de " + a.getDescricaoFuncao().trim() + " tornando-se Exposto Politicamente"));
        }else{
            
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDtInicioExercicio()),
                    a.getNome().trim() + " iniciará exercício da função de " + a.getDescricaoFuncao().trim() + " tornando-se Exposto Politicamente"));
        }
        
        //
        if (currentDate.getTime() > Util.getTimeStamp(a.getDtFimExercicio())){
            
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDtFimExercicio()),
                a.getNome().trim() + " finalizou o exercício da função de " + a.getDescricaoFuncao().trim()));
        }else{
             
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDtFimExercicio()),
                a.getNome().trim() + " finalizará o exercício da função de " + a.getDescricaoFuncao().trim()));
        }
        
        //
        if (currentDate.getTime() > Util.getTimeStamp(a.getDtFimCarencia())){
        
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDtFimCarencia()),
                a.getNome().trim() + " Finalizou a carência do tempo de Pessoa Exposta Politicamente"));

        }else{
            
            timeline.add(adicionaTimeLine(Util.getTimeStamp(a.getDtFimCarencia()),
                a.getNome().trim() + " Finalizará a carência do tempo de Pessoa Exposta Politicamente"));
        }
        
        //
        resultado.setTimeline(timeline);
        resultado.setBotoes(botoes);

        return resultado;
    }
}
