/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * A-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de administrar la variable del pais.
 */
public class CountryDTO {
    private int CodigoPais;
    private String NombrePais;

    public CountryDTO() {
    }
    public CountryDTO(int CodigoPais, String NombrePais) {
        this.CodigoPais = CodigoPais;
        this.NombrePais = NombrePais;
    }

    public int getCodigoPais() {
        return CodigoPais;
    }

    public void setCodigoPais(int CodigoPais) {
        this.CodigoPais = CodigoPais;
    }

    public String getNombrePais() {
        return NombrePais;
    }

    public void setNombrePais(String NombrePais) {
        this.NombrePais = NombrePais;
    }    
}
