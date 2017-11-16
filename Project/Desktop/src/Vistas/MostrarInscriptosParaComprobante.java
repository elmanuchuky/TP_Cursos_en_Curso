/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Model.ComboCurso;
import Model.GestorAsistencia;
import Model.GestorCurso;
import Model.GestorInscripcion;
import Model.VMCertificado;
import Model.VMInscriptosPagados;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando M. de Lima
 */
public class MostrarInscriptosParaComprobante extends javax.swing.JFrame {

    /**
     * Creates new form Mostrar
     */
    final JDialog dialog = new JDialog();
    
    public MostrarInscriptosParaComprobante() {
        initComponents();
        cargarCombo();
        dialog.setAlwaysOnTop(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInscriptos = new javax.swing.JTable();
        cmbCursos = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        btnGenerarComprobante = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar Certificado");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1245, 425));
        setPreferredSize(new java.awt.Dimension(1245, 425));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        tblInscriptos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblInscriptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblInscriptos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(-2, 60, 1230, 275);

        cmbCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(cmbCursos);
        cmbCursos.setBounds(10, 12, 520, 23);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(1130, 10, 89, 25);

        btnGenerarComprobante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGenerarComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/certificate.png"))); // NOI18N
        btnGenerarComprobante.setText("Genenarar Certificado");
        btnGenerarComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarComprobanteActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarComprobante);
        btnGenerarComprobante.setBounds(1003, 350, 210, 25);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel11.setText("jLabel1");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 700, 290);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel9.setText("jLabel1");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 0, 700, 290);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel10.setText("jLabel1");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(90, 0, 700, 290);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel12.setText("jLabel1");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(180, 0, 700, 290);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel13.setText("jLabel1");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(140, 0, 700, 290);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel14.setText("jLabel1");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(90, 0, 700, 290);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel15.setText("jLabel1");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(230, 0, 700, 290);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel16.setText("jLabel1");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(180, 0, 700, 290);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel17.setText("jLabel1");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(270, 0, 700, 290);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel18.setText("jLabel1");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(360, 0, 700, 290);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel19.setText("jLabel1");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(270, 0, 700, 290);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel20.setText("jLabel1");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(320, 0, 700, 290);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel21.setText("jLabel1");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(450, 0, 700, 290);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel22.setText("jLabel1");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(360, 0, 700, 290);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel23.setText("jLabel1");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(410, 0, 700, 290);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel24.setText("jLabel1");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(540, 0, 700, 290);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel25.setText("jLabel1");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(450, 0, 700, 290);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel26.setText("jLabel1");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(500, 0, 700, 290);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel8.setText("jLabel1");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 40, 690, 390);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.PNG"))); // NOI18N
        jLabel6.setText("jLabel1");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(660, 40, 690, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        if (cmbCursos.getSelectedIndex() != -1) {
            int idCurso = ((ComboCurso) cmbCursos.getSelectedItem()).getId();
            GestorInscripcion gi = new GestorInscripcion();
            ArrayList<VMInscriptosPagados> lista = gi.obtenerPorCursoPagados(idCurso);
            Object[] columnas = {"Codigo", "Nombre", "Pago"};
            model.setColumnIdentifiers(columnas);
            for (VMInscriptosPagados vm : lista) {
                Object[] fila = {vm.getCodigo(), vm.getNombre(), vm.getPago()};
                model.addRow(fila);
            }
        }
        tblInscriptos.setModel(model);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGenerarComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarComprobanteActionPerformed
        // TODO add your handling code here:
        if (cmbCursos.getSelectedIndex() >= 0) {
            if (tblInscriptos.getModel().getValueAt(tblInscriptos.getSelectedRow(), 2).equals("Pago completo")) {
                int idInscripcion = (int) tblInscriptos.getModel().getValueAt(tblInscriptos.getSelectedRow(), 0);
                GestorAsistencia ga = new GestorAsistencia();
                VMCertificado vmc = ga.ObtenerCertificadoPorIdInscripcion(idInscripcion);
                imprimirPDF(vmc);
            } else {
                JOptionPane.showMessageDialog(dialog, "No se puede realizar el certificado para este inscripto porque no cumple las condiciones");
            }
        } else {
            JOptionPane.showMessageDialog(dialog, "No se ha seleccionado un inscripto");
        }
    }//GEN-LAST:event_btnGenerarComprobanteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MenuPrincipal.vCertificado = false;
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
            java.util.logging.Logger.getLogger(MostrarInscriptosParaComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarInscriptosParaComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarInscriptosParaComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarInscriptosParaComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarInscriptosParaComprobante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGenerarComprobante;
    private javax.swing.JComboBox<String> cmbCursos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInscriptos;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            GestorCurso gc = new GestorCurso();
            ArrayList<ComboCurso> lista = gc.ComboCursosActuales();
            for (ComboCurso comboCurso : lista) {
                model.addElement(comboCurso);
            }
            cmbCursos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarInscriptosParaComprobante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarInscriptosParaComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirPDF(VMCertificado vmc) {
        try {
            Document doc = new Document(PageSize.A4.rotate());
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Certificado" + vmc.getAlumno().replace(", ", "") + ".pdf"));

            doc.open();

//            //seteamos el titulo
//            Font letraTitulo = FontFactory.getFont("Verdana", 24, Font.UNDERLINE);
//            Paragraph title = new Paragraph("Certificado", letraTitulo);
//            title.setAlignment(Element.ALIGN_CENTER);
            //seteamos la imagen de certificado que utilizaremos
            com.itextpdf.text.Image certificado = com.itextpdf.text.Image.getInstance("src/Imagenes/certificado.jpg");
            float width = doc.getPageSize().getWidth();
            float height = doc.getPageSize().getHeight();
            writer.getDirectContentUnder().addImage(certificado, width, 0, 0, height, 0, 0);

            //seteamos el contenido del mensaje
            Font letraContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.ITALIC);
            Paragraph contenido = new Paragraph("  ", letraContenido);
            Paragraph contenido1 = new Paragraph("Se hace constar que el alumno " + vmc.getAlumno() + ", \ncon Documento Nro: " + vmc.getDocumento() + "\n Asistió y aprobó el curso " + vmc.getNombreCurso(), letraContenido);
            contenido1.setIndentationLeft(90);
            contenido1.setSpacingBefore(120);

            //seteamos el contenido del mensaje
            Font letraContenido2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.ITALIC);
            Paragraph contenido2 = new Paragraph("con una duración de " + vmc.getHoras() + " horas.  \n desde: " + vmc.getFechaInicio() + " hasta: " + vmc.getFechaFinal(), letraContenido2);
            contenido2.setIndentationLeft(0);
            contenido2.setSpacingBefore(70);
            contenido2.setAlignment(Element.ALIGN_CENTER);

            //pasamos al documento (por orden) las cosas que deseamos mostrar
            doc.add(contenido);
            doc.add(contenido1);
            doc.add(contenido2);

            doc.close();

            Desktop.getDesktop().open(new File("Certificado" + vmc.getAlumno().replace(", ", "") + ".pdf"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (DocumentException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
