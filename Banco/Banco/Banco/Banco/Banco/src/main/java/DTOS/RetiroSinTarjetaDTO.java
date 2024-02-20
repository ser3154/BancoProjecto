/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author Serva
 */
public class RetiroSinTarjetaDTO {

    private int folio;
    private int contraseña;
    private String estado;
    private int idOperacion;
    private double monto;

    public RetiroSinTarjetaDTO(int folio, int contraseña, String estado, int idOperacion, double monto) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
        this.idOperacion = idOperacion;
        this.monto = monto;
    }

    public RetiroSinTarjetaDTO() {
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

 
    
}
