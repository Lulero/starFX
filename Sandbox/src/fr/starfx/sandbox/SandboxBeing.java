package fr.starfx.sandbox;

import fr.starfx.sandbox.common.SandboxObject;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

public class SandboxBeing extends SandboxObject {

    private final StringProperty name = new SimpleStringProperty(this, "Name");

    private final ReadOnlyBooleanWrapper internalSoulForm
            = new ReadOnlyBooleanWrapper(this, "Soul Form", true);
    private final ReadOnlyBooleanProperty soulForm = internalSoulForm.getReadOnlyProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public boolean isSoulForm() {
        return soulForm.get();
    }

    public ReadOnlyBooleanProperty soulFormProperty() {
        return soulForm;
    }

    public void fromSoul() {
        if (isSoulForm()) {
            internalSoulForm.set(false);
        }
    }

    public void toSoul() {
        if (!isSoulForm()) {
            internalSoulForm.set(true);
        }
    }

    @Override
    protected void initializeToString() {
        toStringWrapper().bind(Bindings.createStringBinding(
                () -> (isSoulForm() ? "Soul " : "Being ") + nameProperty().get(),
                nameProperty(), soulFormProperty()
        ));
    }

}
