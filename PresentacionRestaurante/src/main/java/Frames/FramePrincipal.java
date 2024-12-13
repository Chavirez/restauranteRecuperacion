/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Excepcion.NegocioException;
import InterfacesNegocio.IMesaNegocio;
import InterfacesNegocio.IRestauranteNegocio;
import Negocio.MesaNegocio;
import Negocio.RestauranteNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class FramePrincipal extends javax.swing.JFrame {
    
    IRestauranteNegocio restauranteNegocio = new RestauranteNegocio();
    IMesaNegocio mesaNegocio = new MesaNegocio();
    
    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        initComponents();
        
        inicializarComponentes();
        
    }
    
    public void inicializarComponentes(){
        
        try {
            if(restauranteNegocio.verificarSiExiste())
                lblInsertarDatos.setVisible(false);
            else
                lblInsertarDatos.setVisible(true);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, cree una base de datos en MySQL con el nombre de restaurantebd");
        }
    
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
        btnMesas = new javax.swing.JLabel();
        btnConsultas = new javax.swing.JLabel();
        btnReserva = new javax.swing.JLabel();
        lblInsertarDatos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(51, 36, 12));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lblMenuPrincipal.png"))); // NOI18N

        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/X.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        btnMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Módulo de mesas.png"))); // NOI18N
        btnMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMesasMouseClicked(evt);
            }
        });

        btnConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Módulo de consultas.png"))); // NOI18N
        btnConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultasMouseClicked(evt);
            }
        });

        btnReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hacer Reserva.png"))); // NOI18N
        btnReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservaMouseClicked(evt);
            }
        });

        lblInsertarDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Insertar datos.png"))); // NOI18N
        lblInsertarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInsertarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsertarDatosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblInsertarDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCerrar))
                    .addComponent(btnConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHeader))
                    .addComponent(lblInsertarDatos))
                .addGap(18, 18, 18)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(btnMesas)
                .addGap(85, 85, 85)
                .addComponent(btnConsultas)
                .addGap(101, 101, 101))
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                    .addContainerGap(374, Short.MAX_VALUE)
                    .addComponent(btnReserva)
                    .addGap(372, 372, 372)))
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

    private void btnMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesasMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnMesasMouseClicked

    private void btnConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultasMouseClicked

    private void btnReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservaMouseClicked
        // TODO add your handling code here:
        FrameInformacionReserva frm = new FrameInformacionReserva(this);
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnReservaMouseClicked

    private void lblInsertarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsertarDatosMouseClicked
        try {
            // TODO add your handling code here:

            restauranteNegocio.guardarRestaurante();
            mesaNegocio.llenarMesasPrueba();
            
            lblInsertarDatos.setVisible(false);
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la inserción de datos " + ex);
            return;
        }
        
        
        JOptionPane.showMessageDialog(this, "Se insertaron correctamente los datos!");
        
    }//GEN-LAST:event_lblInsertarDatosMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnConsultas;
    private javax.swing.JLabel btnMesas;
    private javax.swing.JLabel btnReserva;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInsertarDatos;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
