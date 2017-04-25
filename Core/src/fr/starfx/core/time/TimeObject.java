package fr.starfx.core.time;

import fr.starfx.core.property.PositiveLongProperty;

public interface TimeObject {

    TimeGlobal getTimeGlobal();

    default PositiveLongProperty currentTimeProperty() { return getTimeGlobal().currentTimeProperty(); }

}
