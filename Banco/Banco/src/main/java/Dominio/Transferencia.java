/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Serva
 */
public class Transferencia {

    private int idTransferencia;
    private long cuentaDestino;
    private int idOperacion;

    public Transferencia(int idTransferencia, long cuentaDestino, int idOperacion) {
        this.idTransferencia = idTransferencia;
        this.cuentaDestino = cuentaDestino;
        this.idOperacion = idOperacion;
    }

    public Transferencia(long cuentaDestino, int idOperacion) {
        this.cuentaDestino = cuentaDestino;
        this.idOperacion = idOperacion;
    }

    public Transferencia() {
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
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

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", cuentaDestino=" + cuentaDestino + ", idOperacion=" + idOperacion + '}';
    }
    
    
}
