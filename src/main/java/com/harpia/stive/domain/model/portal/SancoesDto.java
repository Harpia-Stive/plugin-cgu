package com.harpia.stive.domain.model.portal;

import com.harpia.stive.domain.model.AcordosLenienciaDTO;
import com.harpia.stive.domain.model.CnepDTO;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Fernando
 */
@Data
public class SancoesDto {

    private List<AcordosLenienciaDTO> acordos;
    private List<CnepDTO> cneps;
}
