package fr.starfx.sandbox.wellofsouls;

import fr.starfx.sandbox.Archetype;
import fr.starfx.sandbox.Demon;
import fr.starfx.sandbox.Faction;
import fr.starfx.sandbox.common.SandboxUtils;
import fr.starfx.sandbox.common.Tier;
import fr.starfx.sandbox.common.WorldObject;
import fr.starfx.sandbox.factory.DemonSupplier;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.Random;

public class WellOfSouls extends WorldObject {

    static private final int DEFAULT_CAPACITY = 100;

    private Random rng = new Random();

    private final DemonSupplier demonSupplier;

    private final IntegerProperty capacity
            = new SimpleIntegerProperty(this, "Capacity", DEFAULT_CAPACITY);

    private final ObservableList<Demon> internalSoulPool = FXCollections.observableArrayList();
    private final ObservableList<Demon> soulPool = FXCollections.unmodifiableObservableList(internalSoulPool);

    private final ObservableList<Demon> internalSoulItems = FXCollections.observableArrayList();
    private final ObservableList<Demon> soulItems = FXCollections.unmodifiableObservableList(internalSoulItems);

    private final ObservableList<Demon> internalDemonList = FXCollections.observableArrayList();
    private final ObservableList<Demon> demonList = FXCollections.unmodifiableObservableList(internalDemonList);

    private final ReadOnlyIntegerProperty demonCount = SandboxUtils.createTotalSize(this, "Demon Count",
            internalSoulPool, internalSoulItems, internalDemonList);

    private final BooleanProperty autoFill = new SimpleBooleanProperty(this, "Auto Fill", false);

    public WellOfSouls(String name, ReadOnlyLongProperty currentTimeProperty, DemonSupplier demonSupplier) {
        super("Well Of Soul" + (name!=null && !name.trim().equals("") ? " [" + name + "]" : ""),
                currentTimeProperty
        );
        this.demonSupplier = demonSupplier;
        autoFill.addListener(this::onAutoFillChanged);
    }

    public WellOfSouls(ReadOnlyLongProperty currentTimeProperty, DemonSupplier demonSupplier) {
        this(null, currentTimeProperty, demonSupplier);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public IntegerProperty capacityProperty() {
        return capacity;
    }

    public ObservableList<Demon> getSoulPool() {
        return soulPool;
    }

    public ObservableList<Demon> getSoulItems() {
        return soulItems;
    }

    public ObservableList<Demon> getDemonList() {
        return demonList;
    }

    public int getDemonCount() {
        return demonCount.get();
    }

    public ReadOnlyIntegerProperty demonCountProperty() {
        return demonCount;
    }

    @SuppressWarnings("unused")
    private void onAutoFillChanged(Observable ignored1, boolean ignored2, boolean newValue) {
        if (newValue) {
            demonCount.addListener(this::fillUpListener);
            capacity.addListener(this::fillUpListener);
            fillUp();
        } else {
            demonCount.removeListener(this::fillUpListener);
            capacity.removeListener(this::fillUpListener);
        }
    }

    private void fillUpListener(Object ignored1, Object ignored2, Object ignored3) {
        fillUp();
    }

    private void fillUp() {
        while (getDemonCount() < getCapacity()) {
            createDemonSoul();
        }
    }

    public Demon createDemonSoul() {
        return null;
    }

    public Demon createDemonSoul(Faction faction, Archetype archetype, String name, Tier tier) {
        return null;
    }

}
