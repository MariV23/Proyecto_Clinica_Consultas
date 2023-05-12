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
public class FrmModificar extends javax.swing.JDialog {

    /**
     * Creates new form FrmModificar
     */
    Conexion con = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int indiceC,txtid;
    public FrmModificar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try{
            initComponents();
            this.setTitle("Modificar consultar                   "+Sesion.app.getAPPNOMBRE()+"       "+Sesion.app.getVERSION());
            Color c1 = new Color(216,239,250);
            getContentPane().setBackground(c1);
            setSize(2500, 1150);
            //setLocation(500, 150);
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/logotipo.png")).getImage());
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    public void consulta_Citas()
    {
        String sql = "select * from citas";
        
        try{
            conet = con.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
		
            Object[] cit = new Object[6]; 
            modelo = (DefaultTableModel) tblCit.getModel();
            while(rs.next())
            {
		 
                cit [0] = rs.getInt("id_Citas");
                cit [1] = rs.getString("n_Paciente");
                cit [2] = rs.getString("fecha");
                cit [3] = rs.getString("hora");
                cit [4] = rs.getInt("id_Paciente");
                cit [5] = rs.getInt("id_Especialista");
              
      
		   
                modelo.addRow(cit);
            }
		
            tblCit.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    
    public void agregar_Citas(){
        String idCit=id_Cita.getText();
        String nomP=nom_P.getText();
        String fecha=fechaC.getText();
        String hora=horaC.getText();
        String idPac=id_P.getText();
        String idEsp=id_E.getText();
         int res = 0; 
        try{
            if( idCit.equals("")||nomP.equals("")|| fecha.equals("")|| hora.equals("") || idPac.equals("") || idEsp.equals("")){
                JOptionPane.showMessageDialog(null, "Datos incompletos");
                
            }else{
                String sql="insert into citas(id_Citas,n_Paciente,fecha,hora,id_Paciente,id_Especialista) values('"+idCit+"','"+nomP+"','"+fecha+"','"+hora+"','"+idPac+"','"+idEsp+"')";
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
    
    void actualizar_Citas()
    {
        String nomP=nom_P.getText();
        String fecha=fechaC.getText();
        String hora=horaC.getText();
        String idPac=id_P.getText();
        String idEsp=id_E.getText();
        
        try{
            if( nomP.equals("")|| fecha.equals("")|| hora.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos");

            }else{ 
                String sql= "Update citas set id_Citas = '"+ indiceC+"',n_Paciente='"+nomP+"',fecha='"+fecha+"' ,hora='"+hora+"',id_Paciente='"+idPac+"',id_Especialista='"+idEsp+"'where id_Citas="+indiceC;
                conet = con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(null,"No pudo ser actualizado por el error: "+e);

        }
    }
    
    public void eliminar_Citas(){
       
        int fila =tblCit.getSelectedRow();
        try{
            if(fila<0){
                JOptionPane.showMessageDialog(null,"dato no seleccionado" );
                
            }else{
                String sql= "delete from citas where id_Citas = " + indiceC;
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCit = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id_Cita = new javax.swing.JTextField();
        nom_P = new javax.swing.JTextField();
        fechaC = new javax.swing.JTextField();
        horaC = new javax.swing.JTextField();
        id_P = new javax.swing.JTextField();
        id_E = new javax.swing.JTextField();
        btnActCit = new javax.swing.JButton();
        btnAgregarCit = new javax.swing.JButton();
        btnElimCit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(55, 156, 155));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel2.setText("Consultas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tblCit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tblCit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_consulta", "Nombre del Paciente", "Fecha", "Hora", "id_Paciente", "id_Especialista"
            }
        ));
        tblCit.setRowHeight(28);
        tblCit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCit);

        jPanel1.setAlignmentX(0.8F);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("Id_Consulta:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Nombre Paciente:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Hora:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("Id_Paciente:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Id_Especialista:");

        id_Cita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        id_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_CitaActionPerformed(evt);
            }
        });

        nom_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        fechaC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        horaC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        id_P.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        id_E.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnActCit.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnActCit.setText("Actualizar");
        btnActCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActCitActionPerformed(evt);
            }
        });

        btnAgregarCit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnAgregarCit.setText("Agregar");
        btnAgregarCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCitActionPerformed(evt);
            }
        });

        btnElimCit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnElimCit.setText("Eliminar");
        btnElimCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimCitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id_Cita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(nom_P))
                        .addGap(328, 328, 328))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(id_P, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_E, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(horaC, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnElimCit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarCit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActCit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_Cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nom_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fechaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCit)
                    .addComponent(jLabel7)
                    .addComponent(horaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActCit)
                    .addComponent(jLabel9)
                    .addComponent(id_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnElimCit)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(id_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(55, 156, 155));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel3.setText("Modificar consultas:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_CitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_CitaActionPerformed

    private void btnAgregarCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCitActionPerformed
        // TODO add your handling code here:
        agregar_Citas();
        consulta_Citas();
    }//GEN-LAST:event_btnAgregarCitActionPerformed

    private void btnActCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActCitActionPerformed
        // TODO add your handling code here:
        actualizar_Citas();
        consulta_Citas();
    }//GEN-LAST:event_btnActCitActionPerformed

    private void tblCitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitMouseClicked
        // TODO add your handling code here:
        try{
           int fila = tblCit.rowAtPoint(evt.getPoint());  
        
         if (fila > -1){           
            indiceC = Integer.parseInt((String)tblCit.getValueAt(fila, 0).toString());
            String nomP = (String)tblCit.getValueAt(fila, 1);
            String fecha = (String)tblCit.getValueAt(fila, 2);
            String hora = (String)tblCit.getValueAt(fila, 3);
            int idPac = Integer.parseInt((String)tblCit.getValueAt(fila, 4).toString());
            int idEsp = Integer.parseInt((String)tblCit.getValueAt(fila, 5).toString());
           
            
           id_Cita.setText(""+ indiceC);
           nom_P.setText(""+nomP);
           fechaC.setText(""+fecha);
           horaC.setText(""+hora);
           id_P.setText(""+idPac);
           id_E.setText(""+idEsp);
         } 
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_tblCitMouseClicked

    private void btnElimCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimCitActionPerformed
        // TODO add your handling code here:
        eliminar_Citas();
        consulta_Citas();
    }//GEN-LAST:event_btnElimCitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActCit;
    private javax.swing.JButton btnAgregarCit;
    private javax.swing.JButton btnElimCit;
    private javax.swing.JTextField fechaC;
    private javax.swing.JTextField horaC;
    private javax.swing.JTextField id_Cita;
    private javax.swing.JTextField id_E;
    private javax.swing.JTextField id_P;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nom_P;
    private javax.swing.JTable tblCit;
    // End of variables declaration//GEN-END:variables
}
