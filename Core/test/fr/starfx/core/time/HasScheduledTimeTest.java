package fr.starfx.core.time;

import fr.starfx.core.property.SimpleHasMappedObservableValuesObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HasScheduledTimeTest {

    private static Double[] TEST_VALUE_ARRAY = {null, Double.MIN_VALUE, Double.MAX_VALUE, 0.0, -1.0, 1.0};
    private static int NUMBER_OF_TEST_OBJECTS = (int) Math.pow(TEST_VALUE_ARRAY.length, 2);

    private static Double getInitialValue(int index) { return TEST_VALUE_ARRAY[index % TEST_VALUE_ARRAY.length]; }

    private static Double getNextValue(int index) { return TEST_VALUE_ARRAY[index / TEST_VALUE_ARRAY.length]; }

    private GlobalTime globalTime;
    private final HasScheduledTime[] testArray = new HasScheduledTime[(NUMBER_OF_TEST_OBJECTS)];

    class TestClass extends SimpleHasMappedObservableValuesObject implements HasScheduledTime {

        ObjectProperty<Double> scheduledTime
                = new SimpleObjectProperty<>(this, HasScheduledTime.SCHEDULED_TIME_PROPERTY_NAME);
        @Override public ObjectProperty<Double> scheduledTimeProperty() { return scheduledTime; }

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

    private Double setNextValue(int index) {
        final Double nextValue = getNextValue(index);
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

    private void testAccessors(int index, Double expectedScheduledTime, String phaseString) {

        final boolean expectedIsScheduled = expectedScheduledTime != null;
        final boolean actualIsScheduled = testArray[index].isScheduled();
        assertEquals(expectedIsScheduled, actualIsScheduled,
                phaseString + " [" + index +"]: isScheduled()");

        final Double actualScheduledTime = testArray[index].getScheduledTime();
        assertEquals(expectedScheduledTime, actualScheduledTime,
                phaseString + " [" + index +"]: getScheduledTime()");

        final Double expectedRemainingTime;
        if (!expectedIsScheduled) {
            expectedRemainingTime = null;
        } else {
            final double currentTime = globalTime.getCurrentTime();
            expectedRemainingTime = expectedScheduledTime > currentTime ?
                    expectedScheduledTime - currentTime : 0.0;
        }
        final Double actualRemainingTime = testArray[index].getRemainingTime();
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