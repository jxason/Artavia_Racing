/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IUserRegisterBL;
import DataAccess.UserRegisterDA;
import DataAccessInterface.IUserRegisterDA;
import Entities.ClienteDTO;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Class encargada de administrar la informacion de registro de usuarios.
 */
public class UserRegisterBL implements IUserRegisterBL
{
    IUserRegisterDA userRegisterDA;
    EncryptSHA512BL encryptSHA512BL;
    
    public UserRegisterBL()
    {
        userRegisterDA = new UserRegisterDA();
        encryptSHA512BL = new EncryptSHA512BL();
    }
    /**
     * AR-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de registrar un cliente en el sistema.
     * @param clienteDTO
     * @return 
     */  
    @Override
    public String Save(ClienteDTO clienteDTO) {
        //Aqui validamos si el usuaio existe, en caso de no exitir, devolvemos una respuesta de error
        String ResponseValidation = userRegisterDA.Validate(clienteDTO.getCredencialId());
        if(ResponseValidation == null && ResponseValidation.trim().isEmpty())
        {  
            //Antes de enviar a guardar la informacion encriptamos la contraseña en sha 512 de esta forma es imposible saber cual es la contraseña
            clienteDTO.setContrasena(encryptSHA512BL.Encrypt(clienteDTO.getContrasena()));
            //En este metodo realizamos el salvado del usuario ya con la contraseña encriptada.
            boolean ResponseSave = userRegisterDA.Save(clienteDTO);   
            if(ResponseSave == false)
            {
                return "{\"success\": false, \"message\": \"Hubo algun problema al almacenar el usuario.\"}";
            }
        }else
        {
            return "{\"success\": false, \"message\": \"El usuario se encuentra registrado en el sistema.\"}";
        }
        return "{\"success\": true, \"message\": \"Usuario registrado.\"}";        
    }
    
}
