package com.harpia.stive.api.contrato;

import com.harpia.stive.api.model.Campo;
import com.harpia.stive.api.model.Timeline;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author labldmac
 */
public class DicionarioDados {

    public static Campo adicionaCampo(String rotulo, String chave, int tipo, Object valor, String largura) {

        Campo c = new Campo();
        c.setRotulo(rotulo);
        c.setChave(chave);
        c.setTipo(tipo);
        c.setLargura(largura);
        Long valorAux = null;

        if (valor == null || StringUtils.isBlank(valor.toString()) || valor.toString().equalsIgnoreCase("null")) {

            c.setValor("N/I");
            c.setTipo(2);

        } else if (NumberUtils.isCreatable(valor.toString()) && valor.toString().contains("-")) {

            c.setValor("Não se aplica");
            c.setTipo(2);

        } else if (chave.equalsIgnoreCase("afastado") && valor.toString() != null) {

            System.out.println("valor " + valor);
            valorAux = Long.valueOf(Long.parseLong(valor.toString()));

            if (valorAux.longValue() < 0L) {

                c.setValor("Não se aplica");
                c.setTipo(2);

            } else if (valorAux.equals(Long.valueOf(0L))) {

                c.setValor("Não");

            } else if (valorAux.equals(Long.valueOf(1L))) {

                c.setValor("Sim");

            } else {

                c.setValor(valor.toString());
            }

        } else if (valor.toString().equals("false")) {
            c.setValor("Não");
        } else if (valor.toString().equals("true")) {
            c.setValor("Sim");
        } else {
            c.setValor(valor.toString());
        }

        if (valor != null && StringUtils.isNotBlank(valor.toString()) && (chave.equalsIgnoreCase("cpf") || chave.equalsIgnoreCase("cnpj")) && valor.toString().contains("*")) {
            c.setTipo(2);
        }

        return c;
    }
    
    public static Timeline adicionaTimeLine(Long timestamp, String descricao) {
        
         Timeline line = new Timeline();
         line.setTimestamp(timestamp);
         line.setDescricao(descricao);
         
         return line;
    }
}
