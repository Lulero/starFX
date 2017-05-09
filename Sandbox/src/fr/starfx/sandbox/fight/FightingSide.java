package fr.starfx.sandbox.fight;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FightingSide {

    public final ObjectProperty<Fight> fight = new SimpleObjectProperty<>(this, "Fight");

    public final ObservableList<FightingDemon> members = FXCollections.observableArrayList();

    public void initialize(Fight fight) {
        this.fight.set(fight);
        members.forEach(d -> d.initialize(fight, this));
    }

}
