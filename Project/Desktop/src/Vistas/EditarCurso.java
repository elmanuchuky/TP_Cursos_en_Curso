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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yasmin
 */
public class EditarCurso extends javax.swing.JFrame {

    GestorCurso g = new GestorCurso();
    int id;
    String nombre;
    String descripcion;
    String tema;
    int duracion;
    String fecha;
    String aula;
    int cupo;
    double precio;
    String hora;
    int cargaHoraria;

    final JDialog dialog = new JDialog();

    public EditarCurso() {
        initComponents();
        cargaCmb();
        cargarDiaCombo();
        CargaHoraMinutos();
        this.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
        try {
            cargarCursosFiltro(g.TodosCursos());
        } catch (SQLException ex) {
            Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }

        soloNumero(txtDuracion);
        soloNumero(txtCargaHoraria);
        soloNumero(txtCupo);
        soloNumero(txtCosto);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAula = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaTema = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbMinutos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaDescripcion = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtCargaHoraria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        txtCupo = new javax.swing.JTextField();
        cmbAnio = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cmbDia = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbMes1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbCursosFiltro = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Curso");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(580, 400));
        setPreferredSize(new java.awt.Dimension(580, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        txtAula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAula.setEnabled(false);
        getContentPane().add(txtAula);
        txtAula.setBounds(70, 280, 70, 30);

        txtDuracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDuracion.setEnabled(false);
        getContentPane().add(txtDuracion);
        txtDuracion.setBounds(150, 233, 70, 30);

        jScrollPane1.setEnabled(false);

        txtaTema.setColumns(20);
        txtaTema.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtaTema.setRows(5);
        txtaTema.setEnabled(false);
        jScrollPane1.setViewportView(txtaTema);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 160, 470, 60);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setEnabled(false);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(90, 50, 470, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Hora");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(410, 290, 29, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Carga Horaria");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 330, 83, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cupo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(160, 290, 33, 17);

        cmbMinutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbMinutos.setEnabled(false);
        cmbMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMinutosActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMinutos);
        cmbMinutos.setBounds(510, 280, 50, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Aula");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 290, 25, 17);

        cmbHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbHora.setEnabled(false);
        getContentPane().add(cmbHora);
        cmbHora.setBounds(450, 280, 50, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Duracion en Semanas");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 240, 140, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Costo $");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 290, 50, 17);

        jScrollPane2.setEnabled(false);

        txtaDescripcion.setColumns(20);
        txtaDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtaDescripcion.setRows(5);
        txtaDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtaDescripcion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 86, 470, 68);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText(":");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(500, 280, 8, 17);

        txtCargaHoraria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCargaHoraria.setEnabled(false);
        getContentPane().add(txtCargaHoraria);
        txtCargaHoraria.setBounds(110, 323, 70, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 55, 49, 17);

        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCosto.setEnabled(false);
        getContentPane().add(txtCosto);
        txtCosto.setBounds(340, 280, 60, 30);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrow.png"))); // NOI18N
        btnRegistrar.setText("Modificar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(460, 325, 105, 30);

        txtCupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCupo.setEnabled(false);
        getContentPane().add(txtCupo);
        txtCupo.setBounds(200, 280, 70, 30);

        cmbAnio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbAnio.setEnabled(false);
        cmbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbAnio);
        cmbAnio.setBounds(490, 233, 70, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("/");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(400, 240, 8, 17);

        cmbDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDia.setEnabled(false);
        getContentPane().add(cmbDia);
        cmbDia.setBounds(330, 233, 60, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("/");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(480, 240, 10, 17);

        cmbMes1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbMes1.setEnabled(false);
        cmbMes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMes1ActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMes1);
        cmbMes1.setBounds(410, 233, 60, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de Inicio");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 240, 90, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Temas");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 170, 51, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descripcion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 86, 70, 17);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Cursos");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 21, 42, 17);

