/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Yasmin
 */
public class Bienvenida extends javax.swing.JFrame {

    private int aux = 0;
    private boolean realizado = false;
    hilo ejecutar = new hilo();
    
    /**
     * Creates new form Welcome
     */
    public Bienvenida() {
        initComponents();
        barra.setStringPainted(true);
        barra.setForeground(Color.BLACK);
        Bienvenida.this.getRootPane().setOpaque(false); 
        Bienvenida.this.getContentPane().setBackground(new Color (0 , 0 , 0 , 0)); //Tansparente
        Bienvenida.this.setBackground(new Color (0 , 0 , 0 , 0));
        this.setResizable(false);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagenInicio = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblImagenInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IMG_8324-1.png"))); // NOI18N

        barra.setBackground(new java.awt.Color(0, 0, 204));
        barra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        barra.setForeground(new java.awt.Color(0, 0, 0));
        barra.setToolTipText("");
        barra.setString("Cargando Programa ...");
        barra.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblImagenInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (realizado == false) {
            realizado = true;
            barra.setMaximum(46);
            barra.setMinimum(0);
            barra.setStringPainted(true);
            ejecutar.start();
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenida().setVisible(true);
            }
        });
    }
    
    private class  hilo extends Thread{
        @Override
        public void run(){
            try {while (true) {
                aux ++;
                barra.setValue(aux);
                repaint();
                switch(aux){
                    case 0:
                        barra.setString("Cargando Programa ...");
                        break;
                    case 20:
                        barra.setString("Leyendo Preferencias ...");
                        break;
                    case 49:
                        barra.setString("Carga Finalizada");
                        break;
                    case 50:
                        InicioSesion p = new InicioSesion();
                        p.setVisible(true);
                        p.setLocationRelativeTo(Bienvenida.this);
                        Bienvenida.this.dispose();
                        break;
                }
                Thread.sleep(100);}
            } catch (InterruptedException ex) {
                Logger.getLogger(Bienvenida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel lblImagenInicio;
    // End of variables declaration//GEN-END:variables
}
