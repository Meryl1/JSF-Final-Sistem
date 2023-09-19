
package sistem.dao;

import java.util.List;
import sistem.modelo.City;

/**
 *
 * @author Meryli
 */
public interface CityDAO {
    public List<City> select();
    public void insert(City ciudad);
    public void update(City ciudad);
    public void delete(City ciudad);
}
