package fr.starfx.core.rating;

import fr.starfx.core.property.ValuedObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

public interface HasRating extends ValuedObject {

    int getNaturalRating();

    String CURRENT_RATING_PROPERTY_NAME = "Current Rating";

    IntegerProperty currentRatingProperty();
    default int getCurrentRating() { return currentRatingProperty().get(); }
    default void setCurrentRating(int currentRating) { currentRatingProperty().set(currentRating); }

    String GLOBAL_MODIFIER_PROPERTY_NAME = "Global Modifier";

    double EXTRA_RATING_MODIFIER = (double) 2 / 3;

    static double getGlobalModifier(HasRating hasRatingObject) {
        final double currentRating = hasRatingObject.getCurrentRating();
        final double naturalRating = hasRatingObject.getNaturalRating();
        final double extraRating = currentRating > naturalRating ?
                currentRating - naturalRating :
                0;
        return naturalRating + EXTRA_RATING_MODIFIER * extraRating;
    }

    default ReadOnlyDoubleProperty globalModifierProperty() {
        return getReadOnlyDoubleProperty(
                GLOBAL_MODIFIER_PROPERTY_NAME,
                () -> getGlobalModifier(this),
                currentRatingProperty());
    }
    default double getGlobalModifier() { return globalModifierProperty().get(); }

}
