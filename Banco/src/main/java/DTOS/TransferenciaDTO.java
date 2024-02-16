/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author Serva
 */
public class TransferenciaDTO {

    private long cuentaDestino;
    private int idOperacion;

    public TransferenciaDTO(long cuentaDestino, int idOperacion) {
        this.cuentaDestino = cuentaDestino;
        this.idOperacion = idOperacion;
    }

    public TransferenciaDTO() {
    }

    public long getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(long cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

}
