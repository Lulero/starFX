package fr.starfx.core.time;

import fr.starfx.core.property.SimpleValuedObject;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HasEndTimeTest {

    private static Long[] TEST_VALUE_ARRAY = {Long.MIN_VALUE, Long.MAX_VALUE, 0L, -1L, 1L};
    private static int NUMBER_OF_TEST_OBJECTS = (int) Math.pow(TEST_VALUE_ARRAY.length, 2);

    private static long getInitialValue(int index) { return TEST_VALUE_ARRAY[index % TEST_VALUE_ARRAY.length]; }

    private static long getNextValue(int index) { return TEST_VALUE_ARRAY[index / TEST_VALUE_ARRAY.length]; }

    private GlobalTime globalTime;
    private final HasEndTime[] testArray = new HasEndTime[(NUMBER_OF_TEST_OBJECTS)];

    class TestClass extends SimpleValuedObject implements HasEndTime {

        LongProperty scheduledTime
                = new SimpleLongProperty(this, HasEndTime.END_TIME_PROPERTY_NAME);
        @Override public LongProperty endTimeProperty() { return scheduledTime; }

        @Override
        public GlobalTime getGlobalTime() { return HasEndTimeTest.this.globalTime; }

    }

    @BeforeEach
    void setUp() {
        globalTime = new SimpleGlobalTime();
        for (int index = 0; index < NUMBER_OF_TEST_OBJECTS; index++) {
            testArray[index] = new TestClass();
            testArray[index].setEndTime(getInitialValue(index));
        }
    }

    private Long setNextValue(int index) {
        final Long nextValue = getNextValue(index);
        testArray[index].setEndTime(nextValue);
        return nextValue;
    }

    @AfterEach
    void tearDown() {
        globalTime = null;
        for (int index = 0; index < NUMBER_OF_TEST_OBJECTS; index++) {
            testArray[index] = null;
        }
    }

    private void testAccessors(int index, long expectedScheduledTime, String phaseString) {

        final long actualScheduledTime = testArray[index].getEndTime();
        assertEquals(expectedScheduledTime, actualScheduledTime,
                phaseString + " [" + index +"]: getEndTime()");

        final long currentTime = globalTime.getCurrentTime();
        final long expectedRemainingTime = expectedScheduledTime > currentTime ?
                expectedScheduledTime - currentTime : 0L;
        final long actualRemainingTime = testArray[index].getRemainingTime();
        assertEquals(expectedRemainingTime, actualRemainingTime,
                phaseString + " [" + index +"]: getRemainingTime()");
    }

    @Test
    void scheduledTime() {
        for (int index = 0; index < NUMBER_OF_TEST_OBJECTS; index++) {
            testAccessors(index, getInitialValue(index), "Initialisation");
            testAccessors(index, setNextValue(index), "Change Value");
        }
    }

}