package fr.starfx.core.time;

import javafx.beans.Observable;

public interface TimeObject extends Comparable<TimeObject> {

    TimeProperty timeProperty();

    @Override
    default int compareTo(TimeObject o) {
        return Long.compare(timeProperty().get(), o.timeProperty().get());
    }

    default boolean isFromThePast() {
        return timeProperty().computeTimeTense() == TimeTense.PAST;
    }

    static Observable[] extractor(TimeObject timeObject) {
        final Observable[] result = new Observable[1];
        result[0] = timeObject.timeProperty();
        return  result;
    }

}
