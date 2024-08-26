package DataAccess;

import DataAccessInterface.IMenuDA;
import Entities.MenuDTO;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar el menu del usuario.
 */
public class MenuDA extends BaseConnectionDA implements IMenuDA {
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener el html del menu que se desplegará por rol del usuario.
    * @param RolId el rol del usuario en sesión
    * @return retorna un html con el menu del rol del usuario
    */
    @Override
    public MenuDTO Get(int RolId) {
        MenuDTO Objdto = null;
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_ObtenerMenuPorRol(?, ?)}");
            callableStatements.setInt(1, RolId);
            callableStatements.registerOutParameter(2, java.sql.Types.CLOB);

            callableStatements.execute();

            Clob clobHtml = callableStatements.getClob(2); // Obtener el CLOB del parámetro de salida

            Objdto = new MenuDTO();
            Objdto.setHtmlMenu(clobToString(clobHtml)); // Convertir CLOB a String y asignarlo

        } catch (SQLException e) {
            e.printStackTrace(); // Mejor manejo de excepciones
        } catch (Exception e) {
            e.printStackTrace(); // Manejar posibles excepciones del método clobToString
        } finally {
            closeResources(); // Asegurar cierre de recursos
        }
        return Objdto;
    }

    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Método encargado de convertir un objeto CLOB en una cadena de texto (String).
    * Este método lee el contenido del CLOB y lo convierte en un String utilizando un lector de caracteres.
    * 
    * @param clob El objeto CLOB que contiene el texto a convertir.
    * @return Una cadena de texto (String) que representa el contenido del CLOB.
    * @throws Exception Si ocurre algún error durante la conversión del CLOB.
    */
    private static String clobToString(Clob clob) throws Exception 
    {
        StringBuilder sb = new StringBuilder();
        try (java.io.Reader reader = clob.getCharacterStream()) {
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, bytesRead);
            }
        }
        return sb.toString();
    }

}
