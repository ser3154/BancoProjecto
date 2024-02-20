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
public class ClienteDTO {
    
    private Date fechaNacimiento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int idDireccion;
    private int edad;
    private String contraseña; // Nueva variable para almacenar la contraseña del cliente

    public ClienteDTO(Date fechaNacimiento, String nombre, String apellidoPaterno, String apellidoMaterno, int idDireccion, int edad, String contraseña) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.idDireccion = idDireccion;
        this.edad = edad;
        this.contraseña = contraseña;
    }

    public ClienteDTO() {
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

 
}
