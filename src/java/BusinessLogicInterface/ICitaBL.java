/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.CitaAdminDTO;
import Entities.CitaDTO;
import Entities.DiagnosticoDTO;
import java.util.List;

/**
 *
 * @author: Horacio Porras
 */
public interface ICitaBL {
    
    boolean agregarCita(CitaDTO cita);
    
    boolean actualizarCita(CitaDTO cita);
    
    boolean cancelarCita(int idCita);
    
    boolean eliminarCita(int idCita); // Agregar esta línea
    
    List<CitaDTO> listarCitas();
    
    CitaAdminDTO obtenerCitaPorId(int idCita);

    boolean agregarDiagnostico(DiagnosticoDTO Request);
    
}