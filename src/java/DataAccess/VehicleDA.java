package DataAccess;

import DataAccessInterface.IVehicleDA;
import Entities.VehicleRequestDTO;
import Entities.VehicleResponseDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Autor: Andrés Alvarado
 * Id Requirement: AR-010
 * Creation Date: 08/19/2024   (MM/dd/YYYY)
 * Implementación de IVehicleDA que maneja operaciones de acceso a datos para la entidad VEHICULO.
 */
public class VehicleDA extends BaseConnectionDA implements IVehicleDA {

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Guarda un registro de vehículo y su relación con el cliente en la base de datos.
     * @param vehicle El DTO que contiene la información del vehículo y del cliente.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    @Override
    public boolean Save(VehicleRequestDTO vehicle) {
        try {
            connections = conectionDA.Get();            
            callableStatements = connections.prepareCall("{call USP_SaveVehicleAndClient(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatements.setString(1, vehicle.getPlacaVehiculoID());
            callableStatements.setString(2, vehicle.getVin());
            callableStatements.setString(3, vehicle.getMarca());
            callableStatements.setString(4, vehicle.getModelo());
            callableStatements.setInt(5, vehicle.getAno());
            callableStatements.setString(6, vehicle.getColor());
            callableStatements.setInt(7, vehicle.getAlDia());
            callableStatements.setBytes(8, vehicle.getTituloPropiedad());
            callableStatements.setInt(9, vehicle.getHabilitadoVehiculo());
            callableStatements.setString(10, vehicle.getCredencialID());
            callableStatements.setString(11, vehicle.getEditadoPor());
            callableStatements.setInt(12, vehicle.getHabilitadoCliente());
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources(); // Utiliza el método heredado para cerrar los recursos.
        }
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Actualiza un registro de vehículo y su relación con el cliente en la base de datos.
     * @param vehicle El DTO que contiene la información actualizada del vehículo.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    @Override
    public boolean Update(VehicleRequestDTO vehicle) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_UpdateVehicleAndClient(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatements.setString(1, vehicle.getPlacaVehiculoID());
            callableStatements.setString(2, vehicle.getVin());
            callableStatements.setString(3, vehicle.getMarca());
            callableStatements.setString(4, vehicle.getModelo());
            callableStatements.setInt(5, vehicle.getAno());
            callableStatements.setString(6, vehicle.getColor());
            callableStatements.setInt(7, vehicle.getAlDia());
            callableStatements.setBytes(8, vehicle.getTituloPropiedad());
            callableStatements.setInt(9, vehicle.getHabilitadoVehiculo());
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources(); // Utiliza el método heredado para cerrar los recursos.
        }
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Elimina un registro de vehículo y su relación con el cliente de la base de datos.
     * @param placaVehiculoID El ID del vehículo que se desea eliminar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    @Override
    public boolean Delete(String placaVehiculoID) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_DeleteVehicleAndClient(?)}");
            callableStatements.setString(1, placaVehiculoID);
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources(); // Utiliza el método heredado para cerrar los recursos.
        }
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Obtiene todos los registros de vehículos asociados a una credencial de cliente.
     * @param credencialID El ID de la credencial del cliente.
     * @return Una lista de DTOs de vehículos.
     */
    @Override
    public List<VehicleResponseDTO> GetAll(String credencialID) {
        List<VehicleResponseDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_GetAllVehiclesAndClientsByCredentialID(?, ?)}");
            callableStatements.setString(1, credencialID);
            callableStatements.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();

            try (ResultSet resultSet = (ResultSet) callableStatements.getObject(2)) {
                while (resultSet.next()) {
                    lista.add(mapToVehicleResponseDTO(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(); // Utiliza el método heredado para cerrar los recursos.
        }

        return lista;
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Obtiene un registro de vehículo por su ID de placa.
     * @param placaVehiculoID El ID del vehículo.
     * @return El DTO del vehículo, o null si no se encuentra.
     */
    @Override
    public VehicleResponseDTO GetVehicleByPlaca(String placaVehiculoID) {
        VehicleResponseDTO vehicle = null;

        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_GetVehiclesByPlaca(?, ?)}");
            callableStatements.setString(1, placaVehiculoID);
            callableStatements.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();

            try (ResultSet resultSet = (ResultSet) callableStatements.getObject(2)) {
                if (resultSet.next()) {
                    vehicle = mapToVehicleResponseDTO(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(); // Utiliza el método heredado para cerrar los recursos.
        }

        return vehicle;
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Mapea un ResultSet a un objeto VehicleResponseDTO.
     * @param resultSet El ResultSet con los datos del vehículo.
     * @return Un objeto VehicleResponseDTO con la información del vehículo.
     * @throws SQLException Si ocurre un error al obtener los datos del ResultSet.
     */
    private VehicleResponseDTO mapToVehicleResponseDTO(ResultSet resultSet) throws SQLException {
        VehicleResponseDTO vehicle = new VehicleResponseDTO();
        vehicle.setPlacaVehiculoID(resultSet.getString("PLACAVEHICULOID"));
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMarca(resultSet.getString("MARCA"));
        vehicle.setModelo(resultSet.getString("MODELO"));
        vehicle.setAno(resultSet.getInt("AÑO"));
        vehicle.setColor(resultSet.getString("COLOR"));
        vehicle.setAlDia(resultSet.getInt("ALDIA"));

        byte[] tituloPropiedad = resultSet.getBytes("TITULOPROPIEDAD");
        if (tituloPropiedad != null) {
            vehicle.setTituloPropiedad(Base64.getEncoder().encodeToString(tituloPropiedad));
        }      
        return vehicle;
    }
}
