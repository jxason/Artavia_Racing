/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BusinessLogic;

import BusinessLogicInterface.IVehiculoBL;
import DataAccess.VehiculoDA;
import DataAccessInterface.IVehiculoDA;
import Entities.VehiculoDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar los vehiculos
 */
public class VehiculoBL implements IVehiculoBL {
    IVehiculoDA vehiculoDA;
    
    public VehiculoBL()
    {
        vehiculoDA = new VehiculoDA();
    }
    /**
    * AR-003
    * @Author: Horacio Porras
    * Metodo encargado de obtener los vehiculos por ID
    * @return 
    */
    @Override
    public List<VehiculoDTO> GetById(String UserCred) {
        return vehiculoDA.GetById(UserCred);
    }

}
