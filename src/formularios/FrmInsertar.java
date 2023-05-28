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
public class FrmInsertar extends javax.swing.JDialog {

    /**
     * Creates new form FrmInsertar
     */
    Conexion con = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int txtid,indiceP;
    public FrmInsertar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try{
            initComponents();
            Color c1 = new Color(216,239,250);
            getContentPane().setBackground(c1);
            //setLocation(500, 150);
            setSize(2500, 1150);
            this.setTitle("Insertar nuevas consultas                   "+Sesion.app.getAPPNOMBRE()+"      "+Sesion.app.getVERSION());
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/logotipo.png")).getImage());
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }
    void consulta_Pacientes()
    {
        String sql = "select * from pacientes ";
        
        try{
            conet = con.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
		//Cambiar el nombre a el arreglo según la tabla
            Object[] nom = new Object[5]; 
            modelo = (DefaultTableModel) tblPaci.getModel();
            while(rs.next())
            {
		
                nom [0] = rs.getInt("id_Pacientes");
                nom [1] = rs.getString("nombre");
                nom [2] = rs.getString("telefono");
                //nom[6] = rs.getBigDecimal("telefono");
                nom [3] = rs.getString("correo");
                nom [4] = rs.getInt("edad");
               
                
		    //se cambia dentro del paréntesis por el nombre del arreglo
                modelo.addRow(nom);
            }
		//Antes del .setModel va el nombre de nuestra tabla de la interfaz
            tblPaci.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }

    public void agregar_Pacientes(){
        String idP=idPac.getText();
        String nombreP=nomPac.getText();
        String telefonoPac=telefonoP.getText();
        String correo=correoP.getText();
        String edad=edadP.getText();
         int res = 0; 
        try{
            if( idP.equals("")||nombreP.equals("")|| telefonoPac.equals("")|| correo.equals("")|| edad.equals("")){
                JOptionPane.showMessageDialog(null, "Datos incompletos");//Esto es opcional
                
            }else{
                String sql="insert into pacientes(id_Pacientes,nombre,telefono,correo,edad) values('"+idP+"','"+nombreP+"','"+telefonoPac+"','"+correo+"','"+edad+"')";
                conet = con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Se agrego a la tabla exitosamente");
               res = txtid ++;
               
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"No pudo ser actualizado por el error: "+e);
        }
    }
    public void actualizar_Pacientes()
    {
        String nombreP=nomPac.getText();
        String telefonopac=telefonoP.getText();
        String correo=correoP.getText();
        String edad=edadP.getText();
        
        try{
            if(nombreP.equals("")|| telefonopac.equals("")|| correo.equals("")|| edad.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos");

            }else{ 
                String sql= "Update pacientes set id_Pacientes = '"+ indiceP+"',nombre='"+nombreP+"',telefono='"+telefonopac+"' ,correo='"+correo+"',edad='"+edad+"'where id_Pacientes="+indiceP;
                conet = con.getConnection();
                st= conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(null,"No pudo ser actualizado por el error: "+e);

        }
    }

    public void eliminar_Paciente(){
       
        int fila =tblPaci.getSelectedRow();
        try{
            if(fila<0){
                JOptionPane.showMessageDialog(null,"dato no seleccionado" );
                
            }else{
                String sql= "delete from pacientes where id_Pacientes = " + indiceP;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idPac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomPac = new javax.swing.JTextField();
        telefonoP = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        correoP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edadP = new javax.swing.JTextField();
        btnAgregarCita = new javax.swing.JButton();
        btnActPaci = new javax.swing.JButton();
        btnElimPaci = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaci = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Datos generales:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre del paciente:");

        idPac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idPacKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Teléfono:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Correo:");

        nomPac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomPacKeyTyped(evt);
            }
        });

        telefonoP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        telefonoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoPKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Edad:");

        correoP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Id_Paciente:");

        edadP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        edadP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edadPKeyTyped(evt);
            }
        });

        btnAgregarCita.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnAgregarCita.setText("Agregar");
        btnAgregarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCitaActionPerformed(evt);
            }
        });

        btnActPaci.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnActPaci.setText("Actualizar");
        btnActPaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActPaciActionPerformed(evt);
            }
        });

        btnElimPaci.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        btnElimPaci.setText("Eliminar");
        btnElimPaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimPaciActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(311, 311, 311)
                                        .addComponent(btnLimpiar)))
                                .addGap(107, 107, 107))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(telefonoP)
                                            .addComponent(correoP, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                            .addComponent(edadP)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(idPac, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nomPac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActPaci, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAgregarCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnElimPaci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telefonoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(correoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(edadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnAgregarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActPaci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimPaci)))
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        tblPaci.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tblPaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Paciente", "Nombre del paciente", "Teléfono", "Correo", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaci.setRowHeight(28);
        tblPaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaciMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaci);

        jPanel2.setBackground(new java.awt.Color(55, 156, 155));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel1.setText("Pacientes:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/enfermera.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCitaActionPerformed
        // TODO add your handling code here:
        agregar_Pacientes();
        consulta_Pacientes();
    }//GEN-LAST:event_btnAgregarCitaActionPerformed

    private void btnActPaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActPaciActionPerformed
        // TODO add your handling code here:
        actualizar_Pacientes();
        consulta_Pacientes();
    }//GEN-LAST:event_btnActPaciActionPerformed

    private void btnElimPaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimPaciActionPerformed
        // TODO add your handling code here:
        eliminar_Paciente();
        consulta_Pacientes();
    }//GEN-LAST:event_btnElimPaciActionPerformed

    private void tblPaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaciMouseClicked
        // TODO add your handling code here:
        try{
           int fila = tblPaci.rowAtPoint(evt.getPoint());  
        
         if (fila > -1){           
            indiceP = Integer.parseInt((String)tblPaci.getValueAt(fila, 0).toString());
            String nombre = (String)tblPaci.getValueAt(fila, 1);
            String telefono = (String)tblPaci.getValueAt(fila, 2);
            String correo = (String)tblPaci.getValueAt(fila, 3);
            int edad = Integer.parseInt((String)tblPaci.getValueAt(fila, 4).toString());
           
            
           idPac.setText(""+ indiceP);
           nomPac.setText(""+nombre);
           telefonoP.setText(""+telefono);
           correoP.setText(""+correo);
           edadP.setText(""+edad);
         } 
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
        btnAgregarCita.setEnabled(false);
    }//GEN-LAST:event_tblPaciMouseClicked

    private void telefonoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoPKeyTyped
        // TODO add your handling code here:
        try{
            if(telefonoP.getText().length()>=10)
            {
                evt.consume();
                //JOptionPane.showMessageDialog(this, "Estas intentando rebazar la longitud permitida");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_telefonoPKeyTyped

    private void idPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idPacKeyTyped
        // TODO add your handling code here:
        try{
            int key = evt.getKeyChar();
            boolean numValidos = key>=48 && key<=57;
            boolean borrar = key >=8 && key <=8;
            if(idPac.getText().length() >=4)
            {
                evt.consume();
            }
            if(!(numValidos || borrar))
            {
                evt.consume();
                JOptionPane.showMessageDialog(this, "El id_Paciente debe ser solo números");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_idPacKeyTyped

    private void nomPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomPacKeyTyped
        // TODO add your handling code here:
        try{
            int key = evt.getKeyChar();
            boolean letMayusculas = key>=65 && key<=90;
            boolean letMinusculas = key>=97 && key<=122;
            boolean borrar = key >=8 && key <=8;
            boolean espacio = key >=32 && key <=32;
            if(!(letMayusculas || letMinusculas || borrar ||espacio))
            {
                evt.consume();
                JOptionPane.showMessageDialog(this, "El nombre debe ser solo letras");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_nomPacKeyTyped

    private void edadPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edadPKeyTyped
        // TODO add your handling code here:
        try{
            int key = evt.getKeyChar();
            boolean numValidos = key>=49 && key<=57;
            boolean borrar = key >=8 && key <=8;
            if(edadP.getText().length() >=2)
            {
                evt.consume();
            }
            if(!(numValidos || borrar))
            {
                evt.consume();
                JOptionPane.showMessageDialog(this, "Estas introduciendo una edad inválida");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocurrio un error: "+e);
        }
    }//GEN-LAST:event_edadPKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        idPac.setText("");
        nomPac.setText("");
        telefonoP.setText("");
        correoP.setText("");
        edadP.setText("");
        btnAgregarCita.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActPaci;
    private javax.swing.JButton btnAgregarCita;
    private javax.swing.JButton btnElimPaci;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTextField correoP;
    private javax.swing.JTextField edadP;
    private javax.swing.JTextField idPac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomPac;
    private javax.swing.JTable tblPaci;
    private javax.swing.JTextField telefonoP;
    // End of variables declaration//GEN-END:variables
}
