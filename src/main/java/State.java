import java.util.ArrayList;
import java.util.*;

public class State {
    private String stateName;
    private City stateCapital;
    private Set<Region> regions;

    State(String stateName, City stateCapital, Set<Region> regions) {
        this.stateName = stateName;
        this.stateCapital = stateCapital;
        this.regions = regions;
    }

    public String getStateName() {
        return stateName;
    }

    public City getStateCapital() {
        return stateCapital;
    }

    public int getStateSquare() {
        int summator = 0;
        for (Region ob : regions) {
            summator = summator + ob.getRegionSquare();
        }
        return summator;
    }
    public int getStatePopulation() {
        int summator = 0;
        for (Region ob : regions
        ) {
            summator = summator + ob.getRegionPopulation();
        }
        return summator;
    }

    public void addRegions(Set<Region> regions) {
        this.regions.addAll(regions);
    }

    public void addRegion(Region region) {
        this.regions.add(region);
    }

}