/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IUsuarioInventarioDA;
import Entities.InventarioProductosDTO;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar el menu del usuario.
 */
public class UsuarioInventarioDA extends BaseConnectionDA implements IUsuarioInventarioDA {
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener el html del menu que se desplegará por rol del usuario.
    * @return retorna un html con el menu del rol del usuario
    */
    @Override
    public InventarioProductosDTO Get() {
        InventarioProductosDTO Objdto = null;
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call SP_Obtener_Productos_HTML(?)}");            
            callableStatements.registerOutParameter(1, java.sql.Types.CLOB);

            callableStatements.execute();

            Clob clobHtml = callableStatements.getClob(1); // Obtener el CLOB del parámetro de salida

            Objdto = new InventarioProductosDTO();
            Objdto.setHtmlInventarioProductos(clobToString(clobHtml)); // Convertir CLOB a String y asignarlo

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
