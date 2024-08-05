/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase DTO para representar la información de los tipos de teléfono.
 */
public class TipoTelefonoDTO {
    
    private int CategoriaTelefonoId;
    private String TipoTelefono;

    public TipoTelefonoDTO() {
    }

    public TipoTelefonoDTO(int CategoriaTelefonoId, String TipoTelefono) {
        this.CategoriaTelefonoId = CategoriaTelefonoId;
        this.TipoTelefono = TipoTelefono;
    }

    public int getCategoriaTelefonoId() {
        return CategoriaTelefonoId;
    }

    public void setCategoriaTelefonoId(int CategoriaTelefonoId) {
        this.CategoriaTelefonoId = CategoriaTelefonoId;
    }

    public String getTipoTelefono() {
        return TipoTelefono;
    }

    public void setTipoTelefono(String TipoTelefono) {
        this.TipoTelefono = TipoTelefono;
    }

   
    
}
