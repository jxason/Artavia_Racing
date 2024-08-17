/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BusinessLogic;

import BusinessLogicInterface.ICitaBL;
import DataAccess.CitaDA;
import DataAccessInterface.ICitaDA;
import Entities.CitaDTO;
import java.util.List;

/**
 *
 * @author: Horacio Porras
 */
public class CitaBL implements ICitaBL {

    ICitaDA citaDA;
    
    public CitaBL() {
        citaDA = new CitaDA();
    }
    
    @Override
    public boolean agregarCita(CitaDTO cita) {
        return citaDA.agregarCita(cita);
    }

    @Override
    public boolean actualizarCita(CitaDTO cita) {
        return citaDA.actualizarCita(cita);
    }

    @Override
    public boolean cancelarCita(int idCita) {
        return citaDA.cancelarCita(idCita);
    }

    @Override
    public List<CitaDTO> listarCitas() {
        return citaDA.listarCitas();
    }

    @Override
    public CitaDTO obtenerCitaPorId(int idCita) {
        return citaDA.obtenerCitaPorId(idCita);
    }

    @Override
    public void agregarDiagnostico(int idCita, String diagnostico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
