/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vmary
 */
public class Conexion {
    Connection conectar=null;
    static String user = "admin"; 
    static String password = "admin_123"; 
    static String url = "jdbc:mysql://localhost:3306/clinica"; 
    public Conexion()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url,user,password);
            if(conectar!=null)
            {
                //JOptionPane.showMessageDialog(null,"Conexión exitosa","Conexion", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Conectado");
            }
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Sin conexión "+ e,"Conexion", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return conectar;
    }
    
    public void desconectar(){ 
      conectar = null; 
   } 
  /*public static void main(String [] args){
        Conexion con = new Conexion();
        con.getConnection();
    }*/
}
