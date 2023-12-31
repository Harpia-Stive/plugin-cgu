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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.threeten.bp.LocalDate;

/**
 * NovoBolsaFamiliaPagoDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-10T02:15:55.020Z")
public class NovoBolsaFamiliaPagoDTO {
  @SerializedName("beneficiarioNovoBolsaFamilia")
  private BeneficiarioDTO beneficiarioNovoBolsaFamilia = null;

  @SerializedName("dataMesCompetencia")
  private LocalDate dataMesCompetencia = null;

  @SerializedName("dataMesReferencia")
  private LocalDate dataMesReferencia = null;

  @SerializedName("dataSaque")
  private LocalDate dataSaque = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("municipio")
  private MunicipioDTO municipio = null;

  @SerializedName("valorSaque")
  private BigDecimal valorSaque = null;

  public NovoBolsaFamiliaPagoDTO beneficiarioNovoBolsaFamilia(BeneficiarioDTO beneficiarioNovoBolsaFamilia) {
    this.beneficiarioNovoBolsaFamilia = beneficiarioNovoBolsaFamilia;
    return this;
  }

   /**
   * Get beneficiarioNovoBolsaFamilia
   * @return beneficiarioNovoBolsaFamilia
  **/
  @ApiModelProperty(value = "")
  public BeneficiarioDTO getBeneficiarioNovoBolsaFamilia() {
    return beneficiarioNovoBolsaFamilia;
  }

  public void setBeneficiarioNovoBolsaFamilia(BeneficiarioDTO beneficiarioNovoBolsaFamilia) {
    this.beneficiarioNovoBolsaFamilia = beneficiarioNovoBolsaFamilia;
  }

  public NovoBolsaFamiliaPagoDTO dataMesCompetencia(LocalDate dataMesCompetencia) {
    this.dataMesCompetencia = dataMesCompetencia;
    return this;
  }

   /**
   * Get dataMesCompetencia
   * @return dataMesCompetencia
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDataMesCompetencia() {
    return dataMesCompetencia;
  }

  public void setDataMesCompetencia(LocalDate dataMesCompetencia) {
    this.dataMesCompetencia = dataMesCompetencia;
  }

  public NovoBolsaFamiliaPagoDTO dataMesReferencia(LocalDate dataMesReferencia) {
    this.dataMesReferencia = dataMesReferencia;
    return this;
  }

   /**
   * Get dataMesReferencia
   * @return dataMesReferencia
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDataMesReferencia() {
    return dataMesReferencia;
  }

  public void setDataMesReferencia(LocalDate dataMesReferencia) {
    this.dataMesReferencia = dataMesReferencia;
  }

  public NovoBolsaFamiliaPagoDTO dataSaque(LocalDate dataSaque) {
    this.dataSaque = dataSaque;
    return this;
  }

   /**
   * Get dataSaque
   * @return dataSaque
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDataSaque() {
    return dataSaque;
  }

  public void setDataSaque(LocalDate dataSaque) {
    this.dataSaque = dataSaque;
  }

  public NovoBolsaFamiliaPagoDTO id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public NovoBolsaFamiliaPagoDTO municipio(MunicipioDTO municipio) {
    this.municipio = municipio;
    return this;
  }

   /**
   * Get municipio
   * @return municipio
  **/
  @ApiModelProperty(value = "")
  public MunicipioDTO getMunicipio() {
    return municipio;
  }

  public void setMunicipio(MunicipioDTO municipio) {
    this.municipio = municipio;
  }

  public NovoBolsaFamiliaPagoDTO valorSaque(BigDecimal valorSaque) {
    this.valorSaque = valorSaque;
    return this;
  }

   /**
   * Get valorSaque
   * @return valorSaque
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getValorSaque() {
    return valorSaque;
  }

  public void setValorSaque(BigDecimal valorSaque) {
    this.valorSaque = valorSaque;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NovoBolsaFamiliaPagoDTO novoBolsaFamiliaPagoDTO = (NovoBolsaFamiliaPagoDTO) o;
    return Objects.equals(this.beneficiarioNovoBolsaFamilia, novoBolsaFamiliaPagoDTO.beneficiarioNovoBolsaFamilia) &&
        Objects.equals(this.dataMesCompetencia, novoBolsaFamiliaPagoDTO.dataMesCompetencia) &&
        Objects.equals(this.dataMesReferencia, novoBolsaFamiliaPagoDTO.dataMesReferencia) &&
        Objects.equals(this.dataSaque, novoBolsaFamiliaPagoDTO.dataSaque) &&
        Objects.equals(this.id, novoBolsaFamiliaPagoDTO.id) &&
        Objects.equals(this.municipio, novoBolsaFamiliaPagoDTO.municipio) &&
        Objects.equals(this.valorSaque, novoBolsaFamiliaPagoDTO.valorSaque);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beneficiarioNovoBolsaFamilia, dataMesCompetencia, dataMesReferencia, dataSaque, id, municipio, valorSaque);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NovoBolsaFamiliaPagoDTO {\n");
    
    sb.append("    beneficiarioNovoBolsaFamilia: ").append(toIndentedString(beneficiarioNovoBolsaFamilia)).append("\n");
    sb.append("    dataMesCompetencia: ").append(toIndentedString(dataMesCompetencia)).append("\n");
    sb.append("    dataMesReferencia: ").append(toIndentedString(dataMesReferencia)).append("\n");
    sb.append("    dataSaque: ").append(toIndentedString(dataSaque)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    municipio: ").append(toIndentedString(municipio)).append("\n");
    sb.append("    valorSaque: ").append(toIndentedString(valorSaque)).append("\n");
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

