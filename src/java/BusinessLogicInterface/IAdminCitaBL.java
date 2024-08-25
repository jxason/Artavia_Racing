/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

/**
 *
 * @author Luis Solorzano Campos
 */
import Entities.CitaDTO;
import java.util.List;


public interface IAdminCitaBL {
    boolean agregarCita(CitaDTO cita);
    boolean actualizarCita(CitaDTO cita);
    boolean cancelarCita(int citaId);    
    List<CitaDTO> listarCitas();
}