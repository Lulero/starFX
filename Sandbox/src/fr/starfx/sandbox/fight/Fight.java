package fr.starfx.sandbox.fight;

import fr.starfx.sandbox.World;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fight extends World {

    private final ObservableList<FightSide> fightSideList = FXCollections.observableArrayList();

    public ObservableList<FightSide> getFightSideList() {
        return fightSideList;
    }

}
