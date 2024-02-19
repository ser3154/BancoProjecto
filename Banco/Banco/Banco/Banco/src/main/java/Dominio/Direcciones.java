/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Serva
 */
public class Direcciones {
    private int id_direcciones;
    private String Calle;
    private String Colonia;
    private String Num;

    public Direcciones(int id_direcciones, String Calle, String Colonia, String Num) {
        this.id_direcciones = id_direcciones;
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Num = Num;
    }

    public Direcciones(String Calle, String Colonia, String Num) {
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Num = Num;
    }

    public Direcciones() {
    }

    public int getId_direcciones() {
        return id_direcciones;
    }

    public void setId_direcciones(int id_direcciones) {
        this.id_direcciones = id_direcciones;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String Num) {
        this.Num = Num;
    }

    @Override
    public String toString() {
        return "Direcciones{" + "id_direcciones=" + id_direcciones + ", Calle=" + Calle + ", Colonia=" + Colonia + ", Num=" + Num + '}';
    }
}
