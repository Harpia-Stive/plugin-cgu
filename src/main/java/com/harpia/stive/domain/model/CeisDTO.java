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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CeisDTO
 */
public class CeisDTO {

    private String abrangenciaDefinidaDecisaoJudicial = null;

    private String dataFimSancao = null;

    private String dataInicioSancao = null;

    private String dataOrigemInformacao = null;

    private String dataPublicacaoSancao = null;

    private String dataReferencia = null;

    private String dataTransitadoJulgado = null;

    private String detalhamentoPublicacao = null;

    private FonteSancaoDTO fonteSancao = null;

    private Integer id = null;

    private String informacoesAdicionaisDoOrgaoSancionador = null;

    private LegislacaoDTO legislacao = null;

    private String linkPublicacao = null;

    private String numeroProcesso = null;

    private OrgaoSancionadorDTO orgaoSancionador = null;

    private PessoaDTO pessoa = null;

    private SancionadoDTO sancionado = null;

    private String textoPublicacao = null;

    private TipoSancaoDTO tipoSancao = null;

    private List<CodigoDescricaoDTO> fundamentacao = null;

    public CeisDTO abrangenciaDefinidaDecisaoJudicial(String abrangenciaDefinidaDecisaoJudicial) {
        this.abrangenciaDefinidaDecisaoJudicial = abrangenciaDefinidaDecisaoJudicial;
        return this;
    }

    /**
     * Get abrangenciaDefinidaDecisaoJudicial
     *
     * @return abrangenciaDefinidaDecisaoJudicial
     *
     */
    @ApiModelProperty(value = "")
    public String getAbrangenciaDefinidaDecisaoJudicial() {
        return abrangenciaDefinidaDecisaoJudicial;
    }

    public void setAbrangenciaDefinidaDecisaoJudicial(String abrangenciaDefinidaDecisaoJudicial) {
        this.abrangenciaDefinidaDecisaoJudicial = abrangenciaDefinidaDecisaoJudicial;
    }

    public CeisDTO dataFimSancao(String dataFimSancao) {
        this.dataFimSancao = dataFimSancao;
        return this;
    }

    /**
     * Get dataFimSancao
     *
     * @return dataFimSancao
     *
     */
    @ApiModelProperty(value = "")
    public String getDataFimSancao() {
        return dataFimSancao;
    }

    public void setDataFimSancao(String dataFimSancao) {
        this.dataFimSancao = dataFimSancao;
    }

    public CeisDTO dataInicioSancao(String dataInicioSancao) {
        this.dataInicioSancao = dataInicioSancao;
        return this;
    }

    /**
     * Get dataInicioSancao
     *
     * @return dataInicioSancao
     *
     */
    @ApiModelProperty(value = "")
    public String getDataInicioSancao() {
        return dataInicioSancao;
    }

    public void setDataInicioSancao(String dataInicioSancao) {
        this.dataInicioSancao = dataInicioSancao;
    }

    public CeisDTO dataOrigemInformacao(String dataOrigemInformacao) {
        this.dataOrigemInformacao = dataOrigemInformacao;
        return this;
    }

    /**
     * Get dataOrigemInformacao
     *
     * @return dataOrigemInformacao
     *
     */
    @ApiModelProperty(value = "")
    public String getDataOrigemInformacao() {
        return dataOrigemInformacao;
    }

    public void setDataOrigemInformacao(String dataOrigemInformacao) {
        this.dataOrigemInformacao = dataOrigemInformacao;
    }

    public CeisDTO dataPublicacaoSancao(String dataPublicacaoSancao) {
        this.dataPublicacaoSancao = dataPublicacaoSancao;
        return this;
    }

    /**
     * Get dataPublicacaoSancao
     *
     * @return dataPublicacaoSancao
     *
     */
    @ApiModelProperty(value = "")
    public String getDataPublicacaoSancao() {
        return dataPublicacaoSancao;
    }

