package sistem.modelo;
// Generated 18-sep-2023 7:05:44 by Hibernate Tools 4.3.1



/**
 * City generated by hbm2java
 */
public class City  implements java.io.Serializable {


     private Integer id;
     private Country country;
     private String name;
     private String district;
     private int population;

    public City() {
    }

    public City(Country country, String name, String district, int population) {
       this.country = country;
       this.name = name;
       this.district = district;
       this.population = population;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Country getCountry() {
        return this.country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    public int getPopulation() {
        return this.population;
    }
    
    public void setPopulation(int population) {
        this.population = population;
    }




}

