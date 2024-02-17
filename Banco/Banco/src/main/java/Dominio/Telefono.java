/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Serva
 */
public class Telefono {

    private int idTelefono;
    private String telefono;
    private int idCliente;

    public Telefono(int idTelefono, String telefono, int idCliente) {
        this.idTelefono = idTelefono;
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    public Telefono(String telefono, int idCliente) {
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    public Telefono() {
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Telefono{" + "idTelefono=" + idTelefono + ", telefono=" + telefono + ", idCliente=" + idCliente + '}';
    }
    
    
}