    public void setDataPublicacaoSancao(String dataPublicacaoSancao) {
        this.dataPublicacaoSancao = dataPublicacaoSancao;
    }

    public CeisDTO dataReferencia(String dataReferencia) {
        this.dataReferencia = dataReferencia;
        return this;
    }

    /**
     * Get dataReferencia
     *
     * @return dataReferencia
     *
     */
    @ApiModelProperty(value = "")
    public String getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(String dataReferencia) {
        this.dataReferencia = dataReferencia;
    }

    public CeisDTO dataTransitadoJulgado(String dataTransitadoJulgado) {
        this.dataTransitadoJulgado = dataTransitadoJulgado;
        return this;
    }

    /**
     * Get dataTransitadoJulgado
     *
     * @return dataTransitadoJulgado
     *
     */
    @ApiModelProperty(value = "")
    public String getDataTransitadoJulgado() {
        return dataTransitadoJulgado;
    }

    public void setDataTransitadoJulgado(String dataTransitadoJulgado) {
        this.dataTransitadoJulgado = dataTransitadoJulgado;
    }

    public CeisDTO detalhamentoPublicacao(String detalhamentoPublicacao) {
        this.detalhamentoPublicacao = detalhamentoPublicacao;
        return this;
    }

    /**
     * Get detalhamentoPublicacao
     *
     * @return detalhamentoPublicacao
     *
     */
    @ApiModelProperty(value = "")
    public String getDetalhamentoPublicacao() {
        return detalhamentoPublicacao;
    }

    public void setDetalhamentoPublicacao(String detalhamentoPublicacao) {
        this.detalhamentoPublicacao = detalhamentoPublicacao;
    }

    public CeisDTO fonteSancao(FonteSancaoDTO fonteSancao) {
        this.fonteSancao = fonteSancao;
        return this;
    }

    /**
     * Get fonteSancao
     *
     * @return fonteSancao
     *
     */
    @ApiModelProperty(value = "")
    public FonteSancaoDTO getFonteSancao() {
        return fonteSancao;
    }

    public void setFonteSancao(FonteSancaoDTO fonteSancao) {
        this.fonteSancao = fonteSancao;
    }

    public CeisDTO id(Integer id) {
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

    public CeisDTO informacoesAdicionaisDoOrgaoSancionador(String informacoesAdicionaisDoOrgaoSancionador) {
        this.informacoesAdicionaisDoOrgaoSancionador = informacoesAdicionaisDoOrgaoSancionador;
        return this;
    }

    /**
     * Get informacoesAdicionaisDoOrgaoSancionador
     *
     * @return informacoesAdicionaisDoOrgaoSancionador
     *
     */
    @ApiModelProperty(value = "")
    public String getInformacoesAdicionaisDoOrgaoSancionador() {
        return informacoesAdicionaisDoOrgaoSancionador;
    }

    public void setInformacoesAdicionaisDoOrgaoSancionador(String informacoesAdicionaisDoOrgaoSancionador) {
        this.informacoesAdicionaisDoOrgaoSancionador = informacoesAdicionaisDoOrgaoSancionador;
    }

    public CeisDTO legislacao(LegislacaoDTO legislacao) {
        this.legislacao = legislacao;
        return this;
    }

    /**
     * Get legislacao
     *
     * @return legislacao
     *
     */
    @ApiModelProperty(value = "")
    public LegislacaoDTO getLegislacao() {
        return legislacao;
    }

    public void setLegislacao(LegislacaoDTO legislacao) {
        this.legislacao = legislacao;
    }

    public CeisDTO linkPublicacao(String linkPublicacao) {
        this.linkPublicacao = linkPublicacao;
        return this;
    }

    /**
     * Get linkPublicacao
     *
     * @return linkPublicacao
     *
     */
    @ApiModelProperty(value = "")
    public String getLinkPublicacao() {
        return linkPublicacao;
    }

    public void setLinkPublicacao(String linkPublicacao) {
        this.linkPublicacao = linkPublicacao;
    }

    public CeisDTO numeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
        return this;
    }

