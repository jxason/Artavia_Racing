/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.ServicioDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar los servicios
 */
public interface IServicioBL {
    /**
    * AR-003
    * @Author: Horacio Porras Marín
    * Metodo encargado de obtener todos los servicios
    * @return 
    */
    List<ServicioDTO> GetBy(int CodigoCategoriaServicio);
}
