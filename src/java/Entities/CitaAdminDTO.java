/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Alfon
 */
import java.util.Date; // Importar java.util.Date

/**
 *
 * @author: Horacio Porras
 */
public class CitaAdminDTO {

    private int CitaId;
    private String CredencialId;
    private String PlacaVehiculoId;
    private String VIN;
    private String ServicioId;
    private String EstadoCitaId;
    private Date FechaAgendada; // Cambiado a java.util.Date
    private String Descripcion;
    private String HoraAgendada;
    private String HoraFinalizacion;
    private String vin;

    // Propiedades predeterminadas
    private String EditadoPor = "000000001"; // Valor predeterminado
    private int Habilitado = 1; // Valor predeterminado
    private Date FechaCreacion = new Date(); // Valor predeterminado

    // Constructor vacío
    public CitaAdminDTO() {}

    // Constructor con parámetros
    public CitaAdminDTO(int CitaId, String CredencialId, String PlacaVehiculoId, String VIN, String ServicioId, String EstadoCitaId, Date FechaAgendada, String Descripcion, String HoraAgendada, String HoraFinalizacion) {
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getServicioId() {
        return ServicioId;
    }

    public void setServicioId(String ServicioId) {
        this.ServicioId = ServicioId;
    }

    public String getEstadoCitaId() {
        return EstadoCitaId;
    }

    public void setEstadoCitaId(String EstadoCitaId) {
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
}