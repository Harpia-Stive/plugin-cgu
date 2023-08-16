/*
 * API REST do Portal da Transparência do Governo Federal
 * API de serviços do Portal da Transparência do Governo Federal
 *
 * OpenAPI spec version: 1.0
 * Contact: listaapitransparencia@cgu.gov.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.harpia.stive.domain.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * TipoPunicaoDTO
 */
public class TipoPunicaoDTO {

    private String descricao = null;

    public TipoPunicaoDTO descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    /**
     * Get descricao
     *
     * @return descricao
     *
     */
    @ApiModelProperty(value = "")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TipoPunicaoDTO tipoPunicaoDTO = (TipoPunicaoDTO) o;
        return Objects.equals(this.descricao, tipoPunicaoDTO.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TipoPunicaoDTO {\n");

        sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
