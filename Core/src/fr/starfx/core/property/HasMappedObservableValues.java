package fr.starfx.core.property;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;

import java.util.Map;
import java.util.concurrent.Callable;

public interface HasMappedObservableValues {

    Map<String, ObservableValue> getObservableValueMap();

    // Utilities
    // ---------

    @SuppressWarnings("unchecked")
    default <T> ReadOnlyObjectProperty<T> getReadOnlyObjectProperty(
            String propertyName,
            Callable<T> valueSupplier,
            Observable... dependencies) {
        ReadOnlyObjectProperty<T> result = (ReadOnlyObjectProperty<T>) getObservableValueMap().get(propertyName);
        if (result == null) {
            final ReadOnlyObjectWrapper<T> wrapper = new ReadOnlyObjectWrapper<>(this, propertyName);
            wrapper.bind(Bindings.createObjectBinding(valueSupplier, dependencies));
            result = wrapper.getReadOnlyProperty();
            getObservableValueMap().put(propertyName, result);
        }
        return result;
    }

    default ReadOnlyDoubleProperty getReadOnlyDoubleProperty(
            String propertyName,
            Callable<Double> valueSupplier,
            Observable... dependencies) {
        ReadOnlyDoubleProperty result = (ReadOnlyDoubleProperty) getObservableValueMap().get(propertyName);
        if (result == null) {
            final ReadOnlyDoubleWrapper wrapper = new ReadOnlyDoubleWrapper(this, propertyName);
            wrapper.bind(Bindings.createObjectBinding(valueSupplier, dependencies));
            result = wrapper.getReadOnlyProperty();
            getObservableValueMap().put(propertyName, result);
        }
        return result;
    }

}
