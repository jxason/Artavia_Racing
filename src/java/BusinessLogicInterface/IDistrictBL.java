/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.DistrictDTO;
import java.util.List;


/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar informacion del distritos de los condados.
 */
public interface IDistrictBL {
     /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del distritos de los condados.
    * @return 
    */
    List<DistrictDTO> GetAll(int CodigoCondado); 
}
