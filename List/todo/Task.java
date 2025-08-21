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

    public String getDescription() { return description; }
    public boolean isDone() { return isDone; }
    public int getIdentifier() { return identifier; }

    public void modifyDescription(String newDescription) {
        validateDescription(newDescription);
        this.description = newDescription;
    }

    public void markDone() { this.isDone = true; }
    public void undo() { this.isDone = false; }

    private void validateDescription(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }
    }
}
