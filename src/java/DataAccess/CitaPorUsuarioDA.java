/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DataAccess;

import DataAccessInterface.ICitaPorUsuarioDA;
import Entities.ResponseCitaPorUsuarioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author: Horacio Porras
 */
public class CitaPorUsuarioDA extends BaseConnectionDA implements ICitaPorUsuarioDA{

    private static final Logger logger = Logger.getLogger(CitaPorUsuarioDA.class.getName());
    
    @Override
    public List<ResponseCitaPorUsuarioDTO> GetBy(String cedulaUsuario) {
        List<ResponseCitaPorUsuarioDTO> lista = new ArrayList<>();
        
        try {
            // Establecer la conexión
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            // Preparar el procedimiento almacenado
            callableStatements = connections.prepareCall("{call USP_Listar_Citas(?,?)}");
            callableStatements.setString(1, cedulaUsuario);
            callableStatements.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);

            // Ejecutar el procedimiento almacenado
            callableStatements.execute();

            // Obtener el cursor de resultados
            resultSets = (ResultSet) callableStatements.getObject(2);

            // Procesar los resultados
            while (resultSets.next()) {
                ResponseCitaPorUsuarioDTO dto = new ResponseCitaPorUsuarioDTO();
                dto.setPlacaVehiculo(resultSets.getString("PLACAVEHICULOID"));
                dto.setNombreVehiculo(resultSets.getString("VEHICULO"));
                dto.setNombreCategoria(resultSets.getString("CATEGORIA"));
                dto.setNombreServicio(resultSets.getString("SERVICIO"));
                dto.setFechaAgendada(resultSets.getString("FECHAAGENDADA"));
                dto.setHoraAgendada(resultSets.getString("HORAAGENDADA"));
                dto.setEstadoCita(resultSets.getString("ESTADOCITAID"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching services", e);
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
