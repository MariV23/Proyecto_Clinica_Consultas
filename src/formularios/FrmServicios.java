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
public class FrmServicios extends javax.swing.JDialog {

    /**
     * Creates new form FrmServicios
     */
    Conexion con = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int txtid,indiceA;
    public FrmServicios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try{
            initComponents();
            Color c1 = new Color(216,239,250);
            getContentPane().setBackground(c1);
            //setLocation(500, 150);
            setSize(2500, 1150);
            this.setTitle("Servicios de la clínica                "+Sesion.app.getAPPNOMBRE()+"      "+Sesion.app.getVERSION());
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/logotipo.png")).getImage());
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    
   public void consulta_Area()
    {
        String sql = "select * from area ";
        
        try{
            conet = con.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);

            Object[] area = new Object[3]; 
            modelo = (DefaultTableModel) tblArea.getModel();
            while(rs.next())
            {
		 
                area [0] = rs.getInt("id_Area");
                area [1] = rs.getString("nombre");
                area [2] = rs.getString("descripcion");
             
                modelo.addRow(area);
            }
		
            tblArea.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    
    public void agregar_Areas(){
        String idA=idArea.getText();
        String nombreA=nomArea.getText();
        String descripcion=descripcionA.getText();
         int res = 0; 
        try{
            if( idArea.equals("")||nombreA.equals("")|| descripcion.equals("")){
                JOptionPane.showMessageDialog(null, "Datos incompletos");
                
            }else{
                String sql="insert into area(id_Area,nombre,descripcion) values('"+idA+"','"+nombreA+"','"+descripcion+"')";
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
    
    public void actualizar_Areas()
    {
        String nomA=nomArea.getText();
        String descrip=descripcionA.getText();
        
        try{
            if( nomA.equals("")|| descrip.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos");

            }else{ 
                String sql= "Update area set id_Area = '"+ indiceA+"',nombre='"+nomA+"',descripcion='"+descrip+"' where id_Area="+indiceA;
                conet = con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(null,"No pudo ser actualizado por el error: "+e);

        }
    }
    
     public void eliminar_Area(){
       
        int fila =tblArea.getSelectedRow();
        try{
            if(fila<0){
                JOptionPane.showMessageDialog(null,"dato no seleccionado" );
                
            }else{
                String sql= "delete from area where id_Area = " + indiceA;
                conet= con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);   
            JOptionPane.showMessageDialog(null,"Se elimino el registro");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el resgistro, error: "+e);
        }
   }
    
    
    public void limpiarTablaA(){
       for(int i=0; i<tblArea.getRowCount(); i++){
           modelo.removeRow(i);
           i=i-1;
       } 
       tblArea.setModel(new DefaultTableModel());
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idArea = new javax.swing.JTextField();
        nomArea = new javax.swing.JTextField();
        descripcionA = new javax.swing.JTextField();
        btnNArea = new javax.swing.JButton();
        btnActArea = new javax.swing.JButton();
        btnEArea = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setForeground(new java.awt.Color(102, 255, 153));

        jLabel2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Consulta nuestros servicios de las diferentes áreas de nuestra clínica");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/muestra.png"))); // NOI18N
        jLabel3.setText("ANÁLISIS CLÍNICOS");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/este.png"))); // NOI18N
        jLabel4.setText("CONSULTA GENERAL");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pediatria.png"))); // NOI18N
        jLabel7.setText("PEDIATRÍA");

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pies.png"))); // NOI18N
        jLabel15.setText("PODOLOGÍA");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gine.png"))); // NOI18N
        jLabel10.setText("GINECOLOGÍA");

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cardiograma.png"))); // NOI18N
        jLabel13.setText("CARDIOLOGÍA");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/derma.png"))); // NOI18N
        jLabel8.setText("DERMATOLOGÍA");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/servicios.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel8)))
                        .addGap(209, 209, 209)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(455, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Servicios", jPanel1);

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));

        tblArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Area", "Nombre del área", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblArea.setRowHeight(28);
        tblArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArea);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Id_Area:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Nombre:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Descripción:");

        idArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idAreaActionPerformed(evt);
            }
        });
        idArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idAreaKeyTyped(evt);
            }
        });

        nomArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        descripcionA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnNArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNArea.setText("Agregar");
        btnNArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNAreaActionPerformed(evt);
            }
        });

        btnActArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActArea.setText("Actualizar");
        btnActArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActAreaActionPerformed(evt);
            }
        });

        btnEArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEArea.setText("Eliminar");
        btnEArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEAreaActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\vmary\\Documents\\NetBeansProjects\\Proyecto_Clinica_Consultas\\src\\imagenes\\hospital.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1487, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descripcionA, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(nomArea)
                            .addComponent(idArea)))
                    .addComponent(btnLimpiar))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEArea, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNArea, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(nomArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActArea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(descripcionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEArea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNArea)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Áreas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(405, 405, 405))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idAreaActionPerformed

    private void btnNAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNAreaActionPerformed
        // TODO add your handling code here:
        agregar_Areas();
        consulta_Area();
    }//GEN-LAST:event_btnNAreaActionPerformed

    private void tblAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreaMouseClicked
        // TODO add your handling code here:
        try{
           int fila = tblArea.rowAtPoint(evt.getPoint());  
        
         if (fila > -1){           
            indiceA = Integer.parseInt((String)tblArea.getValueAt(fila, 0).toString());
            String nombreA = (String)tblArea.getValueAt(fila, 1);
            String descripcion = (String)tblArea.getValueAt(fila, 2);
           
            
           idArea.setText(""+ indiceA);
           nomArea.setText(""+nombreA);
           descripcionA.setText(descripcion);
         } 
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
        btnNArea.setEnabled(false);
    }//GEN-LAST:event_tblAreaMouseClicked

    private void btnActAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActAreaActionPerformed
        // TODO add your handling code here:
        actualizar_Areas();
        //limpiarTablaA();
        consulta_Area();
    }//GEN-LAST:event_btnActAreaActionPerformed

    private void btnEAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEAreaActionPerformed
        // TODO add your handling code here:
        eliminar_Area();
        consulta_Area();
    }//GEN-LAST:event_btnEAreaActionPerformed

    private void idAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idAreaKeyTyped
        // TODO add your handling code here:
        try{
            int key = evt.getKeyChar();
            boolean numValidos = key>=48 && key<=57;
            boolean borrar = key >=8 && key <=8;
            if(idArea.getText().length() >=4)
            {
                evt.consume();
            }
            if(!(numValidos || borrar))
            {
                evt.consume();
                JOptionPane.showMessageDialog(this, "El id_Area debe ser solo números");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_idAreaKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        idArea.setText("");
        nomArea.setText("");
        descripcionA.setText("");
        btnNArea.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActArea;
    private javax.swing.JButton btnEArea;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNArea;
    private javax.swing.JTextField descripcionA;
    private javax.swing.JTextField idArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nomArea;
    private javax.swing.JTable tblArea;
    // End of variables declaration//GEN-END:variables
}
