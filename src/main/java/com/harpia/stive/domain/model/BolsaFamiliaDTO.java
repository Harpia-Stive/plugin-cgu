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
import java.math.BigDecimal;
import java.util.Objects;

/**
 * BolsaFamiliaDTO
 */
public class BolsaFamiliaDTO {

    private String dataMesCompetencia = null;

    private String dataMesReferencia = null;

    private Long id = null;

    private MunicipioDTO municipio = null;

    private Integer quantidadeDependentes = null;

    private BeneficiarioDTO titularBolsaFamilia = null;

    private BigDecimal valor = null;

    public BolsaFamiliaDTO dataMesCompetencia(String dataMesCompetencia) {
        this.dataMesCompetencia = dataMesCompetencia;
        return this;
    }

    /**
     * Get dataMesCompetencia
     *
     * @return dataMesCompetencia
     *
     */
    @ApiModelProperty(value = "")
    public String getDataMesCompetencia() {
        return dataMesCompetencia;
    }

    public void setDataMesCompetencia(String dataMesCompetencia) {
        this.dataMesCompetencia = dataMesCompetencia;
    }

    public BolsaFamiliaDTO dataMesReferencia(String dataMesReferencia) {
        this.dataMesReferencia = dataMesReferencia;
        return this;
    }

    /**
     * Get dataMesReferencia
     *
     * @return dataMesReferencia
     *
     */
    @ApiModelProperty(value = "")
    public String getDataMesReferencia() {
        return dataMesReferencia;
    }

    public void setDataMesReferencia(String dataMesReferencia) {
        this.dataMesReferencia = dataMesReferencia;
    }

    public BolsaFamiliaDTO id(Long id) {
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BolsaFamiliaDTO municipio(MunicipioDTO municipio) {
        this.municipio = municipio;
        return this;
    }

    /**
     * Get municipio
     *
     * @return municipio
     *
     */
    @ApiModelProperty(value = "")
    public MunicipioDTO getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDTO municipio) {
        this.municipio = municipio;
    }

    public BolsaFamiliaDTO quantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
        return this;
    }

    /**
     * Get quantidadeDependentes
     *
     * @return quantidadeDependentes
     *
     */
    @ApiModelProperty(value = "")
    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public BolsaFamiliaDTO titularBolsaFamilia(BeneficiarioDTO titularBolsaFamilia) {
        this.titularBolsaFamilia = titularBolsaFamilia;
        return this;
    }

    /**
     * Get titularBolsaFamilia
     *
     * @return titularBolsaFamilia
     *
     */
    @ApiModelProperty(value = "")
    public BeneficiarioDTO getTitularBolsaFamilia() {
        return titularBolsaFamilia;
    }

    public void setTitularBolsaFamilia(BeneficiarioDTO titularBolsaFamilia) {
        this.titularBolsaFamilia = titularBolsaFamilia;
    }

    public BolsaFamiliaDTO valor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    /**
     * Get valor
     *
     * @return valor
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BolsaFamiliaDTO bolsaFamiliaDTO = (BolsaFamiliaDTO) o;
        return Objects.equals(this.dataMesCompetencia, bolsaFamiliaDTO.dataMesCompetencia)
                && Objects.equals(this.dataMesReferencia, bolsaFamiliaDTO.dataMesReferencia)
                && Objects.equals(this.id, bolsaFamiliaDTO.id)
                && Objects.equals(this.municipio, bolsaFamiliaDTO.municipio)
                && Objects.equals(this.quantidadeDependentes, bolsaFamiliaDTO.quantidadeDependentes)
                && Objects.equals(this.titularBolsaFamilia, bolsaFamiliaDTO.titularBolsaFamilia)
                && Objects.equals(this.valor, bolsaFamiliaDTO.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataMesCompetencia, dataMesReferencia, id, municipio, quantidadeDependentes, titularBolsaFamilia, valor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BolsaFamiliaDTO {\n");

        sb.append("    dataMesCompetencia: ").append(toIndentedString(dataMesCompetencia)).append("\n");
        sb.append("    dataMesReferencia: ").append(toIndentedString(dataMesReferencia)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    municipio: ").append(toIndentedString(municipio)).append("\n");
        sb.append("    quantidadeDependentes: ").append(toIndentedString(quantidadeDependentes)).append("\n");
        sb.append("    titularBolsaFamilia: ").append(toIndentedString(titularBolsaFamilia)).append("\n");
        sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
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
