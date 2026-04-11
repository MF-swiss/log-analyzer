package ch.wiss.m323.loganalyzer;

import java.nio.file.Path;
import java.util.List;

public class App {

  public static void main(String[] args) {
    // Erstellt ein Objekt zum Einlesen der Logdatei
    LogReader reader = new LogReader();
    // Erstellt ein Objekt zur Erstellung des Reports
    ReportGenerator generator = new ReportGenerator();

    // Pfad zur Logdatei (relativ zum Projektverzeichnis)
    Path logFile = Path.of("logs/app.log");
    // Liest die Logeinträge aus der Datei ein
    List<LogEntry> entries = reader.read(logFile);

    System.out.println(generator.createReport(entries));
  }
}