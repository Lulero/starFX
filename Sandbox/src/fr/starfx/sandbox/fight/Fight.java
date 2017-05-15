package fr.starfx.sandbox.fight;

import fr.starfx.sandbox.world.SimpleWorld;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fight extends SimpleWorld {

    private final ObservableList<FightSide> fightSideList = FXCollections.observableArrayList();

    private double statScale;

    public Fight(String name) {
        super(name);
    }

    public ObservableList<FightSide> getFightSideList() {
        return fightSideList;
    }

    public double getStatScale() {
        return statScale;
    }

    public void setStatScale(double statScale) {
        this.statScale = statScale;
    }

}
