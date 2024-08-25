/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import BusinessLogicInterface.ICitaBL;
import BusinessLogic.CitaBL;
import Entities.CitaAdminDTO;
import Entities.CitaDTO;
import Entities.DiagnosticoDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditarCitaController")
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

                    // Convertir el objeto CitaDTO a JSON
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
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            try {
                // Obtener los parámetros del formulario
                int citaId = Integer.parseInt(request.getParameter("citaId"));
                String Descripcion = request.getParameter("credencialId"); // aqui tiene que poner el id del nuevo campo que usted va a crear que se llama descripcion
                
                // Crear un objeto CitaDTO con los datos
                DiagnosticoDTO Request  = new DiagnosticoDTO (citaId,Descripcion );
                
                // Actualizar la cita
                boolean success = citaBL.agregarDiagnostico(Request);
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
                boolean success = citaBL.eliminarCita(citaId);
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
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
    }

    private static class Response {
        private boolean success;

        public Response(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
}