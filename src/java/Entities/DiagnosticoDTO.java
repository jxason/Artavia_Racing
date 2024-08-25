/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Alfon
 */
public class DiagnosticoDTO 
{
    private int IdCita;
    private String Diagnostico;
    private String CodigoTrabajador = "000000001"; // Valor predeterminado
    private String EditadoPor = "000000001"; // Valor predeterminado
    private int Habilitado = 1; // Valor predeterminado
    private Date FechaCreacion = new Date(); // Valor predeterminado

    public DiagnosticoDTO(int IdCita, String Diagnostico) {
        this.IdCita = IdCita;
        this.Diagnostico = Diagnostico;
    }

    public DiagnosticoDTO() {
    }

    public int getIdCita() {
        return IdCita;
    }

    public void setIdCita(int IdCita) {
        this.IdCita = IdCita;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getCodigoTrabajador() {
        return CodigoTrabajador;
    }

    public void setCodigoTrabajador(String CodigoTrabajador) {
        this.CodigoTrabajador = CodigoTrabajador;
    }

    public String getEditadoPor() {
        return EditadoPor;
    }

    public void setEditadoPor(String EditadoPor) {
        this.EditadoPor = EditadoPor;
    }

    public int getHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(int Habilitado) {
        this.Habilitado = Habilitado;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
     
     
}
