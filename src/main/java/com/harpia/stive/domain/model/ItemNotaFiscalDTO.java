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
 * ItemNotaFiscalDTO
 */
public class ItemNotaFiscalDTO {

    private String cfop = null;

    private String codigoNcmSh = null;

    private String descricaoProdutoServico = null;

    private String ncmSh = null;

    private String numeroProduto = null;

    private String quantidade = null;

    private String unidade = null;

    private String valor = null;

    private String valorUnitario = null;

    public ItemNotaFiscalDTO cfop(String cfop) {
        this.cfop = cfop;
        return this;
    }

    /**
     * Get cfop
     *
     * @return cfop
     *
     */
    @ApiModelProperty(value = "")
    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public ItemNotaFiscalDTO codigoNcmSh(String codigoNcmSh) {
        this.codigoNcmSh = codigoNcmSh;
        return this;
    }

    /**
     * Get codigoNcmSh
     *
     * @return codigoNcmSh
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoNcmSh() {
        return codigoNcmSh;
    }

    public void setCodigoNcmSh(String codigoNcmSh) {
        this.codigoNcmSh = codigoNcmSh;
    }

    public ItemNotaFiscalDTO descricaoProdutoServico(String descricaoProdutoServico) {
        this.descricaoProdutoServico = descricaoProdutoServico;
        return this;
    }

    /**
     * Get descricaoProdutoServico
     *
     * @return descricaoProdutoServico
     *
     */
    @ApiModelProperty(value = "")
    public String getDescricaoProdutoServico() {
        return descricaoProdutoServico;
    }

    public void setDescricaoProdutoServico(String descricaoProdutoServico) {
        this.descricaoProdutoServico = descricaoProdutoServico;
    }

    public ItemNotaFiscalDTO ncmSh(String ncmSh) {
        this.ncmSh = ncmSh;
        return this;
    }

    /**
     * Get ncmSh
     *
     * @return ncmSh
     *
     */
    @ApiModelProperty(value = "")
    public String getNcmSh() {
        return ncmSh;
    }

    public void setNcmSh(String ncmSh) {
        this.ncmSh = ncmSh;
    }

    public ItemNotaFiscalDTO numeroProduto(String numeroProduto) {
        this.numeroProduto = numeroProduto;
        return this;
    }

    /**
     * Get numeroProduto
     *
     * @return numeroProduto
     *
     */
    @ApiModelProperty(value = "")
    public String getNumeroProduto() {
        return numeroProduto;
    }

    public void setNumeroProduto(String numeroProduto) {
        this.numeroProduto = numeroProduto;
    }

    public ItemNotaFiscalDTO quantidade(String quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Get quantidade
     *
     * @return quantidade
     *
     */
    @ApiModelProperty(value = "")
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public ItemNotaFiscalDTO unidade(String unidade) {
        this.unidade = unidade;
        return this;
    }

    /**
     * Get unidade
     *
     * @return unidade
     *
     */
    @ApiModelProperty(value = "")
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public ItemNotaFiscalDTO valor(String valor) {
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
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ItemNotaFiscalDTO valorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    /**
     * Get valorUnitario
     *
     * @return valorUnitario
     *
     */
    @ApiModelProperty(value = "")
    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemNotaFiscalDTO itemNotaFiscalDTO = (ItemNotaFiscalDTO) o;
        return Objects.equals(this.cfop, itemNotaFiscalDTO.cfop)
                && Objects.equals(this.codigoNcmSh, itemNotaFiscalDTO.codigoNcmSh)
                && Objects.equals(this.descricaoProdutoServico, itemNotaFiscalDTO.descricaoProdutoServico)
                && Objects.equals(this.ncmSh, itemNotaFiscalDTO.ncmSh)
                && Objects.equals(this.numeroProduto, itemNotaFiscalDTO.numeroProduto)
                && Objects.equals(this.quantidade, itemNotaFiscalDTO.quantidade)
                && Objects.equals(this.unidade, itemNotaFiscalDTO.unidade)
                && Objects.equals(this.valor, itemNotaFiscalDTO.valor)
                && Objects.equals(this.valorUnitario, itemNotaFiscalDTO.valorUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cfop, codigoNcmSh, descricaoProdutoServico, ncmSh, numeroProduto, quantidade, unidade, valor, valorUnitario);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ItemNotaFiscalDTO {\n");

        sb.append("    cfop: ").append(toIndentedString(cfop)).append("\n");
        sb.append("    codigoNcmSh: ").append(toIndentedString(codigoNcmSh)).append("\n");
        sb.append("    descricaoProdutoServico: ").append(toIndentedString(descricaoProdutoServico)).append("\n");
        sb.append("    ncmSh: ").append(toIndentedString(ncmSh)).append("\n");
        sb.append("    numeroProduto: ").append(toIndentedString(numeroProduto)).append("\n");
        sb.append("    quantidade: ").append(toIndentedString(quantidade)).append("\n");
        sb.append("    unidade: ").append(toIndentedString(unidade)).append("\n");
        sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
        sb.append("    valorUnitario: ").append(toIndentedString(valorUnitario)).append("\n");
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
