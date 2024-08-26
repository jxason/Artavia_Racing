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
    public boolean agregarCita(CitaDTO cita) {
        // Asume que CitaDA.agregarCita devuelve un booleano
        return citaDA.agregarCita(cita);
    }

    @Override
    public boolean actualizarCita(CitaDTO cita) {
        // Asume que CitaDA.actualizarCita devuelve un booleano
        return citaDA.actualizarCita(cita);
    }

    @Override
    public boolean cancelarCita(int citaId) {
        // Asume que CitaDA.cancelarCita devuelve un booleano
        return citaDA.cancelarCita(citaId);
    }


    @Override
    public List<CitaDTO> listarCitas() {
        return citaDA.listarCitas();
    }
}