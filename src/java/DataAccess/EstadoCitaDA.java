/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DataAccess;

import DataAccessInterface.IEstadoCitaDA;
import Entities.EstadoCitaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AR-003
 * @Author: Horacio Porras Marín 
 * Clase encargada de administrar los estados de cita
 */
public class EstadoCitaDA extends BaseConnectionDA implements IEstadoCitaDA {
    private static final Logger logger = Logger.getLogger(EstadoCitaDA.class.getName());
    
    @Override
    public List<EstadoCitaDTO> GetAll() {
        List<EstadoCitaDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            callableStatements = connections.prepareCall("{call USP_SeleccionarEstadoCita(?)}");
            callableStatements.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();

            resultSets = (ResultSet) callableStatements.getObject(1);
            while (resultSets.next()) {
                EstadoCitaDTO dto = new EstadoCitaDTO();
                dto.setEstadoCitaId(resultSets.getInt("ESTADOCITAID"));
                dto.setEstadoCita(resultSets.getString("ESTADO"));
                dto.setDescripcionCita(resultSets.getString("DESCRIPCION"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching status" + e.getMessage(), e);
        } finally {
            closeResources();
        }
        
        return lista;
    }

}
