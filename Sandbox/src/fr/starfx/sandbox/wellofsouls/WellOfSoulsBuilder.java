package fr.starfx.sandbox.wellofsouls;

import fr.starfx.sandbox.demon.Archetype;

import java.util.HashMap;
import java.util.Map;

public class WellOfSoulsBuilder {

    private int capacity = WellOfSouls.DEFAULT_CAPACITY;
    private int starOdds = WellOfSouls.DEFAULT_STAR_ODDS;

    public boolean addArchetype(String name, double odds) {
        if (archetypeMap.containsKey(name)) return false;
        final Impl archetype = new Impl(name, odds);
        archetypeMap.put(name, archetype);
        return true;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStarOdds(int starOdds) {
        this.starOdds = starOdds;
    }

    public WellOfSouls build() {
        final WellOfSouls result = new WellOfSouls();
        result.capacity.set(capacity);
        result.starOdds.set(starOdds);
        // TODO
        return result;
    }


}
