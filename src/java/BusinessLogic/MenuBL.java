/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IMenuBL;
import DataAccess.MenuDA;
import DataAccessInterface.IMenuDA;
import Entities.MenuDTO;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar el menu del usuario.
 */
public class MenuBL  implements  IMenuBL
{
    IMenuDA ObjDA;
    public MenuBL()
    {
        ObjDA= new MenuDA();
    }
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener el html del menu que se desplegará por rol del usuario.
    * @param RolId el rol del usuario en sesión
    * @return retorna un html con el menu del rol del usuario
    */
    @Override
    public MenuDTO Get(int RolId) 
    {
        return ObjDA.Get(RolId);
    }    
}