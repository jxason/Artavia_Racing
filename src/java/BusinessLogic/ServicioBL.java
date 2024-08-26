/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BusinessLogic;

import BusinessLogicInterface.IServicioBL;
import DataAccess.ServicioDA;
import DataAccessInterface.IServicioDA;
import Entities.ServicioDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar los servicios
 */
public class ServicioBL implements IServicioBL {
    
    IServicioDA servicioDA;
    
    public ServicioBL() {
        servicioDA = new ServicioDA();
    }
    /**
    * AR-003
    * @Author: Horacio Porras
    * Metodo encargado de obtener todos los servicios
    * @param CodigoCategoriaServicio
    * @return 
    */
    @Override
    public List<ServicioDTO> GetBy(int CodigoCategoriaServicio) {
        return servicioDA.GetBy(CodigoCategoriaServicio);
    }

}
