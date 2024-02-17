/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.sql.Date;

/**
 *
 * @author Serva
 */
public class CuentaDTO {

    private long numeroCuenta;
    private int saldo;
    private Date fechaApertura;
    private String estado;
    private int idCliente;

    public CuentaDTO(long numeroCuenta, int saldo, Date fechaApertura, String estado, int idCliente) {
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

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
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
