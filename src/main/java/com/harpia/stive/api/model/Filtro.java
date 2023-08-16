package com.harpia.stive.api.model;

import java.util.List;
import lombok.Data;

@Data
public class Filtro {

    /*
    "url": "nome",
          "instrucao": "Digite o nome da pessoa e empresa que deseja encontrar. A pesquisa considera nomes parciais.",
          "atributos
     */
    private String url;
    private String instrucao;
    private List<Atributo> atributos;
}
