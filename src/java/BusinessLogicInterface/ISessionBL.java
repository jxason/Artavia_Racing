package BusinessLogicInterface;

import Entities.Enums.TypeSessions;
import Entities.SessionDTO;
import javax.servlet.http.HttpSession;

/**
 * FI-001
 * Author: Andrés Alvarado Matamoros
 * Interfaz encargada de definir los métodos para administrar la sesión del usuario.
 */
public interface ISessionBL {

    /**
     * FI-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de obtener la información del usuario en sesión, tal como nombre, rol, etc.
     * 
     * @param session La sesión HTTP actual.
     * @param typeSessions El objeto que representa la sesión a obtener.
     * @return Retorna un objeto session.
     */
    SessionDTO Get(HttpSession session, TypeSessions typeSessions);

    /**
     * FI-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de guardar la información del usuario en sesión.
     * 
     * @param session La sesión HTTP actual.
     * @param sessionDTO Objeto sesión con la información que se va a guardar.
     * @return Retorna un identificador de la sesión para posteriormente recuperar la información.
     */
    int Save(HttpSession session, SessionDTO sessionDTO);

    /**
     * AR-001
     * Author: Andrés Alvarado Matamoros
     * Método para eliminar una sesión registrada.
     * 
     * @param session La sesión HTTP actual.
     * @param typeSessions El objeto que representa la sesión a eliminar.
     */
    void Delete(HttpSession session, TypeSessions typeSessions);
}
