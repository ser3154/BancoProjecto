/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Serva
 */
public class RetiroSinTarjeta {

    private int idRetiroSinTarjeta;
    private int folio;
    private int contraseña;
    private String estado;
    private int idOperacion;

    public RetiroSinTarjeta(int idRetiroSinTarjeta, int folio, int contraseña, String estado, int idOperacion) {
        this.idRetiroSinTarjeta = idRetiroSinTarjeta;
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
        this.idOperacion = idOperacion;
    }

    public RetiroSinTarjeta(int folio, int contraseña, String estado, int idOperacion) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
        this.idOperacion = idOperacion;
    }

    public RetiroSinTarjeta() {
    }

    public int getIdRetiroSinTarjeta() {
        return idRetiroSinTarjeta;
    }

    public void setIdRetiroSinTarjeta(int idRetiroSinTarjeta) {
        this.idRetiroSinTarjeta = idRetiroSinTarjeta;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    @Override
    public String toString() {
        return "RetiroSinTarjeta{" + "idRetiroSinTarjeta=" + idRetiroSinTarjeta + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + ", estado=" + estado + ", idOperacion=" + idOperacion + '}';
    }

}
