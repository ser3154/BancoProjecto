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
public class CuentaDTO {

    private long numeroCuenta;
    private Double saldo;
    private Timestamp fechaApertura;
    private String estado;
    private int idCliente;

    public CuentaDTO(long numeroCuenta, Double saldo, Timestamp fechaApertura, String estado, int idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public CuentaDTO() {
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
