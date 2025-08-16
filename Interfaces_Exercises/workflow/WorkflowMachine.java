import activity.Activity;

public class WorkflowMachine {
    public void execute(Workflow workflow) {
        if (workflow == null) throw new IllegalArgumentException("workflow cannot be null");
        for (Activity activity : workflow.getActivities()) {
            activity.execute();
        }
    }
}
