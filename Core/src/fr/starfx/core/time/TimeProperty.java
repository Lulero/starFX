package fr.starfx.core.time;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ObservableLongValue;

public class TimeProperty extends SimpleLongProperty {

    private final ObservableLongValue observableCurrentTime;
    private ReadOnlyLongProperty waitDurationProperty = null;
    private ReadOnlyObjectProperty<TimeTense> timeTensePropery = null;

    public TimeProperty(ObservableLongValue observableCurrentTime, Object bean, long initialValue) {
        super(bean, "Time", initialValue);
        this.observableCurrentTime = observableCurrentTime;
    }

    private ObservableLongValue observableCurrentTime() { return observableCurrentTime; }
    private long getCurrentTime() { return observableCurrentTime().get(); }

    public LongProperty asLongProperty() { return this; }

    public void activateWaitDuration() {
        if (waitDurationProperty == null) {
            final ReadOnlyLongWrapper wrapper
                    = new ReadOnlyLongWrapper(getBean(), "Wait Duration");
            wrapper.bind(Bindings.createLongBinding(
                    this::computeWaitDuration,
                    this, this.observableCurrentTime()
            ));
            waitDurationProperty = wrapper.getReadOnlyProperty();
        }
    }

    public long computeWaitDuration() { return get() - getCurrentTime(); }
    public ReadOnlyLongProperty waitDurationProperty() { return waitDurationProperty; }
    public long getWaitDuration() { return waitDurationProperty().get(); }


    public void activateTimeTense() {
        if (timeTensePropery == null) {
            final ReadOnlyObjectWrapper<TimeTense> wrapper
                    = new ReadOnlyObjectWrapper<>(getBean(), "Time Tense");
            wrapper.bind(Bindings.createObjectBinding(
                    this::computeTimeTense,
                    this, this.observableCurrentTime()
            ));
            timeTensePropery = wrapper.getReadOnlyProperty();
        }
    }

    public TimeTense computeTimeTense() { return TimeTense.from(computeWaitDuration()); }
    public ReadOnlyObjectProperty<TimeTense> timeTenseProperty() { return timeTensePropery; }
    public TimeTense getTimeTense() { return timeTenseProperty().get(); }



}
