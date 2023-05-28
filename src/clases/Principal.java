/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import formularios.FrmLogin;
import java.awt.Color;

/**
 *
 * @author vmary
 */
public class Principal {
    
    public static void main(String[] args) {
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setSize(600,600);
        frmLogin.setTitle("Iniciar Sesión");
        frmLogin.setLocation(650, 250);
        frmLogin.setVisible(true);
    }
}
