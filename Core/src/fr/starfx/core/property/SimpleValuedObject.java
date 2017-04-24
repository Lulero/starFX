package fr.starfx.core.property;

import javafx.beans.value.ObservableValue;

import java.util.HashMap;
import java.util.Map;

public class SimpleValuedObject implements ValuedObject {

    private final Map<String, ObservableValue> observableValueMap = new HashMap<>();

    @Override
    public Map<String, ObservableValue> getObservableValueMap() { return observableValueMap; }

}
