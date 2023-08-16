package com.harpia.stive.domain.model.portal;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author Fernando
 */
@Component
@Data
public class ListaLicitacaoPortal {

    private Long skLicitacao;
    private String orgao;
    private String unidadeGestora;
    private String numeroLicitacao;
    private String dataAbertura;
}
