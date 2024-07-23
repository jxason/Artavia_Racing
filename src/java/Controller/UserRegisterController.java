package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserRegisterController", urlPatterns = {"/UserRegisterController"})
public class UserRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

    @Override
    public String getServletInfo() {
        return "Servlet para procesar datos de registro de usuario.";
    }
}
