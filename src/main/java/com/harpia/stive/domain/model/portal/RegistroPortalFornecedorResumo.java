package com.harpia.stive.domain.model.portal;

import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author Fernando
 */
@Data
@Component
public class RegistroPortalFornecedorResumo {

    private List<FornecedorResumo> dados;
}
