package com.harpia.stive.api.model;

import java.util.List;
import lombok.Data;

@Data
public class Consulta {

    private String nome;
    private String url;
    private String descricao;
    private List<Filtro> filtros;
}
