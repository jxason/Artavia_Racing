/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IServicioDA;
import Entities.ServicioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Clase encargada de administrar los servicios
 */
public class ServicioDA extends BaseConnectionDA implements IServicioDA {

    private static final Logger logger = Logger.getLogger(ServicioDA.class.getName());

    @Override
    public List<ServicioDTO> GetBy(int CodigoCategoriaServicio) {
        List<ServicioDTO> lista = new ArrayList<>();
        
        try {
            // Establecer la conexión
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            // Preparar el procedimiento almacenado
            callableStatements = connections.prepareCall("{call USP_SeleccionarServicio(?,?)}");
            callableStatements.setInt(1, CodigoCategoriaServicio);
            callableStatements.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);

            // Ejecutar el procedimiento almacenado
            callableStatements.execute();

            // Obtener el cursor de resultados
            resultSets = (ResultSet) callableStatements.getObject(2);

            // Procesar los resultados
            while (resultSets.next()) {
                ServicioDTO dto = new ServicioDTO();
                int precio = resultSets.getInt("PRECIO");
                int tiempo = resultSets.getInt("TIEMPOSERVICIO");
                String mensajePersonalizado = tiempo == 1? Integer.toString(tiempo) + " hora":Integer.toString(tiempo) + " horas";
                dto.setCodigoServicio(resultSets.getInt("SERVICIOID"));
                dto.setNombreServicio(resultSets.getString("NOMBRE") + " | Precio: " + "₡" + Integer.toString(precio)  + " | Tiempo Estimado: " + mensajePersonalizado);
                dto.setPrecioServicio(resultSets.getInt("PRECIO"));
                dto.setTiempoServicio(resultSets.getInt("TIEMPOSERVICIO"));
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
