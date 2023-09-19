package sistem.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sistem.dao.UsuarioDAO;
import sistem.impl.UsuarioDAOImpl;
import sistem.modelo.User;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Meryli
 */
@ManagedBean
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private User usuario;
    private String nombreUsuario;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        this.usuario = new User();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";
        //implementar la consulta 
        UsuarioDAO datos = new UsuarioDAOImpl();
        this.usuario = datos.login(usuario);

        if (this.usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombreUsuario());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Loggin Correcto, Bienvenido", this.usuario.getNombreUsuario());
            ruta = "/WorldCity/faces/views/Bienvenido.xhtml";
            //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);

        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Contraseña o Usuario Incorrecto");
            usuario = new User();
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);

    }

    public String logout() {
        this.nombreUsuario = null;
        this.password = null;

        HttpSession httpsession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpsession.invalidate(); //borrar sesion
        return "/Login";
    }
}
