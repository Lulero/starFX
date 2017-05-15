package fr.starfx.sandbox;

import fr.starfx.sandbox.stat.BaseStatsSheet;

public class Demon extends WorldObject {

    private final BaseStatsSheet statsSheet = new BaseStatsSheet();

    public Demon(World world, String name) {
        super(world, name);
    }

    public BaseStatsSheet getStatsSheet() {
        return statsSheet;
    }

}
