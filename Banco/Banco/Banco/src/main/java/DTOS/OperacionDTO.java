/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Serva
 */
public class OperacionDTO {

    private int monto;
    private String tipoOperacion;
    private Timestamp fechaHora;

    public OperacionDTO(int monto, String tipoOperacion, Timestamp fechaHora) {
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.fechaHora = fechaHora;
    }

    public OperacionDTO() {
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

}
