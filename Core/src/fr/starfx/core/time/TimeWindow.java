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

    // Is Future
    // ---------

    default boolean isFuture() {
        return startTimeProperty().get() >= currentTimeProperty().get();
    }

    BooleanBinding isFutureBinding();

    static BooleanBinding createIsFutureBinding(TimeWindow timeWindow) {
        return Bindings.createBooleanBinding(
                timeWindow::isFuture,
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty(),
                timeWindow.currentTimeProperty()
        );
    }

    // Is Past
    // -------

    default boolean isPast(long time) {
        return getEndTime() < time;
    }

    default boolean isPast() {
        return isPast(currentTimeProperty().get());
    }

    BooleanBinding isPastBinding();

    static BooleanBinding createIsPastBinding(TimeWindow timeWindow) {
        return Bindings.createBooleanBinding(
                timeWindow::isPast,
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty(),
                timeWindow.currentTimeProperty()
        );
    }

    // Is Active
    // ---------

    default boolean isActive() {
        return !isFuture() && !isPast();
    }

    BooleanBinding isActiveBinding();

    static BooleanBinding createIsActiveBinding(TimeWindow timeWindow) {
        return Bindings.createBooleanBinding(
                timeWindow::isFuture,
                timeWindow.startTimeProperty(),
                timeWindow.durationProperty(),
                timeWindow.currentTimeProperty()
        );
    }

    // Elapsed Duration
    // ----------------

    default long getElapsedDuration() {
        if (isPast()) return durationProperty().get();
        if (isFuture()) return 0L;
        return currentTimeProperty().get() - startTimeProperty().get();
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
            return isFuture() ? 0.0 : 1.0;
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

    static long getRelevantTime(TimeWindow timeWindow) {
        if (timeWindow.isFuture()) return timeWindow.startTimeProperty().get();
        return timeWindow.getEndTime();
    }

    @Override
    default int compareTo(TimeWindow o) {
        return Long.compare(getRelevantTime(this), getRelevantTime(o));
    }

    // Extractor
    // ---------

    /**
     * {@link #isFutureBinding()} is used instead of {@link #currentTimeProperty()}
     * to mark the object updated only when the {@code timeWindow} relevant time
     * changes because of {@code currentTime}.
     */
    static Observable[] extractor(TimeWindow timeWindow) {
        final Observable[] result = new Observable[3];
        result[0] = timeWindow.startTimeProperty();
        result[1] = timeWindow.durationProperty();
        result[2] = timeWindow.isFutureBinding();
        return result;
    }

}
