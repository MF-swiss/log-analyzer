# Log Analyzer – Dokumentation (Version 2.0)

## Projektübersicht

Dieses Projekt ist eine Java-Anwendung zur Analyse von Logdateien. Sie liest Logzeilen ein, wandelt sie in Objekte um, analysiert die Daten mit modernen Java-Streams und gibt einen strukturierten Bericht aus.

---

## Hauptfunktionen

- **Logdateien einlesen:**
  - Über die Klasse `LogReader` werden Logdateien zeilenweise eingelesen.
- **Parsing:**
  - Die Klasse `LogParser` wandelt jede Logzeile in ein `LogEntry`-Objekt um.
- **Analyse:**
  - Die Klasse `LogAnalyzer` bietet Methoden zur Auswertung, z.B. Fehler zählen, Einträge pro Benutzer, häufigste Fehlermeldungen, eindeutige IPs.
- **Berichtserstellung:**
  - Die Klasse `ReportGenerator` erzeugt einen ausführlichen Analysebericht mit Statistiken und Zusammenfassungen.
- **Startpunkt:**
  - Die Klasse `App` ist der Einstiegspunkt und steuert den Ablauf.

---

## Aufbau der Logdatei

Eine Logzeile hat das Format:
```
YYYY-MM-DD HH:MM:SS;LEVEL;USER;MESSAGE;IP
```
Beispiel:
```
2026-03-28 10:15:22;ERROR;admin;Login failed;192.168.1.10
```

---

## Beispiel-Ausgabe des Berichts

```
########### LOG REPORT ###########
            **********
 
Einträge total: 250
Fehler total:   34
Anzahl ERROR: 34
Anzahl WARNING: 18
Anzahl INFO: 198
Häufigste IP: 192.168.1.10
Aktivster Benutzer: admin

~~~ Einträge pro Benutzer ~~~
  admin                120
  user1                80
  user2                50

~~~ Häufigste Fehlermeldungen ~~~
  [20×] Login failed
  [10×] File not found

~~~ Eindeutige IP-Adressen ~~~
  192.168.1.10
  192.168.1.11
  192.168.1.12
###################################
```

---

## Tests

- Die wichtigsten Funktionen werden durch Unit-Tests abgedeckt:
  - Parsing von Logzeilen (`LogParserTest`)
  - Fehlerzählung und Analyse (`LogAnalyzerTest`)
  - Berichtserstellung und Statistiken (`ReportGeneratorTest`)
  - **IP-Validierung:** Es wird getestet, dass nur gültige IPv4-Adressen (0.0.0.0 bis 255.255.255.255) akzeptiert werden (`LogEntryTest`).
- Tests ausführen mit:
  ```
  mvn test
  ```

---

## Hinweise für Lernende

- Die Anwendung ist modular aufgebaut: Jede Klasse hat eine klar abgegrenzte Aufgabe.
- Die Analyse nutzt moderne Java-Streams und Lambdas.
- Die wichtigsten Auswertungen (z. B. aktivster Benutzer, häufigste IP) sind im Bericht enthalten.
- Die Logdatei muss im Projektverzeichnis unter `logs/app.log` liegen.
- Der Code ist so kommentiert, dass auch Einsteiger ihn gut nachvollziehen können.
- **Tipp:** Die Tests können als Vorlage für eigene Erweiterungen genutzt werden.

---

## Erweiterungsmöglichkeiten

- Unterstützung für weitere Logformate
- Export des Berichts als Datei
- Filterung nach Zeitraum oder Benutzer
- Grafische Oberfläche (GUI)
- Erweiterte Validierung und Fehlerbehandlung für Logzeilen

---

## Autoren
- Vorlage: Lehrperson
- Umsetzung: Lernender

---

## Stand
April 2026
