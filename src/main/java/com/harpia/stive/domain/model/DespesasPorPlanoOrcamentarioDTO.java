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
 * DespesasPorPlanoOrcamentarioDTO
 */
public class DespesasPorPlanoOrcamentarioDTO {

    private String codPOIdAcompanhamento = null;

    private String codUnidadeOrcamentaria = null;

    private String codigo = null;

    private String codigoAcao = null;

    private String codigoFuncao = null;

    private String codigoPrograma = null;

    private String codigoSubFuncao = null;

    private String descPOIdAcompanhamento = null;

    private String descricao = null;

    private Integer id = null;

    private Integer numAno = null;

    public DespesasPorPlanoOrcamentarioDTO codPOIdAcompanhamento(String codPOIdAcompanhamento) {
        this.codPOIdAcompanhamento = codPOIdAcompanhamento;
        return this;
    }

    /**
     * Get codPOIdAcompanhamento
     *
     * @return codPOIdAcompanhamento
     *
     */
    @ApiModelProperty(value = "")
    public String getCodPOIdAcompanhamento() {
        return codPOIdAcompanhamento;
    }

    public void setCodPOIdAcompanhamento(String codPOIdAcompanhamento) {
        this.codPOIdAcompanhamento = codPOIdAcompanhamento;
    }

    public DespesasPorPlanoOrcamentarioDTO codUnidadeOrcamentaria(String codUnidadeOrcamentaria) {
        this.codUnidadeOrcamentaria = codUnidadeOrcamentaria;
        return this;
    }

    /**
     * Get codUnidadeOrcamentaria
     *
     * @return codUnidadeOrcamentaria
     *
     */
    @ApiModelProperty(value = "")
    public String getCodUnidadeOrcamentaria() {
        return codUnidadeOrcamentaria;
    }

    public void setCodUnidadeOrcamentaria(String codUnidadeOrcamentaria) {
        this.codUnidadeOrcamentaria = codUnidadeOrcamentaria;
    }

    public DespesasPorPlanoOrcamentarioDTO codigo(String codigo) {
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

    public DespesasPorPlanoOrcamentarioDTO codigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
        return this;
    }

    /**
     * Get codigoAcao
     *
     * @return codigoAcao
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public DespesasPorPlanoOrcamentarioDTO codigoFuncao(String codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
        return this;
    }

    /**
     * Get codigoFuncao
     *
     * @return codigoFuncao
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(String codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public DespesasPorPlanoOrcamentarioDTO codigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
        return this;
    }

    /**
     * Get codigoPrograma
     *
     * @return codigoPrograma
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public DespesasPorPlanoOrcamentarioDTO codigoSubFuncao(String codigoSubFuncao) {
        this.codigoSubFuncao = codigoSubFuncao;
        return this;
    }

    /**
     * Get codigoSubFuncao
     *
     * @return codigoSubFuncao
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoSubFuncao() {
        return codigoSubFuncao;
    }

    public void setCodigoSubFuncao(String codigoSubFuncao) {
        this.codigoSubFuncao = codigoSubFuncao;
    }

    public DespesasPorPlanoOrcamentarioDTO descPOIdAcompanhamento(String descPOIdAcompanhamento) {
        this.descPOIdAcompanhamento = descPOIdAcompanhamento;
        return this;
    }

    /**
     * Get descPOIdAcompanhamento
     *
     * @return descPOIdAcompanhamento
     *
     */
    @ApiModelProperty(value = "")
    public String getDescPOIdAcompanhamento() {
        return descPOIdAcompanhamento;
    }

    public void setDescPOIdAcompanhamento(String descPOIdAcompanhamento) {
        this.descPOIdAcompanhamento = descPOIdAcompanhamento;
    }

    public DespesasPorPlanoOrcamentarioDTO descricao(String descricao) {
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

    public DespesasPorPlanoOrcamentarioDTO id(Integer id) {
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

    public DespesasPorPlanoOrcamentarioDTO numAno(Integer numAno) {
        this.numAno = numAno;
        return this;
    }

    /**
     * Get numAno
     *
     * @return numAno
     *
     */
    @ApiModelProperty(value = "")
    public Integer getNumAno() {
        return numAno;
    }

    public void setNumAno(Integer numAno) {
        this.numAno = numAno;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DespesasPorPlanoOrcamentarioDTO despesasPorPlanoOrcamentarioDTO = (DespesasPorPlanoOrcamentarioDTO) o;
        return Objects.equals(this.codPOIdAcompanhamento, despesasPorPlanoOrcamentarioDTO.codPOIdAcompanhamento)
                && Objects.equals(this.codUnidadeOrcamentaria, despesasPorPlanoOrcamentarioDTO.codUnidadeOrcamentaria)
                && Objects.equals(this.codigo, despesasPorPlanoOrcamentarioDTO.codigo)
                && Objects.equals(this.codigoAcao, despesasPorPlanoOrcamentarioDTO.codigoAcao)
                && Objects.equals(this.codigoFuncao, despesasPorPlanoOrcamentarioDTO.codigoFuncao)
                && Objects.equals(this.codigoPrograma, despesasPorPlanoOrcamentarioDTO.codigoPrograma)
                && Objects.equals(this.codigoSubFuncao, despesasPorPlanoOrcamentarioDTO.codigoSubFuncao)
                && Objects.equals(this.descPOIdAcompanhamento, despesasPorPlanoOrcamentarioDTO.descPOIdAcompanhamento)
                && Objects.equals(this.descricao, despesasPorPlanoOrcamentarioDTO.descricao)
                && Objects.equals(this.id, despesasPorPlanoOrcamentarioDTO.id)
                && Objects.equals(this.numAno, despesasPorPlanoOrcamentarioDTO.numAno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPOIdAcompanhamento, codUnidadeOrcamentaria, codigo, codigoAcao, codigoFuncao, codigoPrograma, codigoSubFuncao, descPOIdAcompanhamento, descricao, id, numAno);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DespesasPorPlanoOrcamentarioDTO {\n");

        sb.append("    codPOIdAcompanhamento: ").append(toIndentedString(codPOIdAcompanhamento)).append("\n");
        sb.append("    codUnidadeOrcamentaria: ").append(toIndentedString(codUnidadeOrcamentaria)).append("\n");
        sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
        sb.append("    codigoAcao: ").append(toIndentedString(codigoAcao)).append("\n");
        sb.append("    codigoFuncao: ").append(toIndentedString(codigoFuncao)).append("\n");
        sb.append("    codigoPrograma: ").append(toIndentedString(codigoPrograma)).append("\n");
        sb.append("    codigoSubFuncao: ").append(toIndentedString(codigoSubFuncao)).append("\n");
        sb.append("    descPOIdAcompanhamento: ").append(toIndentedString(descPOIdAcompanhamento)).append("\n");
        sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    numAno: ").append(toIndentedString(numAno)).append("\n");
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
