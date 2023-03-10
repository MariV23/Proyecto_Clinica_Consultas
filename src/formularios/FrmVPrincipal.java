/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import clases.Sesion;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author vmary
 */
public class FrmVPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmVPrincipal
     */
    public FrmVPrincipal() {
        initComponents();
        try{
        this.setTitle("Home                                                                                     "+Sesion.app.getAPPNOMBRE()+"      "+Sesion.app.getVERSION());
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logotipo.png")).getImage());
        iblUser.setText("Usuario: "+Sesion.user.getUsr() + " "+Sesion.user.getNombre()+" "+Sesion.user.getaPaterno()+" "+Sesion.user.getaMaterno()+" "+Sesion.user.getIdUser());
        Color c1 = new Color(255,255,255);
        getContentPane().setBackground(c1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        }catch(Exception e)
            {
               JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e); 
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iblUser = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mEspecialistas = new javax.swing.JMenuItem();
        mHorarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        iblUser.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        iblUser.setText(" ");

        btnInsertar.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnListar.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(216, 239, 250));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Vida Sana");

        jLabel2.setText("Tu salud en nuestras manos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Inicio");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Informaci??n de la cl??nica");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        mEspecialistas.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        mEspecialistas.setText("Especialistas");
        mEspecialistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEspecialistasActionPerformed(evt);
            }
        });
        jMenu2.add(mEspecialistas);

        mHorarios.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        mHorarios.setText("Horarios");
        mHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHorariosActionPerformed(evt);
            }
        });
        jMenu2.add(mHorarios);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Servicios");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnSalir)))
                .addContainerGap(617, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(iblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(btnInsertar)
                .addGap(18, 18, 18)
                .addComponent(btnListar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(33, 33, 33)
                .addComponent(btnSalir)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try
        {
            Icon salida = new ImageIcon(getClass().getResource("/imagenes/salida.png"));
            String opciones[] = {"Si","No"};
           int opcion = JOptionPane.showOptionDialog(rootPane, "??Estas seguro que quieres salir?", "Cerrar", 0, 0, salida, opciones, this);
           if(opcion==JOptionPane.YES_OPTION)
           {
               System.exit(0);
           }
           else 
           {
              if(opcion==JOptionPane.NO_OPTION) {System.out.println("");}
           }
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
      }
    }//GEN-LAST:event_formWindowClosing

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        try{
            FrmInsertar insertN  = new FrmInsertar(this,true);
            insertN.setVisible(true);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        try{
            FrmConsultas listarConsul  = new FrmConsultas(this,true);
            listarConsul.setVisible(true);
          }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try{
            FrmModificar modifConsul  = new FrmModificar(this,true);
            modifConsul.setVisible(true);
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        try{
            this.setVisible(false);
            FrmLogin fl = new FrmLogin();
            String usr = null;
            Sesion.loginOut(usr, "Mari", "V??squez", "Garc??a", 1);
            fl.setVisible(true);
            fl.setLocation(650, 250);
            
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void mEspecialistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEspecialistasActionPerformed
        // TODO add your handling code here:
        try{
            Especialistas esp = new Especialistas(this,true);
            esp.setVisible(true);
            //esp.setLocation(650,250);
            //esp.setSize(2500, 1150);
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_mEspecialistasActionPerformed

    private void mHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHorariosActionPerformed
        // TODO add your handling code here:
        
        Horarios hr = new Horarios(this,true);
        hr.setVisible(true);
        
    }//GEN-LAST:event_mHorariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel iblUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mEspecialistas;
    private javax.swing.JMenuItem mHorarios;
    // End of variables declaration//GEN-END:variables
}
