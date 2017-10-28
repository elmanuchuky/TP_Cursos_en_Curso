/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Model.GestorCurso;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Yasmin
 */
public class RegistrarPago extends javax.swing.JFrame {

    GestorCurso g;

    public RegistrarPago() {
        initComponents();
        g = new GestorCurso();
        try {
            cargarComboCurso(g.ComboCursoProximoyActuales());
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        this.setLocationRelativeTo(null);
    }

    public RegistrarPago(String mail, int i, String monto) {
        initComponents();
        txtMail.setText(mail);
        cmbCursos.setSelectedIndex(i);
        txtMonto.setText(monto);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCarga = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pago");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(445, 193));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrow.png"))); // NOI18N
        btnCarga.setText("Cargar");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mail");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Curso");

        txtMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Monto");

        cmbCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(19, 19, 19)
                            .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCarga)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        try {
            //codigo de carga

            imprimirComprobante();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrarPago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(RegistrarPago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCargaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String mail = txtMail.getText();
        int i = cmbCursos.getSelectedIndex();
        String monto = txtMonto.getText();

        VentanaCerrarPagos vep = new VentanaCerrarPagos(mail, i, monto);
        this.setVisible(true);
        vep.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/IconoDefinitivo.jpg"));
        return retValue;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarga;
    private javax.swing.JComboBox cmbCursos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
public void cargarComboCurso(ArrayList listaGenerica) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Object elemento : listaGenerica) {
            model.addElement(elemento);
        }

        cmbCursos.setModel(model);
    }

    public void imprimirComprobante() throws FileNotFoundException, BadElementException, IOException {

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Comprobante.pdf"));
            doc.open();
            
            
            //seteamos el titulo
            Font letraTitulo = FontFactory.getFont("Verdana", 24, BaseColor.BLACK);
            Paragraph title = new Paragraph("COMPROBANTE DE PAGO \n \n", letraTitulo);
            title.setAlignment(Element.ALIGN_CENTER);
            
            //seteamos el contenido del mensaje
            Font letraContenido = FontFactory.getFont("Verdana", 16, BaseColor.BLACK);
            Paragraph contenido = new Paragraph("Se recibe de la insitucion .... en concentimiento de .... del curso .... \n \n", letraContenido);
            
            //seteamos la imagen
            com.itextpdf.text.Image im = com.itextpdf.text.Image.getInstance("src/Imagenes/FirmaSello.png");
            im.setAlignment(Element.ALIGN_RIGHT);
            
            //seteamos la letra de saldo
            Font letraSaldo = FontFactory.getFont("Verdana", 16, BaseColor.BLACK);
            Paragraph contenidoSuma = new Paragraph("\n Suma de ...", letraSaldo);
            
            //seteamos los datos del margen derecho superior
            Font formatoDato = FontFactory.getFont("Verdana", 16, BaseColor.BLACK);
            Paragraph dato = new Paragraph("Recibo Nro. .... \n  + isnertefecha", formatoDato);
            
            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell(im);
            tabla.addCell(dato);
            
            doc.add(tabla);
            doc.add(title);
            doc.add(contenido);
            doc.add(contenidoSuma);
            doc.add(im);
            
            doc.close();
//            for (Consulta1DTO item : lista) {
//                Paragraph p = new Paragraph();
//                p.add("Responsable: " + item.getNombreResponsable());
//                p.add("\n - Cantidad: " + item.getCantidad());
//                doc.add(p);
//            }

            //Con  una tabla
//            PdfPTable tabla = new PdfPTable(2);
//
//            tabla.addCell("RESPONSABLE");
//            tabla.addCell("CANTIDAD");
//            for (Consulta1DTO item : lista) {
//                tabla.addCell(item.getNombreResponsable());
//                tabla.addCell(String.valueOf(item.getCantidad()));
//            }
//            doc.add(Chunk.NEWLINE);
//            doc.add(Chunk.NEWLINE);
//            doc.add(Chunk.NEWLINE);
//            doc.add(Chunk.NEWLINE);
//            doc.add(Chunk.NEWLINE);
//            doc.add(tabla);
//            
//            for (int i = 0; i < 10; i++) {
//                doc.add(new Paragraph("Parrafo numero " + i));
//            }

        } catch (DocumentException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
