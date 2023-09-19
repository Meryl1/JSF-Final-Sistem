
package sistem.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import sistem.dao.UsuarioDAO;
import sistem.componentes.EncriptarPassword;
import sistem.modelo.User;
import sistem.util.HibernateUtil;
/**
 *
 * @author Meryli
 */
public class UsuarioDAOImpl implements UsuarioDAO{
    @Override
    public User search(User usuario) {
    
    Session session= HibernateUtil.getSessionFactory().openSession();
    String hql="FROM User WHERE nombreUsuario=:nombreUsuario";
    Query query=session.createQuery(hql);
    query.setParameter("nombreUsuario", usuario.getNombreUsuario());
    return (User) query.uniqueResult();
    
    
    }

    @Override
    public User login(User usuario) {
        User usuarioLogin=search(usuario);
        if(usuarioLogin !=null){
            if(!usuarioLogin.getPassword().equals(EncriptarPassword.sha512(usuario.getPassword()))){
                usuarioLogin=null;
            }
        }
        
        return usuarioLogin;
        
        
    }
}
