package fr.starfx.sandbox.fight.vital;

import fr.starfx.sandbox.common.Sheet;

public class VitalSheet extends Sheet<Vital, Integer> {

    public VitalSheet() {
        super(0);
    }

    public boolean isAlive() {
        return getValue(Vital.LIFE) > 0;
    }

    public boolean canAct() {
        return getValue(Vital.DELAY) <= 0;
    }

    public boolean canUseSpecial() {
        return getValue(Vital.ENERGY) >= 100;
    }

}
