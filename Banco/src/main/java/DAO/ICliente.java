/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTOS.ClienteDTO;
import DTOS.DireccionesDTO;
import Dominio.Cliente;
import Dominio.Direcciones;
import Exceptiones.PersisteciaException;

/**
 *
 * @author Serva
 */
public interface ICliente {
    public Cliente agregarCliente(ClienteDTO cliente) throws PersisteciaException;
    public Direcciones agregarDireccion(DireccionesDTO cliente) throws PersisteciaException;
}
