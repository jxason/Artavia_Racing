/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.ICitaDA;
import Entities.CitaAdminDTO;
import Entities.CitaDTO;
import Entities.DiagnosticoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín 
 * Clase encargada de administrar las citas
 */
public class CitaDA extends BaseConnectionDA implements ICitaDA {

    // Constructor sin parámetros
    public CitaDA() {
        super(); // Llama al constructor de la clase base
    }

    // Método para agregar una nueva cita
    @Override
    public boolean agregarCita(CitaDTO cita) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_AGREGAR_CITA(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatements.setString(1, cita.getCredencialId());
            callableStatements.setString(2, cita.getPlacaVehiculoId());
            callableStatements.setString(3, cita.getVIN());
            callableStatements.setInt(4, cita.getServicioId());
            callableStatements.setInt(5, cita.getEstadoCitaId());
            callableStatements.setDate(6, new java.sql.Date(cita.getFechaAgendada().getTime()));
            callableStatements.setString(7, cita.getDescripcion());
            callableStatements.setString(8, cita.getHoraAgendada());
            callableStatements.setString(9, cita.getEditadoPor());
            callableStatements.setInt(10, cita.getHabilitado());
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar una cita existente
    @Override
    public boolean actualizarCita(CitaDTO cita) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_ACTUALIZAR_CITA(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatements.setInt(1, cita.getCitaId());
            callableStatements.setString(2, cita.getCredencialId());
            callableStatements.setString(3, cita.getPlacaVehiculoId());
            callableStatements.setString(4, cita.getVIN());
            callableStatements.setInt(5, cita.getServicioId());
            callableStatements.setInt(6, cita.getEstadoCitaId());
            callableStatements.setDate(7, new java.sql.Date(cita.getFechaAgendada().getTime()));
            callableStatements.setString(8, cita.getDescripcion());
            callableStatements.setString(9, cita.getHoraAgendada());
            callableStatements.setString(10, cita.getHoraFinalizacion());
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para cancelar una cita
    @Override
    public boolean cancelarCita(int idCita) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_CANCELAR_CITA(?)}");
            callableStatements.setInt(1, idCita);
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una cita
    public boolean eliminarCita(int idCita) {
        String sql = "DELETE FROM Citas WHERE CitaID = ?";
        
        try (Connection conn = conectionDA.Get();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idCita);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
            return false;
        }
    }

    // Método para listar todas las citas
    @Override
    public List<CitaDTO> listarCitas() {
        List<CitaDTO> citas = new ArrayList<>();
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_LISTAR_CITAS(?, ?)}");
            ResultSet rs = callableStatements.executeQuery();
            while (rs.next()) {
                CitaDTO cita = new CitaDTO();
                cita.setCitaId(rs.getInt("cita_id"));
                cita.setCredencialId(rs.getString("credencial_id"));
                cita.setPlacaVehiculoId(rs.getString("placa_vehiculo_id"));
                cita.setVIN(rs.getString("vin"));
                cita.setServicioId(rs.getInt("servicio_id"));
                cita.setEstadoCitaId(rs.getInt("estado_cita_id"));
                cita.setFechaAgendada(rs.getDate("fecha_agendada"));
                cita.setDescripcion(rs.getString("descripcion"));
                cita.setHoraAgendada(rs.getString("hora_agendada"));
                cita.setHoraFinalizacion(rs.getString("hora_finalizacion"));
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    // Método para obtener una cita por su ID
    @Override
    public CitaAdminDTO obtenerCitaPorId(int idCita) {
        CitaAdminDTO cita = null;
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_OBTENER_CITA_POR_ID(? , ?)}");
            callableStatements.setInt(1, idCita);
            callableStatements.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();

            try (ResultSet rs = (ResultSet) callableStatements.getObject(2)) {
                if (rs.next()) {
                    cita = new CitaAdminDTO();                    
                    cita.setCredencialId(rs.getString("CREDENCIALID"));
                    cita.setPlacaVehiculoId(rs.getString("PLACAVEHICULOID"));
                    cita.setVIN(rs.getString("VIN"));
                    cita.setServicioId(rs.getString("SERVICIOVEHICULO"));
                    cita.setEstadoCitaId(rs.getString("ESTADO"));
                    cita.setFechaAgendada(rs.getDate("FECHAAGENDADA"));
                    cita.setDescripcion(rs.getString("DESCRIPCION"));
                    cita.setHoraAgendada(rs.getString("HORAAGENDADA"));              
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    // Método para agregar un diagnóstico a una cita
        @Override
         public boolean agregarDiagnostico(DiagnosticoDTO Request)
         {
             try {
                 connections = conectionDA.Get();
                 callableStatements = connections.prepareCall("{call USP_INSERTAR_DIAGNOSTICO(?, ?, ?, ?, ?, ?)}");            
                 callableStatements.setInt(1, Request.getIdCita());
                 callableStatements.setString(2, Request.getDiagnostico());
                 callableStatements.setString(3, Request.getCodigoTrabajador());
                 callableStatements.setString(4, Request.getEditadoPor());
                 callableStatements.setInt(5, Request.getHabilitado());
                 callableStatements.setDate(6, new java.sql.Date(Request.getFechaCreacion().getTime()));
                 callableStatements.execute();
                 return true;
             } catch (SQLException e) {
                 e.printStackTrace();
                 return false;
             } finally {
                 closeResources();
             }
         }
    }