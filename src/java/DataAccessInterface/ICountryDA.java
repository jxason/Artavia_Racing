/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.CountryDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar informacion del Pais
 */
public interface ICountryDA {
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion de los Paises     
    * @return 
    */
    List<CountryDTO> GetAll();    
}
