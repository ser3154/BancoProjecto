/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author Serva
 */
public class Operacion {

    private int idOperacion;
    private int monto;
    private String tipoOperacion;
    private Date fechaHora;

    public Operacion(int idOperacion, int monto, String tipoOperacion, Date fechaHora) {
        this.idOperacion = idOperacion;
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.fechaHora = fechaHora;
    }

    public Operacion(int monto, String tipoOperacion, Date fechaHora) {
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

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Operacion{" + "idOperacion=" + idOperacion + ", monto=" + monto + ", tipoOperacion=" + tipoOperacion + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
