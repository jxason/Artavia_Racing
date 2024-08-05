/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.ClienteDTO;


/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar la informacion de registro de usuarios.
 */
public interface IUserRegisterDA {
    
     /**
     * AR-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de registrar un cliente en el sistema.
     * @param clienteDTO
     * @return 
     */    
    boolean Save(ClienteDTO clienteDTO);
     /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de validar si el usuario con esa cedula se encuentra almacenado en el sistema.
    * @param Cedula
    * @return 
    */
    String Validate(String Cedula); 
}
