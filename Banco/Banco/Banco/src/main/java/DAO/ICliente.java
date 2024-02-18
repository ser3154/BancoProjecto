/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import DTOS.DireccionesDTO;
import DTOS.TelefonoDTO;
import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Direcciones;
import Dominio.Telefono;
import Exceptiones.PersisteciaException;

/**
 *
 * @author Serva
 */
public interface ICliente {
    public Cliente agregarCliente(ClienteDTO cliente) throws PersisteciaException;
    public Direcciones agregarDireccion(DireccionesDTO cliente) throws PersisteciaException;
    public Telefono agregarTelefono (TelefonoDTO telefono) throws PersisteciaException;
    public Cuenta agregarCuenta (CuentaDTO cuenta) throws PersisteciaException;
}