    /**
     * Get numeroProcesso
     *
     * @return numeroProcesso
     *
     */
    @ApiModelProperty(value = "")
    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public CeisDTO orgaoSancionador(OrgaoSancionadorDTO orgaoSancionador) {
        this.orgaoSancionador = orgaoSancionador;
        return this;
    }

    /**
     * Get orgaoSancionador
     *
     * @return orgaoSancionador
     *
     */
    @ApiModelProperty(value = "")
    public OrgaoSancionadorDTO getOrgaoSancionador() {
        return orgaoSancionador;
    }

    public void setOrgaoSancionador(OrgaoSancionadorDTO orgaoSancionador) {
        this.orgaoSancionador = orgaoSancionador;
    }

    public CeisDTO pessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    /**
     * Get pessoa
     *
     * @return pessoa
     *
     */
    @ApiModelProperty(value = "")
    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public CeisDTO sancionado(SancionadoDTO sancionado) {
        this.sancionado = sancionado;
        return this;
    }

    /**
     * Get sancionado
     *
     * @return sancionado
     *
     */
    @ApiModelProperty(value = "")
    public SancionadoDTO getSancionado() {
        return sancionado;
    }

    public void setSancionado(SancionadoDTO sancionado) {
        this.sancionado = sancionado;
    }

    public CeisDTO textoPublicacao(String textoPublicacao) {
        this.textoPublicacao = textoPublicacao;
        return this;
    }

    /**
     * Get textoPublicacao
     *
     * @return textoPublicacao
     *
     */
    @ApiModelProperty(value = "")
    public String getTextoPublicacao() {
        return textoPublicacao;
    }

    public void setTextoPublicacao(String textoPublicacao) {
        this.textoPublicacao = textoPublicacao;
    }

    public CeisDTO tipoSancao(TipoSancaoDTO tipoSancao) {
        this.tipoSancao = tipoSancao;
        return this;
    }

    /**
     * Get tipoSancao
     *
     * @return tipoSancao
     *
     */
    @ApiModelProperty(value = "")
    public TipoSancaoDTO getTipoSancao() {
        return tipoSancao;
    }

    public void setTipoSancao(TipoSancaoDTO tipoSancao) {
        this.tipoSancao = tipoSancao;
    }

    public CeisDTO fundamentacao(List<CodigoDescricaoDTO> fundamentacao) {
        this.fundamentacao = fundamentacao;
        return this;
    }

    public CeisDTO addFundamentacaoItem(CodigoDescricaoDTO fundamentacaoItem) {
        if (this.fundamentacao == null) {
            this.fundamentacao = new ArrayList<CodigoDescricaoDTO>();
        }
        this.fundamentacao.add(fundamentacaoItem);
        return this;
    }

    /**
     * Get fundamentacao
     *
     * @return fundamentacao
     *
     */
    @ApiModelProperty(value = "")
    public List<CodigoDescricaoDTO> getFundamentacao() {
        return fundamentacao;
    }

