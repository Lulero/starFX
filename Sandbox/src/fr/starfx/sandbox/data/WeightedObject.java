package fr.starfx.sandbox.data;

import fr.starfx.sandbox.common.NamedObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class WeightedObject<T extends NamedObject> extends NamedObject {

    private final ObservableMap<T, IntegerProperty> weightMap = FXCollections.observableHashMap();

    public WeightedObject(String name) {
        super(name);
    }

    public IntegerProperty weightPropertyFor(T scope) {
        IntegerProperty result = weightMap.get(scope);
        if (result == null) {
            result = new SimpleIntegerProperty(this, "Weight for " + scope.getName(), 0);
            weightMap.put(scope, result);
        }
        return result;
    }

}
