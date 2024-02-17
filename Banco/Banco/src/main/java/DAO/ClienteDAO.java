/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import DTOS.DireccionesDTO;
import DTOS.TelefonoDTO;
import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Direcciones;
import Dominio.Telefono;
import Exceptiones.PersisteciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serva
 */
public class ClienteDAO implements ICliente {

    final IConexion conexionBD;

    public ClienteDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    @Override
    public Direcciones agregarDireccion(DireccionesDTO direccion) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO Direcciones (calle, colonia, numero) VALUES (?, ?, ?)";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNum());

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción de la dirección falló, ninguna fila afectada.");
            }

            try ( ResultSet registroGenerado = comandoSQL.getGeneratedKeys()) {
                if (registroGenerado.next()) {
                    int idDireccionGenerado = registroGenerado.getInt(1);
                    return new Direcciones(idDireccionGenerado, direccion.getCalle(), direccion.getColonia(), direccion.getNum());
                } else {
                    throw new PersisteciaException("La inserción de la dirección falló, no se generó el ID de la dirección.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la dirección", e);
            throw new PersisteciaException("No se pudo agregar la dirección ", e);
        }
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO CLIENTE(fechaNacimiento,nombre,apellidoPaterno,apellidoMaterno,idDireccion,edad )"
                + "VALUES (?,?,?,?,?,?)";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setDate(1, cliente.getFechaNacimiento());
            comandoSQL.setString(2, cliente.getNombre());
            comandoSQL.setString(3, cliente.getApellidoPaterno());
            comandoSQL.setString(4, cliente.getApellidoMaterno());
            comandoSQL.setInt(5, cliente.getIdDireccion());
            comandoSQL.setInt(6, cliente.getEdad());
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con exito {0}", registrosModificados);
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();

            Cliente clienteNuevo = new Cliente(registroGenerado.getInt(1), cliente.getFechaNacimiento(), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getIdDireccion(), cliente.getEdad());

            return clienteNuevo;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente", e);
            throw new PersisteciaException("No se pudo agregar el cliente", e);
        }
    }

    @Override
    public Telefono agregarTelefono(TelefonoDTO telefono) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO Telefonos (Telefono, ID_cliente) VALUES (?, ?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setString(1, telefono.getTelefono());
            comandoSQL.setInt(2, telefono.getIdCliente());  // Asegúrate de tener el ID del cliente al que se asociará el teléfono

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción del teléfono falló, ninguna fila afectada.");
            }

            try ( ResultSet registroGenerado = comandoSQL.getGeneratedKeys()) {
                if (registroGenerado.next()) {
                    int idTelefonoGenerado = registroGenerado.getInt(1);
                    return new Telefono(idTelefonoGenerado, telefono.getTelefono(), telefono.getIdCliente());
                } else {
                    throw new PersisteciaException("La inserción del teléfono falló, no se generó el ID del teléfono.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el teléfono", e);
            throw new PersisteciaException("No se pudo agregar el teléfono ", e);
        }
    }

    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO Cuentas (Saldo, Tipo_Cuenta, Estado, ID_cliente) VALUES (?, ?, ?, ?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setDouble(1, cuenta.getSaldo());
            comandoSQL.setDate(2, cuenta.getFechaApertura());
            comandoSQL.setString(3, cuenta.getEstado());
            comandoSQL.setInt(4, cuenta.getIdCliente());

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción de la cuenta falló, ninguna fila afectada.");
            }

            try ( ResultSet registroGenerado = comandoSQL.getGeneratedKeys()) {
                if (registroGenerado.next()) {
                    int idCuentaGenerado = registroGenerado.getInt(1);
                    return new Cuenta(idCuentaGenerado, cuenta.getSaldo(), cuenta.getFechaApertura(), cuenta.getEstado(), cuenta.getIdCliente());
                } else {
                    throw new PersisteciaException("La inserción de la cuenta falló, no se generó el ID de la cuenta.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta", e);
            throw new PersisteciaException("No se pudo agregar la cuenta ", e);
        }
    }
}