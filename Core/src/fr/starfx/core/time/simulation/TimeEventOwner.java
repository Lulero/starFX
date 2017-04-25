package fr.starfx.core.time.simulation;

import fr.starfx.core.time.TimeGlobal;
import fr.starfx.core.time.simple.SimpleTimeWindow;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

public class TimeEventOwner<T extends TimeEvent> extends SimpleTimeWindow implements TimeEvent {

    private final ObservableList<T> eventList;
    private final ObservableList<T> sortedEventList;

    private TimeEventOwner(TimeGlobal timeGlobal, List<T> rawEventList) {
        super(timeGlobal);
        if (rawEventList instanceof ObservableList) {
            eventList = (ObservableList<T>) rawEventList;
        } else {
            eventList = FXCollections.observableList(rawEventList);
        }
        sortedEventList = eventList
                .filtered(t -> t.endTimeBinding().get() != 0L)
                .sorted();
        startTimeProperty().bind(Bindings.createLongBinding(
                () -> sortedEventList.isEmpty() ? 0L : sortedEventList.get(0).getEndTime(),
                sortedEventList
        ));
        durationProperty().bind(Bindings.createLongBinding(() -> 0L));
    }

    public TimeEventOwner(TimeGlobal timeGlobal) {
        this(timeGlobal, new LinkedList<>());
    }

    public ObservableList<T> getEventList() {
        return sortedEventList;
    }

}
