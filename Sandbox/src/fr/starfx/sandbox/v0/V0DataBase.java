package fr.starfx.sandbox.v0;

import fr.starfx.sandbox.data.Archetype;
import fr.starfx.sandbox.data.DataBase;
import fr.starfx.sandbox.data.Faction;

public class V0DataBase extends DataBase {

    public V0DataBase() {
        super("V0");
        getFactionList().addAll(
                new Faction("Primal"),  // Improved base stats      (depends on archetype)
                new Faction("Neo"),     // Improved skill           (depends on archetype)
                new Faction("Blood"),   // Stronger against Fire
                new Faction("Bone"),    // Stronger against Ash
                new Faction("Fire"),    // Stronger against Bone
                new Faction("Ash")      // Stronger against Blood
        );
        getArchetypeList().addAll(
                new Archetype("Behemoth"),          // Tank, front-liner
                new Archetype("Succubus"),          // Reduces opponent stats
                new Archetype("Overlord"),          // Boosts others of same faction
                new Archetype("Imp"),               // Fodder
                new Archetype("Horned Beast"),      // Damage Dealer, front-liner
                new Archetype("Beholder")           // Single Target Damage Dealer, back-line
        );

    }

}
