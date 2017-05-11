package fr.starfx.sandbox;

import fr.starfx.sandbox.common.SandboxObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SandboxWellOfSoul<T extends SandboxBeing>  extends SandboxObject {

    private ObservableList<T> soulPool = FXCollections.observableArrayList();

    public ObservableList<T> getSoulPool() {
        return soulPool;
    }
}
