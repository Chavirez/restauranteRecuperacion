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
public class FrameGestionMesas extends javax.swing.JFrame {

    FrameModuloMesas frmModulo;
    FrameGestionMesas frmGestion;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    IRestauranteNegocio restauranteNegocio = new RestauranteNegocio();
    IMesaNegocio mesaNegocio = new MesaNegocio();
    List<MesaDTO> mesas = new ArrayList<>();

    
    /**
     * Creates new form FramePrincipal
     */
    public FrameGestionMesas(FrameModuloMesas frmModulo) {

        this.frmModulo = frmModulo;
        this.frmGestion = this;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();


        
        inicializarComponentes();
        
    }
    
    public void inicializarComponentes(){
    
        configurarTablaMesas();
        llenarComboSecciones();
        
    }
    
    private void configurarTablaMesas() {
        
        modeloTabla = (DefaultTableModel) tblMesas.getModel();
        TableColumnModel modeloColumnas = tblMesas.getColumnModel();

        // Configurar renderizador y editor de botón
        modeloTabla.setRowCount(0);
        modeloColumnas.getColumn(2).setCellRenderer(new JButtonRenderer("Eliminar", new Color(221,188,0)));
        modeloColumnas.getColumn(2).setCellEditor(new JButtonCellEditor("Eliminar", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 
                    if(tblMesas.getSelectedRow() == -1)
                        return;
                    
                    MesaDTO mesa = mesas.get(tblMesas.getSelectedRow());
                    int option = JOptionPane.showConfirmDialog(frmModulo, "Estás seguro que quieres eliminar la siguiente mesa? " + mesa.getCodigo(),
                            "Importante", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE );
                    if(option == JOptionPane.YES_OPTION){
                    

                        try {
                            mesaNegocio.eliminarMesa(mesa);
                        } catch (NegocioException ex) {
                           JOptionPane.showMessageDialog(frmModulo, "Error al eliminar mesa en base de datos " + ex);
                        }
                        
                        cargarMesasPorSeccion();
                        
                    }
                    if(option == JOptionPane.NO_OPTION){
                    
                       
                        
                    }


                }
            }));
        modeloColumnas.getColumn(1).setCellRenderer(new JButtonRenderer("Editar", new Color(221,188,0)));
        modeloColumnas.getColumn(1).setCellEditor(new JButtonCellEditor("Editar", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    if(tblMesas.getSelectedRow() == -1)
                        return;
                    
                    MesaDTO mesaSeleccionada = mesas.get(tblMesas.getSelectedRow());
                    
                    FrameEditarMesa frm = new FrameEditarMesa(frmGestion, mesaSeleccionada);
                    
                    frm.setVisible(true);
                    cargarDatosTablaMesas();
                    cerrarFrame();
                    

                    
                    
                }
            }));
        
    }
    

    private void cerrarFrame(){
    
        this.dispose();
        
    }
    
    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            
            cargarMesasPorSeccion();
            this.repaint();
            
        } 

        // Llama al método original para asegurarte de que la funcionalidad básica de setVisible siga funcionando
        super.setVisible(visible);
    }
    
    private void cargarDatosTablaMesas() {
        
        modeloTabla = (DefaultTableModel) tblMesas.getModel();
        modeloTabla.setRowCount(0);
        
        if(mesas == null || mesas.isEmpty())
            return;
        
        for(MesaDTO mesa : mesas){
        
            String codigo  = mesa.getCodigo();

            
            Object[] fila = new Object[2];
            fila[0] = codigo;
            
            modeloTabla.addRow(fila);
            
        }
        
    }
    
    private void llenarComboSecciones(){
        
        try {
            for(String ubicacion : restauranteNegocio.buscarRestaurante().getUbicaciones()){
                
                boxSeccion.addItem(ubicacion);
                
            }
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al llenar box de secciones" + ex);
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
        boxSeccion = new javax.swing.JComboBox<>();
        lblSeccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(51, 36, 12));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestión de mesas.png"))); // NOI18N

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
                "Código", "Editar", "Eliminar"
            }
        ));
        tblMesas.setToolTipText("");
        tblMesas.setGridColor(new java.awt.Color(221, 188, 0));
        tblMesas.setSelectionBackground(new java.awt.Color(221, 188, 0));
        tblMesas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblMesas);

        boxSeccion.setBackground(new java.awt.Color(241, 228, 153));
        boxSeccion.setForeground(new java.awt.Color(0, 0, 0));
        boxSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSeccionActionPerformed(evt);
            }
        });

        lblSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Seleccion la seccion deseada.png"))); // NOI18N

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
                        .addGap(244, 244, 244)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxSeccion, 0, 304, Short.MAX_VALUE)
                            .addComponent(lblSeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(18, 18, 18)
                .addComponent(lblSeccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        frmModulo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void cargarMesasPorSeccion(){
        
        if(mesas != null)
            this.mesas.removeAll(mesas);
        
        MesaDTO seccion = new MesaDTO();
        seccion.setUbicacion(boxSeccion.getSelectedItem().toString());
 
        try {
            this.mesas = mesaNegocio.buscarMesasPorSeccion(seccion);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar mesas por seccion" + ex);
        }

        cargarDatosTablaMesas();
        
    }
    
    private void boxSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSeccionActionPerformed
        // TODO add your handling code here:

        cargarMesasPorSeccion();
        
    }//GEN-LAST:event_boxSeccionActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxSeccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tblMesas;
    // End of variables declaration//GEN-END:variables
}
