/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.ICountyBL;
import DataAccess.CountyDA;
import DataAccessInterface.ICountyDA;
import Entities.CountyDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Class encargada de administrar informacion del condado de los estados.
 */
public class CountyBL implements ICountyBL{
     ICountyDA countyDA;
    
    public CountyBL()
    {
        countyDA = new CountyDA();
    }
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del condado de los estados.
    * @return 
    */
    @Override
    public List<CountyDTO> GetAll(int CodigoEstado) {
       return countyDA.GetAll(CodigoEstado);
    }
    
}
