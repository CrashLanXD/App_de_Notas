import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager noteManager = new NoteManager();

        label:
        while (true) {
            System.out.println("""
                    ===========================
                    1. Crear Nota
                    2. Crear Tarea
                    3. Mostrar Notas y Tareas
                    4. Marcar Tarea como completada
                    5. Editar Nota
                    6. Editar Tarea
                    7. Eliminar Nota
                    8. Eliminar Tarea
                    0. Cerrar""");
            int choice = getIntWithScanner(scanner, "Que desea hacer?: ");
            System.out.print(TextStyle.RESET);

            switch (choice) {
                case 1: {
                    System.out.print("Titulo: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.println("Contenido: ");
                    String content = scanner.nextLine();
                    SimpleNotes note = new SimpleNotes(title, content);
                    noteManager.addNote(note);
                    break;
                }
                case 2: {
                    System.out.print("Titulo: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    TaskNotes task = new TaskNotes(title, false);
                    noteManager.addTask(task);
                    break;
                }
                case 3:
                    noteManager.displayNotesAndTasks();
                    break;
                case 4: {
                    noteManager.displayNotesWithIndex();
                    int taskIndex = getIntWithScanner(scanner, "Ingrese el numero de la tarea que completo: ");
                    if (noteManager.findTaskByIndex(taskIndex) != null) {
                        noteManager.completeTask(taskIndex);
                    } else {
                        System.out.println("No se encontró la tarea #" + taskIndex);
                    }
                    break;
                }
                case 5: {
                    noteManager.displayNotesWithIndex();
                    int noteIndex = getIntWithScanner(scanner, "Ingrese el numero de la nota: ");
                    if (noteManager.findTaskByIndex(noteIndex) != null) {
                        scanner.nextLine();
                        System.out.print("Nuevo titulo: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Nuevo contenido");
                        String newContent = scanner.nextLine();
                        noteManager.editNoteByIndex(noteIndex, newTitle, newContent);
                    } else {
                        System.out.println("No se encontró la nota #" + noteIndex);
                    }
                    break;
                }
                case 6: {
                    noteManager.displayTasksWithIndex();
                    int taskIndex = getIntWithScanner(scanner, "Ingrese el numero de la tarea: ");
                    if (noteManager.findTaskByIndex(taskIndex) != null) {
                        scanner.nextLine();
                        System.out.print("Nuevo titulo: ");
                        String newTitle = scanner.nextLine();
                        noteManager.editTaskByIndex(taskIndex, newTitle);
                    } else {
                        System.out.println("No se encontró la tarea #" + taskIndex);
                    }
                    break;
                }
                case 7: {
                    noteManager.displayNotesWithIndex();
                    int noteIndex = getIntWithScanner(scanner, "Ingrese el numero de la nota: ");
                    if (noteManager.findNoteByIndex(noteIndex) != null) {
                        noteManager.deleteNoteByIndex(noteIndex);
                    } else {
                        System.out.println("No se encontró la nota #" + noteIndex);
                    }
                    break;
                }
                case 8: {
                    noteManager.displayTasksWithIndex();
                    int taskIndex = getIntWithScanner(scanner, "Ingrese el numero de la tarea: ");
                    if (noteManager.findTaskByIndex(taskIndex) != null) {
                        noteManager.deleteTaskByIndex(taskIndex);
                    } else {
                        System.out.println("No se encontró la tarea #" + taskIndex);
                    }
                    break;
                }
                case 0:
                    break label;
                default:
                    System.out.println("Opción invalida, intente de nuevo");
                    break;
            }
        }

        scanner.close();
    }

    public static int getIntWithScanner(Scanner scanner, String message) {
        System.out.print(message);
        while (!(scanner.hasNextInt())) {
            scanner.next();
            System.out.println("Ingrese un numero entero por favor." + message);
        }
        return scanner.nextInt();
    }
}