/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Base64;

/**
 *
 * @author fidelitas
 */
public class ProductosImagenesDTO {

    private String PlaceHolderName;  
    private String Imagen;

    public ProductosImagenesDTO() {
    }

    public ProductosImagenesDTO(String PlaceHolderName,byte[] Imagen) {
        this.PlaceHolderName = PlaceHolderName;
        this.Imagen = encodeToBase64(Imagen);
    }
  
    public String getPlaceHolderName() {
        return PlaceHolderName;
    }

    public void setPlaceHolderName(String PlaceHolderName) {
        this.PlaceHolderName = PlaceHolderName;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }
     // Método para convertir un arreglo de bytes en una cadena base64
    private String encodeToBase64(byte[] data) {
        if (data != null) {
            return Base64.getEncoder().encodeToString(data);
        }
        return null;
    }
}
