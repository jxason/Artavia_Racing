/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Clase Objeto encargado de obtener las citas
 */
public class CitaDTO {

    private int CitaId;
    private String CredencialId;
    private String PlacaVehiculoId;
    private String VIN;
    private int ServicioId;
    private String Descripcion;
    private Date FechaAgendada;
    private String HoraAgendada;
    private String HoraFinalizacion;

    // Propiedades predeterminadas
    private int EstadoCitaId = 1; // Valor predeterminado
    private String EditadoPor = "000000001"; // Valor predeterminado
    private int Habilitado = 1; // Valor predeterminado
    private Date FechaCreacion = new Date(System.currentTimeMillis()); // Valor predeterminado

    // Constructor vacío
    public CitaDTO() {}
    
    // Constructor con parámetros
    public CitaDTO(int CitaId, String CredencialId, String PlacaVehiculoId, String VIN, int ServicioId, int EstadoCitaId, Date FechaAgendada, String Descripcion, String HoraAgendada, String HoraFinalizacion) {
        this.CitaId = CitaId;
        this.CredencialId = CredencialId;
        this.PlacaVehiculoId = PlacaVehiculoId;
        this.VIN = VIN;
        this.ServicioId = ServicioId;
        this.EstadoCitaId = EstadoCitaId;
        this.FechaAgendada = FechaAgendada;
        this.Descripcion = Descripcion;
        this.HoraAgendada = HoraAgendada;
        this.HoraFinalizacion = HoraFinalizacion;
    }

    // Getters y Setters
    public int getCitaId() {
        return CitaId;
    }

    public void setCitaId(int CitaId) {
        this.CitaId = CitaId;
    }

    public String getCredencialId() {
        return CredencialId;
    }

    public void setCredencialId(String CredencialId) {
        this.CredencialId = CredencialId;
    }

    public String getPlacaVehiculoId() {
        return PlacaVehiculoId;
    }

    public void setPlacaVehiculoId(String PlacaVehiculoId) {
        this.PlacaVehiculoId = PlacaVehiculoId;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getServicioId() {
        return ServicioId;
    }

    public void setServicioId(int ServicioId) {
        this.ServicioId = ServicioId;
    }

    public int getEstadoCitaId() {
        return EstadoCitaId;
    }

    public void setEstadoCitaId(int EstadoCitaId) {
        this.EstadoCitaId = EstadoCitaId;
    }

    public Date getFechaAgendada() {
        return FechaAgendada;
    }

    public void setFechaAgendada(Date FechaAgendada) {
        this.FechaAgendada = FechaAgendada;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getHoraAgendada() {
        return HoraAgendada;
    }

    public void setHoraAgendada(String HoraAgendada) {
        this.HoraAgendada = HoraAgendada;
    }

    public String getHoraFinalizacion() {
        return HoraFinalizacion;
    }

    public void setHoraFinalizacion(String HoraFinalizacion) {
        this.HoraFinalizacion = HoraFinalizacion;
    }

    // Getters y Setters para propiedades predeterminadas
    public String getEditadoPor() {
        return EditadoPor;
    }

    public void setEditadoPor(String EditadoPor) {
        this.EditadoPor = EditadoPor;
    }

    public int getHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(int Habilitado) {
        this.Habilitado = Habilitado;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public void setDiagnostico(String diagnostico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
