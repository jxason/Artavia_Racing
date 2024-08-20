/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.ServicioBL;
import BusinessLogicInterface.IServicioBL;
import Entities.ServicioDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AR-003 Author: Horacio Porras Marín
 * Servlet para el manejo de servicios. Este servlet gestiona las solicitudes GET para obtener datos del servicio.
 */
@WebServlet(name = "ServicioController", urlPatterns = {"/ServicioController"})
public class ServicioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IServicioBL servicioBL = new ServicioBL();

    /**
     * AR-003
     *
     * @Author Horacio Porras
     * Servlet para el manejo de servicios. Este servlet gestiona las solicitudes GET para obtener datos de los servicios.
     * @param request
     * @param response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getServicios".equals(action)) {
            // Obtener el parámetro 'codigoCategoriaServicio' de la solicitud
            String codigoCategoriaParam = request.getParameter("codigoCategoriaServicio");

            // Verificar si 'codigoCategoriaServicio' no es nulo y no está vacío
            if (codigoCategoriaParam != null && !codigoCategoriaParam.trim().isEmpty()) {
                try {
                    // Convertir el parámetro 'codigoCategoriaServicio' a entero
                    int codigoCategoriaServicio = Integer.parseInt(codigoCategoriaParam);

                    // Obtener la lista de estados usando el Business Logic
                    List<ServicioDTO> listServicios = servicioBL.GetBy(codigoCategoriaServicio);

                    // Configurar el tipo de contenido de la respuesta
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    // Crear una instancia de Gson
                    Gson gson = new Gson();

                    // Convertir la lista de estados a JSON
                    String jsonResponse = gson.toJson(listServicios);

                    // Enviar la respuesta al cliente
                    response.getWriter().write(jsonResponse);

                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de categoría no válido.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de categoría no proporcionado o inválido.");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de servicios.";
    }

}
