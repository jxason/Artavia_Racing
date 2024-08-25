/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import BusinessLogic.AdminCitaBL;
import BusinessLogicInterface.IAdminCitaBL;
import DataAccess.CitaDA;  // Asegúrate de importar CitaDA
import Entities.CitaDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AR-XXX
 * Author: [Luis Solorzano Campos]
 * Servlet encargado de manejar las solicitudes AJAX relacionadas con la tabla CITAS.
 */
@WebServlet(name = "AdminCitaController", urlPatterns = {"/AdminCitaController"})
public class AdminCitaController extends HttpServlet {

    // Inicialización de adminCitaBL con una nueva instancia de CitaDA
    private IAdminCitaBL adminCitaBL = new AdminCitaBL(new CitaDA());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            /*if ("get".equals(method)) {
                int citaId = Integer.parseInt(request.getParameter("citaId"));
                CitaDTO cita = adminCitaBL.obtenerCitaPorId(citaId);
                out.write(new Gson().toJson(cita));
            } else */
            if ("getAll".equals(method)) {
                List<CitaDTO> citas = adminCitaBL.listarCitas();
                out.write(new Gson().toJson(Collections.singletonMap("citas", citas)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Método inválido")));
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Formato de número inválido")));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Se produjo un error: " + e.getMessage())));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            if ("save".equals(method) || "update".equals(method)) {
                int citaId = request.getParameter("citaId") != null && !request.getParameter("citaId").isEmpty()
                             ? Integer.parseInt(request.getParameter("citaId"))
                             : 0;
                String credencialId = request.getParameter("credencialId");
                String placaVehiculoId = request.getParameter("placaVehiculoId");
                String vin = request.getParameter("vin");
                int servicioId = Integer.parseInt(request.getParameter("servicioId"));
                int estadoCitaId = Integer.parseInt(request.getParameter("estadoCitaId"));
                Date fechaAgendada = Date.valueOf(request.getParameter("fechaAgendada"));
                String descripcion = request.getParameter("descripcion");
                String horaAgendada = request.getParameter("horaAgendada");
                String horaFinalizacion = request.getParameter("horaFinalizacion");

                CitaDTO cita = new CitaDTO();
                if (citaId > 0) {
                    cita.setCitaId(citaId);
                }
                cita.setCredencialId(credencialId);
                cita.setPlacaVehiculoId(placaVehiculoId);                
                cita.setServicioId(servicioId);
                cita.setEstadoCitaId(estadoCitaId);
                cita.setFechaAgendada(fechaAgendada);
                cita.setDescripcion(descripcion);
                cita.setHoraAgendada(horaAgendada);
                cita.setHoraFinalizacion(horaFinalizacion);

                boolean success;
                if ("save".equals(method)) {
                    success = adminCitaBL.agregarCita(cita);
                } else if ("update".equals(method)) {
                    success = adminCitaBL.actualizarCita(cita);
                } else {
                    success = false;
                }

                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else if ("delete".equals(method)) {
                int citaId = Integer.parseInt(request.getParameter("citaId"));
                boolean success = adminCitaBL.cancelarCita(citaId);
                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Método inválido")));
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Formato de número inválido")));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Se produjo un error: " + e.getMessage())));
        }
    }
}