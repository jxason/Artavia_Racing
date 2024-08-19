/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.VehiculoDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar los vehiculos
 */
public interface IVehiculoDA {
    
    /**
    * AR-003
    * @Author: Horacio Porras Marín
    * Metodo encargado de obtener los vehiculos por ID
    * @return 
    */
    List<VehiculoDTO> GetById(String UserCred);  
}