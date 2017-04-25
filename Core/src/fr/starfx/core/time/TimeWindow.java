package fr.starfx.core.time;

import fr.starfx.core.property.PositiveLongProperty;
import javafx.beans.Observable;
import javafx.beans.binding.*;

import java.util.Comparator;

public interface TimeWindow extends TimeObject, Comparable<TimeWindow> {

    PositiveLongProperty startTimeProperty();

    PositiveLongProperty durationProperty();

    // End Time
    // --------

    default long getEndTime() {
        return startTimeProperty().get() + durationProperty().get();
    }

    LongBinding endTimeBinding();

    static LongBinding createEndTimeBinding(TimeWindow timeWindow) {
        return Bindings.createLongBinding(
                timeWindow::getEndTime,
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty()
        );
    }

    // Is Instant
    // ----------

    default boolean isInstant() {
        return durationProperty().get() == 0L;
    }

    BooleanBinding isInstantBinding();

    static BooleanBinding createIsInstantBinding(TimeWindow timeWindow) {
        return Bindings.createBooleanBinding(
                timeWindow::isInstant,
                timeWindow.durationProperty()
        );
    }

    // Time Status
    // -----------

    enum Status {
        BEFORE,
        OPEN,
        AFTER
    }

    default Status getTimeStatus() {
        final long currentTime = currentTimeProperty().get();
        final long startTime = startTimeProperty().get();
        if (startTime > currentTime) return Status.BEFORE;
        final long endTime = getEndTime();
        if (currentTime <= endTime) return Status.OPEN;
        return Status.AFTER;
    }

    ObjectBinding<Status> timeStatusBinding();

    static ObjectBinding<Status> createTimeStatusBinding(TimeWindow timeWindow) {
        return Bindings.createObjectBinding(
                timeWindow::getTimeStatus,
                timeWindow.currentTimeProperty(),
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty()
        );
    }

    // Elapsed Duration
    // ----------------

    default long getElapsedDuration() {
        final Status status = getTimeStatus();
        switch (status) {
            case AFTER: return durationProperty().get();
            case OPEN: return currentTimeProperty().get() - startTimeProperty().get();
            case BEFORE: return 0L;
            default: throw new IllegalStateException(status.toString());
        }
    }

    LongBinding elapsedDurationBinding();

    static LongBinding createElapsedDurationBinding(TimeWindow timeWindow) {
        return Bindings.createLongBinding(
                timeWindow::getElapsedDuration,
                timeWindow.currentTimeProperty(),
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty()
        );
    }

    // Remaining Duration
    // ------------------

    default long getRemainingDuration() {
        return durationProperty().get() - getElapsedDuration();
    }

    LongBinding remainingDurationBinding();

    static LongBinding createRemainingDurationBinding(TimeWindow timeWindow) {
        return Bindings.createLongBinding(
                timeWindow::getRemainingDuration,
                timeWindow.currentTimeProperty(),
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty()
        );
    }

    // Progress
    // --------

    default double getProgress() {
        if (isInstant()) {
            return getTimeStatus() == Status.BEFORE ? 0.0 : 1.0;
        }
        return (double) getElapsedDuration() / (double) durationProperty().get();
    }

    DoubleBinding progressBinding();

    static DoubleBinding createProgressBinding(TimeWindow timeWindow) {
        return Bindings.createDoubleBinding(
                timeWindow::getProgress,
                timeWindow.currentTimeProperty(),
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty()
        );
    }

    // Comparator
    // ----------

    Comparator<TimeWindow> COMPARATOR = Comparator.comparingDouble(t -> t.endTimeBinding().get());

    @Override
    default int compareTo(TimeWindow o) {
        return COMPARATOR.compare(this, o);
    }

    // Extractor
    // ---------

    static Observable[] extractor(TimeWindow timeWindow) {
        final Observable[] result = new Observable[2];
        result[0] = timeWindow.startTimeProperty();
        result[1] = timeWindow.durationProperty();
        return result;
    }

}
