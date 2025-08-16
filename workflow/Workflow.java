import activity.Activity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workflow {
    private final List<Activity> activities = new ArrayList<>();

    public void registerActivity(Activity activity) {
        if (activity == null) throw new IllegalArgumentException("activity cannot be null");
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(activities);
    }
}