    public void setFundamentacao(List<CodigoDescricaoDTO> fundamentacao) {
        this.fundamentacao = fundamentacao;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CeisDTO ceisDTO = (CeisDTO) o;
        return Objects.equals(this.abrangenciaDefinidaDecisaoJudicial, ceisDTO.abrangenciaDefinidaDecisaoJudicial)
                && Objects.equals(this.dataFimSancao, ceisDTO.dataFimSancao)
                && Objects.equals(this.dataInicioSancao, ceisDTO.dataInicioSancao)
                && Objects.equals(this.dataOrigemInformacao, ceisDTO.dataOrigemInformacao)
                && Objects.equals(this.dataPublicacaoSancao, ceisDTO.dataPublicacaoSancao)
                && Objects.equals(this.dataReferencia, ceisDTO.dataReferencia)
                && Objects.equals(this.dataTransitadoJulgado, ceisDTO.dataTransitadoJulgado)
                && Objects.equals(this.detalhamentoPublicacao, ceisDTO.detalhamentoPublicacao)
                && Objects.equals(this.fonteSancao, ceisDTO.fonteSancao)
                && Objects.equals(this.id, ceisDTO.id)
                && Objects.equals(this.informacoesAdicionaisDoOrgaoSancionador, ceisDTO.informacoesAdicionaisDoOrgaoSancionador)
                && Objects.equals(this.legislacao, ceisDTO.legislacao)
                && Objects.equals(this.linkPublicacao, ceisDTO.linkPublicacao)
                && Objects.equals(this.numeroProcesso, ceisDTO.numeroProcesso)
                && Objects.equals(this.orgaoSancionador, ceisDTO.orgaoSancionador)
                && Objects.equals(this.pessoa, ceisDTO.pessoa)
                && Objects.equals(this.sancionado, ceisDTO.sancionado)
                && Objects.equals(this.textoPublicacao, ceisDTO.textoPublicacao)
                && Objects.equals(this.tipoSancao, ceisDTO.tipoSancao)
                && Objects.equals(this.fundamentacao, ceisDTO.fundamentacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abrangenciaDefinidaDecisaoJudicial, dataFimSancao, dataInicioSancao, dataOrigemInformacao, dataPublicacaoSancao, dataReferencia, dataTransitadoJulgado, detalhamentoPublicacao, fonteSancao, id, informacoesAdicionaisDoOrgaoSancionador, legislacao, linkPublicacao, numeroProcesso, orgaoSancionador, pessoa, sancionado, textoPublicacao, tipoSancao, fundamentacao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CeisDTO {\n");

        sb.append("    abrangenciaDefinidaDecisaoJudicial: ").append(toIndentedString(abrangenciaDefinidaDecisaoJudicial)).append("\n");
        sb.append("    dataFimSancao: ").append(toIndentedString(dataFimSancao)).append("\n");
        sb.append("    dataInicioSancao: ").append(toIndentedString(dataInicioSancao)).append("\n");
        sb.append("    dataOrigemInformacao: ").append(toIndentedString(dataOrigemInformacao)).append("\n");
        sb.append("    dataPublicacaoSancao: ").append(toIndentedString(dataPublicacaoSancao)).append("\n");
        sb.append("    dataReferencia: ").append(toIndentedString(dataReferencia)).append("\n");
        sb.append("    dataTransitadoJulgado: ").append(toIndentedString(dataTransitadoJulgado)).append("\n");
        sb.append("    detalhamentoPublicacao: ").append(toIndentedString(detalhamentoPublicacao)).append("\n");
        sb.append("    fonteSancao: ").append(toIndentedString(fonteSancao)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    informacoesAdicionaisDoOrgaoSancionador: ").append(toIndentedString(informacoesAdicionaisDoOrgaoSancionador)).append("\n");
        sb.append("    legislacao: ").append(toIndentedString(legislacao)).append("\n");
        sb.append("    linkPublicacao: ").append(toIndentedString(linkPublicacao)).append("\n");
        sb.append("    numeroProcesso: ").append(toIndentedString(numeroProcesso)).append("\n");
        sb.append("    orgaoSancionador: ").append(toIndentedString(orgaoSancionador)).append("\n");
        sb.append("    pessoa: ").append(toIndentedString(pessoa)).append("\n");
        sb.append("    sancionado: ").append(toIndentedString(sancionado)).append("\n");
        sb.append("    textoPublicacao: ").append(toIndentedString(textoPublicacao)).append("\n");
        sb.append("    tipoSancao: ").append(toIndentedString(tipoSancao)).append("\n");
        sb.append("    fundamentacao: ").append(toIndentedString(fundamentacao)).append("\n");
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
