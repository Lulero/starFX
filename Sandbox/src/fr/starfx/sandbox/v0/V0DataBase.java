package fr.starfx.sandbox.v0;

import fr.starfx.sandbox.data.Archetype;
import fr.starfx.sandbox.data.DataBase;
import fr.starfx.sandbox.data.Prefix;
import fr.starfx.sandbox.data.Suffix;

public class V0DataBase extends DataBase {

    public V0DataBase() {
        super("V0");
        getPrefixList().addAll(
                new Prefix("Primal"),  // Improved power
                new Prefix("Neo")      // Improved spender
        );
        getSuffixList().addAll(
                new Suffix("Blood"),   // Stronger against Fire
                new Suffix("Bones"),    // Stronger against Ash
                new Suffix("Fire"),    // Stronger against Bone
                new Suffix("Ashes")      // Stronger against Blood
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
