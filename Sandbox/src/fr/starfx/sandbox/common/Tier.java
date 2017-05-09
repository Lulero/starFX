package fr.starfx.sandbox.common;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

public class Tier {

    public final TieredWorldObject bean;

    public final DoubleProperty experience;
    public final IntegerProperty level;

    public final DoubleProperty essence;

    public final IntegerProperty naturalTier;
    public final IntegerProperty extraTier;
    public final ReadOnlyIntegerProperty tier;

    public Tier(TieredWorldObject bean) {
        this.bean = bean;

        experience = new SimpleDoubleProperty(bean, "Experience", 0);
        level = new SimpleIntegerProperty(this, "Level");

        essence = new SimpleDoubleProperty(this, "Essence", 0);

        naturalTier = new SimpleIntegerProperty(this, "Natural Tier", 0);
        extraTier = new SimpleIntegerProperty(this, "Extra Tier", 0);

        final ReadOnlyIntegerWrapper tierWrapper = new ReadOnlyIntegerWrapper(this, "Tier");
        tierWrapper.bind(Bindings.createIntegerBinding(
                () -> naturalTier.get() + extraTier.get(), naturalTier, extraTier
        ));
        tier = tierWrapper.getReadOnlyProperty();
    }

    @Override
    public String toString() {
        return level.get() + " <" + tier.get() + " [" + naturalTier.get() + "] >";
    }

}
