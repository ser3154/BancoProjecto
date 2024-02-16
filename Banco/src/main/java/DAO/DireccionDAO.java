/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTOS.ClienteDTO;
import DTOS.DireccionesDTO;
import Dominio.Cliente;
import Dominio.Direcciones;
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
public class DireccionDAO implements ICliente {

    final IConexion conexionBD;

    public DireccionDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }
    private static final Logger LOG = Logger.getLogger(DireccionDAO.class.getName());

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
}
