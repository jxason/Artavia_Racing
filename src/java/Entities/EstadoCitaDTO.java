/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-003
 *
 * @Author: Horacio Porras Marín 
 * Clase Objeto encargado de obtener los estados de cita
 */
public class EstadoCitaDTO {

    private int estadoCitaId;
    private String estadoCita;
    private String descripcionCita;

    public EstadoCitaDTO(int estadoCitaId, String estadoCita, String descripcionCita) {
        this.estadoCitaId = estadoCitaId;
        this.estadoCita = estadoCita;
        this.descripcionCita = descripcionCita;
    }

    public EstadoCitaDTO() {

    }

    public int getEstadoCitaId() {
        return estadoCitaId;
    }

    public void setEstadoCitaId(int estadoCitaId) {
        this.estadoCitaId = estadoCitaId;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getDescripcionCita() {
        return descripcionCita;
    }

    public void setDescripcionCita(String descripcionCita) {
        this.descripcionCita = descripcionCita;
    }

}
