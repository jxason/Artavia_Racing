/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.ISessionBL;
import Entities.SessionDTO;
import java.util.HashMap;
import java.util.Map;

/**
 * FI-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar la variable session del usuario.
 */
public class SessionBL  implements ISessionBL
{
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Se definen variables globales.
    */
    private static Map<Integer, SessionDTO> sessionMap;
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo constructor aqui se inicializan vaiables o instancias. 
    */
    public SessionBL()
    {
        sessionMap= new HashMap<>();
    }
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener la informacion del usuario en sesion tal como nombre, rol, etc
    * @param credential Aqui viene la cedula del usuario en sesion.
    * @return Retorna un objeto session
    */
    @Override
    public SessionDTO Get(int credential) {
          return sessionMap.get(credential); // Retorna el objeto SessionDTO almacenado bajo el credential dado
    }
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener la informacion del usuario en sesion tal como nombre, rol, etc
    * @param sessionDTO Aqui viene el objeto sesion con la informacion que se va a guardar.
    * @return Retorna un identificador de la session para posteriormente recuperar la informacion.
    */
    @Override
    public int Save(SessionDTO sessionDTO) {
        int credential = sessionDTO.getCredential(); // Obtener el credential del objeto SessionDTO
        sessionMap.put(credential, sessionDTO);
        return credential; // Retorna el credential como identificador de la sesión guardada
    }
    
}
