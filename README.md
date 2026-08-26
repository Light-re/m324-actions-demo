# M324 - GitHub Actions Demo

Begleitprojekt zum Vortrag "GitHub Actions nutzen" (Modul 324).

- `backend/` - Maven-Projekt (Java 21) mit der Logik einer Todo-Liste und JUnit-Tests
- `.github/workflows/ci-backend.yml` - CI-Pipeline: auschecken, JDK einrichten, testen,
  Testreport veröffentlichen, JAR als Artefakt hochladen

Die Pipeline läuft bei jedem Push auf `main` und bei jedem Pull-Request auf `main`.
Der Branch `main` ist geschützt: ohne grünen Status-Check ist kein Merge möglich.
