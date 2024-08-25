package BusinessLogicInterface;

import Entities.VehicleRequestDTO;
import Entities.VehicleResponseDTO;
import java.util.List;

/**
 * Autor: Andrés Alvarado
 * Id Requirement: AR-010
 * Creation Date: 08/19/2024   (MM/dd/YYYY)
 * Interfaz que define las operaciones de negocio para gestionar vehículos.
 */
public interface IVehicleBL {

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Método para guardar un nuevo vehículo.
     * @param vehicle VehicleRequestDTO con la información del vehículo.
     * @return boolean indicando si la operación fue exitosa.
     */
    boolean Save(VehicleRequestDTO vehicle);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Método para actualizar un vehículo existente.
     * @param vehicle VehicleRequestDTO con la información actualizada del vehículo.
     * @return boolean indicando si la operación fue exitosa.
     */
    boolean Update(VehicleRequestDTO vehicle);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Método para eliminar un vehículo por su ID de placa.
     * @param placaVehiculoID ID del vehículo a eliminar.
     * @return boolean indicando si la operación fue exitosa.
     */
    boolean Delete(String placaVehiculoID);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Método para obtener todos los vehículos asociados a una credencial de cliente.
     * @param credencialID El ID de la credencial del cliente.
     * @return Lista de VehicleResponseDTO con la información de todos los vehículos.
     */
    List<VehicleResponseDTO> GetAll(String credencialID);

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Método para obtener un vehículo por su ID de placa.
     * @param placaVehiculoID ID del vehículo.
     * @return VehicleResponseDTO con la información del vehículo.
     */
    VehicleResponseDTO GetVehicleByPlaca(String placaVehiculoID);
}