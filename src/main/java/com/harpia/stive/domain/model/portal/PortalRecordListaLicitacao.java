package com.harpia.stive.domain.model.portal;

import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author Fernando
 *
 */
@Data
@Component
public class PortalRecordListaLicitacao {

    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    List<ListaLicitacaoPortal> data;
    String error;
}
