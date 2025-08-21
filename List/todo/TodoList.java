import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        // Ensure unique identifier
        for (Task t : tasks) {
            if (t.getIdentifier() == task.getIdentifier()) {
                throw new IllegalArgumentException(
                    "Task with identifier " + task.getIdentifier() + " already exists in the list"
                );
            }
        }
        tasks.add(task);
    }

    public boolean markTaskDone(int identifier) {
        for (Task t : tasks) {
            if (t.getIdentifier() == identifier) {
                t.markDone();   // even if already done, still returns true
                return true;
            }
        }
        return false; // not found
    }

    public boolean undoTask(int identifier) {
        for (Task t : tasks) {
            if (t.getIdentifier() == identifier) {
                t.undo();       // even if already undone, still returns true
                return true;
            }
        }
        return false; // not found
    }

    public void undoAll() {
        for (Task t : tasks) {
            t.undo();
        }
    }

    public void completeAll() {
        for (Task t : tasks) {
            t.markDone();
        }
    }

    public void listTasks() {
        for (Task t : tasks) {
            String box = t.isDone() ? "X" : " ";
            System.out.println("[" + box + "]  Id: " + t.getIdentifier() + " - Description: " + t.getDescription());
        }
    }
}
