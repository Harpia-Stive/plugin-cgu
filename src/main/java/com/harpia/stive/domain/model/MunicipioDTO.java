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
 * MunicipioDTO
 */
public class MunicipioDTO {

    private String codigoIBGE = null;

    private String codigoRegiao = null;

    private String nomeIBGE = null;

    private String nomeRegiao = null;

    private String pais = null;

    private UFDTO uf = null;

    public MunicipioDTO codigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
        return this;
    }

    /**
     * Get codigoIBGE
     *
     * @return codigoIBGE
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public MunicipioDTO codigoRegiao(String codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
        return this;
    }

    /**
     * Get codigoRegiao
     *
     * @return codigoRegiao
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoRegiao() {
        return codigoRegiao;
    }

    public void setCodigoRegiao(String codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
    }

    public MunicipioDTO nomeIBGE(String nomeIBGE) {
        this.nomeIBGE = nomeIBGE;
        return this;
    }

    /**
     * Get nomeIBGE
     *
     * @return nomeIBGE
     *
     */
    @ApiModelProperty(value = "")
    public String getNomeIBGE() {
        return nomeIBGE;
    }

    public void setNomeIBGE(String nomeIBGE) {
        this.nomeIBGE = nomeIBGE;
    }

    public MunicipioDTO nomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
        return this;
    }

    /**
     * Get nomeRegiao
     *
     * @return nomeRegiao
     *
     */
    @ApiModelProperty(value = "")
    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public MunicipioDTO pais(String pais) {
        this.pais = pais;
        return this;
    }

    /**
     * Get pais
     *
     * @return pais
     *
     */
    @ApiModelProperty(value = "")
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public MunicipioDTO uf(UFDTO uf) {
        this.uf = uf;
        return this;
    }

    /**
     * Get uf
     *
     * @return uf
     *
     */
    @ApiModelProperty(value = "")
    public UFDTO getUf() {
        return uf;
    }

    public void setUf(UFDTO uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MunicipioDTO municipioDTO = (MunicipioDTO) o;
        return Objects.equals(this.codigoIBGE, municipioDTO.codigoIBGE)
                && Objects.equals(this.codigoRegiao, municipioDTO.codigoRegiao)
                && Objects.equals(this.nomeIBGE, municipioDTO.nomeIBGE)
                && Objects.equals(this.nomeRegiao, municipioDTO.nomeRegiao)
                && Objects.equals(this.pais, municipioDTO.pais)
                && Objects.equals(this.uf, municipioDTO.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIBGE, codigoRegiao, nomeIBGE, nomeRegiao, pais, uf);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MunicipioDTO {\n");

        sb.append("    codigoIBGE: ").append(toIndentedString(codigoIBGE)).append("\n");
        sb.append("    codigoRegiao: ").append(toIndentedString(codigoRegiao)).append("\n");
        sb.append("    nomeIBGE: ").append(toIndentedString(nomeIBGE)).append("\n");
        sb.append("    nomeRegiao: ").append(toIndentedString(nomeRegiao)).append("\n");
        sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
        sb.append("    uf: ").append(toIndentedString(uf)).append("\n");
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
