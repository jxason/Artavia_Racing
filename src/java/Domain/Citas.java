/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "CITAS")
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citaId;

    private Number credencialId;
    private Long placaVehiculoId;
    private Long vin;
    private Number servicioId;
    private Number estadoCitaId;
    private LocalDateTime fechaAgendada;
    private Long descripcion;
    private LocalDateTime horaAgendada;
    private LocalDateTime horaFinalizacion;
    private Long editadoPor;
    private Number habilitado;
    private LocalDateTime fechaCreacion;

    // Getters y Setters
}
