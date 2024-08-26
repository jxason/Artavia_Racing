/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BusinessLogic;

import BusinessLogicInterface.IVehiculoPorClienteBL;
import DataAccess.VehiculoPorClienteDA;
import DataAccessInterface.IVehiculoPorClienteDA;
import Entities.ResponseVehiculoPorClienteDTO;
import java.util.List;

/**
 *
 * @author: Horacio Porras
 */
public class VehiculoPorClienteBL implements IVehiculoPorClienteBL {
    
    IVehiculoPorClienteDA vehiculoClienteDA;
    
    public VehiculoPorClienteBL() {
        vehiculoClienteDA = new VehiculoPorClienteDA();
    }
    
    public List<ResponseVehiculoPorClienteDTO> GetBy(String cedulaUsuario) {
        return vehiculoClienteDA.GetBy(cedulaUsuario);
    }
}
