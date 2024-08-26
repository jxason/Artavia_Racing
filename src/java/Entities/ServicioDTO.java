/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-003
 * @Author: Horacio Porras Marín 
 * Clase Objeto encargado de obtener los servicios
 */
public class ServicioDTO {

    private int CodigoServicio;
    private String NombreServicio;
    private int PrecioServicio;
    private int TiempoServicio;

    public ServicioDTO(int CodigoServicio, String NombreServicio, int PrecioServicio, int TiempoServicio) {
        this.CodigoServicio = CodigoServicio;
        this.NombreServicio = NombreServicio;
        this.PrecioServicio = PrecioServicio;
        this.TiempoServicio = TiempoServicio;
    }
    
    public ServicioDTO() {
        
    }

    public int getCodigoServicio() {
        return CodigoServicio;
    }

    public void setCodigoServicio(int CodigoServicio) {
        this.CodigoServicio = CodigoServicio;
    }

    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String NombreServicio) {
        this.NombreServicio = NombreServicio;
    }

    public int getPrecioServicio() {
        return PrecioServicio;
    }

    public void setPrecioServicio(int PrecioServicio) {
        this.PrecioServicio = PrecioServicio;
    }

    public int getTiempoServicio() {
        return TiempoServicio;
    }

    public void setTiempoServicio(int TiempoServicio) {
        this.TiempoServicio = TiempoServicio;
    }

}
