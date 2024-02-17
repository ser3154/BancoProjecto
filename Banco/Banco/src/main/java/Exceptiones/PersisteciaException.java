/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptiones;

/**
 *
 * @author Serva
 */
public class PersisteciaException extends Exception {

    public PersisteciaException() {
    }

    public PersisteciaException(String string) {
        super(string);
    }

    public PersisteciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PersisteciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PersisteciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
