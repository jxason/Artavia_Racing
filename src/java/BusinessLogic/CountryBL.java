/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.ICountryBL;
import DataAccess.CountryDA;
import DataAccessInterface.ICountryDA;
import Entities.CountryDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar informacion del Pais
 */
public class CountryBL implements ICountryBL
{
    ICountryDA countryDA;
    
    public CountryBL()
    {
        countryDA = new CountryDA();
    }
   /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion de los Paises     
    * @return 
    */
    @Override
    public List<CountryDTO> GetAll() {
       return countryDA.GetAll();
    }
    
}
