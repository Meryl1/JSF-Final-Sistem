package sistem.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sistem.dao.CityDAO;
import sistem.impl.CityDAOImpl;
import sistem.modelo.City;

/**
 *
 * @author Meryli
 */
@ManagedBean
@Named(value = "cityBean")
@ViewScoped
public class CityBean {

    private City ciudad = null;
    private List<City> ciudades = null;

    public CityBean() {
    }

    public List<City> getCiudades() {
        CityDAO datos = new CityDAOImpl();
        this.ciudades = datos.select();
        return ciudades;
    }

    public void prepareCiudad() {
        ciudad = new City();
    }

    public void insertCiudad() {
        CityDAO datos = new CityDAOImpl();
        datos.insert(ciudad);
    }

    public void updateCiudad() {
        CityDAO datos = new CityDAOImpl();
        datos.update(ciudad);
        this.ciudad = new City();
    }

    public void deleteCiudad() {
        CityDAO datos = new CityDAOImpl();
        datos.delete(ciudad);
        ciudad = new City();
    }

    public City getCiudad() {
        return ciudad;
    }

    public void setCiudad(City ciudad) {
        this.ciudad = ciudad;
    }

    public void setCiudades(List<City> ciudades) {
        this.ciudades = ciudades;
    }

}
