package fr.starfx.sandbox;

import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class Utils {

    public static ReadOnlyLongProperty readOnlyLongProperty(Object bean, String name, long initialValue) {
        final ReadOnlyLongWrapper wrapper = new ReadOnlyLongWrapper(bean, name, initialValue);
        return wrapper.getReadOnlyProperty();
    }

    public static ReadOnlyStringProperty readOnlyStringProperty(Object bean, String name, String initialValue) {
        final ReadOnlyStringWrapper wrapper = new ReadOnlyStringWrapper(bean, name, initialValue);
        return wrapper.getReadOnlyProperty();
    }

}
