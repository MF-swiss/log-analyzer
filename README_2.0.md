
# Log Analyzer – Technische Dokumentation (Version 2.0)


## Projektübersicht

Der Log Analyzer ist eine professionelle Java-Anwendung zur strukturierten Analyse von Logdateien. Die Software liest Logzeilen ein, wandelt diese in Objekte um und wertet die Daten mithilfe moderner Java-Streams aus. Die Ergebnisse werden in einem übersichtlichen, statistisch aufbereiteten Bericht präsentiert.

---


## Hauptfunktionen

- **Logdateien einlesen:**
  - Die Klasse `LogReader` übernimmt das zeilenweise Einlesen der Logdateien.
- **Parsing:**
  - Die Klasse `LogParser` konvertiert jede Logzeile in ein validiertes `LogEntry`-Objekt.
- **Analyse:**
  - Die Klasse `LogAnalyzer` stellt Methoden zur Verfügung, um Fehler zu zählen, Einträge pro Benutzer zu ermitteln, häufigste Fehlermeldungen zu identifizieren und eindeutige IP-Adressen zu extrahieren.
- **Berichtserstellung:**
  - Die Klasse `ReportGenerator` generiert einen detaillierten Analysebericht mit allen relevanten Statistiken.
- **Applikationseinstieg:**
  - Die Klasse `App` bildet den Einstiegspunkt und steuert den gesamten Ablauf der Anwendung.

---



## Format der Logdatei

Jede Logzeile muss exakt folgendem Format entsprechen:
```
YYYY-MM-DD HH:MM:SS;LEVEL;USER;MESSAGE;IP
```
Beispiel:
```
2026-04-11 08:00:00;INFO;Marco;Login erfolgreich;192.168.0.12
```
Das Datumsformat wird beim Parsen explizit mit `yyyy-MM-dd HH:mm:ss` verarbeitet. Die Logdatei ist im Projektverzeichnis unter `logs/app.log` zu platzieren.

---


## Fehlerbehebung

- **Keine Einträge im Bericht?**
  - Überprüfen Sie, ob das Datumsformat in der Logdatei exakt `yyyy-MM-dd HH:mm:ss` entspricht (z. B. `2026-04-11 08:00:00`).
  - Stellen Sie sicher, dass die Datei `logs/app.log` existiert und die Anwendung aus dem Projektverzeichnis gestartet wird.
  - Bei Fehlern gibt die Anwendung eine aussagekräftige Fehlermeldung in der Konsole aus.


---


## Beispielhafter Analysebericht

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


## Testabdeckung

Die Anwendung wird durch umfassende Unit-Tests abgesichert:
- Parsing von Logzeilen (`LogParserTest`)
- Fehlerzählung und Analyse (`LogAnalyzerTest`)
- Berichtserstellung und Statistiken (`ReportGeneratorTest`)
- **IP-Validierung:** Es wird geprüft, dass nur gültige IPv4-Adressen (0.0.0.0 bis 255.255.255.255) akzeptiert werden (`LogEntryTest`).

Alle Tests können mit folgendem Befehl ausgeführt werden:
```
mvn test
```

---


## Hinweise zur Nutzung und Erweiterung

- Die Anwendung ist modular aufgebaut, jede Klasse übernimmt eine klar definierte Aufgabe.
- Die Analyse erfolgt ausschließlich mit modernen Java-Streams und Lambda-Ausdrücken.
- Die wichtigsten Auswertungen (z. B. aktivster Benutzer, häufigste IP-Adresse) sind im Bericht enthalten.
- Die Logdatei muss im Projektverzeichnis unter `logs/app.log` abgelegt werden.
- Der Quellcode ist umfassend kommentiert und eignet sich auch für die Einarbeitung in fortgeschrittene Java-Techniken.
- Die bereitgestellten Tests können als Grundlage für eigene Erweiterungen dienen.

---


## Erweiterungspotenzial

- Unterstützung zusätzlicher Logformate
- Export des Analyseberichts als Datei
- Filterung nach Zeitraum oder Benutzer
- Entwicklung einer grafischen Benutzeroberfläche (GUI)
- Erweiterte Validierung und Fehlerbehandlung für Logzeilen

---


## Autoren

- Konzept: Lehrperson
- Implementierung: Lernender

---


## Stand
April 2026
