import java.util.Set;
import java.util.*;

public class District {
    private String districtName;
    private int districtSquare;
    private Set<City> cities;

    public District(String districtName, int districtSquare, Set<City> cities) {
        this.districtName = districtName;
        this.districtSquare = districtSquare;
        this.cities = cities;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void addCities(Set<City> cities) {
        this.cities.addAll(cities);
    }

    public int getDistrictSquare() {
        return districtSquare;
    }

    public String getDistrictName(){return districtName; }

    public City getCity(){return cities.iterator().next(); }

    public int getDistrictPopulation() {
        int summator = 0;
        for (City ob : cities
        ) {
            summator = summator + ob.getPopulation();
        }
        return summator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return  districtName.equals(district.districtName);
    }
    @Override
    public int hashCode() {
        return districtName.hashCode() * districtName.hashCode() + districtName.hashCode();
    }
}
