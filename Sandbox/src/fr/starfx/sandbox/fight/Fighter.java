package fr.starfx.sandbox.fight;

import fr.starfx.sandbox.Demon;
import fr.starfx.sandbox.fight.vital.VitalSheet;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Fighter extends FightObject {

    private final Demon demon;
    private final VitalSheet vitalSheet = new VitalSheet();
    private final IntegerProperty archetypeState = new SimpleIntegerProperty(this, "Archetype State");

    public Fighter(Fight fight, Demon demon) {
        super(fight);
        this.demon = demon;
    }

    public Demon getDemon() {
        return demon;
    }

    public VitalSheet getVitalSheet() {
        return vitalSheet;
    }

    public int getArchetypeState() {
        return archetypeState.get();
    }

    public IntegerProperty archetypeStateProperty() {
        return archetypeState;
    }

    public void setArchetypeState(int archetypeState) {
        this.archetypeState.set(archetypeState);
    }

}
