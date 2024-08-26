/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * A-001
 * Autor: José Andrés Alvarado Matamoros 
 * Clase Objeto encargado de administrar la variable del Estado.
 */
public class StateDTO 
{
    private int CodigoEstado;
    private String NombreEstado;     

    public StateDTO(int CodigoEstado, String NombreEstado) {
        this.CodigoEstado = CodigoEstado;
        this.NombreEstado = NombreEstado;
    }

    public StateDTO() {
    }

    public int getCodigoEstado() {
        return CodigoEstado;
    }

    public void setCodigoEstado(int CodigoEstado) {
        this.CodigoEstado = CodigoEstado;
    }

    public String getNombreEstado() {
        return NombreEstado;
    }

    public void setNombreEstado(String NombreEstado) {
        this.NombreEstado = NombreEstado;
    }
    
    
}
