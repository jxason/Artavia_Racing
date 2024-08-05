package Controller;

import BusinessLogic.CountryBL;
import BusinessLogic.CountyBL;
import BusinessLogic.DistrictBL;
import BusinessLogic.StateBL;
import BusinessLogic.UserRegisterBL;
import Entities.ClienteDTO;
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
    private UserRegisterBL userRegisterBL= new  UserRegisterBL();
    /**
     * AR-001
     * @Author Andrés Alvarado Matamoros
     * Este método recupera los datos del formulario enviados a través de una solicitud HTTP POST, 
     * asigna los valores a un objeto {@link ClienteDTO} y luego puede ser utilizado para procesos adicionales, 
     * como la lógica de registro. Parsea y convierte los datos según sea necesario, incluyendo el manejo de 
     * campos opcionales y valores predeterminados.
     *
     * @param request el objeto HttpServletRequest que contiene la solicitud realizada por el cliente
     * @param response el objeto HttpServletResponse que contiene la respuesta que el servlet devuelve
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de entrada/salida al escribir la respuesta
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // Crear una instancia del DTO y asignar los valores directamente
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCredencialId(request.getParameter("credencialId"));
        clienteDTO.setNombre(request.getParameter("nombre"));
        clienteDTO.setPrimerApellido(request.getParameter("primerApellido"));
        clienteDTO.setSegundoApellido(request.getParameter("segundoApellido"));

        // Convertir la fecha de nacimiento si está presente
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        clienteDTO.setFechaNacimiento(fechaNacimientoStr != null ? java.sql.Date.valueOf(fechaNacimientoStr) : null);

        clienteDTO.setCorreoElectronico(request.getParameter("email"));
        clienteDTO.setContrasena(request.getParameter("contrasena"));
        clienteDTO.setNumeroTelefono(request.getParameter("numeroTelefono"));

        // Convertir y asignar valores numéricos
        clienteDTO.setCategoriaTelefonoId(parseIntOrDefault(request.getParameter("categoriaTelefonoId"), 0));
        clienteDTO.setNumeroExtension(parseIntOrDefault(request.getParameter("numeroExtension"), 0));
        clienteDTO.setDescripcionTelefono(request.getParameter("descripcionTelefono"));

        clienteDTO.setCodigoPais(parseIntOrDefault(request.getParameter("codigoPais"), 0));
        clienteDTO.setCodigoEstado(parseIntOrDefault(request.getParameter("codigoEstado"), 0));
        clienteDTO.setCodigoCondado(parseIntOrDefault(request.getParameter("codigoCondado"), 0));
        clienteDTO.setCodigoDistrito(parseIntOrDefault(request.getParameter("codigoDistrito"), 0));

        clienteDTO.setDescripcionDireccion(request.getParameter("descripcionDireccion"));

        String ResponseSaveUser= userRegisterBL.Save(clienteDTO);

        // Responder con éxito
        response.setContentType("application/json");
        response.getWriter().write(ResponseSaveUser);
    }
    /**
     * AR-001
     * @Author Andrés Alvarado Matamoros
     *  Método auxiliar para convertir una cadena a un entero, con valor predeterminado en caso de error o si es nulo    
     */    
    private int parseIntOrDefault(String value, int defaultValue) {
        try {
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * AR-001
     * @Author Andrés Alvarado Matamoros
     * Metodo encargado de ejecutar las acciones get para el registro del usuario en el sistema     
     * @param request
     * @param response     
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
