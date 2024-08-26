/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author: Horacio Porras
 */
public class ResponseCitaPorUsuarioDTO {
    private int CodigoCita;
    private String PlacaVehiculo;
    private String NombreVehiculo;
    private String NombreCategoria;
    private String NombreServicio;
    private String FechaAgendada;
    private String HoraAgendada;
    
    // Propiedades predeterminadas
    private String EstadoCita ; // Valor predeterminado

    public ResponseCitaPorUsuarioDTO(int CodigoCita, String PlacaVehiculo, String NombreVehiculo, String NombreCategoria, String NombreServicio, String FechaAgendada, String HoraAgendada) {
        this.CodigoCita = CodigoCita;
        this.PlacaVehiculo = PlacaVehiculo;
        this.NombreVehiculo = NombreVehiculo;
        this.NombreCategoria = NombreCategoria;
        this.NombreServicio = NombreServicio;
        this.FechaAgendada = FechaAgendada;
        this.HoraAgendada = HoraAgendada;
    }
    
    public ResponseCitaPorUsuarioDTO() {
        
    }

    public int getCodigoCita() {
        return CodigoCita;
    }

    public void setCodigoCita(int CodigoCita) {
        this.CodigoCita = CodigoCita;
    }

    public String getPlacaVehiculo() {
        return PlacaVehiculo;
    }

    public void setPlacaVehiculo(String PlacaVehiculo) {
        this.PlacaVehiculo = PlacaVehiculo;
    }

    public String getNombreVehiculo() {
        return NombreVehiculo;
    }

    public void setNombreVehiculo(String NombreVehiculo) {
        this.NombreVehiculo = NombreVehiculo;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String NombreServicio) {
        this.NombreServicio = NombreServicio;
    }

    public String getFechaAgendada() {
        return FechaAgendada;
    }

    public void setFechaAgendada(String FechaAgendada) {
        this.FechaAgendada = FechaAgendada;
    }

    public String getHoraAgendada() {
        return HoraAgendada;
    }

    public void setHoraAgendada(String HoraAgendada) {
        this.HoraAgendada = HoraAgendada;
    }

    public String getEstadoCita() {
        return EstadoCita;
    }

    public void setEstadoCita(String EstadoCita) {
        this.EstadoCita = EstadoCita;
    }
    
}
