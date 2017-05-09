package fr.starfx.sandbox.wellofsouls;

import fr.starfx.sandbox.Demon;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class WellOfSouls {

    static public final int DEFAULT_CAPACITY = 100;
    static public final int DEFAULT_STAR_ODDS = 25;

    public Random rng = new Random();

    public final IntegerProperty capacity
            = new SimpleIntegerProperty(this, "Capacity", DEFAULT_CAPACITY);
    public final IntegerProperty starOdds
            = new SimpleIntegerProperty(this, "Star Odds", DEFAULT_STAR_ODDS);

    private final ObservableList<Demon> internalSoulPool = FXCollections.observableArrayList();
    public final ObservableList<Demon> soulPool = FXCollections.unmodifiableObservableList(internalSoulPool);

    private final ObservableList<Demon> internalSoulItems = FXCollections.observableArrayList();
    public final ObservableList<Demon> soulItems = FXCollections.unmodifiableObservableList(internalSoulItems);

    private final ObservableList<Demon> internalDemonList = FXCollections.observableArrayList();
    public final ObservableList<Demon> demonList = FXCollections.unmodifiableObservableList(internalDemonList);
}
