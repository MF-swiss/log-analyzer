# Aufgabenstellung: Logfile Analyzer

## Ausgangslage

Ein Webserver erzeugt laufend Logdateien. Diese enthalten Informationen über Ereignisse im System, zum Beispiel:

- Zeitstempel
- Log-Level
- Benutzername
- Meldung
- IP-Adresse

Beispiel für Logeinträge:

```text
2026-03-28 10:15:22;ERROR;admin;Login failed;192.168.1.10
2026-03-28 10:16:03;INFO;system;Backup started;127.0.0.1
2026-03-28 10:18:44;WARNING;guest;Too many requests;192.168.1.25
```

Deine Aufgabe ist es, ein Java-Programm zu entwickeln, das solche Logdateien einliest, analysiert und wichtige Informationen ausgibt.

Dabei liegt der Fokus auf:

- funktionaler Programmierung
- `Stream`
- Lambda-Ausdrücken
- `Collectors`

## Lernziele

Mit diesem Projekt übst du:

- Textdateien in Java einlesen
- Daten in Objekte umwandeln
- mit `Stream` arbeiten
- Daten mit `filter`, `map`, `distinct`, `sorted`, `count` und `collect` auswerten
- `Collectors.groupingBy(...)` und `Collectors.counting()` anwenden
- Ergebnisse verständlich ausgeben

## Vorgegebenes Starterprojekt

Du erhältst ein Starterprojekt mit:

- einer bestehenden Maven-Struktur
- den wichtigsten Klassen als Grundgerüst
- einigen sichtbaren Tests
- einer Beispiel-Logdatei

Deine Aufgabe ist es, die fehlende Logik schrittweise zu implementieren.

## Arbeitsaufträge Zu Den Klassen

- `LogEntry`: Repräsentiert einen einzelnen Logeintrag mit allen benötigten Informationen.
- `LogParser`: Wandelt eine einzelne Logzeile in ein `LogEntry`-Objekt um und erkennt ungültige Zeilen.
- `LogReader`: Liest eine Logdatei ein und verarbeitet die Zeilen mit dem `LogParser`.
- `LogAnalyzer`: Führt die fachlichen Auswertungen mit Streams auf einer Liste von `LogEntry`-Objekten durch.
- `ReportGenerator`: Erstellt aus den vorhandenen Logdaten oder Analyseergebnissen einen verständlichen Textbericht.
- `App`: Kann als Startpunkt der Anwendung verwendet werden, zum Beispiel zum Laden der Datei und zum Aufrufen der Analyse.

## Anforderungen

## 1. Datenmodell

Verwende die Klasse `LogEntry` mit mindestens folgenden Informationen:

- `timestamp`
- `level`
- `user`
- `message`
- `ipAddress`

## 2. Logzeilen parsen

Implementiere die Klasse `LogParser`.

Jede gültige Logzeile soll in ein `LogEntry`-Objekt umgewandelt werden.

Beachte:

- Trennzeichen ist `;`
- ungültige Zeilen sollen erkannt werden
- ungültige Zeilen dürfen nicht einfach als gültige Einträge behandelt werden

## 3. Datei einlesen

Implementiere die Klasse `LogReader`.

Die Logdatei soll Zeile für Zeile eingelesen und mit dem `LogParser` verarbeitet werden.

## 4. Logdaten analysieren

Implementiere in `LogAnalyzer` mindestens folgende Auswertungen:

### a) Alle `ERROR`-Einträge finden

Zeige nur Einträge mit dem Log-Level `ERROR`.

### b) Anzahl aller `ERROR`-Einträge berechnen

Berechne, wie viele Fehler insgesamt vorhanden sind.

### c) Verschiedene IP-Adressen bestimmen

Gib alle IP-Adressen ohne Duplikate aus.

### d) Einträge pro Benutzer zählen

Bestimme, wie viele Einträge jeder Benutzer erzeugt hat.

### e) Häufige Fehlermeldungen ermitteln

Betrachte nur `ERROR`-Einträge und gruppiere sie nach Meldung.

### f) Einträge chronologisch sortieren

Sortiere die Logeinträge nach Datum und Zeit.

## 5. Bericht erzeugen

Implementiere die Klasse `ReportGenerator`.

Erstelle daraus einen kleinen Analysebericht, zum Beispiel:

```text
--- Analysebericht ---
Anzahl Logeinträge: 250
Anzahl ERROR: 34
Anzahl WARNING: 18
Häufigste IP: 192.168.1.10
Aktivster Benutzer: admin
```

## Erweiterungen

Wenn du die Grundanforderungen fertig umgesetzt hast, kannst du Zusatzfunktionen bearbeiten:

- Top-3 IP-Adressen bestimmen
- Einträge eines bestimmten Benutzers suchen
- `WARNING` und `ERROR` vergleichen
- Konsolenmenü bauen

## Technische Vorgaben

- Programmiersprache: Java
- Build-Tool: Maven
- Verwende Streams statt klassische Schleifen, wo es sinnvoll ist
- Verwende Lambda-Ausdrücke
- Arbeite schrittweise und teste deine Lösung regelmässig

## Hinweise zur Bearbeitung

- Starte mit den sichtbaren Tests im Projekt
- Arbeite in kleinen Schritten
- Trenne Einlesen, Parsen, Analysieren und Ausgabe sauber voneinander
- Nutze feste Testdaten für eigene zusätzliche Tests
- Achte auf lesbaren und sauberen Code

## Abgabe

Am Ende soll dein Projekt:

- kompilieren
- die vorhandenen Tests bestehen
- die geforderten Funktionen korrekt umsetzen
- sauber strukturiert und gut lesbar sein
