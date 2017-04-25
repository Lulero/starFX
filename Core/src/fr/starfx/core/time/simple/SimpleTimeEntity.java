package fr.starfx.core.time.simple;

import fr.starfx.core.time.TimeEntity;
import fr.starfx.core.time.TimeGlobal;
import javafx.beans.binding.LongBinding;

public class SimpleTimeEntity extends SimpleTimeObject implements TimeEntity {

    private final long creationTime;

    private LongBinding age = null;

    public SimpleTimeEntity(TimeGlobal timeGlobal) {
        super(timeGlobal);
        creationTime = currentTimeProperty().get();
    }

    @Override
    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public LongBinding ageBinding() {
        if (age == null) age = TimeEntity.createAgeBinding(this);
        return age;
    }

}
