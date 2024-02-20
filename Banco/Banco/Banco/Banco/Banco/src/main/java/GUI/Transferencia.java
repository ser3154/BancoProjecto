/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Conexion.Conexion;
import DAO.ClienteDAO;
import DAO.OperacionDAO;
import DTOS.OperacionDTO;
import DTOS.TransferenciaDTO;
import Dominio.Operacion;
import Exceptiones.LimitarDigitos;
import Exceptiones.PersisteciaException;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Serva
 */
public class Transferencia extends javax.swing.JFrame {

    
    private LimitarDigitos filtro;
    private final Usuario usuario;
    private final Conexion conexionBD;

    /**
     * Creates new form Transferencia
     */
    public Transferencia(Usuario usuario, Conexion conexionBD) {
        initComponents();
        this.getContentPane().setBackground(Color.decode("#365979"));
        this.usuario = usuario;
        this.conexionBD = conexionBD;
        
        
          // Crear el filtro para limitar los dígitos del JPasswordField a 4
        filtro = new LimitarDigitos(4);
        
        // Aplicar el filtro al JPasswordField
        AbstractDocument doc = (AbstractDocument) contraseña.getDocument();
        doc.setDocumentFilter(filtro);
        
        

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Cuando se cierra la ventana, establecer la visibilidad de la ventana anterior como verdadera para mostrarla nuevamente
                dispose();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCuentaDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        LOGIN = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        txtIDCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transferencia");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INGRESA EL MONTO:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CUENTA DESTINO:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("INGRESA TU NIP:");

        btnAceptar.setBackground(new java.awt.Color(0, 153, 0));
        btnAceptar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        LOGIN.setBackground(new java.awt.Color(255, 255, 255));
        LOGIN.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("GUARDIA FINANCIERA");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GF");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INGRESA TU ID:");

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("MOSTRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 220, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(LOGIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtCuentaDestino, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtIDCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(366, 366, 366))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(385, 385, 385))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addGap(307, 307, 307))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        try {
        // Autenticar al usuario y obtener su ID de cliente
        long idCliente = Long.parseLong(txtIDCliente.getText()); // Se asume que hay un JTextField llamado txtIDCliente para ingresar el ID del cliente
        long idAutenticado = autenticarUsuario(idCliente, new String(contraseña.getPassword()));
        if (idAutenticado != -1) {
            // Autenticación exitosa, realizar transferencia
            realizarTransferencia(idCliente, Double.parseDouble(txtMonto.getText()), Long.parseLong(txtCuentaDestino.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "ID de cliente o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID de cliente, el monto o el número de cuenta no son válidos", "Error de formato", JOptionPane.ERROR_MESSAGE);
    }       
        
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed
// Función para autenticar al usuario y obtener su ID de cliente (debes implementarla según tu lógica real)


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    
    
    private long autenticarUsuario(long idCliente, String contrasena) {
    try (Connection connection = conexionBD.crearConexion();
            PreparedStatement pstmt = connection.prepareStatement("SELECT ID_cliente FROM Clientes WHERE ID_cliente = ? AND Contraseña = ?")) {

        pstmt.setLong(1, idCliente);
        pstmt.setString(2, contrasena);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getLong("ID_cliente");
            } else {
                return -1;
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al autenticar usuario: " + e.getMessage(), "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
}
    
    
    
    private void realizarTransferencia(long idClienteEmisor, double monto, long cuentaDestino) {
        try (Connection connection = conexionBD.crearConexion();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Cuentas SET Saldo = Saldo - ? WHERE ID_cliente = ?");
            PreparedStatement pstmt2 = connection.prepareStatement("UPDATE Cuentas SET Saldo = Saldo + ? WHERE ID_cliente = ?");
            PreparedStatement pstmtOperacion = connection.prepareStatement("INSERT INTO Operaciones (ID_cliente, Tipo_operacion, Monto, Fecha) VALUES (?, ?, ?, ?)")) {

        // Restar el monto de la cuenta del cliente emisor
        pstmt.setDouble(1, monto);
        pstmt.setLong(2, idClienteEmisor);
        int filasActualizadas = pstmt.executeUpdate();

        if (filasActualizadas == 0) {
            throw new SQLException("No se pudo actualizar el saldo del cliente emisor");
        }

        // Sumar el monto a la cuenta del cliente receptor
        pstmt2.setDouble(1, monto);
        pstmt2.setLong(2, cuentaDestino);
        filasActualizadas = pstmt2.executeUpdate();

        if (filasActualizadas == 0) {
            throw new SQLException("No se pudo actualizar el saldo del cliente receptor");
        }

        // Registrar la operación en la tabla de operaciones
        pstmtOperacion.setLong(1, idClienteEmisor);
        pstmtOperacion.setString(2, "Transferencia enviada");
        pstmtOperacion.setDouble(3, monto);
        pstmtOperacion.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // Obtiene la fecha y hora actual
        pstmtOperacion.executeUpdate();

        JOptionPane.showMessageDialog(this, "Transferencia realizada con éxito", "Transferencia exitosa", JOptionPane.INFORMATION_MESSAGE);
        dispose();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al realizar la transferencia: " + e.getMessage(), "Error de transferencia", JOptionPane.ERROR_MESSAGE);
    }
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOGIN;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
