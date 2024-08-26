/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entities;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Clase Objeto encargado de obtener los vehiculos
 */
public class VehiculoDTO {
    private String placaVehiculoId;
    private String vinVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private int anyoVehiculo;
    private String colorVehiculo;

    public VehiculoDTO(String placaVehiculoId, String vinVehiculo, String marcaVehiculo, String modeloVehiculo, int anyoVehiculo, String colorVehiculo) {
        this.placaVehiculoId = placaVehiculoId;
        this.vinVehiculo = vinVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.anyoVehiculo = anyoVehiculo;
        this.colorVehiculo = colorVehiculo;
    }
    
    public VehiculoDTO() {
    }

    public String getPlacaVehiculoId() {
        return placaVehiculoId;
    }

    public void setPlacaVehiculoId(String placaVehiculoId) {
        this.placaVehiculoId = placaVehiculoId;
    }

    public String getVinVehiculo() {
        return vinVehiculo;
    }

    public void setVinVehiculo(String vinVehiculo) {
        this.vinVehiculo = vinVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public int getAnyoVehiculo() {
        return anyoVehiculo;
    }

    public void setAnyoVehiculo(int anyoVehiculo) {
        this.anyoVehiculo = anyoVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }
    
}