/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formularios;

import clases.Sesion;
import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vmary
 */
public class Especialistas extends javax.swing.JDialog {

    /**
     * Creates new form Especialistas
     */
    Conexion con = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int indiceEsp,txtid;
    public Especialistas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try{
            initComponents();
            Color c1 = new Color(216,239,250);
            getContentPane().setBackground(c1);
            //setLocation(500, 150);
            setSize(2500, 1150);
            this.setTitle("Especialistas      "+Sesion.app.getAPPNOMBRE()+"   "+Sesion.app.getVERSION());
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/logotipo.png")).getImage());
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    
    public void consulta_Especialistas()
    {
        String sql = "select * from especialistas";
        
        try{
            conet = con.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object[] esp = new Object[7];
            modelo = (DefaultTableModel) tblEsp.getModel();
            while(rs.next())
            {
                esp [0] = rs.getInt("id_Especialistas");
                esp [1] = rs.getInt("ced_Especialista");
                esp [2] = rs.getString("nombre");
                esp [3] = rs.getString("correo");
                esp [4] = rs.getString("hora_Entrada");
                esp [5] = rs.getString("hora_Salida");
                esp [6] = rs.getInt("id_Area");
                
                modelo.addRow(esp);
            }
            tblEsp.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    
     public void agregar_Especialista(){
        String idEspe=idEsp.getText();
        String cedEspe=cedEsp.getText();
        String nombreE=nomEsp.getText();
        String correoE=correoEsp.getText();
        String horaE=hrEnt.getText();
        String horaS=hrSal.getText();
        String idArea=id_Area.getText();
         int res = 0; 
        try{
            if( idEspe.equals("")||cedEspe.equals("")|| nombreE.equals("")|| correoE.equals("") || horaE.equals("") || horaS.equals("") || idArea.equals("")){
                JOptionPane.showMessageDialog(null, "Datos incompletos");
                
            }else{
                String sql="insert into especialistas(id_Especialistas,ced_Especialista,nombre,correo,hora_Entrada,hora_Salida,id_Area) values('"+idEspe+"','"+cedEspe+"','"+nombreE+"','"+correoE+"','"+horaE+"','"+horaS+"','"+idArea+"')";
                conet = con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Se agrego a la tabla exitosamente");
               res = txtid ++;
               
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo agregar a la tabla, error:  "+e);
        }
    }
    
     public void actualizar_Especialistas()
    {
        String cedEspe=cedEsp.getText();
        String nombreE=nomEsp.getText();
        String correoE=correoEsp.getText();
        String horaE=hrEnt.getText();
        String horaS=hrSal.getText();
        String idArea=id_Area.getText();
        
        try{
            if( cedEsp.equals("")|| nombreE.equals("")|| correoE.equals("") || horaE.equals("") || horaS.equals("")|| idArea.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos");

            }else{ 
                String sql= "Update especialistas set id_Area = '"+ indiceEsp+"',ced_Especialista='"+cedEspe+"',nombre='"+nombreE+"',correo='"+correoE+"',hora_Entrada='"+horaE+"',hora_Salida='"+horaS+"',id_Area='"+idArea+"' where id_Area="+indiceEsp;
                conet = con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(null,"No pudo ser actualizado por el error: "+e);

        }
    }
     
     
     public void eliminar_Especialista(){
       
        int fila =tblEsp.getSelectedRow();
        try{
            if(fila<0){
                JOptionPane.showMessageDialog(null,"dato no seleccionado" );
                
            }else{
                String sql= "delete from especialistas where id_Especialistas = " + indiceEsp;
                conet= con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);   
            JOptionPane.showMessageDialog(null,"Se elimino el registro");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el resgistro, error: "+e);
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

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarEsp = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cedEsp = new javax.swing.JTextField();
        nomEsp = new javax.swing.JTextField();
        correoEsp = new javax.swing.JTextField();
        hrEnt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hrSal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        id_Area = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idEsp = new javax.swing.JTextField();
        btnActEsp = new javax.swing.JButton();
        btnEEsp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEsp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Agregar un nuevo especialista");

        btnAgregarEsp.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnAgregarEsp.setText("Agregar");
        btnAgregarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEspActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Cédula profesional:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nombre del especialista:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Correo:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Hora de entrada:");

        cedEsp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        nomEsp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        correoEsp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        hrEnt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Hora de salida:");

        hrSal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Id_Area");

        id_Area.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Id_Especialista:");

        idEsp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnActEsp.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnActEsp.setText("Actualizar");
        btnActEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActEspActionPerformed(evt);
            }
        });

        btnEEsp.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnEEsp.setText("Eliminar");
        btnEEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEEspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hrSal)
                    .addComponent(cedEsp)
                    .addComponent(nomEsp)
                    .addComponent(correoEsp)
                    .addComponent(hrEnt)
                    .addComponent(id_Area)
                    .addComponent(idEsp, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarEsp, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btnActEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(idEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cedEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(nomEsp, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(correoEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hrEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(hrSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnAgregarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEEsp)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(id_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblEsp.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tblEsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Especialista", "Céd. Profesional", "Nombre", "Correo", "Hora entrada", "Hora Salida", "Id_Area"
            }
        ));
        tblEsp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEsp.setRowHeight(30);
        tblEsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEsp);

        jPanel3.setBackground(new java.awt.Color(55, 156, 155));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel1.setText("Especialistas:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)))
                        .addGap(167, 167, 167)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspMouseClicked
        // TODO add your handling code here:
        try{
           int fila = tblEsp.rowAtPoint(evt.getPoint());  
        
         if (fila > -1){           
            indiceEsp = Integer.parseInt((String)tblEsp.getValueAt(fila, 0).toString());
            int ced = Integer.parseInt((String)tblEsp.getValueAt(fila, 1).toString());
            String nombre = (String)tblEsp.getValueAt(fila, 2);
            String correo = (String)tblEsp.getValueAt(fila, 3);
            String horaEnt = (String)tblEsp.getValueAt(fila, 4);
            String horaSal = (String)tblEsp.getValueAt(fila, 5);
            int idArea = Integer.parseInt((String)tblEsp.getValueAt(fila, 6).toString());
           
            
           idEsp.setText(""+ indiceEsp);
           cedEsp.setText(""+ced);
           nomEsp.setText(nombre);
           correoEsp.setText(""+correo);
           hrEnt.setText(""+horaEnt);
           hrSal.setText(""+horaSal);
           id_Area.setText(""+idArea);
         } 
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
        
    }//GEN-LAST:event_tblEspMouseClicked

    private void btnActEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActEspActionPerformed
        // TODO add your handling code here:
        actualizar_Especialistas();
        consulta_Especialistas();
    }//GEN-LAST:event_btnActEspActionPerformed

    private void btnAgregarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEspActionPerformed
        // TODO add your handling code here:
        agregar_Especialista();
        consulta_Especialistas();
    }//GEN-LAST:event_btnAgregarEspActionPerformed

    private void btnEEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEEspActionPerformed
        // TODO add your handling code here:
        eliminar_Especialista();
        consulta_Especialistas();
    }//GEN-LAST:event_btnEEspActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActEsp;
    private javax.swing.JButton btnAgregarEsp;
    private javax.swing.JButton btnEEsp;
    private javax.swing.JTextField cedEsp;
    private javax.swing.JTextField correoEsp;
    private javax.swing.JTextField hrEnt;
    private javax.swing.JTextField hrSal;
    private javax.swing.JTextField idEsp;
    private javax.swing.JTextField id_Area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomEsp;
    private javax.swing.JTable tblEsp;
    // End of variables declaration//GEN-END:variables
}
