package ch.m324.todo;

import java.util.ArrayList;
import java.util.List;

/** Geschaeftslogik der Todo-Liste. */
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public Task hinzufuegen(String beschreibung) {
        Task task = new Task(beschreibung);
        tasks.add(task);
        return task;
    }

    public List<Task> alle() {
        return List.copyOf(tasks);
    }

    public int anzahlOffen() {
        return (int) tasks.stream().filter(t -> !t.isErledigt()).count();
    }

    public boolean erledigen(String beschreibung) {
        for (Task t : tasks) {
            if (t.getBeschreibung().equals(beschreibung)) {
                t.erledigen();
                return true;
            }
        }
        return false;
    }
}
