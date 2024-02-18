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
        String sentenciaSQL = "INSERT INTO Direcciones (Calle, Colonia, Num) VALUES (?, ?, ?)";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNum());

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción de la dirección falló, ninguna fila afectada.");
            }

            try (ResultSet registroGenerado = comandoSQL.getGeneratedKeys()) {
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

    public int obtenerIdDireccionExistente(DireccionesDTO direccion) throws PersisteciaException {
        String sentenciaSQL = "SELECT ID_direccion FROM Direcciones WHERE Calle = ? AND Colonia = ? AND Num = ?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNum());

            try (ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt("ID_direccion");
                } else {
                    return -1; // Si no se encuentra ninguna dirección existente, devuelve -1
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al obtener ID de dirección existente", e);
            throw new PersisteciaException("Error al obtener ID de dirección existente", e);
        }
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO CLIENTES(Nombre,ApellidoPaterno,ApellidoMaterno,FechaNacimiento,ID_direccion,Edad)"
                + "VALUES (?,?,?,?,?,?)";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setDate(4, cliente.getFechaNacimiento());
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

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setString(1, telefono.getTelefono());
            comandoSQL.setInt(2, telefono.getIdCliente());  // Asegúrate de tener el ID del cliente al que se asociará el teléfono

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción del teléfono falló, ninguna fila afectada.");
            }

            try (ResultSet registroGenerado = comandoSQL.getGeneratedKeys()) {
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
        String sentenciaSQL = "INSERT INTO Cuentas (Numero_Cuenta, Saldo, Fecha_Apertura, Estado, ID_cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setLong(1, cuenta.getNumeroCuenta());
            comandoSQL.setDouble(2, 0);
            comandoSQL.setDate(3, cuenta.getFechaApertura());
            comandoSQL.setString(4, "Activo");
            comandoSQL.setInt(5, cuenta.getIdCliente());

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción de la cuenta falló, ninguna fila afectada.");
            }

            try (ResultSet clavesGeneradas = comandoSQL.getGeneratedKeys()) {
                if (clavesGeneradas.next()) {
                    int idCuentaGenerado = clavesGeneradas.getInt(1);
                    return new Cuenta(idCuentaGenerado, cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getFechaApertura(), cuenta.getEstado(), cuenta.getIdCliente());
                } else {
                    throw new PersisteciaException("La inserción de la cuenta falló, no se generó el ID de la cuenta.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta al cliente", e);
            throw new PersisteciaException("No se pudo agregar la cuenta al cliente", e);
        }
    }
}
