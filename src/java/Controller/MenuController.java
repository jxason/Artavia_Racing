/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.MenuBL;
import BusinessLogic.SessionBL;
import Entities.Enums.TypeSessions;
import Entities.MenuDTO;
import Entities.SessionDTO;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Servlet para el manejo de menús. 
 * Este servlet gestiona las solicitudes GET para obtener datos del menú del usuario.
 */
@WebServlet(name = "MenuController", urlPatterns = {"/MenuController"})
public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MenuBL menuBL = new MenuBL();
    private SessionBL sessionBL = new SessionBL();

    /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros 
     * Método encargado de manejar las solicitudes GET para el manejo del menú.
     * 
     * @param request La solicitud HTTP del cliente.
     * @param response La respuesta HTTP del servidor.
     * @throws ServletException Si ocurre un error en el procesamiento del servlet.
     * @throws IOException Si ocurre un error de entrada/salida durante el procesamiento.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession httpSession = request.getSession(); // Obtener la sesión HTTP
        SessionDTO session = sessionBL.Get(httpSession, TypeSessions.SESSION_USER);
        
        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User session is not valid.");
            return;
        }

        int RolUser = session.getRol(); // Obtener el rol del usuario desde la sesión
        String action = request.getParameter("action");
        
        if ("getMenu".equals(action)) {
            MenuDTO menu = menuBL.Get(RolUser);

            // Configurar el tipo de contenido de la respuesta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Crear una instancia de Gson para convertir el objeto a JSON
            Gson gson = new Gson();

            // Convertir el objeto MenuDTO a una cadena JSON
            String jsonResponse = gson.toJson(menu);

            // Enviar la respuesta JSON al cliente
            response.getWriter().write(jsonResponse);
        } 
    }

    /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros 
     * Proporciona información descriptiva sobre este servlet.
     * 
     * @return Una cadena que describe el servlet, incluyendo su nombre, versión y autor.
     */
    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos del menú.";
    }
}
