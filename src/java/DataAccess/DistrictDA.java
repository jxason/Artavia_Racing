/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IDistrictDA;
import Entities.DistrictDTO;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar informacion del distrito de los condados.
 */
public class DistrictDA extends BaseConnectionDA implements IDistrictDA 
{
   /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del Estado de los paises.
    * @param CodigoCondado
    * @return 
    */
    @Override
    public List<DistrictDTO>  GetAll(int CodigoCondado) {
        List<DistrictDTO> lista = new ArrayList<>();   
        try {
            // Establecer la conexión
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            // Preparar el procedimiento almacenado
            callableStatements = connections.prepareCall("{call USP_SeleccionarDistritos(?,?)}");
            callableStatements.setInt(1, CodigoCondado);
            callableStatements.registerOutParameter(2, java.sql.Types.REF_CURSOR);

            // Ejecutar el procedimiento almacenado
            callableStatements.execute();

            // Obtener el cursor de resultados
            resultSets = (ResultSet) callableStatements.getObject(2);

            // Procesar los resultados
            while (resultSets.next()) {
                DistrictDTO dto = new DistrictDTO();
                dto.setCodigoDistrito(resultSets.getInt("CODIGODISTRITO"));
                dto.setNombreDistrito(resultSets.getString("NOMBRE"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching states", e);
        } finally {
            // Cerrar recursos
            try {
                if (resultSets != null) resultSets.close();
                if (callableStatements != null) callableStatements.close();
                if (connections != null) connections.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error closing resources", e);
            }
        }

        return lista;
    }
    
}