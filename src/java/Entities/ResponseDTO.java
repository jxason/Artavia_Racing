/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
* AR-001
* Autor: José Andrés Alvarado Matamoros
* Clase interna para estructurar la respuesta JSON.
*/
public class ResponseDTO {
    public boolean success;

    public ResponseDTO(boolean success) {
        this.success = success;
    }
    public ResponseDTO() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}