/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de administrar la variable del distrito.
 */
public class DistrictDTO {
      private int CodigoDistrito;
    private String NombreDistrito;     

    public DistrictDTO() {
    }

    public DistrictDTO(int CodigoDistrito, String NombreDistrito) {
        this.CodigoDistrito = CodigoDistrito;
        this.NombreDistrito = NombreDistrito;
    }

    public int getCodigoDistrito() {
        return CodigoDistrito;
    }

    public void setCodigoDistrito(int CodigoDistrito) {
        this.CodigoDistrito = CodigoDistrito;
    }

    public String getNombreDistrito() {
        return NombreDistrito;
    }

    public void setNombreDistrito(String NombreDistrito) {
        this.NombreDistrito = NombreDistrito;
    }
}
