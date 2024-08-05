package Controller;

import BusinessLogic.CountryBL;
import BusinessLogic.CountyBL;
import BusinessLogic.DistrictBL;
import BusinessLogic.StateBL;
import Entities.CountryDTO;
import Entities.CountyDTO;
import Entities.DistrictDTO;
import Entities.StateDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserRegisterController", urlPatterns = {"/UserRegisterController"})
public class UserRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CountryBL countryBL = new CountryBL(); 
    private StateBL stateBL= new StateBL();
    private CountyBL  countyBL= new  CountyBL();
    private DistrictBL  districtBL= new  DistrictBL();
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los datos del formulario enviados por AJAX
        String credencialId = request.getParameter("credencialId");
        String nombre = request.getParameter("nombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String categoriaTelefonoId = request.getParameter("categoriaTelefonoId");
        String numeroExtension = request.getParameter("numeroExtension");
        String descripcionTelefono = request.getParameter("descripcionTelefono");
        String codigoPais = request.getParameter("codigoPais");
        String codigoEstado = request.getParameter("codigoEstado");
        String codigoCondado = request.getParameter("codigoCondado");
        String codigoDistrito = request.getParameter("codigoDistrito");
        String descripcionDireccion = request.getParameter("descripcionDireccion");

        // Aquí puedes hacer lo que quieras con los datos, como enviarlos a otro sistema
        // Por ahora, solo respondemos con un éxito para probar que todo está funcionando.

        response.setContentType("application/json");
        response.getWriter().write("{\"success\": true, \"message\": \"Datos recibidos correctamente.\"}");
    }
    
    /**
     * AR-001
     * @Author Andrés Alvarado Matamoros
     * Metodo encargado de ejecutar las acciones get para el registro del usuario en el sistema     
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getCountries".equals(action)) {
            List<CountryDTO> countries = countryBL.GetAll();

            // Configurar el tipo de contenido de la respuesta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Convertir la lista de países a JSON
            String jsonResponse = gson.toJson(countries);

            // Enviar la respuesta al cliente
            response.getWriter().write(jsonResponse);

        } else if ("getStates".equals(action)) {
            // Obtener el parámetro 'codigoPais' de la solicitud
            String codigoPaisParam = request.getParameter("codigoPais");

            // Verificar si 'codigoPais' no es nulo y no está vacío
            if (codigoPaisParam != null && !codigoPaisParam.trim().isEmpty()) {
                try {
                    // Convertir el parámetro 'codigoPais' a entero
                    int codigoPais = Integer.parseInt(codigoPaisParam);

                    // Obtener la lista de estados usando el Business Logic
                    List<StateDTO> listStates = stateBL.GetAll(codigoPais);

                    // Configurar el tipo de contenido de la respuesta
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    // Crear una instancia de Gson
                    Gson gson = new Gson();

                    // Convertir la lista de estados a JSON
                    String jsonResponse = gson.toJson(listStates);

                    // Enviar la respuesta al cliente
                    response.getWriter().write(jsonResponse);

                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de país no válido.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de país no proporcionado o inválido.");
            }
        } else if ("getCondados".equals(action)) {
            // Obtener el parámetro 'codigoEstado' de la solicitud
            String codigoEstadoParam = request.getParameter("codigoEstado");

            // Verificar si 'codigoPais' no es nulo y no está vacío
            if (codigoEstadoParam != null && !codigoEstadoParam.trim().isEmpty()) {
                try {
                    // Convertir el parámetro 'codigoEstado' a entero
                    int codigoEstado = Integer.parseInt(codigoEstadoParam);

                    // Obtener la lista de condados usando el Business Logic
                    List<CountyDTO> listCondados = countyBL.GetAll(codigoEstado);

                    // Configurar el tipo de contenido de la respuesta
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    // Crear una instancia de Gson
                    Gson gson = new Gson();

                    // Convertir la lista de condados a JSON
                    String jsonResponse = gson.toJson(listCondados);

                    // Enviar la respuesta al cliente
                    response.getWriter().write(jsonResponse);

                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de estado no válido.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de estado no proporcionado o inválido.");
            }
        }else if ("getDistritos".equals(action)) {
            // Obtener el parámetro 'codigoCondado' de la solicitud
            String codigoCondadoParam = request.getParameter("codigoCondado");

            // Verificar si 'codigoPais' no es nulo y no está vacío
            if (codigoCondadoParam != null && !codigoCondadoParam.trim().isEmpty()) {
                try {
                    // Convertir el parámetro 'codigoCondado' a entero
                    int codigoCondado = Integer.parseInt(codigoCondadoParam);

                    // Obtener la lista de distritos usando el Business Logic
                    List<DistrictDTO> listDistritos = districtBL.GetAll(codigoCondado);

                    // Configurar el tipo de contenido de la respuesta
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    // Crear una instancia de Gson
                    Gson gson = new Gson();

                    // Convertir la lista de condados a JSON
                    String jsonResponse = gson.toJson(listDistritos);

                    // Enviar la respuesta al cliente
                    response.getWriter().write(jsonResponse);

                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de condado no válido.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de condado no proporcionado o inválido.");
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de registro de usuario.";
    }
}
