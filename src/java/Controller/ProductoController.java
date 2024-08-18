package Controller;

import BusinessLogic.IProductoBL;
import BusinessLogic.ProductoBL;
import Entities.ProductoRequestDTO;
import Entities.ProductoResponseDTO;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * AR-021
 * Author: Andrés Alvarado Matamoros
 * Servlet encargado de manejar las solicitudes AJAX relacionadas con la tabla PRODUCTO.
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
@MultipartConfig
public class ProductoController extends HttpServlet {

    private IProductoBL productoBL = new ProductoBL();

    /**
     * AR-022
     * Author: Andrés Alvarado Matamoros
     * Método encargado de manejar las solicitudes GET.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            if ("get".equals(method)) {
                int productoId = Integer.parseInt(request.getParameter("productoId"));
                ProductoResponseDTO producto = productoBL.Get(productoId);
                out.write(new Gson().toJson(producto));
            } else if ("getAll".equals(method)) {
                List<ProductoResponseDTO> productos = productoBL.GetAll();
                out.write(new Gson().toJson(Collections.singletonMap("products", productos)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid method")));
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid number format")));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write(new Gson().toJson(Collections.singletonMap("error", "An error occurred: " + e.getMessage())));
        }
    }

    /**
     * AR-023
     * Author: Andrés Alvarado Matamoros
     * Método encargado de manejar las solicitudes POST.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            if ("save".equals(method) || "update".equals(method)) {
                int productoId = request.getParameter("productoId") != null && !request.getParameter("productoId").isEmpty() 
                                 ? Integer.parseInt(request.getParameter("productoId")) 
                                 : 0;
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                double precioUnitario = Double.parseDouble(request.getParameter("precioUnitario"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                String editadoPor = request.getParameter("editadoPor");
                int habilitado = Integer.parseInt(request.getParameter("habilitado"));
                Date fechaCreacion = Date.valueOf(request.getParameter("fechaCreacion"));
                int CategoriaProducto = Integer.parseInt(request.getParameter("codigoCategoriaProductoId"));
                // Leer imagen
                Part imagenPart = request.getPart("imagen");
                byte[] imagen = null;
                if (imagenPart != null && imagenPart.getSize() > 0) {
                    try (InputStream inputStream = imagenPart.getInputStream();
                         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        imagen = outputStream.toByteArray();
                    }
                }

                ProductoRequestDTO producto = new ProductoRequestDTO();
                if (productoId > 0) {
                    producto.setProductoId(productoId);
                }
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecioUnitario(precioUnitario);
                producto.setCantidad(cantidad);
                producto.setEditadoPor(editadoPor);
                producto.setHabilitado(habilitado);
                producto.setFechaCreacion(fechaCreacion);
                producto.setImagen(imagen);
                producto.setCategoriaProductoId(CategoriaProducto);
                

                boolean success;
                if ("save".equals(method)) {
                    success = productoBL.Save(producto);
                } else if ("update".equals(method)) {
                    success = productoBL.Update(producto);
                } else {
                    success = false;
                }

                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else if ("delete".equals(method)) {
                int productoId = Integer.parseInt(request.getParameter("productoId"));
                boolean success = productoBL.Delete(productoId);
                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid method")));
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid number format")));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write(new Gson().toJson(Collections.singletonMap("error", "An error occurred: " + e.getMessage())));
        }
    }
}