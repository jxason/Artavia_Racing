/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AZ-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de administrar el menu del sitio.
 */
public class MenuDTO 
{
    String HtmlMenu;    
   /**
     * AZ-001
     * Autor: José Andrés Alvarado Matamoros.
     * En este contructore se le asigna la inicializaion de las variables del objeto.    
     * @param HtmlMenu Contiene el html de menu de acuerdo al rol que se le envio
     */
    public MenuDTO(String HtmlMenu) {
        this.HtmlMenu = HtmlMenu;
    }

    public MenuDTO() {
    }

    public String getHtmlMenu() {
        return HtmlMenu;
    }

    public void setHtmlMenu(String HtmlMenu) {
        this.HtmlMenu = HtmlMenu;
    }
 
     
    
}
