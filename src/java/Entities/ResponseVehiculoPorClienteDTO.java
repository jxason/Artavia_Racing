/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entities;

/**
 *
 * @author: Horacio Porras
 */
public class ResponseVehiculoPorClienteDTO {
    private String CodigoVehiculo;
    private String NombreVehiculo;

    public ResponseVehiculoPorClienteDTO(String CodigoVehiculo, String NombreVehiculo) {
        this.CodigoVehiculo = CodigoVehiculo;
        this.NombreVehiculo = NombreVehiculo;
    }
    
    public ResponseVehiculoPorClienteDTO() {
        
    }

    public String getCodigoVehiculo() {
        return CodigoVehiculo;
    }

    public void setCodigoVehiculo(String CodigoVehiculo) {
        this.CodigoVehiculo = CodigoVehiculo;
    }

    public String getNombreVehiculo() {
        return NombreVehiculo;
    }

    public void setNombreVehiculo(String NombreVehiculo) {
        this.NombreVehiculo = NombreVehiculo;
    }
    
    
}
