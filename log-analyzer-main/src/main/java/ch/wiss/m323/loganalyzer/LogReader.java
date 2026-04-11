package ch.wiss.m323.loganalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LogReader {

  private final LogParser parser = new LogParser();

  public List<LogEntry> read(Path path) {
    try {
      return Files.lines(path)
          .map(parser::parse)
          .filter(opt -> opt.isPresent())
          .map(opt -> opt.get())
          .toList();
    } catch (IOException e) {
      System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
      return List.of();
    }
  }
}