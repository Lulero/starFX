package fr.starfx.sandbox.archetype;

import fr.starfx.sandbox.Archetype;

import java.util.HashMap;
import java.util.Map;

public class ArchetypeFactory {

    private final Map<String, Impl> archetypeMap = new HashMap<>();

    public Archetype getArchetype(String name) {
        if (archetypeMap.containsKey(name)) return archetypeMap.get(name);
        final Impl archetype = new Impl(name);
        archetypeMap.put(name, archetype);
        return archetype;
    }

    private static class Impl extends Archetype {

        private Impl(String name) {
            super();
            internalName.set(name);
        }

        private void setOdds(double odds) {
            internalOdds.set(odds);
        }
    }

}
