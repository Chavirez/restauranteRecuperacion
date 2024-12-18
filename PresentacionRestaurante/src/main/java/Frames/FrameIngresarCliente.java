/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import DTO.ClienteDTO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import DTO.RestauranteDTO;
import Excepcion.NegocioException;
import InterfacesNegocio.IClienteNegocio;
import InterfacesNegocio.IMesaNegocio;
import InterfacesNegocio.IReservaNegocio;
import InterfacesNegocio.IRestauranteNegocio;
import Negocio.ClienteNegocio;
import Negocio.MesaNegocio;
import Negocio.ReservaNegocio;
import Negocio.RestauranteNegocio;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author santi
 */
public class FrameIngresarCliente extends javax.swing.JFrame {

    FrameSeleccionMesa frmSeleccionMesa;
    ReservaDTO reserva;
    MesaDTO mesa;
    
    IReservaNegocio reservaNegocio = new ReservaNegocio();
    IClienteNegocio clienteNegocio = new ClienteNegocio();
        
    /**
     * Creates new form FramePrincipal
     */
    public FrameIngresarCliente(FrameSeleccionMesa frmSeleccionMesa, ReservaDTO reserva, MesaDTO mesa) {

        this.frmSeleccionMesa = frmSeleccionMesa;
        this.reserva = reserva;
        this.mesa = mesa;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();

        inicializarComponentes();
        
    }
    
    public void inicializarComponentes(){
    

        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        lblComensales = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();
        lblRealizarReserva = new javax.swing.JLabel();
        fldNombre = new javax.swing.JTextField();
        fldTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(51, 36, 12));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ingrese sus datos.png"))); // NOI18N

        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/X.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/(-.png"))); // NOI18N
        lblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });

        lblComensales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComensales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nombre completo.png"))); // NOI18N

        lblSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Número de teléfono.png"))); // NOI18N

        lblRealizarReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRealizarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realizar reserva.png"))); // NOI18N
        lblRealizarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRealizarReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRealizarReservaMouseClicked(evt);
            }
        });

        fldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCerrar))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSeccion)
                            .addComponent(lblComensales)
                            .addComponent(fldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(lblRealizarReserva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCerrar)
                    .addComponent(lblAtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHeader)
                .addGap(18, 18, 18)
                .addComponent(lblLogo)
                .addGap(79, 79, 79)
                .addComponent(lblComensales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblSeccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(lblRealizarReserva)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        // TODO add your handling code here:
        frmSeleccionMesa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAtrasMouseClicked


    
    private void lblRealizarReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRealizarReservaMouseClicked

        try {
            if(fldNombre.getText().isEmpty() || fldTelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos");
                return;
            }
            
            String regex1 = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(fldNombre.getText());

            if (!matcher1.matches()) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre completo válido (dos palabras separadas por un espacio y la primera letra en mayúsculas)");
                return;
            }

            
            String regex2 = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(fldTelefono.getText());
            
            if(!matcher2.matches()){
                JOptionPane.showMessageDialog(this, "Ingrese un número de teléfono correcto");
                return;
            }
            
            ClienteDTO cliente = new ClienteDTO(fldTelefono.getText(), fldNombre.getText());
            ClienteDTO clienteExistente = clienteNegocio.obtenerClientePorTelefono(cliente);
            
            if(clienteExistente != null){
                int option = JOptionPane.showConfirmDialog(this, "Ya hay registros con ese número de teléfono, quieres continuar con el nombre " + clienteExistente.getNombreCompleto(),
                        "Importante", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE );
                if(option == JOptionPane.YES_OPTION){
                
                    reservaNegocio.guardarReserva(reserva, clienteExistente, mesa);
                    JOptionPane.showMessageDialog(this, "Reserva guardada correctamente!");
                    FramePrincipal frmPrincipal = new FramePrincipal();
                    frmPrincipal.setVisible(true);
                    this.dispose();                 
                    
                } 
            } 
            else{
                
                clienteNegocio.guardarCliente(cliente);
                clienteExistente = clienteNegocio.obtenerClientePorTelefono(cliente);
                    
                reservaNegocio.guardarReserva(reserva, clienteExistente, mesa);
                JOptionPane.showMessageDialog(this, "Reserva guardada correctamente!");
                FramePrincipal frmPrincipal = new FramePrincipal();
                frmPrincipal.setVisible(true);
                this.dispose();
            
            }
        
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN BASE");
        }
        
    }//GEN-LAST:event_lblRealizarReservaMouseClicked

    private void fldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldTelefonoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldNombre;
    private javax.swing.JTextField fldTelefono;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblComensales;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRealizarReserva;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
