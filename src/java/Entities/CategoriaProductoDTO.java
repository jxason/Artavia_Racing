/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase Objeto encargado de obtener las categorias de los productos
 */
public class CategoriaProductoDTO {
    private int CodigoCategoriaProducto;
    private String CategoriaProducto;   

    public CategoriaProductoDTO(int CodigoCategoriaProducto, String CategoriaProducto) {
        this.CodigoCategoriaProducto = CodigoCategoriaProducto;
        this.CategoriaProducto = CategoriaProducto;
    }

    public CategoriaProductoDTO() {
    }

    public int getCodigoCategoriaProducto() {
        return CodigoCategoriaProducto;
    }

    public void setCodigoCategoriaProducto(int CodigoCategoriaProducto) {
        this.CodigoCategoriaProducto = CodigoCategoriaProducto;
    }

    public String getCategoriaProducto() {
        return CategoriaProducto;
    }

    public void setCategoriaProducto(String CategoriaProducto) {
        this.CategoriaProducto = CategoriaProducto;
    }
    
}
