/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.SessionBL;
import BusinessLogic.VehiculoBL;
import BusinessLogicInterface.IVehiculoBL;
import Entities.Enums.TypeSessions;
import Entities.SessionDTO;
import Entities.VehiculoDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Servlet para el manejo de vehiculos. 
 * Este servlet gestiona las solicitudes GET para obtener datos de los vehiculos.
 */
@WebServlet(name = "VehiculoController", urlPatterns = {"/VehiculoController"})
public class VehiculoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IVehiculoBL vehiculoBL = new VehiculoBL();
    private SessionBL sessionBL = new SessionBL();

    /**
     * AR-003
     * @Author Horacio Porras 
     * Metodo encargado de ejecutar las acciones get para el registro del usuario en el sistema
     * @param request
     * @param response
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

        String UserCred = session.getCredential(); // Obtener la cedula del usuario desde la sesión

        if ("getVehiculo".equals(action)) {
            List<VehiculoDTO> vehiculo = vehiculoBL.GetById(UserCred);

            // Configurar el tipo de contenido de la respuesta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Convertir la lista de países a JSON
            String jsonResponse = gson.toJson(vehiculo);

            // Enviar la respuesta al cliente
            response.getWriter().write(jsonResponse);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de vehiculos.";
    }

}
