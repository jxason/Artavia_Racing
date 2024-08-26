/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IStateBL;
import DataAccess.StateDA;
import DataAccessInterface.IStateDA;
import Entities.StateDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar informacion del Estado por Pais
 */
public class StateBL implements IStateBL
{   
   IStateDA stateDA;
    
    public StateBL()
    {
        stateDA = new StateDA();
    }
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda la informacion del Estado de los paises.
    * @param CodigoPais
    * @return 
    */
    @Override
    public List<StateDTO> GetAll(int CodigoPais) {
         return stateDA.GetAll(CodigoPais);
    }    
}
