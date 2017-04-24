package fr.starfx.core.time;

import fr.starfx.core.property.SimpleHasMappedObservableValuesObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HasScheduledTimeTest {

    private static Long[] TEST_VALUE_ARRAY = {null, Long.MIN_VALUE, Long.MAX_VALUE, 0L, -1L, 1L};
    private static int NUMBER_OF_TEST_OBJECTS = (int) Math.pow(TEST_VALUE_ARRAY.length, 2);

    private static Long getInitialValue(int index) { return TEST_VALUE_ARRAY[index % TEST_VALUE_ARRAY.length]; }

    private static Long getNextValue(int index) { return TEST_VALUE_ARRAY[index / TEST_VALUE_ARRAY.length]; }

    private GlobalTime globalTime;
    private final HasScheduledTime[] testArray = new HasScheduledTime[(NUMBER_OF_TEST_OBJECTS)];

    class TestClass extends SimpleHasMappedObservableValuesObject implements HasScheduledTime {

        ObjectProperty<Long> scheduledTime
                = new SimpleObjectProperty<>(this, HasScheduledTime.SCHEDULED_TIME_PROPERTY_NAME);
        @Override public ObjectProperty<Long> scheduledTimeProperty() { return scheduledTime; }

        @Override
        public GlobalTime getGlobalTime() { return HasScheduledTimeTest.this.globalTime; }

    }

    @BeforeEach
    void setUp() {
        globalTime = new SimpleGlobalTime();
        for (int index = 0; index < NUMBER_OF_TEST_OBJECTS; index++) {
            testArray[index] = new TestClass();
            testArray[index].setScheduledTime(getInitialValue(index));
        }
    }

    private Long setNextValue(int index) {
        final Long nextValue = getNextValue(index);
        testArray[index].setScheduledTime(nextValue);
        return nextValue;
    }

    @AfterEach
    void tearDown() {
        globalTime = null;
        for (int index = 0; index < NUMBER_OF_TEST_OBJECTS; index++) {
            testArray[index] = null;
        }
    }

    private void testAccessors(int index, Long expectedScheduledTime, String phaseString) {

        final boolean expectedIsScheduled = expectedScheduledTime != null;
        final boolean actualIsScheduled = testArray[index].isScheduled();
        assertEquals(expectedIsScheduled, actualIsScheduled,
                phaseString + " [" + index +"]: isScheduled()");

        final Long actualScheduledTime = testArray[index].getScheduledTime();
        assertEquals(expectedScheduledTime, actualScheduledTime,
                phaseString + " [" + index +"]: getScheduledTime()");

        final Long expectedRemainingTime;
        if (!expectedIsScheduled) {
            expectedRemainingTime = null;
        } else {
            final long currentTime = globalTime.getCurrentTime();
            expectedRemainingTime = expectedScheduledTime > currentTime ?
                    expectedScheduledTime - currentTime : 0L;
        }
        final Long actualRemainingTime = testArray[index].getRemainingTime();
        assertEquals(expectedRemainingTime, actualRemainingTime,
                phaseString + " [" + index +"]: getRemainingTime()");
    }

    @Test
    void scheduledTime() {
        for (int index = 0; index < NUMBER_OF_TEST_OBJECTS; index++) {
            testAccessors(index, getInitialValue(index), "Initialisation");
            testAccessors(index, setNextValue(index), "Change Value");
            testArray[index].unSchedule();
            testAccessors(index, null, "UnSchedule");
        }
    }

}