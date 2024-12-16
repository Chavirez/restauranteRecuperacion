/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import DTO.MesaDTO;
import DTO.ReservaDTO;
import DTO.RestauranteDTO;
import Excepcion.NegocioException;
import InterfacesNegocio.IMesaNegocio;
import InterfacesNegocio.IRestauranteNegocio;
import Negocio.MesaNegocio;
import Negocio.RestauranteNegocio;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FrameModuloMesas extends javax.swing.JFrame {

    FramePrincipal frmPrincipal;

    
    /**
     * Creates new form FramePrincipal
     */
    public FrameModuloMesas(FramePrincipal frmPrincipal) {

        this.frmPrincipal = frmPrincipal;
        
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
        lblInsertarMesas = new javax.swing.JLabel();
        lblGestionarMesas = new javax.swing.JLabel();
        lblCambiarHorarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(51, 36, 12));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Módulo de mesa.png"))); // NOI18N

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

        lblInsertarMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertarMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Insertar mesas.png"))); // NOI18N
        lblInsertarMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInsertarMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsertarMesasMouseClicked(evt);
            }
        });

        lblGestionarMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestionar Mesas.png"))); // NOI18N
        lblGestionarMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGestionarMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarMesasMouseClicked(evt);
            }
        });

        lblCambiarHorarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCambiarHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cambiar horario del restaurante.png"))); // NOI18N
        lblCambiarHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCambiarHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCambiarHorariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(lblInsertarMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCerrar))
                    .addComponent(lblGestionarMesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCambiarHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(lblInsertarMesas)
                .addGap(88, 88, 88)
                .addComponent(lblGestionarMesas)
                .addGap(83, 83, 83)
                .addComponent(lblCambiarHorarios)
                .addContainerGap(145, Short.MAX_VALUE))
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
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void lblInsertarMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsertarMesasMouseClicked
        // TODO add your handling code here:
        FrameInsertarMesas frm = new FrameInsertarMesas(this);
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblInsertarMesasMouseClicked

    private void lblGestionarMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarMesasMouseClicked
        // TODO add your handling code here:
        FrameGestionMesas frm = new FrameGestionMesas(this);
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblGestionarMesasMouseClicked

    private void lblCambiarHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarHorariosMouseClicked
        // TODO add your handling code here:
        FrameActualizarHorario frm = new FrameActualizarHorario(this);
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblCambiarHorariosMouseClicked


    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCambiarHorarios;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGestionarMesas;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInsertarMesas;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
