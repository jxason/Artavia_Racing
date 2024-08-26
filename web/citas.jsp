<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, oracle.jdbc.OracleTypes"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión de Citas</title>
   <!-- Estilos CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">  
</head>
<body>
    <div id="menu-container">
        <!-- Menú se cargará aquí -->
    </div>
    
    <div class="container">
        <h2 class="text-center mt-4">Gestión de Citas</h2>
        
        
        <!-- Tabla de Citas -->
        <table id="citasTable" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>CitaID</th>
                    <th>Fecha Agendada</th>
                    <th>Hora Agendada</th>
                    <th>Placa del Vehículo</th>
                    <th>Detalle del Vehículo</th>
                    <th>Cliente</th>
                    <th>Categoria Servicio</th>
                    <th>Servicio</th>
                    <th>Estado</th>
                    <th>Comentario Cliente</th> <!-- Nueva columna para la placa -->
                    <th>Diagnostico</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    /*  Por hacer: esta conexion no cumple con el estandar propuesto por los compañeros de equipo
                        Esto fue desarrollado por el compañero Luis, y tuvo que haber sido implementado con
                        sus respectivas clases de DTO, DA, Interface DA, BL y su Interface BL
                        Por temás de tiempo se deja de esta forma, pero no es un buena práctica
                    */
                    String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
                    String dbUser = "ARTAVIARACING";
                    String dbPassword = "12345";
                    
                    Connection conn = null;
                    CallableStatement stmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                        
                        stmt = conn.prepareCall("{call USP_LISTAR_CITAS_ADMIN(?)}");
                        stmt.registerOutParameter(1, OracleTypes.CURSOR);
                        stmt.execute();
                        
                        rs = (ResultSet) stmt.getObject(1);

                        while (rs.next()) {
                            int citaId = rs.getInt("CITAID");
                            Date fechaAgendada = rs.getDate("FECHAAGENDADA");
                            String horaAgendada = rs.getString("HORAAGENDADA");
                            String placaVehiculo = rs.getString("PLACAVEHICULOID"); // Nueva columna para la placa del vehículo
                            String MarcaVehiculo = rs.getString("VEHICULO"); 
                            String cliente = rs.getString("CLIENTE");
                            String categoria = rs.getString("CATEGORIA");                            
                            String servicio = rs.getString("SERVICIO");
                            String estado = rs.getString("ESTADO");
                            String problema = rs.getString("DESCRIPCION");
                            String diagnostico = rs.getString("DIAGNOSTICO");
                            

                            %>
                            <tr>
                                <td><%= citaId %></td>
                                <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(fechaAgendada) %></td>
                                <td><%= horaAgendada %></td>
                                <td><%= placaVehiculo %></td> <!-- Mostrar la placa del vehículo -->
                                <td><%= MarcaVehiculo %></td>
                                <td><%= cliente %></td>
                                <td><%= categoria %></td>
                                <td><%= servicio %></td>
                                <td><%= estado %></td>
                                <td><%= problema %></td>
                                <td><%= diagnostico %></td>
                                
                                <td>
                                    <a href="editarcita.jsp?id=<%= citaId %>" class="btn btn-warning btn-sm">Editar</a>
                                    
                                    
                                </td>
                            </tr>
                            <%
                        }
                        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </tbody>
        </table>
        
    </div>

    <!-- Bootstrap JS, Popper.js, jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="js/Menu.js" type="text/javascript"></script> <!-- Asegúrate de cargar el script aquí -->
</body>
</html>