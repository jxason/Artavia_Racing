package BusinessLogic;

import BusinessLogicInterface.IVehicleBL;
import DataAccess.VehicleDA;
import DataAccessInterface.IVehicleDA;
import Entities.VehicleRequestDTO;
import Entities.VehicleResponseDTO;
import java.util.List;

/**
 * Autor: Andrés Alvarado
 * Id Requirement: AR-010
 * Creation Date: 08/19/2024   (MM/dd/YYYY)
 * Clase encargada de implementar la lógica de negocio para la gestión de vehículos.
 */
public class VehicleBL implements IVehicleBL {

    private final IVehicleDA vehicleDA;

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Constructor que inicializa el acceso a datos de vehículos.
     */
    public VehicleBL() {
        vehicleDA = new VehicleDA();
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Implementación del método para guardar un nuevo vehículo.
     * @param vehicle VehicleRequestDTO con la información del vehículo.
     * @return boolean indicando si la operación fue exitosa.
     */
    @Override
    public boolean Save(VehicleRequestDTO vehicle) {
        return vehicleDA.Save(vehicle);
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Implementación del método para actualizar un vehículo existente.
     * @param vehicle VehicleRequestDTO con la información actualizada del vehículo.
     * @return boolean indicando si la operación fue exitosa.
     */
    @Override
    public boolean Update(VehicleRequestDTO vehicle) {
        return vehicleDA.Update(vehicle);
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Implementación del método para eliminar un vehículo por su ID de placa.
     * @param placaVehiculoID ID del vehículo a eliminar.
     * @return boolean indicando si la operación fue exitosa.
     */
    @Override
    public boolean Delete(String placaVehiculoID) {
        return vehicleDA.Delete(placaVehiculoID);
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Implementación del método para obtener todos los vehículos asociados a una credencial de cliente.
     * @param credencialID El ID de la credencial del cliente.
     * @return Lista de VehicleResponseDTO con la información de todos los vehículos.
     */
    @Override
    public List<VehicleResponseDTO> GetAll(String credencialID) {
        return vehicleDA.GetAll(credencialID);
    }

    /**
     * Autor: Andrés Alvarado
     * Id Requirement: AR-010
     * Creation Date: 08/19/2024   (MM/dd/YYYY)
     * Implementación del método para obtener un vehículo por su ID de placa.
     * @param placaVehiculoID ID del vehículo.
     * @return VehicleResponseDTO con la información del vehículo.
     */
    @Override
    public VehicleResponseDTO GetVehicleByPlaca(String placaVehiculoID) {
        return vehicleDA.GetVehicleByPlaca(placaVehiculoID);
    }
}
