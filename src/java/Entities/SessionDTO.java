/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Enums.TypeSessions;

/**
 * AZ-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de administrar la variable sesion de los usuarios.
 */
public class SessionDTO 
{
    private String Credential;
    private String Name;
    private int Rol;
    private String Password;
    private TypeSessions Enum;

    /**
     * Constructor 
     */
    public SessionDTO() {
    }
     /**
     * AZ-001
     * Autor: José Andrés Alvarado Matamoros.
     * En este contructore se le asigna la inicializaion de las variables del objeto.
     * @param Credential Esta es la cedula del usuario.
     * @param Name  Nombre del Usuario.
     * @param Rol  Rol del usuario.
     * @param Password Contraseña del Usuario.
     */
    public SessionDTO(String Credential, String Name, int Rol, String Password,TypeSessions Enum) {
        this.Credential = Credential;
        this.Name = Name;
        this.Rol = Rol;
        this.Password = Password;
        this.Enum = Enum;
    }
    public String getCredential() {
        return Credential;
    }

    public void setCredential(String Credential) {
        this.Credential = Credential;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }    

    public TypeSessions getEnum() {
        return Enum;
    }

    public void setEnum(TypeSessions Enum) {
        this.Enum = Enum;
    }
    
}
