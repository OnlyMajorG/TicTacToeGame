# TicTacToe

Ein Tic-Tac-Toe Spiel zur praktischen Umsetzung von Software-Lifecycle-Tooling im Rahmen der Lehrveranstaltung *Software Lifecycle Tooling (SLT)* an der FH Technikum Wien.

---

## Projektziel

Ziel ist die professionelle Umsetzung eines einfachen Spiels (TicTacToe) unter Einhaltung von Best Practices im Bereich Versionskontrolle, Branch-Strategie, CI/CD, Testautomatisierung und Dokumentation.

---

## Verwendete Technologien

- Java 11
- JUnit 5
- Maven
- Git & GitHub
- GitHub Actions (CI/CD)
- IntelliJ IDEA (Community/Ultimate Edition)

---

## Tests

Alle Kernkomponenten werden durch automatisierte Unit-Tests mit JUnit abgedeckt:

- `BoardTest.java`
- `PlayerTest.java`
- `TicTacToeTest.java`

Die Tests werden automatisch bei jedem Push oder Pull Request über GitHub Actions ausgeführt.

---

## CI/CD Setup

Automatisierte GitHub Action (`maven.yml`) führt bei jedem Push oder Pull Request folgende Schritte aus:

1. Maven Build (`mvn package`)
2. Unit Tests (`mvn test`)
3. Build-Artifact (.jar) wird bereitgestellt

Das `.jar`-File ist unter **GitHub → Actions → letzter Workflow-Lauf → Artifacts** als Download verfügbar.

---

## Projektstruktur

```
.
├── .github/workflows/maven.yml     # CI/CD Pipeline Definition
├── src/
│   ├── main/java/…                 # Java Quellcode (Board, Player, Game-Logik)
│   └── test/java/…                 # JUnit Testklassen
├── pom.xml                         # Maven Build-Konfiguration
├── .gitignore
└── README.md                       # Diese Datei
```
---

## Git-Workflow & Branch-Konvention

- **Feature-Branches**: `feature/US-<Nummer>-<Kurzbeschreibung>`
- **Kein Direkt-Push** auf `main`
- **Merge nur via Pull Request**
- **Branch Protection Rule** aktiv (Tests müssen vorher erfolgreich sein)

---

## Projektmanagement (GitHub Projects)

- GitHub Project Board im Kanban-Stil
  - `Backlog`, `In Bearbeitung`, `Fertig`
  - Aufgaben/Tickets mit Verlinkung zu Branches & Pull Requests
-  Screenshots der Umsetzung werden zur Doku hinzugefügt
- Fortschritt nachvollziehbar über das Board und Git-Historie

---

## Dokumentation

Die Projekt-Dokumentation beinhaltet:

- Screenshots & Beschreibung des Kanban-Boards
- Dokumentierte Git-Konfiguration (Branch Rules, Pull Requests)
- Ablauf der CI/CD-Pipeline 
- Öffentliche Repository-Struktur nachvollziehbar unter:

**[GitHub Repository](https://github.com/OnlyMajorG/TicTacToeGame)**
