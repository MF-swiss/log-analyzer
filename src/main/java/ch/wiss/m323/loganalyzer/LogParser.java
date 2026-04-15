package ch.wiss.m323.loganalyzer;

import java.time.LocalDateTime;
import java.util.Optional;

public class LogParser {

  public Optional<LogEntry> parse(String line) {
    if (line == null || line.isBlank()) return Optional.empty();

    // teilt die Zeile an Semikolon, maximal 5 Teile (damit die Message auch Semikolon enthalten darf)
    String[] parts = line.split(";", 5);
    if (parts.length < 5) return Optional.empty();

    try {
      java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime timestamp = LocalDateTime.parse(parts[0], formatter);
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