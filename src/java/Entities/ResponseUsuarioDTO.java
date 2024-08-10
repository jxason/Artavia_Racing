/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * 
 * Data Transfer Object (DTO) que representa la respuesta del sistema
 * después de verificar las credenciales del usuario.
 */
public class ResponseUsuarioDTO {
    private String credencialId;
    private int rolId;

    // Getters y Setters

    public String getCredencialId() {
        return credencialId;
    }

    public void setCredencialId(String credencialId) {
        this.credencialId = credencialId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}