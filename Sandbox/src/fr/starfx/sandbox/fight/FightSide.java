package fr.starfx.sandbox.fight;

import javafx.beans.property.ObjectProperty;

public class FightSide extends FightObject {

    private ObjectProperty<FightSide> opponentSide;

    public FightSide(Fight fight) {
        super(fight);
    }

    public FightSide getOpponentSide() {
        return opponentSide.get();
    }

    public ObjectProperty<FightSide> opponentSideProperty() {
        return opponentSide;
    }

    public void setOpponentSide(FightSide opponentSide) {
        this.opponentSide.set(opponentSide);
    }

}
