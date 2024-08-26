package DataAccessInterface;

import Entities.VehicleRequestDTO;
import Entities.VehicleResponseDTO;
import java.util.List;

/**
 * Autor: Andrés Alvarado
 * Id Requirement: AR-010
 * Creation Date: 08/19/2024   (MM/dd/YYYY)
 * IVehicleDA es la interfaz que define las operaciones de acceso a datos para la entidad VEHICULO.
 * Incluye métodos para guardar, actualizar, eliminar, y obtener registros de vehículos y sus detalles.
 */
public interface IVehicleDA {

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Guarda un registro de vehículo y su relación con el cliente en la base de datos.
     * @param vehicle El DTO que contiene la información del vehículo y del cliente.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean Save(VehicleRequestDTO vehicle);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Actualiza un registro de vehículo y su relación con el cliente en la base de datos.
     * @param vehicle El DTO que contiene la información actualizada del vehículo.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean Update(VehicleRequestDTO vehicle);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Elimina un registro de vehículo y su relación con el cliente de la base de datos.
     * @param placaVehiculoID El ID del vehículo que se desea eliminar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean Delete(String placaVehiculoID);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Obtiene todos los registros de vehículos asociados a una credencial de cliente.
     * @param credencialID El ID de la credencial del cliente.
     * @return Una lista de DTOs de vehículos.
     */
    List<VehicleResponseDTO> GetAll(String credencialID);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Obtiene un registro de vehículo por su ID de placa.
     * @param placaVehiculoID El ID del vehículo.
     * @return El DTO del vehículo, o null si no se encuentra.
     */
    VehicleResponseDTO GetVehicleByPlaca(String placaVehiculoID);
}
