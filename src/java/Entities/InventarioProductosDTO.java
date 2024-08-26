/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

   /*
    * AZ-001
    * Autor: José Andrés Alvarado Matamoros.
    * En este contructore se le asigna la inicializaion de las variables del objeto.    
    * @param HtmlInventarioProductos Contiene el html del inventario a mostrar
    */
public class InventarioProductosDTO {
      String HtmlInventarioProductos;  

    public InventarioProductosDTO() {
    }

    public InventarioProductosDTO(String HtmlInventarioProductos) {
        this.HtmlInventarioProductos = HtmlInventarioProductos;
    }

    public String getHtmlInventarioProductos() {
        return HtmlInventarioProductos;
    }

    public void setHtmlInventarioProductos(String HtmlInventarioProductos) {
        this.HtmlInventarioProductos = HtmlInventarioProductos;
    }
    
   
}
