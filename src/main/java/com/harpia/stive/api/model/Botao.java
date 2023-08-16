package com.harpia.stive.api.model;

import java.util.Map;
import lombok.Data;

@Data
public class Botao {

    private String rotulo;
    private String referencia; //'REF DA FONTE'$'URL CONSULTA'$'URLFILTRO'
    private Map<String, Object> payload;

}
