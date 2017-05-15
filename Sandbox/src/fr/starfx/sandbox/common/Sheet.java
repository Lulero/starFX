package fr.starfx.sandbox.common;

import java.util.HashMap;
import java.util.Map;

public class Sheet<E extends Enum<E>, T> {

    private final Map<E, T> valueMap = new HashMap<>();
    private final T defaultValue;

    public Sheet(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Map<E, T> getValueMap() {
        return valueMap;
    }

    public T getValue(E item) {
        final T result = getValueMap().get(item);
        if (result == null) return defaultValue;
        return result;
    }

    public void setValue(E item, T value) {
        valueMap.put(item, value);
    }
}
