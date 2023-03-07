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
            String pss = "administrador1";
            String usuario = "user1";
            return (user.equals(usuario) && pwd.equals(pss));
        }catch(Exception e)
        {
            return false;
        }
    }
    
}
