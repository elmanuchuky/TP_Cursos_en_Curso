/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Yasmin
 */
public class EditarMatriculado extends javax.swing.JFrame {

    /**
     * Creates new form EditarMatriculado
     */
    public EditarMatriculado() {
        initComponents();
        cargaCmb();
        cargarDiaCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        txtProfecion = new javax.swing.JTextField();
        cmbAnio = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cmbMes = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbDia = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnMoificar = new javax.swing.JButton();
        txtLegajo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Matriculado");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        txtProfecion.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 33;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 36;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 25);
        getContentPane().add(txtProfecion, gridBagConstraints);

        cmbAnio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2017" }));
        cmbAnio.setEnabled(false);
        cmbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 68;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 4, 0, 25);
        getContentPane().add(cmbAnio, gridBagConstraints);

        jLabel7.setText("Fecha de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 4, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel9.setText("Mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(jLabel9, gridBagConstraints);

        txtNombre.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 4, 0, 0);
        getContentPane().add(txtNombre, gridBagConstraints);

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        cmbMes.setEnabled(false);
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 66;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 4, 0, 0);
        getContentPane().add(cmbMes, gridBagConstraints);

        jLabel10.setText("Profecion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 3, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);

        jLabel6.setText("Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        txtMail.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 65;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 442;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 3, 0, 25);
        getContentPane().add(txtMail, gridBagConstraints);

        cmbTipoDocumento.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 3, 0, 0);
        getContentPane().add(cmbTipoDocumento, gridBagConstraints);

        txtDocumento.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 117;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        getContentPane().add(txtDocumento, gridBagConstraints);

        jLabel12.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 67;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 4, 0, 0);
        getContentPane().add(jLabel12, gridBagConstraints);

        jLabel4.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel8.setText("Telfeono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        txtTelefono.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 5, 0, 0);
        getContentPane().add(txtTelefono, gridBagConstraints);

        txtApellido.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 46;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 4, 0, 25);
        getContentPane().add(txtApellido, gridBagConstraints);

        jLabel2.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 65;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 4, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        cmbDia.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 64;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        getContentPane().add(cmbDia, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Legajo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 56, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        btnMoificar.setText("Modificar");
        btnMoificar.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 2, 11, 0);
        getContentPane().add(btnMoificar, gridBagConstraints);

        txtLegajo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtLegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLegajoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        getContentPane().add(txtLegajo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnioActionPerformed
        cargarDiaCombo();
    }//GEN-LAST:event_cmbAnioActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        cargarDiaCombo();
    }//GEN-LAST:event_cmbMesActionPerformed

    private void txtLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLegajoActionPerformed
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtDocumento.setEnabled(true);
        txtMail.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtProfecion.setEnabled(true);
        cmbTipoDocumento.setEnabled(true);
        cmbDia.setEnabled(true);
        cmbMes.setEnabled(true);
        cmbAnio.setEnabled(true);
        btnMoificar.setEnabled(true);
        //proseso almacenado que filtar
    }//GEN-LAST:event_txtLegajoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarMatriculado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarMatriculado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarMatriculado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarMatriculado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarMatriculado().setVisible(true);
            }
        });
    }

    private void cargaCmb() {
        DefaultComboBoxModel modelAnio = new DefaultComboBoxModel();
        DefaultComboBoxModel modelMes = new DefaultComboBoxModel();
        
        int anio = 1900;
        int mes = 1;
 
        Calendar cal= Calendar.getInstance(); 
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
        cmbMes.setModel(modelMes);
        
    }
    private void cargarDiaCombo() {
        DefaultComboBoxModel modelDia = new DefaultComboBoxModel();
        int dia = 1;
        int mes = cmbMes.getSelectedIndex()+1;

        while (dia <= 28) {            
            modelDia.addElement(dia);
            dia++;
        } 
        
        if(mes == 2){
            if((int)cmbAnio.getSelectedItem()%4 == 0 && ((int)cmbAnio.getSelectedItem()%100 != 0 || (int)cmbAnio.getSelectedItem()%400 == 0)){
                modelDia.addElement(dia);
            }
        }else if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
            while (dia <= 31) {            
                modelDia.addElement(dia);
                dia++;
            }
        }else{
            while (dia <= 30) {            
                modelDia.addElement(dia);
                dia++;
            }
        }
        cmbDia.setModel(modelDia);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoificar;
    private javax.swing.JComboBox cmbAnio;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProfecion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
