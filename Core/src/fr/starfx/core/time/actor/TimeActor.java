package fr.starfx.core.time.actor;

import fr.starfx.core.time.TimeGlobal;
import fr.starfx.core.time.TimeWindow;
import fr.starfx.core.time.simple.SimpleTimeEntity;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TimeActor extends SimpleTimeEntity {

    public TimeActor(TimeGlobal timeGlobal) {
        super(timeGlobal);
        nextActivity.bind(Bindings.createObjectBinding(this::computeNextActivity, nextActivityList));
        nextActionTime.bind(Bindings.createLongBinding(this::computeNextActionTime, nextActivtyProperty()));
    }

    // Activity Lists
    // --------------

    private final ObservableList<TimeActivity> activityList
            = FXCollections.observableArrayList(TimeWindow::extractor);
    private final ObservableList<TimeActivity> sortedActivityList = activityList.sorted();
    private final ObservableList<TimeActivity> pastActivityList = sortedActivityList.filtered(TimeWindow::isPast);
    private final ObservableList<TimeActivity> nextActivityList =
            sortedActivityList.filtered(tw -> !tw.isPast());

    public ObservableList<TimeActivity> getActivityList() {
        return sortedActivityList;
    }

    public ObservableList<TimeActivity> getPastActivityList() {
        return pastActivityList;
    }

    public ObservableList<TimeActivity> getNextActivityList() {
        return nextActivityList;
    }

    public void forgetOldActivities(long time) {
        activityList.removeIf(tw -> tw.isPast(time));
    }

    public void addActivities(TimeActivity... activities) {
        activityList.addAll(activities);
    }

    public void removeActivities(TimeActivity... activities) {
        activityList.removeAll(activities);
    }

    // Next Activity
    // -------------

    private final ReadOnlyObjectWrapper<TimeActivity> nextActivity
            = new ReadOnlyObjectWrapper<>(this, "Next Activity");
    private final ReadOnlyObjectProperty<TimeActivity> readOnlyNextActivity = nextActivity.getReadOnlyProperty();
    public ReadOnlyObjectProperty<TimeActivity> nextActivtyProperty() { return readOnlyNextActivity; }
    public TimeActivity getNextActivity() { return readOnlyNextActivity.get(); }

    private TimeActivity computeNextActivity() {
        final List<TimeActivity> nextActivityList = getNextActivityList();
        if (nextActivityList.isEmpty()) return null;
        return nextActivityList.get(0);
    }

    // Next Action Time
    // ----------------

    static public final long NO_ACTION_TIME = -1L;

    private ReadOnlyLongWrapper nextActionTime
            = new ReadOnlyLongWrapper(this, "Next Action Time");
    private final ReadOnlyLongProperty readOnlyNextActionTime = nextActionTime.getReadOnlyProperty();
    public ReadOnlyLongProperty nextActionTimeProperty() { return readOnlyNextActionTime; }
    public long getNextActionTime() { return readOnlyNextActionTime.get(); }

    private long computeNextActionTime() {
        final TimeActivity nextActivity = getNextActivity();
        if (nextActivity == null) return NO_ACTION_TIME;
        if (nextActivity.isFuture()) return nextActivity.startTimeProperty().get();
        return nextActivity.getEndTime();
    }

}
