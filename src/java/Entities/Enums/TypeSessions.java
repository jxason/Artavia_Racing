/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Enums;

/**
 *
 * @author fidelitas
 */
public enum TypeSessions {
    SESSION_USER(1);

    private final int sessionType;

    // Constructor privado para el valor asociado
    TypeSessions(int sessionType) {
        this.sessionType = sessionType;
    }

    // Método para obtener el valor asociado
    public int getSessionType() {
        return sessionType;
    }
}