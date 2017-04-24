package fr.starfx.core.time;

import fr.starfx.core.property.SimpleHasMappedObservableValuesObject;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SimpleGlobalTime extends SimpleHasMappedObservableValuesObject implements GlobalTime {

    private DoubleProperty currentTime = new SimpleDoubleProperty(
            this,
            CURRENT_TIME_PROPERTY_NAME,
            getCreationTime()
    );

    @Override
    public DoubleProperty currentTimeProperty() {
        return currentTime;
    }

}
