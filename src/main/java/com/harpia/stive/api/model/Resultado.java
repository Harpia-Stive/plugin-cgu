package com.harpia.stive.api.model;

import java.util.List;
import lombok.Data;

@Data
public class Resultado {

    private String documento;
    private String referencia;
    private List<Campo> campos;
    private List<Botao> botoes;
    List<Timeline> timeline;
}
