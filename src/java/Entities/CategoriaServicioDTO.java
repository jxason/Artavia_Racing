/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entities;

/**
 * AR-003
 * @Author: Horacio Porras Marín 
 * Clase Objeto encargado de obtener las categorias de servicio
 */
public class CategoriaServicioDTO {

    private int CodigoCategoriaServicio;
    private String CategoriaServicio;

    public CategoriaServicioDTO(int CodigoCategoriaServicio, String CategoriaServicio) {
        this.CodigoCategoriaServicio = CodigoCategoriaServicio;
        this.CategoriaServicio = CategoriaServicio;
    }
    
    public CategoriaServicioDTO() {
        
    }

    public int getCodigoCategoriaServicio() {
        return CodigoCategoriaServicio;
    }

    public void setCodigoCategoriaServicio(int CodigoCategoriaServicio) {
        this.CodigoCategoriaServicio = CodigoCategoriaServicio;
    }

    public String getCategoriaServicio() {
        return CategoriaServicio;
    }

    public void setCategoriaServicio(String CategoriaServicio) {
        this.CategoriaServicio = CategoriaServicio;
    }
    
}
