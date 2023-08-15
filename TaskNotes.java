public class TaskNotes implements Task {
    private String title;

    private boolean completed;

    public TaskNotes(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public void display() {
        System.out.println("[" + (completed ? ":)" : "  ") + "] " + title);
    }
}
