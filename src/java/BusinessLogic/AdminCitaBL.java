/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

/**
 *
 * @author Luis Solorzano Campos
 */
import java.util.List;
import DataAccess.CitaDA;
import BusinessLogicInterface.IAdminCitaBL;
import Entities.CitaDTO;


public class AdminCitaBL implements IAdminCitaBL {

    private final CitaDA citaDA;

    public AdminCitaBL(CitaDA citaDA) {
        this.citaDA = citaDA;
    }


    @Override
    public CitaDTO obtenerCitaPorId(int id) {
        return citaDA.obtenerCitaPorId(id);
    }

    @Override
    public void actualizarCita(CitaDTO cita) {
        citaDA.actualizarCita(cita);
    }

    @Override
    public void agregarDiagnostico(int idCita, String diagnostico) {
        CitaDTO cita = citaDA.obtenerCitaPorId(idCita);
        cita.setDiagnostico(diagnostico);
        citaDA.actualizarCita(cita);
    }

    @Override
    public List<CitaDTO> listarCitas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}