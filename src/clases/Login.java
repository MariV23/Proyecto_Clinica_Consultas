 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author vmary
 */
public class Login {
    public boolean Login(String user,String pwd)
    {
        try{
            String pss = "admin_123";
            String usuario = "admin";
            return (user.equals(usuario) && pwd.equals(pss));
        }catch(Exception e)
        {
            return false;
        }
    }
    
}
