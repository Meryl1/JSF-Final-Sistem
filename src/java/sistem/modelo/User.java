package sistem.modelo;
// Generated 18-sep-2023 7:05:44 by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer codUsuario;
     private String nombreUsuario;
     private String password;

    public User() {
    }

    public User(String nombreUsuario, String password) {
       this.nombreUsuario = nombreUsuario;
       this.password = password;
    }
   
    public Integer getCodUsuario() {
        return this.codUsuario;
    }
    
    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


