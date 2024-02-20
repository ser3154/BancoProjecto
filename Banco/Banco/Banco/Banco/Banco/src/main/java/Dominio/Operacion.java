/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Serva
 */
public class Operacion {

    private int idOperacion;
    private Double  monto;
    private String tipoOperacion;
    private LocalDateTime fechaHora;

    public Operacion(int idOperacion, Double  monto, String tipoOperacion, LocalDateTime fechaHora) {
        this.idOperacion = idOperacion;
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.fechaHora = fechaHora;
    }

    public Operacion(Double  monto, String tipoOperacion, LocalDateTime fechaHora) {
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.fechaHora = fechaHora;
    }

    public Operacion() {
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Double  getMonto() {
        return monto;
    }

    public void setMonto(Double  monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Operacion{" + "idOperacion=" + idOperacion + ", monto=" + monto + ", tipoOperacion=" + tipoOperacion + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
