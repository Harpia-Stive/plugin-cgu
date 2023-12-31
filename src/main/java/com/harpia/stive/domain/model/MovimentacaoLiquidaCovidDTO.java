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
 * MovimentacaoLiquidaCovidDTO
 */
public class MovimentacaoLiquidaCovidDTO {

    private String acao = null;

    private String codigoAcao = null;

    private String codigoElementoDespesa = null;

    private String codigoFuncao = null;

    private String codigoGrupoDespesa = null;

    private String codigoModalidadeDespesa = null;

    private String codigoPlanoOrcamentario = null;

    private String codigoPrograma = null;

    private String codigoSubfuncao = null;

    private String elementoDespesa = null;

    private String empenhado = null;

    private String funcao = null;

    private String grupoDespesa = null;

    private Integer idPlanoOrcamentario = null;

    private String liquidado = null;

    private Integer mesAno = null;

    private String modalidadeDespesa = null;

    private String pago = null;

    private String planoOrcamentario = null;

    private String programa = null;

    private String subfuncao = null;

    public MovimentacaoLiquidaCovidDTO acao(String acao) {
        this.acao = acao;
        return this;
    }

    /**
     * Get acao
     *
     * @return acao
     *
     */
    @ApiModelProperty(value = "")
    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public MovimentacaoLiquidaCovidDTO codigoAcao(String codigoAcao) {
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

    public MovimentacaoLiquidaCovidDTO codigoElementoDespesa(String codigoElementoDespesa) {
        this.codigoElementoDespesa = codigoElementoDespesa;
        return this;
    }

    /**
     * Get codigoElementoDespesa
     *
     * @return codigoElementoDespesa
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoElementoDespesa() {
        return codigoElementoDespesa;
    }

    public void setCodigoElementoDespesa(String codigoElementoDespesa) {
        this.codigoElementoDespesa = codigoElementoDespesa;
    }

    public MovimentacaoLiquidaCovidDTO codigoFuncao(String codigoFuncao) {
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

    public MovimentacaoLiquidaCovidDTO codigoGrupoDespesa(String codigoGrupoDespesa) {
        this.codigoGrupoDespesa = codigoGrupoDespesa;
        return this;
    }

    /**
     * Get codigoGrupoDespesa
     *
     * @return codigoGrupoDespesa
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoGrupoDespesa() {
        return codigoGrupoDespesa;
    }

    public void setCodigoGrupoDespesa(String codigoGrupoDespesa) {
        this.codigoGrupoDespesa = codigoGrupoDespesa;
    }

    public MovimentacaoLiquidaCovidDTO codigoModalidadeDespesa(String codigoModalidadeDespesa) {
        this.codigoModalidadeDespesa = codigoModalidadeDespesa;
        return this;
    }

    /**
     * Get codigoModalidadeDespesa
     *
     * @return codigoModalidadeDespesa
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoModalidadeDespesa() {
        return codigoModalidadeDespesa;
    }

    public void setCodigoModalidadeDespesa(String codigoModalidadeDespesa) {
        this.codigoModalidadeDespesa = codigoModalidadeDespesa;
    }

    public MovimentacaoLiquidaCovidDTO codigoPlanoOrcamentario(String codigoPlanoOrcamentario) {
        this.codigoPlanoOrcamentario = codigoPlanoOrcamentario;
        return this;
    }

    /**
     * Get codigoPlanoOrcamentario
     *
     * @return codigoPlanoOrcamentario
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoPlanoOrcamentario() {
        return codigoPlanoOrcamentario;
    }

    public void setCodigoPlanoOrcamentario(String codigoPlanoOrcamentario) {
        this.codigoPlanoOrcamentario = codigoPlanoOrcamentario;
    }

    public MovimentacaoLiquidaCovidDTO codigoPrograma(String codigoPrograma) {
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

    public MovimentacaoLiquidaCovidDTO codigoSubfuncao(String codigoSubfuncao) {
        this.codigoSubfuncao = codigoSubfuncao;
        return this;
    }

    /**
     * Get codigoSubfuncao
     *
     * @return codigoSubfuncao
     *
     */
    @ApiModelProperty(value = "")
    public String getCodigoSubfuncao() {
        return codigoSubfuncao;
    }

    public void setCodigoSubfuncao(String codigoSubfuncao) {
        this.codigoSubfuncao = codigoSubfuncao;
    }

    public MovimentacaoLiquidaCovidDTO elementoDespesa(String elementoDespesa) {
        this.elementoDespesa = elementoDespesa;
        return this;
    }

    /**
     * Get elementoDespesa
     *
     * @return elementoDespesa
     *
     */
    @ApiModelProperty(value = "")
    public String getElementoDespesa() {
        return elementoDespesa;
    }

    public void setElementoDespesa(String elementoDespesa) {
        this.elementoDespesa = elementoDespesa;
    }

    public MovimentacaoLiquidaCovidDTO empenhado(String empenhado) {
        this.empenhado = empenhado;
        return this;
    }

    /**
     * Get empenhado
     *
     * @return empenhado
     *
     */
    @ApiModelProperty(value = "")
    public String getEmpenhado() {
        return empenhado;
    }

    public void setEmpenhado(String empenhado) {
        this.empenhado = empenhado;
    }

    public MovimentacaoLiquidaCovidDTO funcao(String funcao) {
        this.funcao = funcao;
        return this;
    }

    /**
     * Get funcao
     *
     * @return funcao
     *
     */
    @ApiModelProperty(value = "")
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public MovimentacaoLiquidaCovidDTO grupoDespesa(String grupoDespesa) {
        this.grupoDespesa = grupoDespesa;
        return this;
    }

    /**
     * Get grupoDespesa
     *
     * @return grupoDespesa
     *
     */
    @ApiModelProperty(value = "")
    public String getGrupoDespesa() {
        return grupoDespesa;
    }

    public void setGrupoDespesa(String grupoDespesa) {
        this.grupoDespesa = grupoDespesa;
    }

    public MovimentacaoLiquidaCovidDTO idPlanoOrcamentario(Integer idPlanoOrcamentario) {
        this.idPlanoOrcamentario = idPlanoOrcamentario;
        return this;
    }

    /**
     * Get idPlanoOrcamentario
     *
     * @return idPlanoOrcamentario
     *
     */
    @ApiModelProperty(value = "")
    public Integer getIdPlanoOrcamentario() {
        return idPlanoOrcamentario;
    }

    public void setIdPlanoOrcamentario(Integer idPlanoOrcamentario) {
        this.idPlanoOrcamentario = idPlanoOrcamentario;
    }

    public MovimentacaoLiquidaCovidDTO liquidado(String liquidado) {
        this.liquidado = liquidado;
        return this;
    }

    /**
     * Get liquidado
     *
     * @return liquidado
     *
     */
    @ApiModelProperty(value = "")
    public String getLiquidado() {
        return liquidado;
    }

    public void setLiquidado(String liquidado) {
        this.liquidado = liquidado;
    }

    public MovimentacaoLiquidaCovidDTO mesAno(Integer mesAno) {
        this.mesAno = mesAno;
        return this;
    }

    /**
     * Get mesAno
     *
     * @return mesAno
     *
     */
    @ApiModelProperty(value = "")
    public Integer getMesAno() {
        return mesAno;
    }

    public void setMesAno(Integer mesAno) {
        this.mesAno = mesAno;
    }

    public MovimentacaoLiquidaCovidDTO modalidadeDespesa(String modalidadeDespesa) {
        this.modalidadeDespesa = modalidadeDespesa;
        return this;
    }

    /**
     * Get modalidadeDespesa
     *
     * @return modalidadeDespesa
     *
     */
    @ApiModelProperty(value = "")
    public String getModalidadeDespesa() {
        return modalidadeDespesa;
    }

    public void setModalidadeDespesa(String modalidadeDespesa) {
        this.modalidadeDespesa = modalidadeDespesa;
    }

    public MovimentacaoLiquidaCovidDTO pago(String pago) {
        this.pago = pago;
        return this;
    }

    /**
     * Get pago
     *
     * @return pago
     *
     */
    @ApiModelProperty(value = "")
    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public MovimentacaoLiquidaCovidDTO planoOrcamentario(String planoOrcamentario) {
        this.planoOrcamentario = planoOrcamentario;
        return this;
    }

    /**
     * Get planoOrcamentario
     *
     * @return planoOrcamentario
     *
     */
    @ApiModelProperty(value = "")
    public String getPlanoOrcamentario() {
        return planoOrcamentario;
    }

    public void setPlanoOrcamentario(String planoOrcamentario) {
        this.planoOrcamentario = planoOrcamentario;
    }

    public MovimentacaoLiquidaCovidDTO programa(String programa) {
        this.programa = programa;
        return this;
    }

    /**
     * Get programa
     *
     * @return programa
     *
     */
    @ApiModelProperty(value = "")
    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public MovimentacaoLiquidaCovidDTO subfuncao(String subfuncao) {
        this.subfuncao = subfuncao;
        return this;
    }

    /**
     * Get subfuncao
     *
     * @return subfuncao
     *
     */
    @ApiModelProperty(value = "")
    public String getSubfuncao() {
        return subfuncao;
    }

    public void setSubfuncao(String subfuncao) {
        this.subfuncao = subfuncao;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovimentacaoLiquidaCovidDTO movimentacaoLiquidaCovidDTO = (MovimentacaoLiquidaCovidDTO) o;
        return Objects.equals(this.acao, movimentacaoLiquidaCovidDTO.acao)
                && Objects.equals(this.codigoAcao, movimentacaoLiquidaCovidDTO.codigoAcao)
                && Objects.equals(this.codigoElementoDespesa, movimentacaoLiquidaCovidDTO.codigoElementoDespesa)
                && Objects.equals(this.codigoFuncao, movimentacaoLiquidaCovidDTO.codigoFuncao)
                && Objects.equals(this.codigoGrupoDespesa, movimentacaoLiquidaCovidDTO.codigoGrupoDespesa)
                && Objects.equals(this.codigoModalidadeDespesa, movimentacaoLiquidaCovidDTO.codigoModalidadeDespesa)
                && Objects.equals(this.codigoPlanoOrcamentario, movimentacaoLiquidaCovidDTO.codigoPlanoOrcamentario)
                && Objects.equals(this.codigoPrograma, movimentacaoLiquidaCovidDTO.codigoPrograma)
                && Objects.equals(this.codigoSubfuncao, movimentacaoLiquidaCovidDTO.codigoSubfuncao)
                && Objects.equals(this.elementoDespesa, movimentacaoLiquidaCovidDTO.elementoDespesa)
                && Objects.equals(this.empenhado, movimentacaoLiquidaCovidDTO.empenhado)
                && Objects.equals(this.funcao, movimentacaoLiquidaCovidDTO.funcao)
                && Objects.equals(this.grupoDespesa, movimentacaoLiquidaCovidDTO.grupoDespesa)
                && Objects.equals(this.idPlanoOrcamentario, movimentacaoLiquidaCovidDTO.idPlanoOrcamentario)
                && Objects.equals(this.liquidado, movimentacaoLiquidaCovidDTO.liquidado)
                && Objects.equals(this.mesAno, movimentacaoLiquidaCovidDTO.mesAno)
                && Objects.equals(this.modalidadeDespesa, movimentacaoLiquidaCovidDTO.modalidadeDespesa)
                && Objects.equals(this.pago, movimentacaoLiquidaCovidDTO.pago)
                && Objects.equals(this.planoOrcamentario, movimentacaoLiquidaCovidDTO.planoOrcamentario)
                && Objects.equals(this.programa, movimentacaoLiquidaCovidDTO.programa)
                && Objects.equals(this.subfuncao, movimentacaoLiquidaCovidDTO.subfuncao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acao, codigoAcao, codigoElementoDespesa, codigoFuncao, codigoGrupoDespesa, codigoModalidadeDespesa, codigoPlanoOrcamentario, codigoPrograma, codigoSubfuncao, elementoDespesa, empenhado, funcao, grupoDespesa, idPlanoOrcamentario, liquidado, mesAno, modalidadeDespesa, pago, planoOrcamentario, programa, subfuncao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MovimentacaoLiquidaCovidDTO {\n");

        sb.append("    acao: ").append(toIndentedString(acao)).append("\n");
        sb.append("    codigoAcao: ").append(toIndentedString(codigoAcao)).append("\n");
        sb.append("    codigoElementoDespesa: ").append(toIndentedString(codigoElementoDespesa)).append("\n");
        sb.append("    codigoFuncao: ").append(toIndentedString(codigoFuncao)).append("\n");
        sb.append("    codigoGrupoDespesa: ").append(toIndentedString(codigoGrupoDespesa)).append("\n");
        sb.append("    codigoModalidadeDespesa: ").append(toIndentedString(codigoModalidadeDespesa)).append("\n");
        sb.append("    codigoPlanoOrcamentario: ").append(toIndentedString(codigoPlanoOrcamentario)).append("\n");
        sb.append("    codigoPrograma: ").append(toIndentedString(codigoPrograma)).append("\n");
        sb.append("    codigoSubfuncao: ").append(toIndentedString(codigoSubfuncao)).append("\n");
        sb.append("    elementoDespesa: ").append(toIndentedString(elementoDespesa)).append("\n");
        sb.append("    empenhado: ").append(toIndentedString(empenhado)).append("\n");
        sb.append("    funcao: ").append(toIndentedString(funcao)).append("\n");
        sb.append("    grupoDespesa: ").append(toIndentedString(grupoDespesa)).append("\n");
        sb.append("    idPlanoOrcamentario: ").append(toIndentedString(idPlanoOrcamentario)).append("\n");
        sb.append("    liquidado: ").append(toIndentedString(liquidado)).append("\n");
        sb.append("    mesAno: ").append(toIndentedString(mesAno)).append("\n");
        sb.append("    modalidadeDespesa: ").append(toIndentedString(modalidadeDespesa)).append("\n");
        sb.append("    pago: ").append(toIndentedString(pago)).append("\n");
        sb.append("    planoOrcamentario: ").append(toIndentedString(planoOrcamentario)).append("\n");
        sb.append("    programa: ").append(toIndentedString(programa)).append("\n");
        sb.append("    subfuncao: ").append(toIndentedString(subfuncao)).append("\n");
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
