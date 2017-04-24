package fr.starfx.core.property;

import javafx.beans.property.Property;

import java.util.Map;

public interface HasMappedProperties {

    Map<String, Property> getPropertyMap();

}
