package ch.m324.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    @Test
    @DisplayName("Eine neue Liste ist leer")
    void neueListeIstLeer() {
        assertEquals(0, service.alle().size());
    }

    @Test
    @DisplayName("Hinzufuegen erhoeht die Anzahl der Aufgaben")
    void hinzufuegenErhoehtAnzahl() {
        service.hinzufuegen("Praesentation vorbereiten");
        service.hinzufuegen("Folien pruefen");
        assertEquals(2, service.alle().size());
    }

    @Test
    @DisplayName("Erledigte Aufgaben zaehlen nicht mehr als offen")
    void erledigenReduziertOffeneAufgaben() {
        service.hinzufuegen("Test schreiben");
        service.hinzufuegen("Pipeline bauen");

        assertTrue(service.erledigen("Test schreiben"));
        assertEquals(1, service.anzahlOffen());
    }

    @Test
    @DisplayName("Der Filter liefert nur unerledigte Aufgaben")
    void filterLiefertNurOffeneAufgaben() {
        service.hinzufuegen("Folien fertig machen");
        service.hinzufuegen("Demo ueben");
        service.erledigen("Folien fertig machen");

        assertEquals(1, service.offene().size());
        assertEquals("Demo ueben", service.offene().get(0).getBeschreibung());
    }
}
