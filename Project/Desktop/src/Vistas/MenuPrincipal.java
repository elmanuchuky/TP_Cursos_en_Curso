/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Frame;
import javafx.scene.layout.Background;
import javax.swing.JFrame;

/**
 *
 * @author Yasmin
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        lblImagen = new javax.swing.JLabel();
        jmbBarraMenu = new javax.swing.JMenuBar();
        jmRegistrar = new javax.swing.JMenu();
        jmiRegistrarMatriculaddo = new javax.swing.JMenuItem();
        jmiRegistrarInscripto = new javax.swing.JMenu();
        jmiRegistrarInscriptoMatriculado = new javax.swing.JMenuItem();
        jmiRegistrarInscriptoFamilia = new javax.swing.JMenuItem();
        jmiRegistrarInscriptoOtro = new javax.swing.JMenuItem();
        jmiRegistrarCurso = new javax.swing.JMenuItem();
        jmiRegistrarPago = new javax.swing.JMenuItem();
        jmAsistencia = new javax.swing.JMenu();
        jmiAsistenciaRegistrar = new javax.swing.JMenuItem();
        jmiRegistrarInscripto1 = new javax.swing.JMenu();
        jmiAsistenciaMostrarXCurso = new javax.swing.JMenuItem();
        jmiAsistenciaMostrarXFecha = new javax.swing.JMenuItem();
        jmiAsistenciaMostrarXCursante = new javax.swing.JMenuItem();
        jmEditar = new javax.swing.JMenu();
        jmiEditarMatriculado = new javax.swing.JMenuItem();
        jmiEditarIscripcion = new javax.swing.JMenu();
        jmiEditarIscripcionMatriculado = new javax.swing.JMenuItem();
        jmiEditarIscripcionFamilia = new javax.swing.JMenuItem();
        jmiEditarIscripcionOtro = new javax.swing.JMenuItem();
        jmiEditarCurso = new javax.swing.JMenuItem();
        jmConsulta = new javax.swing.JMenu();
        jmiConsultaCursos = new javax.swing.JMenuItem();
        jmiConsultaPreInscripcion = new javax.swing.JMenuItem();
        jmiConsultaInscripto = new javax.swing.JMenuItem();
        jmiConsultaPagos = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoPrincipal.jpg"))); // NOI18N

        jmRegistrar.setText("Registar");

        jmiRegistrarMatriculaddo.setText("Matriculado");
        jmiRegistrarMatriculaddo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarMatriculaddoActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmiRegistrarMatriculaddo);

        jmiRegistrarInscripto.setText("Inscripción");

        jmiRegistrarInscriptoMatriculado.setText("Matriculado");
        jmiRegistrarInscriptoMatriculado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarInscriptoMatriculadoActionPerformed(evt);
            }
        });
        jmiRegistrarInscripto.add(jmiRegistrarInscriptoMatriculado);

        jmiRegistrarInscriptoFamilia.setText("Familiar");
        jmiRegistrarInscriptoFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarInscriptoFamiliaActionPerformed(evt);
            }
        });
        jmiRegistrarInscripto.add(jmiRegistrarInscriptoFamilia);

        jmiRegistrarInscriptoOtro.setText("Otro");
        jmiRegistrarInscriptoOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarInscriptoOtroActionPerformed(evt);
            }
        });
        jmiRegistrarInscripto.add(jmiRegistrarInscriptoOtro);

        jmRegistrar.add(jmiRegistrarInscripto);

        jmiRegistrarCurso.setText("Curso");
        jmiRegistrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarCursoActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmiRegistrarCurso);

        jmiRegistrarPago.setText("Pago");
        jmiRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarPagoActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmiRegistrarPago);

        jmbBarraMenu.add(jmRegistrar);

        jmAsistencia.setText("Asistencia");

        jmiAsistenciaRegistrar.setText("Registrar");
        jmiAsistenciaRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAsistenciaRegistrarActionPerformed(evt);
            }
        });
        jmAsistencia.add(jmiAsistenciaRegistrar);

        jmiRegistrarInscripto1.setText("Mostrar");

        jmiAsistenciaMostrarXCurso.setText("Por Curso");
        jmiAsistenciaMostrarXCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAsistenciaMostrarXCursoActionPerformed(evt);
            }
        });
        jmiRegistrarInscripto1.add(jmiAsistenciaMostrarXCurso);

        jmiAsistenciaMostrarXFecha.setText("Por Curso/Fecha ");
        jmiAsistenciaMostrarXFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAsistenciaMostrarXFechaActionPerformed(evt);
            }
        });
        jmiRegistrarInscripto1.add(jmiAsistenciaMostrarXFecha);

        jmiAsistenciaMostrarXCursante.setText("Por Curso/Cursante");
        jmiAsistenciaMostrarXCursante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAsistenciaMostrarXCursanteActionPerformed(evt);
            }
        });
        jmiRegistrarInscripto1.add(jmiAsistenciaMostrarXCursante);

        jmAsistencia.add(jmiRegistrarInscripto1);

        jmbBarraMenu.add(jmAsistencia);

        jmEditar.setText("Editar");

        jmiEditarMatriculado.setText("Matriculado");
        jmiEditarMatriculado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarMatriculadoActionPerformed(evt);
            }
        });
        jmEditar.add(jmiEditarMatriculado);

        jmiEditarIscripcion.setText("Inscripción");

        jmiEditarIscripcionMatriculado.setText("Matriculado");
        jmiEditarIscripcionMatriculado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarIscripcionMatriculadoActionPerformed(evt);
            }
        });
        jmiEditarIscripcion.add(jmiEditarIscripcionMatriculado);

        jmiEditarIscripcionFamilia.setText("Familiar");
        jmiEditarIscripcionFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarIscripcionFamiliaActionPerformed(evt);
            }
        });
        jmiEditarIscripcion.add(jmiEditarIscripcionFamilia);

        jmiEditarIscripcionOtro.setText("Otro");
        jmiEditarIscripcionOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarIscripcionOtroActionPerformed(evt);
            }
        });
        jmiEditarIscripcion.add(jmiEditarIscripcionOtro);

        jmEditar.add(jmiEditarIscripcion);

        jmiEditarCurso.setText("Curso");
        jmiEditarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarCursoActionPerformed(evt);
            }
        });
        jmEditar.add(jmiEditarCurso);

        jmbBarraMenu.add(jmEditar);

        jmConsulta.setText("Consultas");

        jmiConsultaCursos.setText("Cursos");
        jmiConsultaCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaCursosActionPerformed(evt);
            }
        });
        jmConsulta.add(jmiConsultaCursos);

        jmiConsultaPreInscripcion.setText("Pre_inscriptos");
        jmiConsultaPreInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaPreInscripcionActionPerformed(evt);
            }
        });
        jmConsulta.add(jmiConsultaPreInscripcion);

        jmiConsultaInscripto.setText("Inscriptos");
        jmiConsultaInscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaInscriptoActionPerformed(evt);
            }
        });
        jmConsulta.add(jmiConsultaInscripto);

        jmiConsultaPagos.setText("Pagos");
        jmiConsultaPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaPagosActionPerformed(evt);
            }
        });
        jmConsulta.add(jmiConsultaPagos);

        jmbBarraMenu.add(jmConsulta);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiRegistrarMatriculaddoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarMatriculaddoActionPerformed
        RegistrarMatriculado rm = new RegistrarMatriculado();
        rm.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarMatriculaddoActionPerformed

    private void jmiRegistrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarCursoActionPerformed
       RegistrarCurso rc = new RegistrarCurso();
       rc.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarCursoActionPerformed

    private void jmiRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarPagoActionPerformed
       RegistrarPago rp = new RegistrarPago();
       rp.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarPagoActionPerformed

    private void jmiAsistenciaRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAsistenciaRegistrarActionPerformed
       AsistenciaRegistrar ar = new AsistenciaRegistrar();
       ar.setVisible(true);
    }//GEN-LAST:event_jmiAsistenciaRegistrarActionPerformed

    private void jmiEditarMatriculadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarMatriculadoActionPerformed
        EditarMatriculado em = new EditarMatriculado();
        em.setVisible(true);
    }//GEN-LAST:event_jmiEditarMatriculadoActionPerformed

    private void jmiEditarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarCursoActionPerformed
        EditarCurso ec = new EditarCurso();
        ec.setVisible(true);
    }//GEN-LAST:event_jmiEditarCursoActionPerformed

    private void jmiConsultaCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaCursosActionPerformed
        ConsultaCurso cc = new ConsultaCurso();
        cc.setVisible(true);
    }//GEN-LAST:event_jmiConsultaCursosActionPerformed

    private void jmiConsultaPreInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaPreInscripcionActionPerformed
        ConsultaPreInscripcion cpi = new ConsultaPreInscripcion();
        cpi.setVisible(true);
    }//GEN-LAST:event_jmiConsultaPreInscripcionActionPerformed

    private void jmiConsultaInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaInscriptoActionPerformed
        ConsultaInscripcion ci = new ConsultaInscripcion();
        ci.setVisible(true);
    }//GEN-LAST:event_jmiConsultaInscriptoActionPerformed

    private void jmiConsultaPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaPagosActionPerformed
        ConsultaPago cp = new ConsultaPago();
        cp.setVisible(true);
    }//GEN-LAST:event_jmiConsultaPagosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        VentanaCerrarSesion vp = new VentanaCerrarSesion();
//        this.setVisible(true);
//        vp.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jmiRegistrarInscriptoMatriculadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarInscriptoMatriculadoActionPerformed
       RegistrarInscripto ri = new RegistrarInscripto(1);//Matriculado
       ri.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarInscriptoMatriculadoActionPerformed

    private void jmiRegistrarInscriptoFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarInscriptoFamiliaActionPerformed
       RegistrarInscripto ri = new RegistrarInscripto(2);//Familiar
       ri.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarInscriptoFamiliaActionPerformed

    private void jmiRegistrarInscriptoOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarInscriptoOtroActionPerformed
       RegistrarInscripto ri = new RegistrarInscripto(3);//Otro
       ri.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarInscriptoOtroActionPerformed

    private void jmiEditarIscripcionMatriculadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarIscripcionMatriculadoActionPerformed
        EditarInscripcion ei = new EditarInscripcion(1);//Matriculado
        ei.setVisible(true);
    }//GEN-LAST:event_jmiEditarIscripcionMatriculadoActionPerformed

    private void jmiEditarIscripcionFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarIscripcionFamiliaActionPerformed
        EditarInscripcion ei = new EditarInscripcion(2);//Familiar
        ei.setVisible(true);
    }//GEN-LAST:event_jmiEditarIscripcionFamiliaActionPerformed

    private void jmiEditarIscripcionOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarIscripcionOtroActionPerformed
        EditarInscripcion ei = new EditarInscripcion(3);//Otro
        ei.setVisible(true);
    }//GEN-LAST:event_jmiEditarIscripcionOtroActionPerformed

    private void jmiAsistenciaMostrarXCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAsistenciaMostrarXCursoActionPerformed
        AsistenciaMostrar am = new AsistenciaMostrar (1);
        am.setVisible(true);
    }//GEN-LAST:event_jmiAsistenciaMostrarXCursoActionPerformed

    private void jmiAsistenciaMostrarXFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAsistenciaMostrarXFechaActionPerformed
        AsistenciaMostrar am = new AsistenciaMostrar (2);
        am.setVisible(true);
    }//GEN-LAST:event_jmiAsistenciaMostrarXFechaActionPerformed

    private void jmiAsistenciaMostrarXCursanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAsistenciaMostrarXCursanteActionPerformed
        AsistenciaMostrar am = new AsistenciaMostrar (3);
        am.setVisible(true);
    }//GEN-LAST:event_jmiAsistenciaMostrarXCursanteActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JMenu jmAsistencia;
    private javax.swing.JMenu jmConsulta;
    private javax.swing.JMenu jmEditar;
    private javax.swing.JMenu jmRegistrar;
    private javax.swing.JMenuBar jmbBarraMenu;
    private javax.swing.JMenuItem jmiAsistenciaMostrarXCursante;
    private javax.swing.JMenuItem jmiAsistenciaMostrarXCurso;
    private javax.swing.JMenuItem jmiAsistenciaMostrarXFecha;
    private javax.swing.JMenuItem jmiAsistenciaRegistrar;
    private javax.swing.JMenuItem jmiConsultaCursos;
    private javax.swing.JMenuItem jmiConsultaInscripto;
    private javax.swing.JMenuItem jmiConsultaPagos;
    private javax.swing.JMenuItem jmiConsultaPreInscripcion;
    private javax.swing.JMenuItem jmiEditarCurso;
    private javax.swing.JMenu jmiEditarIscripcion;
    private javax.swing.JMenuItem jmiEditarIscripcionFamilia;
    private javax.swing.JMenuItem jmiEditarIscripcionMatriculado;
    private javax.swing.JMenuItem jmiEditarIscripcionOtro;
    private javax.swing.JMenuItem jmiEditarMatriculado;
    private javax.swing.JMenuItem jmiRegistrarCurso;
    private javax.swing.JMenu jmiRegistrarInscripto;
    private javax.swing.JMenu jmiRegistrarInscripto1;
    private javax.swing.JMenuItem jmiRegistrarInscriptoFamilia;
    private javax.swing.JMenuItem jmiRegistrarInscriptoMatriculado;
    private javax.swing.JMenuItem jmiRegistrarInscriptoOtro;
    private javax.swing.JMenuItem jmiRegistrarMatriculaddo;
    private javax.swing.JMenuItem jmiRegistrarPago;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}