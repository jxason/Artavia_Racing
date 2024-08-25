package Entities;

import java.util.Base64;

/**
 * AR-010
 * Author: Andrés Alvarado
 * Clase encargada de administrar los datos de respuesta de un vehículo.
 */
public class VehicleResponseDTO {
    private String placaVehiculoID;
    private String vin;
    private String marca;
    private String modelo;
    private int ano;
    private String color;
    private int alDia;
    private String tituloPropiedad; // Convertido a Base64
    private int habilitadoVehiculo;
    private String editadoPor;

    public VehicleResponseDTO(String placaVehiculoID, String vin, String marca, String modelo, int ano, String color, int alDia, byte[] tituloPropiedad, int habilitadoVehiculo, String editadoPor) {
        this.placaVehiculoID = placaVehiculoID;
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
        this.alDia = alDia;
        this.tituloPropiedad = encodeToBase64(tituloPropiedad);
        this.habilitadoVehiculo = habilitadoVehiculo;
        this.editadoPor = editadoPor;
    }

    public VehicleResponseDTO() {
    }

    // Getters y Setters

    public String getPlacaVehiculoID() {
        return placaVehiculoID;
    }

    public void setPlacaVehiculoID(String placaVehiculoID) {
        this.placaVehiculoID = placaVehiculoID;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAlDia() {
        return alDia;
    }

    public void setAlDia(int alDia) {
        this.alDia = alDia;
    }

    public String getTituloPropiedad() {
        return tituloPropiedad;
    }

    public void setTituloPropiedad(String tituloPropiedad) {
        this.tituloPropiedad = tituloPropiedad;
    }

    public int getHabilitadoVehiculo() {
        return habilitadoVehiculo;
    }

    public void setHabilitadoVehiculo(int habilitadoVehiculo) {
        this.habilitadoVehiculo = habilitadoVehiculo;
    }

    public String getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(String editadoPor) {
        this.editadoPor = editadoPor;
    }

    // Método para convertir un arreglo de bytes en una cadena base64
    private String encodeToBase64(byte[] data) {
        if (data != null) {
            return Base64.getEncoder().encodeToString(data);
        }
        return null;
    }
}
