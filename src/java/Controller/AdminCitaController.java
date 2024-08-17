/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import BusinessLogic.CitaBL;
import BusinessLogicInterface.ICitaBL;
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

    private ICitaBL citaBL = new CitaBL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            if ("get".equals(method)) {
                int citaId = Integer.parseInt(request.getParameter("citaId"));
                CitaDTO cita = citaBL.obtenerCitaPorId(citaId);
                out.write(new Gson().toJson(cita));
            } else if ("getAll".equals(method)) {
                List<CitaDTO> citas = citaBL.listarCitas();
                out.write(new Gson().toJson(Collections.singletonMap("citas", citas)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid method")));
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid number format")));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write(new Gson().toJson(Collections.singletonMap("error", "An error occurred: " + e.getMessage())));
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
                String CredencialId = request.getParameter("credencialId");
                String PlacaVehiculoId = request.getParameter("placaVehiculoId");
                String VIN = request.getParameter("vin");
                int ServicioId = Integer.parseInt(request.getParameter("servicioId"));
                int EstadoCitaId = Integer.parseInt(request.getParameter("estadoCitaId"));
                Date FechaAgendada = Date.valueOf(request.getParameter("fechaAgendada"));
                String Descripcion = request.getParameter("descripcion");
                String HoraAgendada = request.getParameter("horaAgendada");
                String HoraFinalizacion = request.getParameter("horaFinalizacion");

                CitaDTO cita = new CitaDTO();
                if (citaId > 0) {
                    cita.setCitaId(citaId);
                }
                cita.setCredencialId(CredencialId);
                cita.setPlacaVehiculoId(PlacaVehiculoId);
                cita.setVIN(VIN);
                cita.setServicioId(ServicioId);
                cita.setEstadoCitaId(EstadoCitaId);
                cita.setFechaAgendada(FechaAgendada);
                cita.setDescripcion(Descripcion);
                cita.setHoraAgendada(HoraAgendada);
                cita.setHoraFinalizacion(HoraFinalizacion);

                boolean success;
                if ("save".equals(method)) {
                    success = citaBL.agregarCita(cita);
                } else if ("update".equals(method)) {
                    success = citaBL.actualizarCita(cita);
                } else {
                    success = false;
                }

                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else if ("delete".equals(method)) {
                int citaId = Integer.parseInt(request.getParameter("citaId"));
                boolean success = citaBL.cancelarCita(citaId);
                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid method")));
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