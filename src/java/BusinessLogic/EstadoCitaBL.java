/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IEstadoCitaBL;
import DataAccess.EstadoCitaDA;
import DataAccessInterface.IEstadoCitaDA;
import Entities.EstadoCitaDTO;
import java.util.List;

/**
 * AR-003
 *
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar los estados de cita
 */
public class EstadoCitaBL implements IEstadoCitaBL {

    IEstadoCitaDA estadoCitaDA;

    public EstadoCitaBL() {
        estadoCitaDA = new EstadoCitaDA();
    }

    /**
     * AR-003
     * @Author: Horacio Porras Metodo encargado de obtener todos los servicios
     * @return
     */
    @Override
    public List<EstadoCitaDTO> GetAll() {
        return estadoCitaDA.GetAll();
    }

}
