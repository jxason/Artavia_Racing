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
    List<CitaDTO> listarCitas();
    CitaDTO obtenerCitaPorId(int id);
    void actualizarCita(CitaDTO cita);
    void agregarDiagnostico(int idCita, String diagnostico);
}