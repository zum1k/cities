import java.util.*;

public class Region {
    private String regionName;
    private City capitalRegionName;
    private Set<District> disctricts;

    Region(String regionName, City capitalName, Set<District> districts) {
        this.regionName = regionName;
        this.capitalRegionName = capitalName;
        this.disctricts = districts;
    }

    public Set<District> getDisctricts() {
        return disctricts;
    }

    public void addDistricts(Set<District> disctricts) {
        this.disctricts.addAll(disctricts);
    }

    public void addDistrict(District district) {
        this.disctricts.add(district);
    }

    public City getCapitalRegionName() {
        return capitalRegionName;
    }

    public City getCapital(){return capitalRegionName; };

    public int getRegionSquare() {
        int summator = 0;
        for (District ob : disctricts
        ) {
            summator = summator + ob.getDistrictSquare();
        }
        return summator;
    }

    public int getRegionPopulation() {
        int summator = 0;
        for (District ob : disctricts
        ) {
            summator = summator + ob.getDistrictPopulation();
        }
        return summator;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionName == region.regionName ;
    }
    @Override
    public int hashCode() {
        return regionName.hashCode() * regionName.hashCode() + regionName.hashCode();
    }


}

