# Log Analyzer Starterprojekt

Dieses Repository ist das Starterprojekt zur Aufgabe **Logfile Analyzer**.

Die vollständige Aufgabenstellung für die Lernenden befindet sich in [`aufgaben.md`](./aufgaben.md).

## Projektziel

Implementiert wird eine Java-Anwendung, die:

- Logdateien einliest
- Logzeilen in Objekte umwandelt
- Logdaten mit Streams analysiert
- Ergebnisse als Bericht ausgibt

## Vorgegebene Struktur

Im Projekt sind bereits zentrale Klassen als Grundgerüst vorhanden:

- `LogEntry`
- `LogLevel`
- `LogParser`
- `LogReader`
- `LogAnalyzer`
- `ReportGenerator`
- `App`

Ein Teil der Methoden ist absichtlich noch nicht implementiert und muss von den Lernenden ergänzt werden.

## Tests

Im Projekt sind einige sichtbare Tests enthalten. Sie dienen als Einstieg in die Umsetzung und helfen beim schrittweisen Arbeiten.

Tests ausführen:

```bash
mvn test
```

Hinweis:
Neben den sichtbaren Tests kann die Lösung später zusätzlich mit weiteren Tests geprüft werden.

## Beispiel-Daten

Eine kleine Beispiel-Logdatei befindet sich unter:

`src/test/resources/system.log`

## Hinweise Für Die Bearbeitung

- Starte mit den sichtbaren Tests.
- Arbeite in kleinen, nachvollziehbaren Schritten.
- Trenne Parsing, Datei-Einlesen, Analyse und Berichtserzeugung sauber voneinander.
- Verwende Streams und Lambda-Ausdrücke dort, wo sie sinnvoll sind.
- Achte auf lesbaren und gut strukturierten Code.
