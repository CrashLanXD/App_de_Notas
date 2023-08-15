import java.util.ArrayList;
import java.util.List;

public class NoteManager {
    List<Note> simpleNotes;
    List<Task> taskNotes;

    public NoteManager() {
        simpleNotes = new ArrayList<>();
        taskNotes = new ArrayList<>();
    }

    public void addNote(Note note) {
        simpleNotes.add(note);
    }

    public void addTask(Task task) {
        taskNotes.add(task);
    }

    public void displayNotesAndTasks() {
        System.out.println("Simple Notes:");
        for (Note note :
                simpleNotes) {
            note.display();
        }

        System.out.println("\nTask Notes:");
        for (Task task :
                taskNotes) {
            task.display();
        }
    }

    public void displayNotesWithIndex() {
        for (int i = 0; i < simpleNotes.size(); i++) {
            Note note = simpleNotes.get(i);
            System.out.print(i + "-> ");
            note.display();
        }
    }

    public void displayTasksWithIndex() {
        for (int i = 0; i < taskNotes.size(); i++) {
            Task task = taskNotes.get(i);
            System.out.print(i + "-> ");
            task.display();
        }
    }

    public Note findNoteByIndex(int index) {
        if (index >= 0 && index < simpleNotes.size()) {
            return simpleNotes.get(index);
        }
        return null;
    }

    public Note findNoteByTitle(String title) {
        for (Note note : simpleNotes) {
            if (note.getTitle().equals(title)) {
                return note;
            }
        }
        return null;
    }

    public Task findTaskByIndex(int index) {
        if (index >= 0 && index < taskNotes.size()) {
            return taskNotes.get(index);
        }
        return null;
    }

    public Task findTaskByTitle(String title) {
        for (Task task : taskNotes) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public void deleteNoteByIndex(int index) {
        Note note = findNoteByIndex(index);
        if (note != null) {
            simpleNotes.remove(index);
        } else {
            System.out.println("No se encontró la nota #" + index);
        }
    }

    public void deleteTaskByIndex(int index) {
        Task task = findTaskByIndex(index);
        if (task != null) {
            taskNotes.remove(index);
        } else {
            System.out.println("No se encontró la nota #" + index);

        }
    }


    // TODO: hacer que también se puedan buscar notas por el titulo, sirve mas si se crean bastantes notas
    public void deleteNoteByTitle(String title) {
        Note note = findNoteByTitle(title);
        if (note != null) {
            simpleNotes.remove(note);
        } else {
            System.out.println("No se encontró la nota '" + title + "'");
        }
    }

    public void deleteTaskByTitle(String title) {
        Task task = findTaskByTitle(title);
        if (task != null) {
            taskNotes.remove(task);
        } else {
            System.out.println("No se encontró la nota '" + title + "'");
        }
    }

    // ! no se han usado...

    public void editNoteByIndex(int index, String newTitle, String newContent) {
        Note note = findNoteByIndex(index);
        if (note != null) {
            if (!(note.getTitle().equals(newTitle))) {
                note.setTitle(newTitle);
            }
            note.setContent(newContent);
        } else {
            System.out.println("No se encontró la nota #" + index);
        }
    }

    public void editTaskByIndex(int index, String newTitle) {
        Task task = findTaskByIndex(index);
        if (task != null) {
            if (!(task.getTitle().equals(newTitle))) {
                task.setTitle(newTitle);
            }
        } else {
            System.out.println("No se encontró la nota #" + index);
        }
    }

    public void completeTask(int index) {
        Task task = findTaskByIndex(index);
        if (task != null) {
            task.markAsCompleted();
        } else {
            System.out.println("No se encontró la nota #" + index);
        }
    }

}
