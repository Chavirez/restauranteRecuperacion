/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import DTO.MesaDTO;
import DTO.ReservaDTO;
import DTO.RestauranteDTO;
import Excepcion.NegocioException;
import InterfacesNegocio.IRestauranteNegocio;
import Negocio.RestauranteNegocio;
import Util.JButtonCellEditor;
import Util.JButtonRenderer;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author santi
 */
public class FrameSeleccionMesa extends javax.swing.JFrame {

    FrameInformacionReserva frmInfo;
    ReservaDTO reserva;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    List<MesaDTO> mesas;

    
    /**
     * Creates new form FramePrincipal
     */
    public FrameSeleccionMesa(FrameInformacionReserva frmInfo, ReservaDTO reserva, List<MesaDTO> mesas) {

        this.frmInfo = frmInfo;
        this.reserva = reserva;
        this.mesas = mesas;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        initComponents();


        
        inicializarComponentes();
        
    }
    
    public void inicializarComponentes(){
    
        configurarTablaMesas();
        cargarDatosTablaMesas();
        
    }
    
    private void configurarTablaMesas() {
        
        modeloTabla = (DefaultTableModel) tblMesas.getModel();
        TableColumnModel modeloColumnas = tblMesas.getColumnModel();

        // Configurar renderizador y editor de botón
        modeloTabla.setRowCount(0);
        modeloColumnas.getColumn(2).setCellRenderer(new JButtonRenderer("Reservar", new Color(221,188,0)));
        modeloColumnas.getColumn(2).setCellEditor(new JButtonCellEditor("Reservar", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 
                    MesaDTO mesa = mesas.get(tblMesas.getSelectedRow());
                    
                    float costo = 0;
                    
                    if(mesa.getTipo().matches("Pequeña"))
                        costo = 300;

                    if(mesa.getTipo().matches("Mediana"))
                        costo = 500;

                    if(mesa.getTipo().matches("Grande"))
                        costo = 800;
                    
                    reserva.setPrecioReserva(costo);
                    
                    FrameSeleccionMesa frm = new FrameSeleccionMesa(frmInfo, reserva, mesas);
                    
                    FrameIngresarCliente frmCliente = new FrameIngresarCliente(frm, reserva, mesa);
                    frmCliente.setVisible(true);
                    cerrarFrame();
                    
                    
                }
            }));
    }
    
    private void cerrarFrame(){
        
        this.dispose();
        
    }
    
    private void cargarDatosTablaMesas() {
        
        modeloTabla = (DefaultTableModel) tblMesas.getModel();
        
        for(MesaDTO mesa : mesas){
        
            int capacidad  = mesa.getCapacidad();
            String costo = "$";
            
            if(mesa.getTipo().matches("Pequeña"))
                costo = costo.concat("300");
            
            if(mesa.getTipo().matches("Mediana"))
                costo = costo.concat("500");
            
            if(mesa.getTipo().matches("Grande"))
                costo = costo.concat("800");
            
            Object[] fila = new Object[2];
            fila[0] = capacidad;
            fila[1] = costo;
            
            modeloTabla.addRow(fila);
            
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
        lblAtras = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(51, 36, 12));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Seleccione su mesa.png"))); // NOI18N

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

        tblMesas.setBackground(new java.awt.Color(241, 228, 153));
        tblMesas.setForeground(new java.awt.Color(0, 0, 0));
        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Capacidad", "Costo", "Seleccionar"
            }
        ));
        tblMesas.setGridColor(new java.awt.Color(221, 188, 0));
        tblMesas.setSelectionBackground(new java.awt.Color(221, 188, 0));
        tblMesas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblMesas);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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
        frmInfo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAtrasMouseClicked

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tblMesas;
    // End of variables declaration//GEN-END:variables
}
