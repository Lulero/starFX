package fr.starfx.sandbox.common;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.Random;

public class SandboxUtils {

    static public ReadOnlyDoubleProperty createTotalOdds(Object bean, String name, ObservableMap<?, Double> oddsMap) {
        final ReadOnlyDoubleWrapper wrapper = new ReadOnlyDoubleWrapper(bean, name);
        wrapper.bind(Bindings.createDoubleBinding(
                () -> {
                    double result = 0.0;
                    for (Double odds : oddsMap.values()) {
                        result += odds != null ? odds : 0.0;
                    }
                    return result;
                }, oddsMap
        ));
        return wrapper.getReadOnlyProperty();
    }

    static public <T> T pick(Random rng, ObservableMap<T, Double> oddsMap, double totalOdds) {
        final double roll = rng.nextDouble() * totalOdds;
        T lastElement = null;
        double accumulator = 0.0;
        for (T element : oddsMap.keySet()) {
            final Double elementOdds = oddsMap.get(element);
            if (elementOdds != null) {
                accumulator += elementOdds;
                if (roll < accumulator) return element;
            }
            lastElement = element;
        }
        return lastElement;
    }

    static public int rollTier(Random rng, int startingOdds) {
        int odds = startingOdds;
        if (odds < 1) odds = 1;
        int result = 0;
        while (rng.nextInt(101) < (odds > 99 ? 99 : odds)) {
            result += 1;
            odds = odds == 1 ? 1 : odds - 1;
        }
        return result;
    }

    static public ObservableList<?> createDependencies(Observable ... observables) {
        final ObservableList<Observable> dependencies = FXCollections.observableArrayList(
                observable -> {
                    final Observable[] result = new Observable[1];
                    result[0] = observable;
                    return result;
                }
        );
        dependencies.addAll(observables);
        return dependencies;
    }

    static public ReadOnlyIntegerProperty createTotalSize(Object bean, String name, ObservableList<?> ... lists) {
        final ReadOnlyIntegerWrapper wrapper = new ReadOnlyIntegerWrapper(bean, name);
        wrapper.bind(Bindings.createIntegerBinding(
                () -> {
                    int result = 0;
                    for (ObservableList<?> list : lists) {
                        result += list.size();
                    }
                    return result;
                },
                createDependencies(lists)
        ));
        return wrapper.getReadOnlyProperty();
    }

}
