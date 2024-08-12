/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.CategoriaProductoBL;
import BusinessLogicInterface.ICategoriaProductoBL;
import Entities.CategoriaProductoDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Servlet para el manejo de categorias de productos. 
 * Este servlet gestiona las solicitudes GET para obtener datos de la categoria de productos.
 */
@WebServlet(name = "CategoriaProductoController", urlPatterns = {"/CategoriaProductoController"})
public class CategoriaProductoController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private ICategoriaProductoBL categoriaProductoBL = new CategoriaProductoBL(); 

    /**
     * AR-001
     * @Author Andrés Alvarado Matamoros
     * Metodo encargado de ejecutar las acciones get para el registro del usuario en el sistema     
     * @param request
     * @param response     
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getCategoriasProducto".equals(action)) {
            List<CategoriaProductoDTO> categoriasProducto = categoriaProductoBL.GetAll();

            // Configurar el tipo de contenido de la respuesta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Convertir la lista de países a JSON
            String jsonResponse = gson.toJson(categoriasProducto);

            // Enviar la respuesta al cliente
            response.getWriter().write(jsonResponse);
       }
    }
    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de  categoria de productos.";
    }

}
