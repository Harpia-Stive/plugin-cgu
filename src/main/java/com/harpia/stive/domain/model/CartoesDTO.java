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
 * CartoesDTO
 */
public class CartoesDTO {

    private String dataTransacao = null;

    private PessoaDTO estabelecimento = null;

    private Integer id = null;

    private String mesExtrato = null;

    private BeneficiarioDTO portador = null;

    private IdCodigoDescricaoDTO tipoCartao = null;

    private UnidadeGestoraDTO unidadeGestora = null;

    private String valorTransacao = null;

    public CartoesDTO dataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
        return this;
    }

    /**
     * Get dataTransacao
     *
     * @return dataTransacao
     *
     */
    @ApiModelProperty(value = "")
    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public CartoesDTO estabelecimento(PessoaDTO estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    /**
     * Get estabelecimento
     *
     * @return estabelecimento
     *
     */
    @ApiModelProperty(value = "")
    public PessoaDTO getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(PessoaDTO estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartoesDTO id(Integer id) {
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

    public CartoesDTO mesExtrato(String mesExtrato) {
        this.mesExtrato = mesExtrato;
        return this;
    }

    /**
     * Get mesExtrato
     *
     * @return mesExtrato
     *
     */
    @ApiModelProperty(value = "")
    public String getMesExtrato() {
        return mesExtrato;
    }

    public void setMesExtrato(String mesExtrato) {
        this.mesExtrato = mesExtrato;
    }

    public CartoesDTO portador(BeneficiarioDTO portador) {
        this.portador = portador;
        return this;
    }

    /**
     * Get portador
     *
     * @return portador
     *
     */
    @ApiModelProperty(value = "")
    public BeneficiarioDTO getPortador() {
        return portador;
    }

    public void setPortador(BeneficiarioDTO portador) {
        this.portador = portador;
    }

    public CartoesDTO tipoCartao(IdCodigoDescricaoDTO tipoCartao) {
        this.tipoCartao = tipoCartao;
        return this;
    }

    /**
     * Get tipoCartao
     *
     * @return tipoCartao
     *
     */
    @ApiModelProperty(value = "")
    public IdCodigoDescricaoDTO getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(IdCodigoDescricaoDTO tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public CartoesDTO unidadeGestora(UnidadeGestoraDTO unidadeGestora) {
        this.unidadeGestora = unidadeGestora;
        return this;
    }

    /**
     * Get unidadeGestora
     *
     * @return unidadeGestora
     *
     */
    @ApiModelProperty(value = "")
    public UnidadeGestoraDTO getUnidadeGestora() {
        return unidadeGestora;
    }

    public void setUnidadeGestora(UnidadeGestoraDTO unidadeGestora) {
        this.unidadeGestora = unidadeGestora;
    }

    public CartoesDTO valorTransacao(String valorTransacao) {
        this.valorTransacao = valorTransacao;
        return this;
    }

    /**
     * Get valorTransacao
     *
     * @return valorTransacao
     *
     */
    @ApiModelProperty(value = "")
    public String getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(String valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartoesDTO cartoesDTO = (CartoesDTO) o;
        return Objects.equals(this.dataTransacao, cartoesDTO.dataTransacao)
                && Objects.equals(this.estabelecimento, cartoesDTO.estabelecimento)
                && Objects.equals(this.id, cartoesDTO.id)
                && Objects.equals(this.mesExtrato, cartoesDTO.mesExtrato)
                && Objects.equals(this.portador, cartoesDTO.portador)
                && Objects.equals(this.tipoCartao, cartoesDTO.tipoCartao)
                && Objects.equals(this.unidadeGestora, cartoesDTO.unidadeGestora)
                && Objects.equals(this.valorTransacao, cartoesDTO.valorTransacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataTransacao, estabelecimento, id, mesExtrato, portador, tipoCartao, unidadeGestora, valorTransacao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CartoesDTO {\n");

        sb.append("    dataTransacao: ").append(toIndentedString(dataTransacao)).append("\n");
        sb.append("    estabelecimento: ").append(toIndentedString(estabelecimento)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    mesExtrato: ").append(toIndentedString(mesExtrato)).append("\n");
        sb.append("    portador: ").append(toIndentedString(portador)).append("\n");
        sb.append("    tipoCartao: ").append(toIndentedString(tipoCartao)).append("\n");
        sb.append("    unidadeGestora: ").append(toIndentedString(unidadeGestora)).append("\n");
        sb.append("    valorTransacao: ").append(toIndentedString(valorTransacao)).append("\n");
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
