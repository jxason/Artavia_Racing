/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DataAccess;

import DataAccessInterface.IVehiculoDA;
import Entities.VehiculoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Class encargada de administrar los vehiculos
 */
public class VehiculoDA extends BaseConnectionDA implements IVehiculoDA {
    private static final Logger logger = Logger.getLogger(VehiculoDA.class.getName());

    @Override
    public List<VehiculoDTO> GetById(String UserCred) {
        List<VehiculoDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            callableStatements = connections.prepareCall("{call USP_SeleccionarVehiculo(?)}");
            callableStatements.setString(1, UserCred);
            callableStatements.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();

            resultSets = (ResultSet) callableStatements.getObject(1);
            while (resultSets.next()) {
                VehiculoDTO dto = new VehiculoDTO();
                dto.setPlacaVehiculoId(resultSets.getString("PLACAVEHICULOID"));
                dto.setVinVehiculo(resultSets.getString("VIN"));
                dto.setMarcaVehiculo(resultSets.getString("MARCA"));
                dto.setModeloVehiculo(resultSets.getString("MODELO"));
                dto.setAnyoVehiculo(resultSets.getInt("AÑO"));
                dto.setColorVehiculo(resultSets.getString("COLOR"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching vehicles", e);
        } finally {
            closeResources();
        }
        return lista;
    }

}
