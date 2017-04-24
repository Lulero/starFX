package fr.starfx.core.property;

import javafx.beans.property.Property;

import java.util.HashMap;
import java.util.Map;

public class SimpleHasMappedPropertiesObject implements HasMappedProperties {

    private final Map<String, Property> propertyMap = new HashMap<>();

    @Override
    public Map<String, Property> getPropertyMap() { return propertyMap; }

}
