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
 * TipoBeneficioDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-01-27T12:54:57.746Z")
public class TipoBeneficioDTO {

    private String descricao = null;
    private String descricaoDetalhada = null;
    private Integer id = null;

    public TipoBeneficioDTO descricao(String descricao) {
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

    public TipoBeneficioDTO descricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
        return this;
    }

    /**
     * Get descricaoDetalhada
     *
     * @return descricaoDetalhada
     *
     */
    @ApiModelProperty(value = "")
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public TipoBeneficioDTO id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     *
     */
    @ApiModelProperty(value = "")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TipoBeneficioDTO tipoBeneficioDTO = (TipoBeneficioDTO) o;
        return Objects.equals(this.descricao, tipoBeneficioDTO.descricao)
                && Objects.equals(this.descricaoDetalhada, tipoBeneficioDTO.descricaoDetalhada)
                && Objects.equals(this.id, tipoBeneficioDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, descricaoDetalhada, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TipoBeneficioDTO {\n");

        sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
        sb.append("    descricaoDetalhada: ").append(toIndentedString(descricaoDetalhada)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
