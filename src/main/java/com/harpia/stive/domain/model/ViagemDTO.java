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
import java.time.LocalDate;
import java.util.Objects;

/**
 * ViagemDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-01-27T12:54:57.746Z")
public class ViagemDTO {

    private BeneficiarioDTO beneficiario = null;
    private CargoBeneficiarioDTO cargo = null;
    private LocalDate dataFimAfastamento = null;
    private LocalDate dataInicioAfastamento = null;
    private FuncaoBeneficiarioDTO funcao = null;
    private Integer id = null;
    private OrgaoDTO orgao = null;
    private OrgaoDTO orgaoPagamento = null;
    private String situacao = null;
    private String tipoViagem = null;
    private UnidadeGestoraDTO unidadeGestoraResponsavel = null;
    private BigDecimal valorMulta = null;
    private BigDecimal valorTotalDevolucao = null;
    private BigDecimal valorTotalDiarias = null;
    private BigDecimal valorTotalPassagem = null;
    private BigDecimal valorTotalRestituicao = null;
    private BigDecimal valorTotalTaxaAgenciamento = null;
    private BigDecimal valorTotalViagem = null;
    private DimViagemDTO viagem = null;

    public ViagemDTO beneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
        return this;
    }

    /**
     * Get beneficiario
     *
     * @return beneficiario
     *
     */
    @ApiModelProperty(value = "")
    public BeneficiarioDTO getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public ViagemDTO cargo(CargoBeneficiarioDTO cargo) {
        this.cargo = cargo;
        return this;
    }

    /**
     * Get cargo
     *
     * @return cargo
     *
     */
    @ApiModelProperty(value = "")
    public CargoBeneficiarioDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoBeneficiarioDTO cargo) {
        this.cargo = cargo;
    }

    public ViagemDTO dataFimAfastamento(LocalDate dataFimAfastamento) {
        this.dataFimAfastamento = dataFimAfastamento;
        return this;
    }

    /**
     * Get dataFimAfastamento
     *
     * @return dataFimAfastamento
     *
     */
    @ApiModelProperty(value = "")
    public LocalDate getDataFimAfastamento() {
        return dataFimAfastamento;
    }

    public void setDataFimAfastamento(LocalDate dataFimAfastamento) {
        this.dataFimAfastamento = dataFimAfastamento;
    }

    public ViagemDTO dataInicioAfastamento(LocalDate dataInicioAfastamento) {
        this.dataInicioAfastamento = dataInicioAfastamento;
        return this;
    }

    /**
     * Get dataInicioAfastamento
     *
     * @return dataInicioAfastamento
     *
     */
    @ApiModelProperty(value = "")
    public LocalDate getDataInicioAfastamento() {
        return dataInicioAfastamento;
    }

    public void setDataInicioAfastamento(LocalDate dataInicioAfastamento) {
        this.dataInicioAfastamento = dataInicioAfastamento;
    }

    public ViagemDTO funcao(FuncaoBeneficiarioDTO funcao) {
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
    public FuncaoBeneficiarioDTO getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoBeneficiarioDTO funcao) {
        this.funcao = funcao;
    }

    public ViagemDTO id(Integer id) {
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

    public ViagemDTO orgao(OrgaoDTO orgao) {
        this.orgao = orgao;
        return this;
    }

    /**
     * Get orgao
     *
     * @return orgao
     *
     */
    @ApiModelProperty(value = "")
    public OrgaoDTO getOrgao() {
        return orgao;
    }

    public void setOrgao(OrgaoDTO orgao) {
        this.orgao = orgao;
    }

    public ViagemDTO orgaoPagamento(OrgaoDTO orgaoPagamento) {
        this.orgaoPagamento = orgaoPagamento;
        return this;
    }

    /**
     * Get orgaoPagamento
     *
     * @return orgaoPagamento
     *
     */
    @ApiModelProperty(value = "")
    public OrgaoDTO getOrgaoPagamento() {
        return orgaoPagamento;
    }

    public void setOrgaoPagamento(OrgaoDTO orgaoPagamento) {
        this.orgaoPagamento = orgaoPagamento;
    }

    public ViagemDTO situacao(String situacao) {
        this.situacao = situacao;
        return this;
    }

    /**
     * Get situacao
     *
     * @return situacao
     *
     */
    @ApiModelProperty(value = "")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public ViagemDTO tipoViagem(String tipoViagem) {
        this.tipoViagem = tipoViagem;
        return this;
    }

    /**
     * Get tipoViagem
     *
     * @return tipoViagem
     *
     */
    @ApiModelProperty(value = "")
    public String getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(String tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public ViagemDTO unidadeGestoraResponsavel(UnidadeGestoraDTO unidadeGestoraResponsavel) {
        this.unidadeGestoraResponsavel = unidadeGestoraResponsavel;
        return this;
    }

    /**
     * Get unidadeGestoraResponsavel
     *
     * @return unidadeGestoraResponsavel
     *
     */
    @ApiModelProperty(value = "")
    public UnidadeGestoraDTO getUnidadeGestoraResponsavel() {
        return unidadeGestoraResponsavel;
    }

    public void setUnidadeGestoraResponsavel(UnidadeGestoraDTO unidadeGestoraResponsavel) {
        this.unidadeGestoraResponsavel = unidadeGestoraResponsavel;
    }

    public ViagemDTO valorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
        return this;
    }

    /**
     * Get valorMulta
     *
     * @return valorMulta
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }

    public ViagemDTO valorTotalDevolucao(BigDecimal valorTotalDevolucao) {
        this.valorTotalDevolucao = valorTotalDevolucao;
        return this;
    }

    /**
     * Get valorTotalDevolucao
     *
     * @return valorTotalDevolucao
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorTotalDevolucao() {
        return valorTotalDevolucao;
    }

    public void setValorTotalDevolucao(BigDecimal valorTotalDevolucao) {
        this.valorTotalDevolucao = valorTotalDevolucao;
    }

    public ViagemDTO valorTotalDiarias(BigDecimal valorTotalDiarias) {
        this.valorTotalDiarias = valorTotalDiarias;
        return this;
    }

    /**
     * Get valorTotalDiarias
     *
     * @return valorTotalDiarias
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorTotalDiarias() {
        return valorTotalDiarias;
    }

    public void setValorTotalDiarias(BigDecimal valorTotalDiarias) {
        this.valorTotalDiarias = valorTotalDiarias;
    }

    public ViagemDTO valorTotalPassagem(BigDecimal valorTotalPassagem) {
        this.valorTotalPassagem = valorTotalPassagem;
        return this;
    }

    /**
     * Get valorTotalPassagem
     *
     * @return valorTotalPassagem
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorTotalPassagem() {
        return valorTotalPassagem;
    }

    public void setValorTotalPassagem(BigDecimal valorTotalPassagem) {
        this.valorTotalPassagem = valorTotalPassagem;
    }

    public ViagemDTO valorTotalRestituicao(BigDecimal valorTotalRestituicao) {
        this.valorTotalRestituicao = valorTotalRestituicao;
        return this;
    }

    /**
     * Get valorTotalRestituicao
     *
     * @return valorTotalRestituicao
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorTotalRestituicao() {
        return valorTotalRestituicao;
    }

    public void setValorTotalRestituicao(BigDecimal valorTotalRestituicao) {
        this.valorTotalRestituicao = valorTotalRestituicao;
    }

    public ViagemDTO valorTotalTaxaAgenciamento(BigDecimal valorTotalTaxaAgenciamento) {
        this.valorTotalTaxaAgenciamento = valorTotalTaxaAgenciamento;
        return this;
    }

    /**
     * Get valorTotalTaxaAgenciamento
     *
     * @return valorTotalTaxaAgenciamento
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorTotalTaxaAgenciamento() {
        return valorTotalTaxaAgenciamento;
    }

    public void setValorTotalTaxaAgenciamento(BigDecimal valorTotalTaxaAgenciamento) {
        this.valorTotalTaxaAgenciamento = valorTotalTaxaAgenciamento;
    }

    public ViagemDTO valorTotalViagem(BigDecimal valorTotalViagem) {
        this.valorTotalViagem = valorTotalViagem;
        return this;
    }

    /**
     * Get valorTotalViagem
     *
     * @return valorTotalViagem
     *
     */
    @ApiModelProperty(value = "")
    public BigDecimal getValorTotalViagem() {
        return valorTotalViagem;
    }

    public void setValorTotalViagem(BigDecimal valorTotalViagem) {
        this.valorTotalViagem = valorTotalViagem;
    }

    public ViagemDTO viagem(DimViagemDTO viagem) {
        this.viagem = viagem;
        return this;
    }

    /**
     * Get viagem
     *
     * @return viagem
     *
     */
    @ApiModelProperty(value = "")
    public DimViagemDTO getViagem() {
        return viagem;
    }

    public void setViagem(DimViagemDTO viagem) {
        this.viagem = viagem;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ViagemDTO viagemDTO = (ViagemDTO) o;
        return Objects.equals(this.beneficiario, viagemDTO.beneficiario)
                && Objects.equals(this.cargo, viagemDTO.cargo)
                && Objects.equals(this.dataFimAfastamento, viagemDTO.dataFimAfastamento)
                && Objects.equals(this.dataInicioAfastamento, viagemDTO.dataInicioAfastamento)
                && Objects.equals(this.funcao, viagemDTO.funcao)
                && Objects.equals(this.id, viagemDTO.id)
                && Objects.equals(this.orgao, viagemDTO.orgao)
                && Objects.equals(this.orgaoPagamento, viagemDTO.orgaoPagamento)
                && Objects.equals(this.situacao, viagemDTO.situacao)
                && Objects.equals(this.tipoViagem, viagemDTO.tipoViagem)
                && Objects.equals(this.unidadeGestoraResponsavel, viagemDTO.unidadeGestoraResponsavel)
                && Objects.equals(this.valorMulta, viagemDTO.valorMulta)
                && Objects.equals(this.valorTotalDevolucao, viagemDTO.valorTotalDevolucao)
                && Objects.equals(this.valorTotalDiarias, viagemDTO.valorTotalDiarias)
                && Objects.equals(this.valorTotalPassagem, viagemDTO.valorTotalPassagem)
                && Objects.equals(this.valorTotalRestituicao, viagemDTO.valorTotalRestituicao)
                && Objects.equals(this.valorTotalTaxaAgenciamento, viagemDTO.valorTotalTaxaAgenciamento)
                && Objects.equals(this.valorTotalViagem, viagemDTO.valorTotalViagem)
                && Objects.equals(this.viagem, viagemDTO.viagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficiario, cargo, dataFimAfastamento, dataInicioAfastamento, funcao, id, orgao, orgaoPagamento, situacao, tipoViagem, unidadeGestoraResponsavel, valorMulta, valorTotalDevolucao, valorTotalDiarias, valorTotalPassagem, valorTotalRestituicao, valorTotalTaxaAgenciamento, valorTotalViagem, viagem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ViagemDTO {\n");

        sb.append("    beneficiario: ").append(toIndentedString(beneficiario)).append("\n");
        sb.append("    cargo: ").append(toIndentedString(cargo)).append("\n");
        sb.append("    dataFimAfastamento: ").append(toIndentedString(dataFimAfastamento)).append("\n");
        sb.append("    dataInicioAfastamento: ").append(toIndentedString(dataInicioAfastamento)).append("\n");
        sb.append("    funcao: ").append(toIndentedString(funcao)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    orgao: ").append(toIndentedString(orgao)).append("\n");
        sb.append("    orgaoPagamento: ").append(toIndentedString(orgaoPagamento)).append("\n");
        sb.append("    situacao: ").append(toIndentedString(situacao)).append("\n");
        sb.append("    tipoViagem: ").append(toIndentedString(tipoViagem)).append("\n");
        sb.append("    unidadeGestoraResponsavel: ").append(toIndentedString(unidadeGestoraResponsavel)).append("\n");
        sb.append("    valorMulta: ").append(toIndentedString(valorMulta)).append("\n");
        sb.append("    valorTotalDevolucao: ").append(toIndentedString(valorTotalDevolucao)).append("\n");
        sb.append("    valorTotalDiarias: ").append(toIndentedString(valorTotalDiarias)).append("\n");
        sb.append("    valorTotalPassagem: ").append(toIndentedString(valorTotalPassagem)).append("\n");
        sb.append("    valorTotalRestituicao: ").append(toIndentedString(valorTotalRestituicao)).append("\n");
        sb.append("    valorTotalTaxaAgenciamento: ").append(toIndentedString(valorTotalTaxaAgenciamento)).append("\n");
        sb.append("    valorTotalViagem: ").append(toIndentedString(valorTotalViagem)).append("\n");
        sb.append("    viagem: ").append(toIndentedString(viagem)).append("\n");
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
