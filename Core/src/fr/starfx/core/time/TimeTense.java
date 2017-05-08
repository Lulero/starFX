package fr.starfx.core.time;

public enum TimeTense {

    PAST,
    PRESENT,
    FUTURE;

    static public TimeTense from(long wait) {
        return wait < 0 ? PAST : FUTURE;
    }

    static public TimeTense from(long ... waits) {
        long waitStart = waits[0];
        long waitEnd = waits[0];
        for (int index = 1; index < waits.length; index++) {
            long wait = waits[index];
            if (wait < waitStart) waitStart = wait;
            if (wait > waitEnd) waitEnd = wait;
        }
        return waitStart >= 0 ? FUTURE :
                waitEnd < 0 ? PAST : PRESENT;
    }

}
