/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import javax.servlet.http.HttpSession;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * 
 * Data Transfer Object (DTO) que representa los datos de la solicitud
 * para la verificación de usuarios.
 */
public class RequestUsuarioDTO {
    private String correoElectronico;
    private String contrasena;
    private HttpSession httpSession;
    public RequestUsuarioDTO() {
    }
    

    public RequestUsuarioDTO(String correoElectronico, String contrasena,HttpSession httpSession) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
         this.httpSession = httpSession;
    }

    // Getters y Setters

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
    
}