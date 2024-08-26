package Entities;

import java.sql.Date;

/**
 * AR-010
 * Author: Andrés Alvarado
 * Clase encargada de administrar los datos de la solicitud de un vehículo.
 */
public class VehicleRequestDTO {
    private String placaVehiculoID;
    private String vin;
    private String marca;
    private String modelo;
    private int ano;
    private String color;
    private int alDia;
    private byte[] tituloPropiedad;
    private int habilitadoVehiculo;
    private String credencialID;
    private String editadoPor;
    private int habilitadoCliente=1;

    public VehicleRequestDTO(String placaVehiculoID, String vin, String marca, String modelo, int ano, String color, int alDia, byte[] tituloPropiedad, int habilitadoVehiculo, String credencialID, String editadoPor, int habilitadoCliente) {
        this.placaVehiculoID = placaVehiculoID;
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
        this.alDia = alDia;
        this.tituloPropiedad = tituloPropiedad;
        this.habilitadoVehiculo = habilitadoVehiculo;
        this.credencialID = credencialID;
        this.editadoPor = editadoPor;
        this.habilitadoCliente = habilitadoCliente;
    }

    public VehicleRequestDTO() {
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

    public byte[] getTituloPropiedad() {
        return tituloPropiedad;
    }

    public void setTituloPropiedad(byte[] tituloPropiedad) {
        this.tituloPropiedad = tituloPropiedad;
    }

    public int getHabilitadoVehiculo() {
        return habilitadoVehiculo;
    }

    public void setHabilitadoVehiculo(int habilitadoVehiculo) {
        this.habilitadoVehiculo = habilitadoVehiculo;
    }

    public String getCredencialID() {
        return credencialID;
    }

    public void setCredencialID(String credencialID) {
        this.credencialID = credencialID;
    }

    public String getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(String editadoPor) {
        this.editadoPor = editadoPor;
    }

    public int getHabilitadoCliente() {
        return habilitadoCliente;
    }

    public void setHabilitadoCliente(int habilitadoCliente) {
        this.habilitadoCliente = habilitadoCliente;
    }
}
