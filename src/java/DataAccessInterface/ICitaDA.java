/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.CitaAdminDTO;
import Entities.CitaDTO;
import Entities.DiagnosticoDTO;
import java.util.List;

/**
 *
 * @author: Horacio Porras
 */
public interface ICitaDA {
    
    boolean agregarCita(CitaDTO cita);
    
    boolean actualizarCita(CitaDTO cita);
    
    boolean cancelarCita(int idCita);
    
    List<CitaDTO> listarCitas();
    
    CitaAdminDTO obtenerCitaPorId(int idCita);
    boolean eliminarCita(int idCita);
    boolean agregarDiagnostico(DiagnosticoDTO Request);
}
