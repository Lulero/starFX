package fr.starfx.sandbox.archetype;

import fr.starfx.sandbox.common.NamedObject;
import fr.starfx.sandbox.fight.Fighter;
import fr.starfx.sandbox.fight.vital.Vital;
import fr.starfx.sandbox.stat.BaseStat;

public class Archetype extends NamedObject {

    static public int STATE_BASIC = 0;
    static public int STATE_ULTIMATE = 1;

    public Archetype(String name) {
        super(name);
    }

    protected int speedToDelay(Fighter fighter) {
        final double speed = fighter.getDemon().getStatsSheet().getValue(BaseStat.SPEED);
        return (int) (100L / speed);
    }

    public void initialize(Fighter fighter) {
        fighter.getVitalSheet().setValue(Vital.LIFE, 100);
        fighter.getVitalSheet().setValue(Vital.ENERGY, 0);

        fighter.setArchetypeState(STATE_BASIC);
        fighter.getVitalSheet().set
    }

    public abstract void act(Fighter fighter);

}
