/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import DTO.ClienteDTO;
import DTO.ReservaDTO;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class FrameReporte extends javax.swing.JFrame {

    FrameClientesDesplegados frmClientesDesplegados;
    FramePorArea frmPorArea;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    List<ReservaDTO> reservas = new ArrayList<>();
    ClienteDTO cliente;
    String filtro;
    int tipoReporte = 0;
    

    
    /**
     * Creates new form FramePrincipal
     * @param frmClientesDesplegados
     * @param reservas
     * @param cliente
     */
    public FrameReporte(FrameClientesDesplegados frmClientesDesplegados,List<ReservaDTO> reservas, ClienteDTO cliente) {

        this.frmClientesDesplegados = frmClientesDesplegados;
        this.cliente = cliente;
        this.tipoReporte = 1;
        this.reservas = reservas;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        
        inicializarComponentes();
        
    }
    /**
     * Creates new form FramePrincipal
     * @param frmPorArea
     * @param reservas
     * @param filtro
     */
    public FrameReporte(FramePorArea frmPorArea,List<ReservaDTO> reservas, String filtro) {

        this.frmPorArea = frmPorArea;
        this.tipoReporte = 2;
        this.reservas = reservas;
        this.filtro = filtro;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        
        inicializarComponentes();
        
    }
    
    public void inicializarComponentes(){

        cargarDatosTablaReserva();
        
    }
    
    private void cargarDatosTablaReserva() {
        
        modeloTabla = (DefaultTableModel) tblReserva.getModel();
        modeloTabla.setRowCount(0);
        
        if(reservas == null || reservas.isEmpty())
            return;
        
        for(ReservaDTO reserva : reservas){
        
            String nombreCompleto  = reserva.getCliente().getNombreCompleto();
            String codigoMesa  = reserva.getMesa().getCodigo();
            String costo = "$" + String.valueOf((int) reserva.getPrecioReserva() *100);  
            String cantidad = reserva.getNumPersonas() + " comensales";   
            
            Object[] fila = new Object[4];
            fila[0] = nombreCompleto;
            fila[1] = codigoMesa;
            fila[2] = cantidad;
            fila[3] = costo;

            modeloTabla.addRow(fila);
            
        }
        
    }

    private void generarReporte(List<ReservaDTO> reservas){

        String titulo = "ERROR";
        
        if(tipoReporte == 1)
            titulo = cliente.getNombreCompleto();
        
        if(tipoReporte == 2)
            titulo = filtro;
        
        String dest = "reporte" + titulo + ".pdf";

        try {

            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            
            document.add(new Paragraph("Romina's"));
            document.add(new Paragraph(currentDate.format(formatter)));
            document.add(new Paragraph("Reporte de reservas de = " + titulo));

            float[] columnWidths = {200, 200, 200, 200};
            Table table = new Table(columnWidths);
            if (reservas != null) {
                reservas.forEach(row -> {

                String costo = "$" + String.valueOf((int) row.getPrecioReserva()*100);      
                String cantidad = row.getNumPersonas()+ " comensales";    
                table.addCell(row.getCliente().getNombreCompleto());
                table.addCell(row.getMesa().getCodigo());
                table.addCell(cantidad);
                table.addCell(costo);

            });
        }

            document.add(table);
            document.close();
            
            JOptionPane.showMessageDialog(this, "Reporte de reservas generado con éxito!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();    
    
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
        tblReserva = new javax.swing.JTable();
        lblGenerarReporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(51, 36, 12));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reporte.png"))); // NOI18N

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

        tblReserva.setBackground(new java.awt.Color(241, 228, 153));
        tblReserva.setForeground(new java.awt.Color(0, 0, 0));
        tblReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Mesa", "Cantidad de Comensales", "Precio reserva"
            }
        ));
        tblReserva.setToolTipText("");
        tblReserva.setGridColor(new java.awt.Color(221, 188, 0));
        tblReserva.setSelectionBackground(new java.awt.Color(221, 188, 0));
        tblReserva.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblReserva);

        lblGenerarReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Generar reporte.png"))); // NOI18N
        lblGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenerarReporteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addContainerGap())
            .addComponent(lblGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(lblGenerarReporte)
                .addGap(28, 28, 28))
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

        if(tipoReporte == 1){
        
        frmClientesDesplegados.setVisible(true);
        this.dispose();
            
        }

        if(tipoReporte == 2){
        
        frmPorArea.setVisible(true);
        this.dispose();
            
        }
        
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void lblGenerarReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerarReporteMouseClicked
        // TODO add your handling code here:
        
        generarReporte(reservas);

    }//GEN-LAST:event_lblGenerarReporteMouseClicked

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGenerarReporte;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tblReserva;
    // End of variables declaration//GEN-END:variables
}
