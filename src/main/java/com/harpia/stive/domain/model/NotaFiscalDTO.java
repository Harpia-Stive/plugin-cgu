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
 * NotaFiscalDTO
 */
public class NotaFiscalDTO {

    private String chaveNotaFiscal = null;

    private String cnpjFornecedor = null;

    private String codigoOrgaoDestinatario = null;

    private String codigoOrgaoSuperiorDestinatario = null;

    private String dataEmissao = null;

    private String dataTipoEventoMaisRecente = null;

    private Integer id = null;

    private String municipioFornecedor = null;

    private String nomeFornecedor = null;

    private Integer numero = null;

    private String orgaoDestinatario = null;

    private String orgaoSuperiorDestinatario = null;

    private Integer serie = null;

    private String tipoEventoMaisRecente = null;

    private String valorNotaFiscal = null;

    public NotaFiscalDTO chaveNotaFiscal(String chaveNotaFiscal) {
        this.chaveNotaFiscal = chaveNotaFiscal;
        return this;
    }

    /**
     * Get chaveNotaFiscal
     *
     * @return chaveNotaFiscal
     *
     */
    @ApiModelProperty(value = "")
    public String getChaveNotaFiscal() {
        return chaveNotaFiscal;
    }

    public void setChaveNotaFiscal(String chaveNotaFiscal) {
        this.chaveNotaFiscal = chaveNotaFiscal;
    }

