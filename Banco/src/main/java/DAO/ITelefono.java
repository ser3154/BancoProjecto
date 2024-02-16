/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import DTOS.TelefonoDTO;
import Dominio.Telefono;
import Exceptiones.PersisteciaException;

/**
 *
 * @author Serva
 */
public interface ITelefono {
    public Telefono agregarTelefono(TelefonoDTO cliente) throws PersisteciaException;
}
