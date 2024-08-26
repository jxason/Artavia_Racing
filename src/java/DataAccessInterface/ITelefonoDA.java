/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.TipoTelefonoDTO;
import java.util.List;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Interfaces encargada de administrar la información de los tipos de teléfono.
 */
public interface ITelefonoDA {
     /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros
     * Método encargado de obtener todos los tipos de teléfono desde la base de datos.
     * @return Lista de TipoTelefonoDTO con la información de los tipos de teléfono.
     */
     List<TipoTelefonoDTO> GetAll();
}
