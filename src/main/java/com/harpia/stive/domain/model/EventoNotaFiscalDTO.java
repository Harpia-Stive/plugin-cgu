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
 * EventoNotaFiscalDTO
 */
public class EventoNotaFiscalDTO {

    private String dataEvento = null;

    private String evento = null;

    private String motivo = null;

    private String tipoEvento = null;

    public EventoNotaFiscalDTO dataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
        return this;
    }

    /**
     * Get dataEvento
     *
     * @return dataEvento
     *
     */
    @ApiModelProperty(value = "")
    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public EventoNotaFiscalDTO evento(String evento) {
        this.evento = evento;
        return this;
    }

    /**
     * Get evento
     *
     * @return evento
     *
     */
    @ApiModelProperty(value = "")
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public EventoNotaFiscalDTO motivo(String motivo) {
        this.motivo = motivo;
        return this;
    }

    /**
     * Get motivo
     *
     * @return motivo
     *
     */
    @ApiModelProperty(value = "")
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EventoNotaFiscalDTO tipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
        return this;
    }

    /**
     * Get tipoEvento
     *
     * @return tipoEvento
     *
     */
    @ApiModelProperty(value = "")
    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventoNotaFiscalDTO eventoNotaFiscalDTO = (EventoNotaFiscalDTO) o;
        return Objects.equals(this.dataEvento, eventoNotaFiscalDTO.dataEvento)
                && Objects.equals(this.evento, eventoNotaFiscalDTO.evento)
                && Objects.equals(this.motivo, eventoNotaFiscalDTO.motivo)
                && Objects.equals(this.tipoEvento, eventoNotaFiscalDTO.tipoEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataEvento, evento, motivo, tipoEvento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventoNotaFiscalDTO {\n");

        sb.append("    dataEvento: ").append(toIndentedString(dataEvento)).append("\n");
        sb.append("    evento: ").append(toIndentedString(evento)).append("\n");
        sb.append("    motivo: ").append(toIndentedString(motivo)).append("\n");
        sb.append("    tipoEvento: ").append(toIndentedString(tipoEvento)).append("\n");
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
