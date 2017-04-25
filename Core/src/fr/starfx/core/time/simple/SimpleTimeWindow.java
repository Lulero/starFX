package fr.starfx.core.time.simple;

import fr.starfx.core.property.PositiveLongProperty;
import fr.starfx.core.time.TimeGlobal;
import fr.starfx.core.time.TimeWindow;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.binding.ObjectBinding;

public class SimpleTimeWindow extends SimpleTimeObject implements TimeWindow {

    private final PositiveLongProperty startTime = new PositiveLongProperty(this, "Start Time");
    private final PositiveLongProperty duration = new PositiveLongProperty(this, "Duration");

    private LongBinding endTime = null;
    private BooleanBinding isInstant = null;
    private ObjectBinding<TimeWindow.Status> timeStatus = null;
    private LongBinding elapsedDuration = null;
    private LongBinding remainingDuration = null;
    private DoubleBinding progress = null;

    public SimpleTimeWindow(TimeGlobal timeGlobal) {
        super(timeGlobal);
    }

    public SimpleTimeWindow withStartTime(long startTime) {
        startTimeProperty().set(startTime);
        return this;
    }

    public SimpleTimeWindow withDuration(long duration) {
        durationProperty().set(duration);
        return this;
    }

    @Override
    public PositiveLongProperty startTimeProperty() {
        return startTime;
    }

    @Override
    public PositiveLongProperty durationProperty() {
        return duration;
    }

    @Override
    public LongBinding endTimeBinding() {
        if (endTime == null) endTime = TimeWindow.createEndTimeBinding(this);
        return endTime;
    }

    @Override
    public BooleanBinding isInstantBinding() {
        if (isInstant == null) isInstant = TimeWindow.createIsInstantBinding(this);
        return isInstant;
    }

    @Override
    public ObjectBinding<Status> timeStatusBinding() {
        if (timeStatus == null) timeStatus = TimeWindow.createTimeStatusBinding(this);
        return timeStatus;
    }

    @Override
    public LongBinding elapsedDurationBinding() {
        if (elapsedDuration == null) elapsedDuration = TimeWindow.createElapsedDurationBinding(this);
        return elapsedDuration;
    }

    @Override
    public LongBinding remainingDurationBinding() {
        if (remainingDuration == null) remainingDuration = TimeWindow.createRemainingDurationBinding(this);
        return remainingDuration;
    }

    @Override
    public DoubleBinding progressBinding() {
        if (progress == null) progress = TimeWindow.createProgressBinding(this);
        return progress;
    }

}
