package fr.starfx.sandbox;

import fr.starfx.sandbox.Archetype;
import fr.starfx.sandbox.common.NamedObject;
import fr.starfx.sandbox.common.SandboxUtils;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.*;

public class Faction extends NamedObject {

    private final ObservableMap<Archetype, Double> archetypeOdds = FXCollections.observableHashMap();

    private final ReadOnlyDoubleProperty totalArchetypeOdds
            = SandboxUtils.createTotalOdds(this, "Total Archetype Odds", archetypeOdds);

    public Faction(String name) {
        super(name);
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
}
