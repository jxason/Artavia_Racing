/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de administrar la variable del condado.
 */
public class CountyDTO {
    private int CodigoCondado;
    private String NombreCondado;  
    public CountyDTO() {
    }

    public CountyDTO(int CodigoCondado, String NombreCondado) {
        this.CodigoCondado = CodigoCondado;
        this.NombreCondado = NombreCondado;
    }

    public int getCodigoCondado() {
        return CodigoCondado;
    }

    public void setCodigoCondado(int CodigoCondado) {
        this.CodigoCondado = CodigoCondado;
    }

    public String getNombreCondado() {
        return NombreCondado;
    }

    public void setNombreCondado(String NombreCondado) {
        this.NombreCondado = NombreCondado;
    }

   
}
