/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Model.Curso;
import Model.GestorCurso;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasmin
 */
public class ConsultaCurso extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaCurso
     */
    public ConsultaCurso() {
        initComponents();
        cargarTodos();
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

        rbtTodos = new javax.swing.JRadioButton();
        rbtProximo = new javax.swing.JRadioButton();
        rbtActuales = new javax.swing.JRadioButton();
        txtaCursos = new javax.swing.JScrollPane();
        jtxtaCursos = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cursos");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(460, 450));
        setPreferredSize(new java.awt.Dimension(460, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        rbtTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtTodos.setSelected(true);
        rbtTodos.setText("Todos");
        rbtTodos.setOpaque(false);
        rbtTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTodosActionPerformed(evt);
            }
        });
        getContentPane().add(rbtTodos);
        rbtTodos.setBounds(10, 10, 100, 25);

        rbtProximo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtProximo.setText("Próximos");
        rbtProximo.setOpaque(false);
        rbtProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtProximoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtProximo);
        rbtProximo.setBounds(280, 10, 93, 25);

        rbtActuales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtActuales.setText("Actuales");
        rbtActuales.setOpaque(false);
        rbtActuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtActualesActionPerformed(evt);
            }
        });
        getContentPane().add(rbtActuales);
        rbtActuales.setBounds(130, 10, 90, 25);

        jtxtaCursos.setColumns(20);
        jtxtaCursos.setLineWrap(true);
        jtxtaCursos.setRows(5);
        jtxtaCursos.setWrapStyleWord(true);
        jtxtaCursos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtaCursos.setEnabled(false);
        txtaCursos.setViewportView(jtxtaCursos);

        getContentPane().add(txtaCursos);
        txtaCursos.setBounds(10, 40, 430, 360);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/purple-polygonal-960x540.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 480, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTodosActionPerformed
        truFalsRaddio(1);
        if (rbtTodos.isSelected()){
            cargarTodos();
        }
        //Llamar a la consulta que muestre todos los cursos
    }//GEN-LAST:event_rbtTodosActionPerformed

    private void rbtProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtProximoActionPerformed
        truFalsRaddio(2);
        if (rbtProximo.isSelected()){
            cargarProximos();
        }        //Llamar a la consulta cursos proximos
    }//GEN-LAST:event_rbtProximoActionPerformed

    private void rbtActualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtActualesActionPerformed
        truFalsRaddio(3);
        if (rbtActuales.isSelected()){
            cargarActuales();
        }        //Llamar a la consulta cursos Actuales
    }//GEN-LAST:event_rbtActualesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MenuPrincipal.vConsultaCurso = false;
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
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea jtxtaCursos;
    private javax.swing.JRadioButton rbtActuales;
    private javax.swing.JRadioButton rbtProximo;
    private javax.swing.JRadioButton rbtTodos;
    private javax.swing.JScrollPane txtaCursos;
    // End of variables declaration//GEN-END:variables


    private void truFalsRaddio ( int x){
       switch (x){
           case 1:
               rbtProximo.setSelected(false);
               rbtTodos.setSelected(true);
               rbtActuales.setSelected(false);
               break;
            case 2:
                rbtProximo.setSelected(true);
                rbtTodos.setSelected(false);
                rbtActuales.setSelected(false);
                break;
            case 3:
                rbtProximo.setSelected(false);
                rbtTodos.setSelected(false);
                rbtActuales.setSelected(true);
                break;
       }
    }

    private void cargarTodos() {
        GestorCurso gc = new GestorCurso();
        jtxtaCursos.setText("");
        try {
            for (Curso elemento : gc.TodosCursos()) {
                jtxtaCursos.setText(jtxtaCursos.getText() + elemento.toStringDatosCompletosTodos());
            }
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    private void cargarActuales() {
        GestorCurso gc = new GestorCurso();
        jtxtaCursos.setText("");
        try {
            for (Curso elemento : gc.obtenerCursoEnCurso()) {
                jtxtaCursos.setText(jtxtaCursos.getText() + elemento.toStringDatosCompletosTodos());
            }
        } catch (ClassNotFoundException ex) {
        }
    }

    private void cargarProximos() {
        GestorCurso gc = new GestorCurso();
        jtxtaCursos.setText("");
        try {
            for (Curso elemento : gc.proximosCursos()) {
                jtxtaCursos.setText(jtxtaCursos.getText() + elemento.toStringDatosCompletosTodos());
            }
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }
}
