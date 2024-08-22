/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.ResponseVehiculoPorClienteDTO;
import java.util.List;

/**
 *
 * @author horac
 */
public interface IVehiculoPorClienteDA {
    List<ResponseVehiculoPorClienteDTO> GetBy(String cedulaUsuario);
}
