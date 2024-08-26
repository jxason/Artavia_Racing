package Entities;

import java.sql.Date;
import java.util.Base64;

/**
 * AR-006
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar los datos de respuesta de un producto.
 */
public class ProductoResponseDTO {
    private int productoId;
    private int categoriaProductoId;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private String editadoPor;
    private int habilitado;
    private Date fechaCreacion;
    private String imagen; // Cambiado de byte[] a String

    public ProductoResponseDTO(int productoId, int categoriaProductoId, String nombre, String descripcion, double precioUnitario, int cantidad, String editadoPor, int habilitado, Date fechaCreacion, byte[] imagen) {
        this.productoId = productoId;
        this.categoriaProductoId = categoriaProductoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.editadoPor = editadoPor;
        this.habilitado = habilitado;
        this.fechaCreacion = fechaCreacion;
        this.imagen = encodeToBase64(imagen); // Convertir el arreglo de bytes a base64
    }

    public ProductoResponseDTO() {
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCategoriaProductoId() {
        return categoriaProductoId;
    }

    public void setCategoriaProductoId(int categoriaProductoId) {
        this.categoriaProductoId = categoriaProductoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(String editadoPor) {
        this.editadoPor = editadoPor;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    // Método para convertir un arreglo de bytes en una cadena base64
    private String encodeToBase64(byte[] data) {
        if (data != null) {
            return Base64.getEncoder().encodeToString(data);
        }
        return null;
    }
}
