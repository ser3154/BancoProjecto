/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Serva
 */
public class TransferenciaDTO {

    private long cuentaDestino;
    private int monto;
    private String contrasena;
    private String idOperacion; // Agregar un atributo para el ID de operación

    public TransferenciaDTO(long cuentaDestino, int monto, String contrasena) {
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.contrasena = contrasena;
        // Generar el ID de operación al crear una nueva transferencia
        this.idOperacion = generarIdOperacion();
    }

    // Método para generar un ID único de operación basado en la fecha y hora
    private String generarIdOperacion() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return fechaHoraActual.format(formatter);
    }

    public TransferenciaDTO() {
    }

    public long getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(long cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(String idOperacion) {
        this.idOperacion = idOperacion;
    }

}
