package com.harpia.stive.api.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Contrato {

    private Integer versao_protocolo;
    private String nome;
    private String referencia;
    private Integer tipo;
    private String logo;
    private String descricao;
    private List<Consulta> consultas = new ArrayList<>();
}
