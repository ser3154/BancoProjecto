/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author Serva
 */
public class DireccionesDTO {
    private String Calle;
    private String Colonia;
    private String Num;

    public DireccionesDTO(String Calle, String Colonia, String Num) {
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Num = Num;
    }

    public DireccionesDTO() {
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
 
}
