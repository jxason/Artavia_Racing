/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

 
import BusinessLogic.UsuarioInventarioBL;
import BusinessLogicInterface.IUsuarioInventarioBL;
import Entities.InventarioProductosDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

/**
 * AR-021
 * Author: Andrés Alvarado Matamoros
 * Servlet encargado de manejar las solicitudes AJAX relacionadas con la tabla UsuarioInventario.
 */
@WebServlet(name = "UsuarioInventarioController", urlPatterns = {"/UsuarioInventarioController"})
@MultipartConfig
public class UsuarioInventarioController extends HttpServlet {    
    private IUsuarioInventarioBL usuarioInventarioBL = new UsuarioInventarioBL();

   
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
                InventarioProductosDTO inventarioProductosDTO = usuarioInventarioBL.Get();
                out.write(new Gson().toJson(inventarioProductosDTO));
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