        cmbCursosFiltro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbCursosFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursosFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCursosFiltro);
        cmbCursosFiltro.setBounds(90, 11, 470, 30);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/textura-con-manchas-suaves-23827-2560x1600__wallpaper_480x300.jpg"))); // NOI18N
        jLabel16.setText("jLabel13");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(0, 0, 480, 300);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/textura-con-manchas-suaves-23827-2560x1600__wallpaper_480x300.jpg"))); // NOI18N
        jLabel17.setText("jLabel13");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(480, 0, 160, 300);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/textura-con-manchas-suaves-23827-2560x1600__wallpaper_480x300.jpg"))); // NOI18N
        jLabel18.setText("jLabel13");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(-10, 260, 480, 130);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/textura-con-manchas-suaves-23827-2560x1600__wallpaper_480x300.jpg"))); // NOI18N
        jLabel19.setText("jLabel13");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(440, 240, 140, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        try {
            nombre = txtNombre.getText();
            descripcion = txtaDescripcion.getText();
            tema = txtaTema.getText();
            duracion = Integer.parseInt(txtDuracion.getText());
            fecha = cmbMes1.getSelectedItem().toString() + "-" + cmbDia.getSelectedItem().toString() + "-" + cmbAnio.getSelectedItem().toString();
            aula = txtAula.getText();
            cupo = Integer.parseInt(txtCupo.getText());
            precio = Double.parseDouble(txtCosto.getText());
            hora = cmbHora.getSelectedItem().toString() + ":" + cmbMinutos.getSelectedItem().toString();
            cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());

            Curso c = new Curso(nombre, descripcion, fecha, tema, duracion, precio, cupo, aula, hora, cargaHoraria);
            c.setIdCurso(id);
            g.modificar(c);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbCursosFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursosFiltroActionPerformed
        if (cmbCursosFiltro.getSelectedIndex() != 0) {
            try {
                habilitarControles(true);

                id = ((Curso) cmbCursosFiltro.getSelectedItem()).getIdCurso();

                Curso c = g.obtenerCurso(id);

                txtNombre.setText(c.getNombreCurso());
                txtaDescripcion.setText(c.getDescripcion());
                txtaTema.setText(c.getTemas());
                txtDuracion.setText("" + c.getDuracionTotalSemanas());
                txtAula.setText(c.getAula());
                txtCupo.setText("" + c.getCupo());
                txtCargaHoraria.setText("" + c.getCargaHoraria());
                txtCosto.setText("" + c.getCosto());

                String[] datosFecha = c.getFechaInicio().split("-");
                String[] datoshora = c.getDiaHorario().split(" |:");

                cmbAnio.setSelectedIndex(((Integer.parseInt(datosFecha[0])) - 1900));
                cmbMes1.setSelectedIndex(Integer.parseInt(datosFecha[1]) - 1);
                cmbDia.setSelectedIndex(Integer.parseInt(datosFecha[2]) - 1);
                cmbHora.setSelectedIndex(Integer.parseInt(datoshora[1]));
                cmbMinutos.setSelectedIndex(Integer.parseInt(datoshora[2]));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            limpiarControles();
            habilitarControles(false);
        }
    }//GEN-LAST:event_cmbCursosFiltroActionPerformed

    private void cmbMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMinutosActionPerformed

    private void cmbMes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMes1ActionPerformed
        cargarDiaCombo();
    }//GEN-LAST:event_cmbMes1ActionPerformed

    private void cmbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnioActionPerformed
        cargarDiaCombo();
    }//GEN-LAST:event_cmbAnioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MenuPrincipal.vEditarCurso = false;
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
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCurso().setVisible(true);
            }
        });
    }

    private void cargaCmb() {
        DefaultComboBoxModel modelAnio = new DefaultComboBoxModel();
        DefaultComboBoxModel modelMes = new DefaultComboBoxModel();

        int anio = 1900;
        int mes = 1;

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        while (anio <= year) {
            modelAnio.addElement(anio);
            anio++;
        }
        cmbAnio.setModel(modelAnio);

        while (mes <= 12) {
            modelMes.addElement(mes);
            mes++;
        }
        cmbMes1.setModel(modelMes);

    }

    private void cargarDiaCombo() {
        DefaultComboBoxModel modelDia = new DefaultComboBoxModel();
        int dia = 1;
        int mes = cmbMes1.getSelectedIndex() + 1;

        while (dia <= 28) {
            modelDia.addElement(dia);
            dia++;
        }

        if (mes == 2) {
            if ((int) cmbAnio.getSelectedItem() % 4 == 0 && ((int) cmbAnio.getSelectedItem() % 100 != 0 || (int) cmbAnio.getSelectedItem() % 400 == 0)) {
                modelDia.addElement(dia);
            }
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            while (dia <= 31) {
                modelDia.addElement(dia);
                dia++;
            }
        } else {
            while (dia <= 30) {
                modelDia.addElement(dia);
                dia++;
            }
        }
        cmbDia.setModel(modelDia);
    }

    private void CargaHoraMinutos() {
        DefaultComboBoxModel modelH = new DefaultComboBoxModel();
        DefaultComboBoxModel modelM = new DefaultComboBoxModel();

        int hora = 0;
        int min = 0;

        while (hora < 24) {
            modelH.addElement(hora);
            hora++;
        }
        cmbHora.setModel(modelH);

        while (min < 60) {
            modelM.addElement(min);
            min++;
        }
        cmbMinutos.setModel(modelM);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cmbAnio;
    private javax.swing.JComboBox cmbCursosFiltro;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbHora;
    private javax.swing.JComboBox cmbMes1;
    private javax.swing.JComboBox cmbMinutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAula;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtCupo;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtaDescripcion;
    private javax.swing.JTextArea txtaTema;
    // End of variables declaration//GEN-END:variables

    public void cargarCursosFiltro(ArrayList listaGenerica) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Que curso quiere modificar?");
        for (Object elemento : listaGenerica) {
            model.addElement(elemento);
        }

        cmbCursosFiltro.setModel(model);
    }

    private boolean esValido() {
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "El campo nombre no debe estar vacio!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtaDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "El campo descripcion no debe estar vacio!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtaTema.getText().isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "El campo tema no debe estar vacio!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtAula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "El campo aula no debe estar vacio!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(txtDuracion.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "El campo duracion debe ser un numero!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(txtCargaHoraria.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "El campo carga horaria debe ser un numero!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(txtCupo.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "El campo cupo debe ser un numero!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(txtCosto.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "El campo costo debe ser un numero!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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

    public void limpiarControles() {
        txtNombre.setText("");
        txtaDescripcion.setText("");
        txtaTema.setText("");
        txtAula.setText("");
        txtDuracion.setText("");
        txtCargaHoraria.setText("");
        txtCosto.setText("");
        txtCupo.setText("");
        cmbAnio.setSelectedIndex(0);
        cmbDia.setSelectedIndex(0);
        cmbHora.setSelectedIndex(0);
        cmbMes1.setSelectedIndex(0);
        cmbMinutos.setSelectedIndex(0);
    }

    public void habilitarControles(boolean x) {
        txtNombre.setEnabled(x);
        txtaDescripcion.setEnabled(x);
        txtaTema.setEnabled(x);
        txtAula.setEnabled(x);
        txtDuracion.setEnabled(x);
        txtCargaHoraria.setEnabled(x);
        txtCosto.setEnabled(x);
        txtCupo.setEnabled(x);
        cmbAnio.setEnabled(x);
        cmbDia.setEnabled(x);
        cmbHora.setEnabled(x);
        cmbMes1.setEnabled(x);
        cmbMinutos.setEnabled(x);
        btnRegistrar.setEnabled(x);
    }
}
