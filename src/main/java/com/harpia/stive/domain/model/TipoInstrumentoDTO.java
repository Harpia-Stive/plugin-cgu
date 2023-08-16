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
 * TipoInstrumentoDTO
 */
public class TipoInstrumentoDTO {

    private String codigo = null;
    private String descricao = null;
    private Integer id = null;

    public TipoInstrumentoDTO codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    /**
     * Get codigo
     *
     * @return codigo
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoInstrumentoDTO descricao(String descricao) {
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

    public TipoInstrumentoDTO id(Integer id) {
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
        TipoInstrumentoDTO tipoInstrumentoDTO = (TipoInstrumentoDTO) o;
        return Objects.equals(this.codigo, tipoInstrumentoDTO.codigo)
                && Objects.equals(this.descricao, tipoInstrumentoDTO.descricao)
                && Objects.equals(this.id, tipoInstrumentoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TipoInstrumentoDTO {\n");

        sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
        sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
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
