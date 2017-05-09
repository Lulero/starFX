package fr.starfx.core.time;

import java.util.function.Function;

public enum TimeTense {

    PAST,
    PRESENT,
    FUTURE;

    static public TimeTense from(Long wait) {
        if (wait == null) return null;
        return wait < 0 ? PAST : FUTURE;
    }

    static public TimeTense from(TimeTense timeTenseA, TimeTense timeTenseB) {
        if (timeTenseA == null) return timeTenseB;
        if (timeTenseB == null) return timeTenseA;
        if (timeTenseA == PRESENT || timeTenseB == PRESENT || timeTenseA != timeTenseB) return PRESENT;
        return timeTenseA == FUTURE ? FUTURE : PAST;
    }

}
