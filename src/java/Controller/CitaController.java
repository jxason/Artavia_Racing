/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.CitaBL;
import BusinessLogicInterface.ICitaBL;
import Entities.CitaDTO;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AR-003
 * @author Horacio Porras
 * Servlet para el manejo de citas. 
 * Este servlet gestiona las solicitudes GET para obtener datos de las citas.
 */
@WebServlet(name = "CitaController", urlPatterns = {"/CitaController"})
public class CitaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ICitaBL citaBL = new CitaBL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                mostrarFormulario(request, response);
                break;
            case "insert":
                insertarCita(request, response);
                break;
            case "edit":
                mostrarFormularioEdicion(request, response);
                break;
            case "update":
                actualizarCita(request, response);
                break;
            case "delete":
                cancelarCita(request, response);
                break;
            case "list":
            default:
                listarCitas(request, response);
                break;
        }
    }

    private void listarCitas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CitaDTO> listaCitas = citaBL.listarCitas();
        request.setAttribute("listaCitas", listaCitas);
        request.getRequestDispatcher("CitaLista.jsp").forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("CitaForm.jsp").forward(request, response);
    }

    private void insertarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CredencialId = request.getParameter("credencialId");
        String PlacaVehiculoId = request.getParameter("placaVehiculoId");
        String VIN = request.getParameter("vin");
        int ServicioId = Integer.parseInt(request.getParameter("servicioId"));
        int EstadoCitaId = Integer.parseInt(request.getParameter("estadoCitaId"));
        String FechaAgendadaSrt = request.getParameter("fechaAgendada");
        String Descripcion = request.getParameter("descripcion");
        String HoraAgendada = request.getParameter("horaAgendada");
        String HoraFinalizacion = request.getParameter("horaFinalizacion");
        String fechaStr = request.getParameter("fecha");

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date fechaAgendada = format.parse(FechaAgendadaSrt);
            CitaDTO nuevaCita = new CitaDTO(0, CredencialId, PlacaVehiculoId, VIN, ServicioId, EstadoCitaId, (Date) fechaAgendada, Descripcion, HoraAgendada, HoraFinalizacion);
            citaBL.agregarCita(nuevaCita);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("CitaController?action=list");
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCita = Integer.parseInt(request.getParameter("id"));
        CitaDTO cita = citaBL.obtenerCitaPorId(idCita);
        request.setAttribute("cita", cita);
        request.getRequestDispatcher("CitaForm.jsp").forward(request, response);
    }

    private void actualizarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int CitaId = Integer.parseInt(request.getParameter("citaId"));
        String CredencialId = request.getParameter("credencialId");
        String PlacaVehiculoId = request.getParameter("placaVehiculoId");
        String VIN = request.getParameter("vin");
        int ServicioId = Integer.parseInt(request.getParameter("servicioId"));
        int EstadoCitaId = Integer.parseInt(request.getParameter("estadoCitaId"));
        String FechaAgendadaSrt = request.getParameter("fechaAgendada");
        String Descripcion = request.getParameter("descripcion");
        String HoraAgendada = request.getParameter("horaAgendada");
        String HoraFinalizacion = request.getParameter("horaFinalizacion");
        String fechaStr = request.getParameter("fecha");

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date fechaAgendada = format.parse(FechaAgendadaSrt);
            CitaDTO cita = new CitaDTO(CitaId, CredencialId, PlacaVehiculoId, VIN, ServicioId, EstadoCitaId, (Date) fechaAgendada, Descripcion, HoraAgendada, HoraFinalizacion);
            citaBL.actualizarCita(cita);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("CitaController?action=list");
    }

    private void cancelarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCita = Integer.parseInt(request.getParameter("id"));
        citaBL.cancelarCita(idCita);
        response.sendRedirect("CitaController?action=list");
    }
}
