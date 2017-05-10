package fr.starfx.sandbox.factory;

import fr.starfx.sandbox.Faction;
import fr.starfx.sandbox.common.SandboxUtils;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class FactionSupplier extends AbstractSupplier {

    private final ObservableMap<Faction, Double> factionOdds = FXCollections.observableHashMap();

    private final ReadOnlyDoubleProperty totalFactionOdds
            = SandboxUtils.createTotalOdds(this, "Faction Total Odds", factionOdds);

    public ObservableMap<Faction, Double> getFactionOdds() {
        return factionOdds;
    }

    public double getTotalFactionOdds() {
        return totalFactionOdds.get();
    }

    public ReadOnlyDoubleProperty totalFactionOddsProperty() {
        return totalFactionOdds;
    }

    public Faction rollFaction() {
        return SandboxUtils.pick(rng, factionOdds, getTotalFactionOdds());
    }

}