    public NotaFiscalDTO cnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
        return this;
    }

    /**
     * Get cnpjFornecedor
     *
     * @return cnpjFornecedor
     *
     */
    @ApiModelProperty(value = "")
    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public NotaFiscalDTO codigoOrgaoDestinatario(String codigoOrgaoDestinatario) {
        this.codigoOrgaoDestinatario = codigoOrgaoDestinatario;
        return this;
    }

    /**
     * Get codigoOrgaoDestinatario
     *
     * @return codigoOrgaoDestinatario
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoOrgaoDestinatario() {
        return codigoOrgaoDestinatario;
    }

    public void setCodigoOrgaoDestinatario(String codigoOrgaoDestinatario) {
        this.codigoOrgaoDestinatario = codigoOrgaoDestinatario;
    }

    public NotaFiscalDTO codigoOrgaoSuperiorDestinatario(String codigoOrgaoSuperiorDestinatario) {
        this.codigoOrgaoSuperiorDestinatario = codigoOrgaoSuperiorDestinatario;
        return this;
    }

    /**
     * Get codigoOrgaoSuperiorDestinatario
     *
     * @return codigoOrgaoSuperiorDestinatario
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoOrgaoSuperiorDestinatario() {
        return codigoOrgaoSuperiorDestinatario;
    }

    public void setCodigoOrgaoSuperiorDestinatario(String codigoOrgaoSuperiorDestinatario) {
        this.codigoOrgaoSuperiorDestinatario = codigoOrgaoSuperiorDestinatario;
    }

    public NotaFiscalDTO dataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
        return this;
    }

    /**
     * Get dataEmissao
     *
     * @return dataEmissao
     *
     */
    @ApiModelProperty(value = "")
    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public NotaFiscalDTO dataTipoEventoMaisRecente(String dataTipoEventoMaisRecente) {
        this.dataTipoEventoMaisRecente = dataTipoEventoMaisRecente;
        return this;
    }

    /**
     * Get dataTipoEventoMaisRecente
     *
     * @return dataTipoEventoMaisRecente
     *
     */
    @ApiModelProperty(value = "")
    public String getDataTipoEventoMaisRecente() {
        return dataTipoEventoMaisRecente;
    }

    public void setDataTipoEventoMaisRecente(String dataTipoEventoMaisRecente) {
        this.dataTipoEventoMaisRecente = dataTipoEventoMaisRecente;
    }

    public NotaFiscalDTO id(Integer id) {
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

    public NotaFiscalDTO municipioFornecedor(String municipioFornecedor) {
        this.municipioFornecedor = municipioFornecedor;
        return this;
    }

    /**
     * Get municipioFornecedor
     *
     * @return municipioFornecedor
     *
     */
    @ApiModelProperty(value = "")
    public String getMunicipioFornecedor() {
        return municipioFornecedor;
    }

    public void setMunicipioFornecedor(String municipioFornecedor) {
        this.municipioFornecedor = municipioFornecedor;
    }

    public NotaFiscalDTO nomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
        return this;
    }

    /**
     * Get nomeFornecedor
     *
     * @return nomeFornecedor
     *
     */
    @ApiModelProperty(value = "")
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public NotaFiscalDTO numero(Integer numero) {
        this.numero = numero;
        return this;
    }

    /**
     * Get numero
     *
     * @return numero
     *
     */
    @ApiModelProperty(value = "")
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public NotaFiscalDTO orgaoDestinatario(String orgaoDestinatario) {
        this.orgaoDestinatario = orgaoDestinatario;
        return this;
    }

    /**
     * Get orgaoDestinatario
     *
     * @return orgaoDestinatario
     *
     */
    @ApiModelProperty(value = "")
    public String getOrgaoDestinatario() {
        return orgaoDestinatario;
    }

    public void setOrgaoDestinatario(String orgaoDestinatario) {
        this.orgaoDestinatario = orgaoDestinatario;
    }

    public NotaFiscalDTO orgaoSuperiorDestinatario(String orgaoSuperiorDestinatario) {
        this.orgaoSuperiorDestinatario = orgaoSuperiorDestinatario;
        return this;
    }

    /**
     * Get orgaoSuperiorDestinatario
     *
     * @return orgaoSuperiorDestinatario
     *
     */
    @ApiModelProperty(value = "")
    public String getOrgaoSuperiorDestinatario() {
        return orgaoSuperiorDestinatario;
    }

    public void setOrgaoSuperiorDestinatario(String orgaoSuperiorDestinatario) {
        this.orgaoSuperiorDestinatario = orgaoSuperiorDestinatario;
    }

    public NotaFiscalDTO serie(Integer serie) {
        this.serie = serie;
        return this;
    }

    /**
     * Get serie
     *
     * @return serie
     *
     */
    @ApiModelProperty(value = "")
    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public NotaFiscalDTO tipoEventoMaisRecente(String tipoEventoMaisRecente) {
        this.tipoEventoMaisRecente = tipoEventoMaisRecente;
        return this;
    }

    /**
     * Get tipoEventoMaisRecente
     *
     * @return tipoEventoMaisRecente
     *
     */
    @ApiModelProperty(value = "")
    public String getTipoEventoMaisRecente() {
        return tipoEventoMaisRecente;
    }

    public void setTipoEventoMaisRecente(String tipoEventoMaisRecente) {
        this.tipoEventoMaisRecente = tipoEventoMaisRecente;
    }

    public NotaFiscalDTO valorNotaFiscal(String valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
        return this;
    }

    /**
     * Get valorNotaFiscal
     *
     * @return valorNotaFiscal
     *
     */
    @ApiModelProperty(value = "")
    public String getValorNotaFiscal() {
        return valorNotaFiscal;
    }

    public void setValorNotaFiscal(String valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotaFiscalDTO notaFiscalDTO = (NotaFiscalDTO) o;
        return Objects.equals(this.chaveNotaFiscal, notaFiscalDTO.chaveNotaFiscal)
                && Objects.equals(this.cnpjFornecedor, notaFiscalDTO.cnpjFornecedor)
                && Objects.equals(this.codigoOrgaoDestinatario, notaFiscalDTO.codigoOrgaoDestinatario)
                && Objects.equals(this.codigoOrgaoSuperiorDestinatario, notaFiscalDTO.codigoOrgaoSuperiorDestinatario)
                && Objects.equals(this.dataEmissao, notaFiscalDTO.dataEmissao)
                && Objects.equals(this.dataTipoEventoMaisRecente, notaFiscalDTO.dataTipoEventoMaisRecente)
                && Objects.equals(this.id, notaFiscalDTO.id)
                && Objects.equals(this.municipioFornecedor, notaFiscalDTO.municipioFornecedor)
                && Objects.equals(this.nomeFornecedor, notaFiscalDTO.nomeFornecedor)
                && Objects.equals(this.numero, notaFiscalDTO.numero)
                && Objects.equals(this.orgaoDestinatario, notaFiscalDTO.orgaoDestinatario)
                && Objects.equals(this.orgaoSuperiorDestinatario, notaFiscalDTO.orgaoSuperiorDestinatario)
                && Objects.equals(this.serie, notaFiscalDTO.serie)
                && Objects.equals(this.tipoEventoMaisRecente, notaFiscalDTO.tipoEventoMaisRecente)
                && Objects.equals(this.valorNotaFiscal, notaFiscalDTO.valorNotaFiscal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chaveNotaFiscal, cnpjFornecedor, codigoOrgaoDestinatario, codigoOrgaoSuperiorDestinatario, dataEmissao, dataTipoEventoMaisRecente, id, municipioFornecedor, nomeFornecedor, numero, orgaoDestinatario, orgaoSuperiorDestinatario, serie, tipoEventoMaisRecente, valorNotaFiscal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotaFiscalDTO {\n");

        sb.append("    chaveNotaFiscal: ").append(toIndentedString(chaveNotaFiscal)).append("\n");
        sb.append("    cnpjFornecedor: ").append(toIndentedString(cnpjFornecedor)).append("\n");
        sb.append("    codigoOrgaoDestinatario: ").append(toIndentedString(codigoOrgaoDestinatario)).append("\n");
        sb.append("    codigoOrgaoSuperiorDestinatario: ").append(toIndentedString(codigoOrgaoSuperiorDestinatario)).append("\n");
        sb.append("    dataEmissao: ").append(toIndentedString(dataEmissao)).append("\n");
        sb.append("    dataTipoEventoMaisRecente: ").append(toIndentedString(dataTipoEventoMaisRecente)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    municipioFornecedor: ").append(toIndentedString(municipioFornecedor)).append("\n");
        sb.append("    nomeFornecedor: ").append(toIndentedString(nomeFornecedor)).append("\n");
        sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
        sb.append("    orgaoDestinatario: ").append(toIndentedString(orgaoDestinatario)).append("\n");
        sb.append("    orgaoSuperiorDestinatario: ").append(toIndentedString(orgaoSuperiorDestinatario)).append("\n");
        sb.append("    serie: ").append(toIndentedString(serie)).append("\n");
        sb.append("    tipoEventoMaisRecente: ").append(toIndentedString(tipoEventoMaisRecente)).append("\n");
        sb.append("    valorNotaFiscal: ").append(toIndentedString(valorNotaFiscal)).append("\n");
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
