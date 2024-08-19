/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.EstadoCitaBL;
import BusinessLogicInterface.IEstadoCitaBL;
import Entities.EstadoCitaDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AR-003
 * @author Horacio Porras
 * Servlet para el manejo de estados de cita. 
 * Este servlet gestiona las solicitudes GET para obtener datos de los estados de cita.
 */
@WebServlet(name = "EstadoCitaController", urlPatterns = {"/EstadoCitaController"})
public class EstadoCitaController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private IEstadoCitaBL estadoCitaBL = new EstadoCitaBL();

    /**
     * AR-003
     * @Author Horacio Porras Marín
     * Metodo encargado de ejecutar las acciones GET
     * @param request
     * @param response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getServicio".equals(action)) {
            List<EstadoCitaDTO> estado = estadoCitaBL.GetAll();

            // Configurar el tipo de contenido de la respuesta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Convertir la lista de países a JSON
            String jsonResponse = gson.toJson(estado);

            // Enviar la respuesta al cliente
            response.getWriter().write(jsonResponse);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de servicios.";
    }
}
