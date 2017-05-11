package fr.starfx.sandbox.data.base;

import fr.starfx.sandbox.data.skill.PassiveSkill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Affix extends WeightedObject {

    private final ObservableList<PassiveSkill> passiveList = FXCollections.observableArrayList();

    public Affix(String name) {
        super(name);
    }

    public ObservableList<PassiveSkill> getPassiveList() {
        return passiveList;
    }
}
