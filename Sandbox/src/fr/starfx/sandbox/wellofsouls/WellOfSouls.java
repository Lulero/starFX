package fr.starfx.sandbox.wellofsouls;

import fr.starfx.sandbox.data.Archetype;
import fr.starfx.sandbox.Demon;
import fr.starfx.sandbox.data.Faction;
import fr.starfx.sandbox.common.SandboxUtils;
import fr.starfx.sandbox.common.Tier;
import fr.starfx.sandbox.common.WorldObject;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class WellOfSouls extends WorldObject {

    static private final int DEFAULT_CAPACITY = 100;

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

    public WellOfSouls(String name, ReadOnlyLongProperty currentTimeProperty) {
        super(name, currentTimeProperty);
        autoFill.addListener(this::onAutoFillChanged);
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

    public boolean isAutoFill() {
        return autoFill.get();
    }

    public BooleanProperty autoFillProperty() {
        return autoFill;
    }

    public void setAutoFill(boolean autoFill) {
        this.autoFill.set(autoFill);
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
            break; // TODO
        }
    }

}
