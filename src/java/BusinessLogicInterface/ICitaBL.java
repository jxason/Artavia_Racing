/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.CitaDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar las citas
 */
public interface ICitaBL {
    
    boolean agregarCita(CitaDTO cita);
    
    boolean actualizarCita(CitaDTO cita);
    
    boolean cancelarCita(int idCita);
    
    List<CitaDTO> listarCitas();
    
    CitaDTO obtenerCitaPorId(int idCita);
    
}
