package fr.starfx.sandbox.data;

import fr.starfx.sandbox.common.NamedObject;
import fr.starfx.sandbox.data.skill.GeneratorSkill;
import fr.starfx.sandbox.data.skill.PassiveSkill;
import fr.starfx.sandbox.data.skill.SpenderSkill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBase extends NamedObject {

    private final ObservableList<Prefix> prefixList = FXCollections.observableArrayList();

    private final ObservableList<Archetype> archetypeList = FXCollections.observableArrayList();

    private final ObservableList<Suffix> suffixList = FXCollections.observableArrayList();

    private final ObservableList<GeneratorSkill> generatorList = FXCollections.observableArrayList();

    private final ObservableList<SpenderSkill> spenderList = FXCollections.observableArrayList();

    private final ObservableList<PassiveSkill> passiveSkills = FXCollections.observableArrayList();

    public DataBase(String name) {
        super(name);
    }

    public ObservableList<Prefix> getPrefixList() {
        return prefixList;
    }

    public ObservableList<Archetype> getArchetypeList() {
        return archetypeList;
    }

    public ObservableList<Suffix> getSuffixList() {
        return suffixList;
    }

    public ObservableList<GeneratorSkill> getGeneratorList() {
        return generatorList;
    }

    public ObservableList<SpenderSkill> getSpenderList() {
        return spenderList;
    }

    public ObservableList<PassiveSkill> getPassiveSkills() {
        return passiveSkills;
    }
}
