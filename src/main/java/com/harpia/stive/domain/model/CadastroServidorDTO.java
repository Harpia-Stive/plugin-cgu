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
 * CadastroServidorDTO
 */
public class CadastroServidorDTO {

    private List<FichaCargoEfetivoDTO> fichasCargoEfetivo = null;

    private List<FichaServidorCivilDTO> fichasDemaisSituacoes = null;

    private List<FichaFuncaoDTO> fichasFuncao = null;

    private List<FichaMilitarDTO> fichasMilitar = null;

    private ServidorAposentadoPensionistaDTO servidor = null;

    public CadastroServidorDTO fichasCargoEfetivo(List<FichaCargoEfetivoDTO> fichasCargoEfetivo) {
        this.fichasCargoEfetivo = fichasCargoEfetivo;
        return this;
    }

    public CadastroServidorDTO addFichasCargoEfetivoItem(FichaCargoEfetivoDTO fichasCargoEfetivoItem) {
        if (this.fichasCargoEfetivo == null) {
            this.fichasCargoEfetivo = new ArrayList<FichaCargoEfetivoDTO>();
        }
        this.fichasCargoEfetivo.add(fichasCargoEfetivoItem);
        return this;
    }

    /**
     * Get fichasCargoEfetivo
     *
     * @return fichasCargoEfetivo
     *
     */
    @ApiModelProperty(value = "")
    public List<FichaCargoEfetivoDTO> getFichasCargoEfetivo() {
        return fichasCargoEfetivo;
    }

    public void setFichasCargoEfetivo(List<FichaCargoEfetivoDTO> fichasCargoEfetivo) {
        this.fichasCargoEfetivo = fichasCargoEfetivo;
    }

    public CadastroServidorDTO fichasDemaisSituacoes(List<FichaServidorCivilDTO> fichasDemaisSituacoes) {
        this.fichasDemaisSituacoes = fichasDemaisSituacoes;
        return this;
    }

    public CadastroServidorDTO addFichasDemaisSituacoesItem(FichaServidorCivilDTO fichasDemaisSituacoesItem) {
        if (this.fichasDemaisSituacoes == null) {
            this.fichasDemaisSituacoes = new ArrayList<FichaServidorCivilDTO>();
        }
        this.fichasDemaisSituacoes.add(fichasDemaisSituacoesItem);
        return this;
    }

    /**
     * Get fichasDemaisSituacoes
     *
     * @return fichasDemaisSituacoes
     *
     */
    @ApiModelProperty(value = "")
    public List<FichaServidorCivilDTO> getFichasDemaisSituacoes() {
        return fichasDemaisSituacoes;
    }

    public void setFichasDemaisSituacoes(List<FichaServidorCivilDTO> fichasDemaisSituacoes) {
        this.fichasDemaisSituacoes = fichasDemaisSituacoes;
    }

    public CadastroServidorDTO fichasFuncao(List<FichaFuncaoDTO> fichasFuncao) {
        this.fichasFuncao = fichasFuncao;
        return this;
    }

    public CadastroServidorDTO addFichasFuncaoItem(FichaFuncaoDTO fichasFuncaoItem) {
        if (this.fichasFuncao == null) {
            this.fichasFuncao = new ArrayList<FichaFuncaoDTO>();
        }
        this.fichasFuncao.add(fichasFuncaoItem);
        return this;
    }

    /**
     * Get fichasFuncao
     *
     * @return fichasFuncao
     *
     */
    @ApiModelProperty(value = "")
    public List<FichaFuncaoDTO> getFichasFuncao() {
        return fichasFuncao;
    }

    public void setFichasFuncao(List<FichaFuncaoDTO> fichasFuncao) {
        this.fichasFuncao = fichasFuncao;
    }

    public CadastroServidorDTO fichasMilitar(List<FichaMilitarDTO> fichasMilitar) {
        this.fichasMilitar = fichasMilitar;
        return this;
    }

    public CadastroServidorDTO addFichasMilitarItem(FichaMilitarDTO fichasMilitarItem) {
        if (this.fichasMilitar == null) {
            this.fichasMilitar = new ArrayList<FichaMilitarDTO>();
        }
        this.fichasMilitar.add(fichasMilitarItem);
        return this;
    }

    /**
     * Get fichasMilitar
     *
     * @return fichasMilitar
     *
     */
    @ApiModelProperty(value = "")
    public List<FichaMilitarDTO> getFichasMilitar() {
        return fichasMilitar;
    }

    public void setFichasMilitar(List<FichaMilitarDTO> fichasMilitar) {
        this.fichasMilitar = fichasMilitar;
    }

    public CadastroServidorDTO servidor(ServidorAposentadoPensionistaDTO servidor) {
        this.servidor = servidor;
        return this;
    }

    /**
     * Get servidor
     *
     * @return servidor
     *
     */
    @ApiModelProperty(value = "")
    public ServidorAposentadoPensionistaDTO getServidor() {
        return servidor;
    }

    public void setServidor(ServidorAposentadoPensionistaDTO servidor) {
        this.servidor = servidor;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CadastroServidorDTO cadastroServidorDTO = (CadastroServidorDTO) o;
        return Objects.equals(this.fichasCargoEfetivo, cadastroServidorDTO.fichasCargoEfetivo)
                && Objects.equals(this.fichasDemaisSituacoes, cadastroServidorDTO.fichasDemaisSituacoes)
                && Objects.equals(this.fichasFuncao, cadastroServidorDTO.fichasFuncao)
                && Objects.equals(this.fichasMilitar, cadastroServidorDTO.fichasMilitar)
                && Objects.equals(this.servidor, cadastroServidorDTO.servidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fichasCargoEfetivo, fichasDemaisSituacoes, fichasFuncao, fichasMilitar, servidor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CadastroServidorDTO {\n");

        sb.append("    fichasCargoEfetivo: ").append(toIndentedString(fichasCargoEfetivo)).append("\n");
        sb.append("    fichasDemaisSituacoes: ").append(toIndentedString(fichasDemaisSituacoes)).append("\n");
        sb.append("    fichasFuncao: ").append(toIndentedString(fichasFuncao)).append("\n");
        sb.append("    fichasMilitar: ").append(toIndentedString(fichasMilitar)).append("\n");
        sb.append("    servidor: ").append(toIndentedString(servidor)).append("\n");
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
