/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de administrar las variables del cliente para el procedimiento almacenado USP_RegistrarCliente.
 */
public class ClienteDTO {
    private String CredencialId;
    private int RolId = 2; // Valor predeterminado de 2
    private String Nombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private Date FechaNacimiento;

    private String NumeroTelefono;
    private int CategoriaTelefonoId;
    private Integer NumeroExtension;
    private String DescripcionTelefono;

    private int CodigoPais;
    private int CodigoEstado;
    private int CodigoCondado;
    private int CodigoDistrito;
    private String DescripcionDireccion;

    private String CorreoElectronico;
    private String Contrasena;
    private int EsContrasenaTemporal = 0; // Valor predeterminado de 0

    public ClienteDTO() {
    }

    public ClienteDTO(String CredencialId, int RolId, String Nombre, String PrimerApellido, String SegundoApellido, Date FechaNacimiento, String NumeroTelefono, int CategoriaTelefonoId, Integer NumeroExtension, String DescripcionTelefono, int CodigoPais, int CodigoEstado, int CodigoCondado, int CodigoDistrito, String DescripcionDireccion, String CorreoElectronico, String Contrasena, int EsContrasenaTemporal) {
        this.CredencialId = CredencialId;
        this.RolId = RolId;
        this.Nombre = Nombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.FechaNacimiento = FechaNacimiento;
        this.NumeroTelefono = NumeroTelefono;
        this.CategoriaTelefonoId = CategoriaTelefonoId;
        this.NumeroExtension = NumeroExtension;
        this.DescripcionTelefono = DescripcionTelefono;
        this.CodigoPais = CodigoPais;
        this.CodigoEstado = CodigoEstado;
        this.CodigoCondado = CodigoCondado;
        this.CodigoDistrito = CodigoDistrito;
        this.DescripcionDireccion = DescripcionDireccion;
        this.CorreoElectronico = CorreoElectronico;
        this.Contrasena = Contrasena;
        this.EsContrasenaTemporal = EsContrasenaTemporal;
    }

    public String getCredencialId() {
        return CredencialId;
    }

    public void setCredencialId(String CredencialId) {
        this.CredencialId = CredencialId;
    }

    public int getRolId() {
        return RolId;
    }

    public void setRolId(int RolId) {
        this.RolId = RolId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    public int getCategoriaTelefonoId() {
        return CategoriaTelefonoId;
    }

    public void setCategoriaTelefonoId(int CategoriaTelefonoId) {
        this.CategoriaTelefonoId = CategoriaTelefonoId;
    }

    public Integer getNumeroExtension() {
        return NumeroExtension;
    }

    public void setNumeroExtension(Integer NumeroExtension) {
        this.NumeroExtension = NumeroExtension;
    }

    public String getDescripcionTelefono() {
        return DescripcionTelefono;
    }

    public void setDescripcionTelefono(String DescripcionTelefono) {
        this.DescripcionTelefono = DescripcionTelefono;
    }

    public int getCodigoPais() {
        return CodigoPais;
    }

    public void setCodigoPais(int CodigoPais) {
        this.CodigoPais = CodigoPais;
    }

    public int getCodigoEstado() {
        return CodigoEstado;
    }

    public void setCodigoEstado(int CodigoEstado) {
        this.CodigoEstado = CodigoEstado;
    }

    public int getCodigoCondado() {
        return CodigoCondado;
    }

    public void setCodigoCondado(int CodigoCondado) {
        this.CodigoCondado = CodigoCondado;
    }

    public int getCodigoDistrito() {
        return CodigoDistrito;
    }

    public void setCodigoDistrito(int CodigoDistrito) {
        this.CodigoDistrito = CodigoDistrito;
    }

    public String getDescripcionDireccion() {
        return DescripcionDireccion;
    }

    public void setDescripcionDireccion(String DescripcionDireccion) {
        this.DescripcionDireccion = DescripcionDireccion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getEsContrasenaTemporal() {
        return EsContrasenaTemporal;
    }

    public void setEsContrasenaTemporal(int EsContrasenaTemporal) {
        this.EsContrasenaTemporal = EsContrasenaTemporal;
    }  
}
