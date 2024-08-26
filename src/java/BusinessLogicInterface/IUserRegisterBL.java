/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.ClienteDTO;


/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar la informacion de registro de usuarios.
 */
public interface IUserRegisterBL {
    
     /**
     * AR-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de registrar un cliente en el sistema.
     * @param clienteDTO
     * @return 
     */    
     String Save(ClienteDTO clienteDTO);  
}
