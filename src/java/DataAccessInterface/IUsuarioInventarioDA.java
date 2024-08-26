/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.InventarioProductosDTO;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar la informacion de inventario que verá el usuario final.
 */
public interface IUsuarioInventarioDA {
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener el html del inventario que estará viendo el usuario. 
    * @return retorna un html con el menu  del inventario que estará viendo el usuario. 
    */
    InventarioProductosDTO Get(); 
}