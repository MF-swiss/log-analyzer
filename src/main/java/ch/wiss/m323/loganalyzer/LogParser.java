package ch.wiss.m323.loganalyzer;

import java.time.LocalDateTime;
import java.util.Optional;

public class LogParser {

  public Optional<LogEntry> parse(String line) {
    if (line == null || line.isBlank()) return Optional.empty();

    // teilt die Zeile an Leerzeichen, maximal 5 Teile (damit die Message auch Leerzeichen enthalten darf)
    String[] parts = line.split(";", 5);                     // split(";", 5) damit Nachrichten mit Leerzeichen nicht aufgeteilt werden
    if (parts.length < 5) return Optional.empty();

    try {
      LocalDateTime timestamp = LocalDateTime.parse(parts[0]);
      LogLevel level = LogLevel.valueOf(parts[1].toUpperCase());
      String user = parts[2];
      String ipAddress = parts[3];
      String message = parts[4];

      return Optional.of(new LogEntry(timestamp, level, user, message, ipAddress));
    } catch (Exception e) {
      // Optional.empty() = Zeile ist ungültig, wird vom LogReader übersprungen
      return Optional.empty();
    }
  }
}