
package sistem.dao;
import sistem.modelo.User;

/**
 *
 * @author Meryli
 */
public interface UsuarioDAO {
    
    public User search(User usuario);
    
    public User login(User usuario);
}
