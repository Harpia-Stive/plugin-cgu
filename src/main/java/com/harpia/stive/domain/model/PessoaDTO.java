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
 * PessoaDTO
 */
public class PessoaDTO {

    private String cnpjFormatado = null;

    private String cpfFormatado = null;

    private Integer id = null;

    private String nome = null;

    private String nomeFantasiaReceita = null;

    private String numeroInscricaoSocial = null;

    private String razaoSocialReceita = null;

    private String tipo = null;

    public PessoaDTO cnpjFormatado(String cnpjFormatado) {
        this.cnpjFormatado = cnpjFormatado;
        return this;
    }

    /**
     * Get cnpjFormatado
     *
     * @return cnpjFormatado
     *
     */
    @ApiModelProperty(value = "")
    public String getCnpjFormatado() {
        return cnpjFormatado;
    }

    public void setCnpjFormatado(String cnpjFormatado) {
        this.cnpjFormatado = cnpjFormatado;
    }

    public PessoaDTO cpfFormatado(String cpfFormatado) {
        this.cpfFormatado = cpfFormatado;
        return this;
    }

    /**
     * Get cpfFormatado
     *
     * @return cpfFormatado
     *
     */
    @ApiModelProperty(value = "")
    public String getCpfFormatado() {
        return cpfFormatado;
    }

    public void setCpfFormatado(String cpfFormatado) {
        this.cpfFormatado = cpfFormatado;
    }

    public PessoaDTO id(Integer id) {
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

    public PessoaDTO nome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Get nome
     *
     * @return nome
     *
     */
    @ApiModelProperty(value = "")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PessoaDTO nomeFantasiaReceita(String nomeFantasiaReceita) {
        this.nomeFantasiaReceita = nomeFantasiaReceita;
        return this;
    }

    /**
     * Get nomeFantasiaReceita
     *
     * @return nomeFantasiaReceita
     *
     */
    @ApiModelProperty(value = "")
    public String getNomeFantasiaReceita() {
        return nomeFantasiaReceita;
    }

    public void setNomeFantasiaReceita(String nomeFantasiaReceita) {
        this.nomeFantasiaReceita = nomeFantasiaReceita;
    }

    public PessoaDTO numeroInscricaoSocial(String numeroInscricaoSocial) {
        this.numeroInscricaoSocial = numeroInscricaoSocial;
        return this;
    }

    /**
     * Get numeroInscricaoSocial
     *
     * @return numeroInscricaoSocial
     *
     */
    @ApiModelProperty(value = "")
    public String getNumeroInscricaoSocial() {
        return numeroInscricaoSocial;
    }

    public void setNumeroInscricaoSocial(String numeroInscricaoSocial) {
        this.numeroInscricaoSocial = numeroInscricaoSocial;
    }

    public PessoaDTO razaoSocialReceita(String razaoSocialReceita) {
        this.razaoSocialReceita = razaoSocialReceita;
        return this;
    }

    /**
     * Get razaoSocialReceita
     *
     * @return razaoSocialReceita
     *
     */
    @ApiModelProperty(value = "")
    public String getRazaoSocialReceita() {
        return razaoSocialReceita;
    }

    public void setRazaoSocialReceita(String razaoSocialReceita) {
        this.razaoSocialReceita = razaoSocialReceita;
    }

    public PessoaDTO tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    /**
     * Get tipo
     *
     * @return tipo
     *
     */
    @ApiModelProperty(value = "")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PessoaDTO pessoaDTO = (PessoaDTO) o;
        return Objects.equals(this.cnpjFormatado, pessoaDTO.cnpjFormatado)
                && Objects.equals(this.cpfFormatado, pessoaDTO.cpfFormatado)
                && Objects.equals(this.id, pessoaDTO.id)
                && Objects.equals(this.nome, pessoaDTO.nome)
                && Objects.equals(this.nomeFantasiaReceita, pessoaDTO.nomeFantasiaReceita)
                && Objects.equals(this.numeroInscricaoSocial, pessoaDTO.numeroInscricaoSocial)
                && Objects.equals(this.razaoSocialReceita, pessoaDTO.razaoSocialReceita)
                && Objects.equals(this.tipo, pessoaDTO.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpjFormatado, cpfFormatado, id, nome, nomeFantasiaReceita, numeroInscricaoSocial, razaoSocialReceita, tipo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PessoaDTO {\n");

        sb.append("    cnpjFormatado: ").append(toIndentedString(cnpjFormatado)).append("\n");
        sb.append("    cpfFormatado: ").append(toIndentedString(cpfFormatado)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
        sb.append("    nomeFantasiaReceita: ").append(toIndentedString(nomeFantasiaReceita)).append("\n");
        sb.append("    numeroInscricaoSocial: ").append(toIndentedString(numeroInscricaoSocial)).append("\n");
        sb.append("    razaoSocialReceita: ").append(toIndentedString(razaoSocialReceita)).append("\n");
        sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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
