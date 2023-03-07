/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author vmary
 */
public class Sesion 
{
    public static AppData app = new AppData();
    public static User user = new User();
    public static void login(String usr,String nombre, String aPaterno,String aMaterno,int idUser)
    {
        Sesion.user.setUsr(usr);
        Sesion.user.setNombre(nombre);
        Sesion.user.setaPaterno(aPaterno);
        Sesion.user.setaMaterno(aMaterno);
        Sesion.user.setIdUser(idUser);
    }
    
     public static void loginOut(String usr,String nombre, String aPaterno,String aMaterno,int idUser)
    {
        Sesion.user.setUsr(null);
        Sesion.user.setNombre(null);
        Sesion.user.setaPaterno(null);
        Sesion.user.setaMaterno(null);
        Sesion.user.setIdUser(0);
    }
}
