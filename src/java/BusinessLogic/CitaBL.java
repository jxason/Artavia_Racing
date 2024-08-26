/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BusinessLogic;

import BusinessLogicInterface.ICitaBL;
import DataAccess.CitaDA;
import DataAccessInterface.ICitaDA;
import Entities.CitaAdminDTO;
import Entities.CitaDTO;
import Entities.DiagnosticoDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar las citas
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
    public boolean eliminarCita(int idCita) {
        return citaDA.eliminarCita(idCita); // Llamar al método en CitaDA
    }

    @Override
    public List<CitaDTO> listarCitas() {
        return citaDA.listarCitas();
    }

    @Override
    public CitaAdminDTO obtenerCitaPorId(int idCita) {
        return citaDA.obtenerCitaPorId(idCita);
    }

    
    @Override
    public boolean agregarDiagnostico(DiagnosticoDTO Request) {
    return citaDA.agregarDiagnostico(Request);
}
    
}