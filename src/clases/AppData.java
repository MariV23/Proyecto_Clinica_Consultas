/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;

/**
 *Encabezado para las ventanas es decir datos del sistema
 * @author vmary
 */
public class AppData {
    public AppData()
    {
        
    }
    private final String APPNOMBRE = "Sistema de la clínica Vida Sana";
    private final String VERSION = "v.1.0";
    private final Icon ICONO = null;

    //private final Icon ICONO = (Icon) Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logotipo.png"));

    public String getAPPNOMBRE() {
        return APPNOMBRE;
    }

    public String getVERSION() {
        return VERSION;
    }
    
    public Icon getICONO() {
        return ICONO;
    }
    /*
    public Image getIconImage() {
    Image retValue = Toolkit.getDefaultToolkit().
         getImage(ClassLoader.getSystemResource("/imagenes/logotipo.png"));


        return retValue;
    }*/
    
    
}
