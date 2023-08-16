package com.harpia.stive.domain.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * FundamentacaoCeisDTO
 */
public class FundamentacaoCeisDTO {

    @SerializedName("codigo")
    private String codigo = null;

    @SerializedName("descricao")
    private String descricao = null;

    public FundamentacaoCeisDTO codigo(String codigo) {
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

    public FundamentacaoCeisDTO descricao(String dataFimSancao) {
        this.descricao = dataFimSancao;
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
        FundamentacaoCeisDTO ceisDTO = (FundamentacaoCeisDTO) o;
        return Objects.equals(this.codigo, ceisDTO.codigo)
                && Objects.equals(this.descricao, ceisDTO.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CeisDTO {\n");

        sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
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
