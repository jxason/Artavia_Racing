/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.StateDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar informacion del Estado de los paises.
 */
public interface IStateDA {
     /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del Estado de los paises.
    * @return 
    */
    List<StateDTO> GetAll(int CodigoPais); 
}
