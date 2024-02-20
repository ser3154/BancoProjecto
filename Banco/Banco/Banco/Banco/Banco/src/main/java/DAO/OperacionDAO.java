/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexion;
import DTOS.OperacionDTO;
import DTOS.RetiroSinTarjetaDTO;
import DTOS.TransferenciaDTO;
import Dominio.Operacion;
import Dominio.RetiroSinTarjeta;
import Dominio.Transferencia;
import Exceptiones.PersisteciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serva
 */
public class OperacionDAO implements IOperacion {

    final IConexion conexionBD;

    public OperacionDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    @Override
    public Operacion nuevaOperacion(OperacionDTO operacion) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO Operaciones (Monto, Tipo_Operacion, FechaHora) VALUES (?, ?, ?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            // Establecer los valores del PreparedStatement
            comandoSQL.setDouble(1, operacion.getMonto());
            comandoSQL.setString(2, operacion.getTipoOperacion());

            // Obtener la fecha y hora actual
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            java.sql.Timestamp fechaHoraTimestamp = java.sql.Timestamp.valueOf(fechaHoraActual);

            // Establecer la fecha y hora actual en el PreparedStatement
            comandoSQL.setTimestamp(3, fechaHoraTimestamp);

            // Ejecutar la inserción en la base de datos
            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción de la operación falló, ninguna fila afectada.");
            }

            // Obtener el ID de la operación generada
            try ( ResultSet registroGenerado = comandoSQL.getGeneratedKeys()) {
                if (registroGenerado.next()) {
                    int idOperacionGenerado = registroGenerado.getInt(1);

                    // Crear y devolver el objeto Operacion con el ID generado y la fecha y hora actual
                    return new Operacion(idOperacionGenerado, operacion.getMonto(), operacion.getTipoOperacion(), fechaHoraActual);
                } else {
                    throw new PersisteciaException("La inserción de la operación falló, no se generó el ID de la operación.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la operación", e);
            throw new PersisteciaException("No se pudo agregar la operación ", e);
        }
    }

    @Override
    public Transferencia nuevaTransferencia(TransferenciaDTO transferencia) throws PersisteciaException {
        String sentenciaOperacionSQL = "INSERT INTO Operaciones (Monto, Tipo_Operacion, Fecha_Hora) VALUES (?, ?, ?)";
        String sentenciaTransferenciaSQL = "INSERT INTO Transferencias (Cuenta_destino, ID_operacion) VALUES (?, ?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoOperacionSQL = conexion.prepareStatement(sentenciaOperacionSQL, Statement.RETURN_GENERATED_KEYS);  PreparedStatement comandoTransferenciaSQL = conexion.prepareStatement(sentenciaTransferenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            // Crear nueva operación
            comandoOperacionSQL.setDouble(1, transferencia.getMonto());
            comandoOperacionSQL.setString(2, "transferencia");

            LocalDateTime fechaHoraActual = LocalDateTime.now();
            java.sql.Timestamp fechaHoraTimestamp = java.sql.Timestamp.valueOf(fechaHoraActual);
            comandoOperacionSQL.setTimestamp(3, fechaHoraTimestamp);

            int registrosOperacionModificados = comandoOperacionSQL.executeUpdate();

            if (registrosOperacionModificados == 0) {
                throw new PersisteciaException("La inserción de la operación falló, ninguna fila afectada.");
            }

            // Obtener el ID de la operación generada
            try ( ResultSet registroGeneradoOperacion = comandoOperacionSQL.getGeneratedKeys()) {
                if (registroGeneradoOperacion.next()) {
                    int idOperacionGenerado = registroGeneradoOperacion.getInt(1);

                    // Crear nueva transferencia
                    comandoTransferenciaSQL.setLong(1, transferencia.getCuentaDestino());
                    comandoTransferenciaSQL.setInt(2, idOperacionGenerado);

                    int registrosTransferenciaModificados = comandoTransferenciaSQL.executeUpdate();

                    if (registrosTransferenciaModificados == 0) {
                        throw new PersisteciaException("La inserción de la transferencia falló, ninguna fila afectada.");
                    }

                    // Obtener el ID de la transferencia generada
                    try ( ResultSet registroGeneradoTransferencia = comandoTransferenciaSQL.getGeneratedKeys()) {
                        if (registroGeneradoTransferencia.next()) {
                            int idTransferenciaGenerado = registroGeneradoTransferencia.getInt(1);

                            // Crear y devolver el objeto Transferencia con el ID generado
                            return new Transferencia(idTransferenciaGenerado, transferencia.getCuentaDestino(), idOperacionGenerado);
                        } else {
                            throw new PersisteciaException("La inserción de la transferencia falló, no se generó el ID de la transferencia.");
                        }
                    }
                } else {
                    throw new PersisteciaException("La inserción de la operación falló, no se generó el ID de la operación.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la Transferencia", e);
            throw new PersisteciaException("No se pudo agregar la Transferencia ", e);
        }
    }

    @Override
    public RetiroSinTarjeta nuevaRetiroSinTarjeta(RetiroSinTarjetaDTO retiroSinTarjeta) throws PersisteciaException {
        String sentenciaSQL = "INSERT INTO RetiroSinTarjeta (Folio, Contraseña, Estado, ID_operacion, FechaHora) VALUES (?, ?, ?, ?, ?)";

        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setInt(1, retiroSinTarjeta.getFolio());
            comandoSQL.setInt(2, retiroSinTarjeta.getContraseña());

            // Si la operación está en proceso, establecer el estado como "cobrado"
            if (retiroSinTarjeta.getEstado().equals("pendiente")) {
                comandoSQL.setString(3, "cobrado");
            } else {
                comandoSQL.setString(3, retiroSinTarjeta.getEstado());
            }

            comandoSQL.setInt(4, retiroSinTarjeta.getIdOperacion());
            comandoSQL.setObject(5, fechaHoraActual);

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersisteciaException("La inserción del retiro sin tarjeta falló, ninguna fila afectada.");
            }

            try ( ResultSet generatedKeys = comandoSQL.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idRetiroGenerado = generatedKeys.getInt(1);

                    // Obtener el valor de la columna 'Estado' directamente del objeto RetiroSinTarjetaDTO
                    String estadoGenerado = retiroSinTarjeta.getEstado();

                    // Crear y devolver el objeto RetiroSinTarjeta con el ID generado
                    return new RetiroSinTarjeta(retiroSinTarjeta.getFolio(), retiroSinTarjeta.getContraseña(),
                            estadoGenerado, retiroSinTarjeta.getIdOperacion());
                } else {
                    throw new PersisteciaException("La inserción del retiro sin tarjeta falló, no se generó el ID del retiro.");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al agregar el retiro sin tarjeta", e);
            throw new PersisteciaException("Error al agregar el retiro sin tarjeta", e);
        }
    }

}
