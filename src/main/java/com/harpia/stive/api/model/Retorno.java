package com.harpia.stive.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Retorno {

    private List<Resultado> resultado;

    @JsonProperty("versao_protocolo")
    private Integer versaoProtocolo;
}
