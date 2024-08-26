package BusinessLogic;

import BusinessLogicInterface.ISessionBL;
import Entities.Enums.TypeSessions;
import Entities.SessionDTO;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * FI-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar la variable sesión del usuario.
 */
public class SessionBL implements ISessionBL {

    /**
     * FI-001
     * Author: Andrés Alvarado Matamoros
     * Método para obtener el mapa de sesiones de la sesión HTTP.
     * 
     * @param session La sesión HTTP actual.
     * @return El mapa de sesiones almacenado en la sesión HTTP.
     */
    private Map<TypeSessions, SessionDTO> getSessionMap(HttpSession session) {
        // Obtiene el mapa de sesiones almacenado en la sesión HTTP
        Map<TypeSessions, SessionDTO> sessionMap = (Map<TypeSessions, SessionDTO>) session.getAttribute("sessionMap");
        if (sessionMap == null) {
            // Si el mapa no existe, crea uno nuevo y lo guarda en la sesión HTTP
            sessionMap = new HashMap<>();
            session.setAttribute("sessionMap", sessionMap);
        }
        return sessionMap;
    }

    /**
     * FI-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de obtener la información del usuario en sesión tal como nombre, rol, etc.
     * 
     * @param session La sesión HTTP actual.
     * @param typeSessions Identificador de la sesión.
     * @return Retorna un objeto session.
     */
    @Override
    public SessionDTO Get(HttpSession session, TypeSessions typeSessions) {
        Map<TypeSessions, SessionDTO> sessionMap = getSessionMap(session);
        return sessionMap.get(typeSessions); // Obtiene el objeto SessionDTO usando el enum como clave
    }

    /**
     * FI-001
     * Author: Andrés Alvarado Matamoros
     * Método encargado de guardar la información del usuario en sesión.
     * 
     * @param session La sesión HTTP actual.
     * @param sessionDTO Objeto sesión con la información que se va a guardar.
     * @return Retorna un identificador de la sesión para posteriormente recuperar la información.
     */
    @Override
    public int Save(HttpSession session, SessionDTO sessionDTO) {
        Map<TypeSessions, SessionDTO> sessionMap = getSessionMap(session);
        TypeSessions sessionType = sessionDTO.getEnum(); // Usa el enum para obtener la clave
        sessionMap.put(sessionType, sessionDTO); // Guarda el objeto SessionDTO en el mapa usando el enum como clave
        return sessionType.getSessionType(); // Retorna el valor asociado al enum
    }

    /**
     * FI-001
     * Author: Andrés Alvarado Matamoros
     * Método para eliminar una sesión registrada.
     * 
     * @param session La sesión HTTP actual.
     * @param typeSessions El identificador único de la sesión a eliminar.
     */
    @Override
    public void Delete(HttpSession session, TypeSessions typeSessions) {
        Map<TypeSessions, SessionDTO> sessionMap = getSessionMap(session);
        sessionMap.remove(typeSessions); // Elimina la entrada del mapa usando el enum como clave
    }
}
