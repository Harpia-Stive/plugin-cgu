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
 * FonteSancaoDTO
 */
public class FonteSancaoDTO {

    private String enderecoContato = null;

    private String nomeExibicao = null;

    private String telefoneContato = null;

    public FonteSancaoDTO enderecoContato(String enderecoContato) {
        this.enderecoContato = enderecoContato;
        return this;
    }

    /**
     * Get enderecoContato
     *
     * @return enderecoContato
     *
     */
    @ApiModelProperty(value = "")
    public String getEnderecoContato() {
        return enderecoContato;
    }

    public void setEnderecoContato(String enderecoContato) {
        this.enderecoContato = enderecoContato;
    }

    public FonteSancaoDTO nomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
        return this;
    }

    /**
     * Get nomeExibicao
     *
     * @return nomeExibicao
     *
     */
    @ApiModelProperty(value = "")
    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public FonteSancaoDTO telefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
        return this;
    }

    /**
     * Get telefoneContato
     *
     * @return telefoneContato
     *
     */
    @ApiModelProperty(value = "")
    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FonteSancaoDTO fonteSancaoDTO = (FonteSancaoDTO) o;
        return Objects.equals(this.enderecoContato, fonteSancaoDTO.enderecoContato)
                && Objects.equals(this.nomeExibicao, fonteSancaoDTO.nomeExibicao)
                && Objects.equals(this.telefoneContato, fonteSancaoDTO.telefoneContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enderecoContato, nomeExibicao, telefoneContato);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FonteSancaoDTO {\n");

        sb.append("    enderecoContato: ").append(toIndentedString(enderecoContato)).append("\n");
        sb.append("    nomeExibicao: ").append(toIndentedString(nomeExibicao)).append("\n");
        sb.append("    telefoneContato: ").append(toIndentedString(telefoneContato)).append("\n");
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
