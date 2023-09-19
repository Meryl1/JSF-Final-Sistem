
package sistem.bean;

import java.util.List;
import javax.faces.bean.ManagedBean; 
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sistem.dao.CountryDAO;
import sistem.impl.CountryDAOImpl;
import sistem.modelo.Country;

/**
 *
 * @author Meryli
 */
@ManagedBean
@Named(value = "countryBean")
@ViewScoped
public class CountryBean {

    private Country pais=null;
    private List<Country> paises=null;
    
    public CountryBean() {
    }
    
     public List<Country> getPaises() {
        CountryDAO datos = new CountryDAOImpl();
        this.paises = datos.select();
        return paises;
    }
    
     public void preparePais() {
        pais = new Country();
    }

    public void insertPais() {
        CountryDAO datos = new CountryDAOImpl();
        datos.insert(pais);
    }

    public void updatePais() {
        CountryDAO datos = new CountryDAOImpl();
        datos.update(pais);
        this.pais = new Country();
    }

    public void deletePais() {
        CountryDAO datos = new CountryDAOImpl();
        datos.delete(pais);
        pais = new Country();
    }

    public Country getPais() {
        return pais;
    }

    public void setPais(Country pais) {
        this.pais = pais;
    }

    public void setPaises(List<Country> paises) {
        this.paises = paises;
    }
    
}
