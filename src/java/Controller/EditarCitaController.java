/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.CitaBL;
import BusinessLogicInterface.ICitaBL;
import Entities.CitaAdminDTO;
import Entities.DiagnosticoDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fidelitas
 */
@WebServlet(name = "EditarCitaController", urlPatterns = {"/EditarCitaController"})
@MultipartConfig
public class EditarCitaController extends HttpServlet {

    private ICitaBL citaBL;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar la lógica de negocio
        citaBL = new CitaBL();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("get".equals(action)) {
            String idCitaParam = request.getParameter("id");
            if (idCitaParam != null && !idCitaParam.isEmpty()) {
                try {
                    int idCita = Integer.parseInt(idCitaParam);
                    CitaAdminDTO cita = citaBL.obtenerCitaPorId(idCita);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    // Convertir el objeto CitaAdminDTO a JSON
                    String jsonResponse = new Gson().toJson(cita);
                    PrintWriter out = response.getWriter();
                    out.print(jsonResponse);
                    out.flush();
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de ID inválido");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de cita no proporcionado");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("method");
        if ("save".equals(action)) {
            try {
                // Obtener los parámetros del formulario
                String descripcion = request.getParameter("descripcion");
                int citaId = Integer.parseInt(request.getParameter("citaId"));

                // Crear un objeto DiagnosticoDTO con los datos
                DiagnosticoDTO diagnosticoRequest = new DiagnosticoDTO(citaId, descripcion);

                // Guardar el diagnóstico
                boolean success = citaBL.agregarDiagnostico(diagnosticoRequest);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Enviar una respuesta en formato JSON
                PrintWriter out = response.getWriter();
                out.print(new Gson().toJson(new Response(success)));
                out.flush();
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de datos inválido");
            }
        } else if ("delete".equals(action)) {
            try {
                int citaId = Integer.parseInt(request.getParameter("citaId"));
                boolean success = citaBL.cancelarCita(citaId);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Enviar una respuesta en formato JSON
                PrintWriter out = response.getWriter();
                out.print(new Gson().toJson(new Response(success)));
                out.flush();
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de ID inválido");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Método no válido");
        }
    }

    // Clase interna para la respuesta JSON
    private class Response {
        private boolean success;

        public Response(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
