package fr.starfx.sandbox.factory;

import fr.starfx.sandbox.Archetype;
import fr.starfx.sandbox.Faction;
import fr.starfx.sandbox.common.SandboxUtils;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class ArchetypeSupplier extends AbstractSupplier {

    private final Faction faction;

    private final ObservableMap<Archetype, Double> archetypeOdds = FXCollections.observableHashMap();

    private final ReadOnlyDoubleProperty totalArchetypeOdds
            = SandboxUtils.createTotalOdds(this, "Archetype Total Odds", archetypeOdds);

    public ArchetypeSupplier(Faction faction) {
        this.faction = faction;
    }

    public Faction getFaction() {
        return faction;
    }

    public ObservableMap<Archetype, Double> getArchetypeOdds() {
        return archetypeOdds;
    }

    public double getTotalArchetypeOdds() {
        return totalArchetypeOdds.get();
    }

    public ReadOnlyDoubleProperty totalArchetypeOddsProperty() {
        return totalArchetypeOdds;
    }

    public Archetype rollArchetype() {
        return SandboxUtils.pick(rng, archetypeOdds, getTotalArchetypeOdds());
    }
}
