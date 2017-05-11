package fr.starfx.sandbox.data.base;

import fr.starfx.sandbox.common.NamedObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class WeightedObject extends NamedObject {

    private final IntegerProperty weight = new SimpleIntegerProperty(this, "Weight", 0);

    public WeightedObject(String name) {
        super(name);
    }

    public int getWeight() {
        return weight.get();
    }

    public IntegerProperty weightProperty() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight.set(weight);
    }

}
