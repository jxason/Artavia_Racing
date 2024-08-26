/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.CitaPorUsuarioBL;
import BusinessLogic.SessionBL;
import BusinessLogic.VehiculoPorClienteBL;
import Entities.Enums.TypeSessions;
import Entities.ResponseCitaPorUsuarioDTO;
import Entities.ResponseVehiculoPorClienteDTO;
import Entities.SessionDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author horac
 */
@WebServlet(name = "CitaPorUsuarioController", urlPatterns = {"/CitaPorUsuarioController"})
public class CitaPorUsuarioController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private CitaPorUsuarioBL citaUsuarioBL = new CitaPorUsuarioBL();
    private SessionBL sessionBL = new SessionBL();
    
    /**
     * AR-009
     * @Author Horacio Porras Marín
     * Metodo encargado de ejecutar las acciones GET  
     * @param request
     * @param response   
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession httpSession = request.getSession(); // Obtener la sesión HTTP
        SessionDTO session = sessionBL.Get(httpSession, TypeSessions.SESSION_USER);
        
        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User session is not valid.");
            return;
        }

        String cedulaUsuario = session.getCredential(); // Obtener el rol del usuario desde la sesión
        
        if ("getCitas".equals(action)) {
            List<ResponseCitaPorUsuarioDTO> citaUsuario = citaUsuarioBL.GetBy(cedulaUsuario);

            // Configurar el tipo de contenido de la respuesta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Convertir la lista de países a JSON
            String jsonResponse = gson.toJson(citaUsuario);

            // Enviar la respuesta al cliente
            response.getWriter().write(jsonResponse);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de citas.";
    }
    
}
