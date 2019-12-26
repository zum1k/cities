import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class City {
    private String Name;
    private int population;

    City(String cityName, int population) {
        this.Name = cityName;
        this.population = population;
    }

    public String getName() {
        return Name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Name.equals(city.Name);
    }

    @Override
    public int hashCode() {
        return Name.hashCode() * Name.hashCode() -  Name.hashCode()*population;
    }
}