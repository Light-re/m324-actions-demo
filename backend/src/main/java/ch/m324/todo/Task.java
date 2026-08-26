package ch.m324.todo;

/** Eine einzelne Aufgabe der Todo-Liste. */
public class Task {

    private final String beschreibung;
    private boolean erledigt;

    public Task(String beschreibung) {
        if (beschreibung == null || beschreibung.isBlank()) {
            throw new IllegalArgumentException("Beschreibung darf nicht leer sein");
        }
        this.beschreibung = beschreibung;
        this.erledigt = false;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void erledigen() {
        this.erledigt = true;
    }
}
