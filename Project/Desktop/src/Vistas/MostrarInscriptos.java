/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Model.Curso;
import Model.GestorCurso;
import Model.GestorInscripcion;
import Model.GestorMatriculado;
import Model.VMMatriculado;
import static Vistas.MenuPrincipal.vRegistrarInscripcion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
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
public class MostrarInscriptos extends javax.swing.JFrame {

    /**
     * Creates new form MostrarCursos
     */
    ArrayList<VMMatriculado> matriculados;
    final JDialog dialog = new JDialog();

    public MostrarInscriptos() {
        initComponents();
        GestorMatriculado gm = new GestorMatriculado();
        matriculados = gm.obtenerMatriculados("");
        cargarTabla();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblInscriptos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnAgregarMatriculado = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cmbCursos = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1100, 380));
        setPreferredSize(new java.awt.Dimension(1100, 380));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        tblInscriptos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblInscriptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInscriptos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblInscriptos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 45, 1090, 241);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Matriculados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 75, 20);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload.png"))); // NOI18N
        btnActualizar.setText("Actualizar listado");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(930, 300, 151, 25);

        btnAgregarMatriculado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarMatriculado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        btnAgregarMatriculado.setText("Nuevo matriculado");
        btnAgregarMatriculado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMatriculadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarMatriculado);
        btnAgregarMatriculado.setBounds(10, 300, 170, 25);

        btnInscribir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrow.png"))); // NOI18N
        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });
        getContentPane().add(btnInscribir);
        btnInscribir.setBounds(810, 300, 110, 25);

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(570, 10, 420, 23);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(1000, 10, 80, 25);

        cmbCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(cmbCursos);
        cmbCursos.setBounds(100, 10, 450, 23);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel11.setText("jLabel1");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(570, 0, 500, 350);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel12.setText("jLabel1");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 500, 350);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel13.setText("jLabel1");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(70, 0, 500, 350);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel14.setText("jLabel1");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 0, 500, 340);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel15.setText("jLabel1");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 0, 500, 340);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel16.setText("jLabel1");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(40, 0, 500, 350);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistrar.jpg"))); // NOI18N
        jLabel17.setText("jLabel1");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(590, 0, 500, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        GestorMatriculado gm = new GestorMatriculado();
        matriculados = gm.obtenerMatriculados(txtBuscar.getText());
        cargarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        // TODO add your handling code here:
        if (tblInscriptos.getSelectedRow() == -1) {
            // Mensaje de Error
            JOptionPane.showMessageDialog(null, "¡No se ha seleccionado ningún registro!");
        } else {
            GestorInscripcion gi = new GestorInscripcion();
            int legajo = 0;
            int idCurso = 0;
            legajo = (int) tblInscriptos.getModel().getValueAt(tblInscriptos.getSelectedRow(), 1);
            idCurso = ((Curso) cmbCursos.getSelectedItem()).getIdCurso();
            try {
                gi.agregarInscripcionMatriculado(legajo, idCurso);
                JOptionPane.showMessageDialog(dialog, "Se ha registrado una nueva inscripción");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MostrarInscriptos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnAgregarMatriculadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMatriculadoActionPerformed
        try {
            // TODO add your handling code here:
            RegistrarMatriculado rm = new RegistrarMatriculado();
            rm.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarInscriptos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarInscriptos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarMatriculadoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MenuPrincipal.vRegistrarInscripcion = false;
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
            java.util.logging.Logger.getLogger(MostrarInscriptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarInscriptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarInscriptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarInscriptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarInscriptos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarMatriculado;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<String> cmbCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblInscriptos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnas = {"Id", "Legajo", "Profesión", "Nombre", "E-Mail", "Teléfono"};
        model.setColumnIdentifiers(columnas);
        for (VMMatriculado matriculado : matriculados) {
            Object[] fila = {matriculado.getId(), matriculado.getLegajo(), matriculado.getProfesion(), matriculado.getNombre(), matriculado.getMail(), matriculado.getTelefono()};
            model.addRow(fila);
        }
        tblInscriptos.setModel(model);
    }

    private void cargarCombo() {
        try {
            GestorCurso gc = new GestorCurso();
            ArrayList<Curso> cursos = gc.proximosCursos();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Curso curso : cursos) {
                model.addElement(curso);
            }
            cmbCursos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarInscriptos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarInscriptos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
