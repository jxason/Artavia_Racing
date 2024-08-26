package Controller;

import BusinessLogic.SessionBL;
import BusinessLogic.VehicleBL;
import BusinessLogicInterface.IVehicleBL;
import Entities.Enums.TypeSessions;
import Entities.SessionDTO;
import Entities.VehicleRequestDTO;
import Entities.VehicleResponseDTO;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * AR-010
 * Author: Andrés Alvarado
 * Servlet encargado de manejar las solicitudes AJAX relacionadas con la tabla VEHICLE.
 */
@WebServlet(name = "VehicleController", urlPatterns = {"/VehicleController"})
@MultipartConfig
public class VehicleController extends HttpServlet {

    private SessionBL sessionBL = new SessionBL();
    private IVehicleBL vehicleBL = new VehicleBL();

    /**
     * AR-011
     * Author: Andrés Alvarado
     * Método encargado de manejar las solicitudes GET.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            if ("get".equals(method)) {
                String placaVehiculoID = request.getParameter("placaVehiculoID");
                VehicleResponseDTO vehicle = vehicleBL.GetVehicleByPlaca(placaVehiculoID);
                out.write(new Gson().toJson(vehicle));
            } else if ("getAll".equals(method)) {
                HttpSession httpSession = request.getSession();
                SessionDTO session = sessionBL.Get(httpSession, TypeSessions.SESSION_USER);
                if (session == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User session is not valid.");
                    return;
                }
                String credentialID = session.getCredential();
                List<VehicleResponseDTO> vehicles = vehicleBL.GetAll(credentialID);
                out.write(new Gson().toJson(Collections.singletonMap("vehicles", vehicles)));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write(new Gson().toJson(Collections.singletonMap("error", "Invalid method")));
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write(new Gson().toJson(Collections.singletonMap("error", "An error occurred: " + e.getMessage())));
        }
    }

    /**
     * AR-012
     * Author: Andrés Alvarado
     * Método encargado de manejar las solicitudes POST.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();
        SessionDTO session = sessionBL.Get(httpSession, TypeSessions.SESSION_USER);
        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User session is not valid.");
            return;
        }
        String credentialID = session.getCredential();
        try {
            if ("save".equals(method) || "update".equals(method)) {
                String placaVehiculoID = request.getParameter("placaVehiculoID");
                String vin = request.getParameter("vin");
                String marca = request.getParameter("marca");
                String modelo = request.getParameter("modelo");
                int ano = Integer.parseInt(request.getParameter("ano"));
                String color = request.getParameter("color");
                int alDia =  Integer.parseInt(request.getParameter("alDia"));
                String editadoPor ="000000001";
                int habilitadoVehiculo = 1;

                // Leer imagen
                Part imagePart = request.getPart("tituloPropiedad");
                byte[] tituloPropiedad = null;
                if (imagePart != null && imagePart.getSize() > 0) {
                    try (InputStream inputStream = imagePart.getInputStream();
                         ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        tituloPropiedad = outputStream.toByteArray();
                    }
                }

                VehicleRequestDTO vehicle = new VehicleRequestDTO();
                vehicle.setPlacaVehiculoID(placaVehiculoID);
                vehicle.setVin(vin);
                vehicle.setMarca(marca);
                vehicle.setModelo(modelo);
                vehicle.setAno(ano);
                vehicle.setColor(color);
                vehicle.setAlDia(alDia);
                vehicle.setTituloPropiedad(tituloPropiedad);
                vehicle.setHabilitadoVehiculo(habilitadoVehiculo);
                vehicle.setEditadoPor(editadoPor);
                vehicle.setCredencialID(credentialID);

                boolean success;
                if ("save".equals(method)) {
                    success = vehicleBL.Save(vehicle);
                } else if ("update".equals(method)) {
                    success = vehicleBL.Update(vehicle);
                } else {
                    success = false;
                }

                out.write(new Gson().toJson(Collections.singletonMap("success", success)));
            } else if ("delete".equals(method)) {
                String placaVehiculoID = request.getParameter("placaVehiculoID");
                boolean success = vehicleBL.Delete(placaVehiculoID);
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
