/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package formularios;

import clases.Sesion;
import clases.Login;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author vmary
 */
public class FrmLogin extends javax.swing.JFrame {

    /** Creates new form FrmLogin */
    public FrmLogin() {
        initComponents();
        Color c = new Color(255,255,255);
        getContentPane().setBackground(c);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logotipo.png")).getImage());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setBackground(new java.awt.Color(255, 255, 204));

        lbUser.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("Usuario:");
        lbUser.setAlignmentX(5.0F);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password:");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(108, 174, 241));
        btnAceptar.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(108, 174, 241));
        btnCancelar.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/historial.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lbUser))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(lbImage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(123, 123, 123))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
         try{
            String usr = txtUser.getText();
            String pwd = String.valueOf(txtPassword.getPassword());
            FrmVPrincipal frmP;
            if(this.login.Login(usr,pwd))
            {
                Sesion.login(usr, "Raquel", "López", "Rojas", 1);
                frmP = new FrmVPrincipal();
                this.dispose();
                //JOptionPane.showMessageDialog(this, "Has iniciado sesión correctamente");
                //frmP.setLocation(200, 150);
                frmP.setSize(2500, 1150);
                frmP.setVisible(true);
            }
            else
            {
                if(usr.isEmpty() && pwd.isEmpty())
                {
                  JOptionPane.showMessageDialog(this, "Introduce tu usuario y contraseña");
                }
                else
                {
                    if(usr.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "Introduce el usuario");
                    }
                    else
                    {
                        if(pwd.isEmpty())
                        {
                            JOptionPane.showMessageDialog(this, "Introduce la contraseña");
                        }
                    }
                }
            }
                
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Los datos no son correctos");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        try{
        System.exit(0);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

   //Método para al dar enter después de escribir la contraseña entra a la interfaz
    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        try{
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            {
                btnAceptar.doClick();
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        // TODO add your handling code here:
    
        try{
            int key = evt.getKeyChar();
            
            boolean numValidos = key>=48 && key<=57;
            boolean letMayusculas = key>=65 && key<=90;
            boolean letMinusculas = key>=97 && key<=122;
            boolean borrar = key >=8 && key <=8;
            if(txtUser.getText().length()>4)
            {
                evt.consume();
                //JOptionPane.showMessageDialog(this, "Estas intentando rebazar la longitud permitida");
            }
            if(!(numValidos || letMayusculas || letMinusculas || borrar))
            {
                evt.consume();
                JOptionPane.showMessageDialog(this, "No se permiten esos caracteres");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error"+e);
        }
    }//GEN-LAST:event_txtUserKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
private final Login login = new Login();
}
