public class Task {
    private String description;
    private boolean isDone;
    private int identifier;

    public Task(String description, int identifier) {
        validateDescription(description);
        this.description = description;
        this.identifier = identifier;
        this.isDone = false;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getIdentifier() {
        return identifier;
    }

    // Modify description with validation
    public void modifyDescription(String newDescription) {
        validateDescription(newDescription);
        this.description = newDescription;
    }

    // Helpers to change status
    public void markDone() {
        this.isDone = true;
    }

    public void undo() {
        this.isDone = false;
    }

    // Validation helper
    private void validateDescription(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }
    }
}
