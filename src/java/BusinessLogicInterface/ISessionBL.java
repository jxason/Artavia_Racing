package BusinessLogicInterface;

import Entities.SessionDTO;

/**
 * FI-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar la variable session del usuario.
 */
public interface ISessionBL {
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener la informacion del usuario en sesion tal como nombre, rol, etc
    * @param credential Aqui viene la cedula del usuario en sesion.
    * @return Retorna un objeto session
    */
    SessionDTO Get(int credential);
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener la informacion del usuario en sesion tal como nombre, rol, etc
    * @param sessionDTO Aqui viene el objeto sesion con la informacion que se va a guardar.
    * @return Retorna un identificador de la session para posteriormente recuperar la informacion.
    */
    int Save(SessionDTO sessionDTO);
}
