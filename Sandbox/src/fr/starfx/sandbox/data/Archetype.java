package fr.starfx.sandbox.data;

import fr.starfx.sandbox.data.base.WeightedObject;
import fr.starfx.sandbox.data.skill.GeneratorSkill;
import fr.starfx.sandbox.data.skill.PassiveSkill;
import fr.starfx.sandbox.data.skill.SpenderSkill;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Archetype extends WeightedObject {

    private final ObjectProperty<GeneratorSkill> generatorSkill
            = new SimpleObjectProperty<>(this, "Generator Skill");

    private final ObjectProperty<SpenderSkill> spenderSkill
            = new SimpleObjectProperty<>(this, "Spender Skill");

    private final ObservableList<PassiveSkill> passiveList = FXCollections.observableArrayList();

    private final IntegerProperty range = new SimpleIntegerProperty(this, "Range", 0);

    public Archetype(String name) {
        super(name);
    }

    public GeneratorSkill getGeneratorSkill() {
        return generatorSkill.get();
    }

    public ObjectProperty<GeneratorSkill> generatorSkillProperty() {
        return generatorSkill;
    }

    public void setGeneratorSkill(GeneratorSkill generatorSkill) {
        this.generatorSkill.set(generatorSkill);
    }

    public SpenderSkill getSpenderSkill() {
        return spenderSkill.get();
    }

    public ObjectProperty<SpenderSkill> spenderSkillProperty() {
        return spenderSkill;
    }

    public void setSpenderSkill(SpenderSkill spenderSkill) {
        this.spenderSkill.set(spenderSkill);
    }

    public ObservableList<PassiveSkill> getPassiveList() {
        return passiveList;
    }
}
