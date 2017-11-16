/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Model.ComboCurso;
import Model.ComboNuevoCursante;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Model.GestorCurso;
import Model.GestorInscripcion;
import Model.GestorPago;
import Model.Pago;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yasmin
 */
public class RegistrarPago extends javax.swing.JFrame {

    GestorCurso g;
    final JDialog dialog = new JDialog();

    public RegistrarPago() {
        initComponents();
        dialog.setAlwaysOnTop(true);
        g = new GestorCurso();
        try {
            cargarComboCurso(g.ComboCursoProximoyActuales());
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        this.setLocationRelativeTo(null);
        soloNumero(txtMonto);
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
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cobro");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(450, 193));
        setPreferredSize(new java.awt.Dimension(450, 193));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnCarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrow.png"))); // NOI18N
        btnCarga.setText("Cargar");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarga);
        btnCarga.setBounds(350, 120, 110, 30);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(370, 20, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("E-Mail");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 40, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Curso");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 36, 17);

        txtMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });
        getContentPane().add(txtMail);
        txtMail.setBounds(70, 20, 290, 30);

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtMonto);
        txtMonto.setBounds(72, 100, 79, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Monto  $");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(15, 110, 60, 17);

        cmbCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(cmbCursos);
        cmbCursos.setBounds(70, 60, 260, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        try {
            //codigo de carga
            if (esValido()) {
                if (existeMail()) {
                    GestorPago gp = new GestorPago();
                    GestorInscripcion gi = new GestorInscripcion();
                    Pago p = new Pago();
                    p.setMonto(Double.parseDouble(txtMonto.getText()));
                    p.setInscripcion(gi.obtenerInscripcionConMailYCurso(txtMail.getText(), ((ComboCurso) cmbCursos.getSelectedItem()).getId()));
                    java.util.Date fecha = new java.util.Date();

                    Timestamp tm = new Timestamp(fecha.getTime());
                    gp.agregarPago(p);
                    JOptionPane.showMessageDialog(dialog, "Se ha registrado un nuevo cobro");
                    Pago p1 = gp.obtenerUltimoPago();
                    double montoFinal = (p.getMonto() - p1.getMonto());
                    if (montoFinal != 0) {
                        JOptionPane.showMessageDialog(dialog, "Se ha intentado pagar de más", "Atención", JOptionPane.ERROR_MESSAGE);
                        imprimirComprobante(tm, p1.getFechaPago(), ((ComboCurso) cmbCursos.getSelectedItem()).getNombre(), p1.getMonto(), p1.getIdPago());
                        this.dispose();
                    }
                    else{
                        imprimirComprobante(tm, p1.getFechaPago(), ((ComboCurso) cmbCursos.getSelectedItem()).getNombre(), p.getMonto(), p1.getIdPago());
                        this.dispose();
                    }
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(dialog, "¡No existe un e-mail relacionado a ese curso!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (BadElementException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarPago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMailActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        //codigo de carga
        if (existeMailSolo()) {
            g = new GestorCurso();
            cargarComboCurso(g.ComboCursosPagar(txtMail.getText()));
        } else {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement(new ComboCurso(-1, "E-Mail sin curso"));
            cmbCursos.setModel(model);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCarga;
    private javax.swing.JComboBox cmbCursos;
    private javax.swing.JLabel jLabel1;
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

    public void imprimirComprobante(Timestamp tm, String fecha, String curso, double monto, int id) throws FileNotFoundException, BadElementException, IOException {
        String nombreArchivo = "" + tm.getTime();
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("" + nombreArchivo + ".pdf"));
            doc.open();

            //seteamos el titulo
            Font letraTitulo = FontFactory.getFont("Verdana", 24, Font.UNDERLINE);
            Paragraph title = new Paragraph("COMPROBANTE DE PAGO \n \n", letraTitulo);
            title.setAlignment(Element.ALIGN_CENTER);

            //seteamos el contenido del mensaje
            Font letraContenido = FontFactory.getFont("Verdana", 15, BaseColor.BLACK);
            Paragraph contenido = new Paragraph("Se recibe del Colegio de Ciencias Informáticas de Córdoba, en consentimiento del pago realizado, con respecto a lo abonado en el curso de " + curso + " \n \n", letraContenido);

            //seteamos la imagen
            com.itextpdf.text.Image firma = com.itextpdf.text.Image.getInstance("src/Imagenes/FirmaSello.png");
            firma.setAlignment(Element.ALIGN_RIGHT);

            //seteamos la imagen
            com.itextpdf.text.Image iml = com.itextpdf.text.Image.getInstance("src/Imagenes/LogoPago.png");

            //seteamos la letra de saldo
            Font letraSaldo = FontFactory.getFont("Verdana", 16, BaseColor.BLACK);
            Paragraph contenidoSuma = new Paragraph("Se ha cobrado:         $" + monto, letraSaldo);

            //seteamos los datos del margen derecho superior
            Font formatoDato = FontFactory.getFont("Verdana", 16, BaseColor.BLACK);
            Paragraph dato = new Paragraph("        Recibo Nro. " + id + "\n         " + fecha, formatoDato);
            dato.setAlignment(Element.ALIGN_RIGHT);
            //encabezado con imagenes y datos
            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell(iml);
            tabla.addCell(dato);

            //cuerpo con sus respectivos datos
            PdfPTable cuerpo = new PdfPTable(1);
            PdfPCell celda1 = new PdfPCell(contenido);
            celda1.setBorder(Rectangle.NO_BORDER);
            cuerpo.addCell(celda1);
            cuerpo.setSpacingAfter(40);
            cuerpo.setSpacingBefore(20);

            //pie de recibo
            PdfPTable saldoFirma = new PdfPTable(2);
            PdfPCell saldo = new PdfPCell(contenidoSuma);
            saldo.setBorder(Rectangle.NO_BORDER);
            PdfPCell firmacell = new PdfPCell(firma);
            firmacell.setBorder(Rectangle.NO_BORDER);
            saldoFirma.addCell(saldo);
            saldoFirma.addCell(firmacell);

            //pasamos al documento (por orden) las cosas que deseamos mostrar
            doc.add(tabla);
            doc.add(title);
            doc.add(cuerpo);
            doc.add(saldoFirma);

            doc.close();

            Desktop.getDesktop().open(new File("" + nombreArchivo + ".pdf"));
        } catch (DocumentException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private boolean esValido() {
        if (txtMail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "El campo e-mail no debe estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cmbCursos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(dialog, "¡Debe seleccionar un curso!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            double a = Double.parseDouble(txtMonto.getText());
            if (a < 0) {
                JOptionPane.showMessageDialog(dialog, "¡El campo monto debe ser un número positivo!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "¡El campo monto debe ser un número positivo!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean existeMailSolo() {
        GestorInscripcion gi = new GestorInscripcion();
        try {
            return gi.existeMail(txtMail.getText());
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean existeMail() throws ClassNotFoundException {
        GestorInscripcion gi = new GestorInscripcion();
        return gi.existeMailEnCurso(txtMail.getText(), ((ComboCurso) cmbCursos.getSelectedItem()).getId());
    }

    private void limpiarControles() {

        txtMail.setText("");
        cmbCursos.setSelectedIndex(-1);
        txtMonto.setText("");
    }

    public void soloNumero(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
}
