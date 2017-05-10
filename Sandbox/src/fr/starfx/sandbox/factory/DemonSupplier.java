package fr.starfx.sandbox.factory;

import fr.starfx.sandbox.Faction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class DemonSupplier extends AbstractSupplier {

    private final TierSupplier tierSupplier = new TierSupplier();
    private final FactionSupplier factionSupplier = new FactionSupplier();
    private final ObservableMap<Faction, ArchetypeSupplier> archetypeSupplierMap
            = FXCollections.observableHashMap();

    public TierSupplier getTierSupplier() {
        return tierSupplier;
    }

    public FactionSupplier getFactionSupplier() {
        return factionSupplier;
    }

    public ObservableMap<Faction, ArchetypeSupplier> getArchetypeSupplierMap() {
        return archetypeSupplierMap;
    }

}
