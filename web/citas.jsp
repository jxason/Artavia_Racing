<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, oracle.jdbc.OracleTypes"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión de Citas</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
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
                    <th>ID</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Cliente</th>
                    <th>Servicio</th>
                    <th>Estado</th>
                    <th>Placa del Vehículo</th> <!-- Nueva columna para la placa -->
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
                    String dbUser = "ARTAVIA_RACING";
                    String dbPassword = "123456";
                    
                    Connection conn = null;
                    CallableStatement stmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                        
                        stmt = conn.prepareCall("{call USP_LISTAR_CITAS(?)}");
                        stmt.registerOutParameter(1, OracleTypes.CURSOR);
                        stmt.execute();
                        
                        rs = (ResultSet) stmt.getObject(1);

                        while (rs.next()) {
                            int citaId = rs.getInt("CITAID");
                            Date fechaAgendada = rs.getDate("FECHAAGENDADA");
                            String horaAgendada = rs.getString("HORAAGENDADA");
                            String cliente = rs.getString("CREDENCIALID");
                            String servicio = rs.getString("SERVICIOID");
                            String estado = rs.getString("ESTADOCITAID");
                            String placaVehiculo = rs.getString("PLACAVEHICULOID"); // Nueva columna para la placa del vehículo

                            %>
                            <tr>
                                <td><%= citaId %></td>
                                <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(fechaAgendada) %></td>
                                <td><%= horaAgendada %></td>
                                <td><%= cliente %></td>
                                <td><%= servicio %></td>
                                <td><%= estado %></td>
                                <td><%= placaVehiculo %></td> <!-- Mostrar la placa del vehículo -->
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