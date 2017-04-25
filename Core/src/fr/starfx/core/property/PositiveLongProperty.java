package fr.starfx.core.property;

import com.sun.javafx.binding.Logging;
import javafx.beans.property.SimpleLongProperty;

public class PositiveLongProperty extends SimpleLongProperty {

    private static final Object DEFAULT_BEAN = null;
    private static final String DEFAULT_NAME = "";
    private static final long ZERO = 0L;

    public PositiveLongProperty(Object bean, String name, long initialValue) {
        super(bean, name);
        set(initialValue);
    }

    public PositiveLongProperty() {
        this(DEFAULT_BEAN, DEFAULT_NAME, ZERO);
    }

    public PositiveLongProperty(long initialValue) {
        this(DEFAULT_BEAN, DEFAULT_NAME, initialValue);
    }

    public PositiveLongProperty(Object bean, String name) {
        this(bean, name, ZERO);
    }

    @Override
    public void set(long newValue) {
        if (newValue < ZERO) {
            Logging.getLogger().fine(
                    "Attempt to set positive long property to a negative, using zero instead.",
                    new IllegalArgumentException()
            );
            super.set(ZERO);
        } else {
            super.set(newValue);
        }
    }

}
