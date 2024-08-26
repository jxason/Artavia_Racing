/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.EstadoCitaDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar los estados de cita
 */
public interface IEstadoCitaBL {
    /**
    * AR-003
    * @Author: Horacio Porras Marín
    * Metodo encargado de obtener todos los estados de cita
    * @return 
    */
    List<EstadoCitaDTO> GetAll();
}
