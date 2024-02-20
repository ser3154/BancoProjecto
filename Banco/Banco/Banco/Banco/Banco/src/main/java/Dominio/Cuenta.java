/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Serva
 */
public class Cuenta {

    private int idCuenta;
    private long numeroCuenta;
    private Double saldo;
    private Timestamp fechaApertura;
    private String estado;
    private int idCliente;

    public Cuenta(int idCuenta, long numeroCuenta, Double saldo, Timestamp fechaApertura, String estado, int idCliente) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public Cuenta(long numeroCuenta, Double saldo, Timestamp fechaApertura, String estado, int idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public Cuenta() {
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + ", estado=" + estado + ", idCliente=" + idCliente + '}';
    }
    
    
}
