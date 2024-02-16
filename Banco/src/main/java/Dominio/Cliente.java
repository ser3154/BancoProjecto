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
public class Cliente {

    private int idCliente;
    private Date fechaNacimiento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int idDireccion;
    private int edad;

    // Constructor
    public Cliente(int idCliente, Date fechaNacimiento, String nombre, String apellidoPaterno,
            String apellidoMaterno, int idDireccion, int edad) {
        this.idCliente = idCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.idDireccion = idDireccion;
        this.edad = edad;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "idCliente=" + idCliente
                + ", fechaNacimiento=" + fechaNacimiento
                + ", nombre='" + nombre + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", idDireccion=" + idDireccion
                + ", edad=" + edad
                + '}';
    }
}
