
package sistem.dao;

import java.util.List;
import sistem.modelo.Country;

/**
 *
 * @author Meryli
 */
public interface CountryDAO {
    public List<Country> select();
    public void insert(Country pais);
    public void update(Country pais);
    public void delete(Country pais);
}
