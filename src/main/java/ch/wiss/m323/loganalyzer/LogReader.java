package ch.wiss.m323.loganalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LogReader {

  private final LogParser parser = new LogParser();

  public List<LogEntry> read(Path path) {
    try {
      // Stream-Pipeline: Datei lesen → parsen → filtern → sammeln
      return Files.lines(path)               // Liest alle Zeilen als Stream
          .map(parser::parse)                // Jede Zeile → parse() aufrufen
          .filter(opt -> opt.isPresent())    // Ungültige Zeilen rausfiltern
          .map(opt -> opt.get())             // Optional<LogEntry> → LogEntry
          .toList();
    } catch (IOException e) {
      System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
      return List.of();
    }
  }
}