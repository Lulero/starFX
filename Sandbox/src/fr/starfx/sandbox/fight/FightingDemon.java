package fr.starfx.sandbox.fight;

import fr.starfx.sandbox.Demon;
import javafx.beans.property.*;

public class FightingDemon {

    public final ObjectProperty<Demon> demon = new SimpleObjectProperty<>(this, "Demon");

    public final ObjectProperty<Fight> fight = new SimpleObjectProperty<>(this, "Fight");
    public final ObjectProperty<FightingSide> side = new SimpleObjectProperty<>(this, "Side");

    public final IntegerProperty woundCount = new SimpleIntegerProperty(this, "Wound Count");
    public final BooleanProperty isDead = new SimpleBooleanProperty(this, "Is Dead");

    public void initialize(Fight fight, FightingSide side) {
        this.fight.set(fight);
        this.side.set(side);
        this.woundCount.set(0);
        this.isDead.set(false);
    }

}
