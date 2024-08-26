/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BusinessLogic.UsuarioBL;
import Entities.RequestUsuarioDTO;
import Entities.ResponseDTO;
import Entities.ResponseUsuarioDTO;
import Entities.SessionDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 * AR-001
 * Author: José Andrés Alvarado Matamoros
 * Servlet que maneja la autenticación de usuarios.
 * Recibe las credenciales del usuario, verifica su validez y devuelve una respuesta JSON.
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

     private static final long serialVersionUID = 1L;
    private UsuarioBL usuarioBL = new UsuarioBL(); // Instancia de la capa de lógica de negocio para usuarios

    /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros
     * Maneja las solicitudes POST para la autenticación de usuarios.
     * 
     * @param request La solicitud HTTP del cliente.
     * @param response La respuesta HTTP del servidor.
     * @throws ServletException Si ocurre un error en el procesamiento del servlet.
     * @throws IOException Si ocurre un error de entrada/salida durante el procesamiento.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Leer las credenciales del formulario
        String email = request.getParameter("email").toLowerCase();
        String password = request.getParameter("password");
        
        RequestUsuarioDTO Request= new RequestUsuarioDTO(email, password,session );
        // Verificar las credenciales del usuario
        ResponseDTO Response = usuarioBL.Verificar(Request);

        // Configurar el tipo de contenido de la respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Crear una instancia de Gson para convertir el resultado a JSON
        Gson gson = new Gson();
        String jsonResponse;

        // Crear una respuesta JSON indicando error
        jsonResponse = gson.toJson(Response);        

        // Enviar la respuesta JSON al cliente
        response.getWriter().write(jsonResponse);
    }
    /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros
     * Proporciona información descriptiva sobre este servlet.
     * 
     * @return Una cadena que describe el servlet, incluyendo su nombre, versión y autor.
     */
    @Override
    public String getServletInfo() {
        return "Servlet para manejar la autenticación de usuarios.";
    }

}
