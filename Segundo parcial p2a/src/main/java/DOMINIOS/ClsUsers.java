
package DOMINIOS;

/**
 *
 * @author USUARIOTC
 */
public class ClsUsers {
    
    private int id;
    private String username;
    private String password;

   public ClsUsers(){   
    }
    
    public ClsUsers(int id_usuario){
        this.id = id_usuario;   
    }
    
    public ClsUsers(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClsUsuario{" + "id_user=" + id + ", username=" + username + ", password=" + password + '}';
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id_user) {
        this.id = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
