/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.CountyDTO;
import java.util.List;


/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar informacion del condado de los estados.
 */
public interface ICountyDA {
     /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del condado de los estados.
    * @return 
    */
    List<CountyDTO> GetAll(int CodigoEstado); 
}