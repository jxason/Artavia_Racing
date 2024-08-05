/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IDistrictBL;
import DataAccess.DistrictDA;
import DataAccessInterface.IDistrictDA;
import Entities.DistrictDTO;
import java.util.List;


/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar informacion del distrito por condado
 */
public class DistrictBL implements IDistrictBL
{   
   IDistrictDA DistrictDA;
    
    public DistrictBL()
    {
        DistrictDA = new DistrictDA();
    }
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del  distrito por condado.
    * @param CodigoCondado
    * @return 
    */
    @Override
    public List<DistrictDTO> GetAll(int CodigoCondado) {
         return DistrictDA.GetAll(CodigoCondado);
    }    
}
