package ch.wiss.m323.loganalyzer;

import java.time.LocalDateTime;
import java.util.Optional;

public class LogParser {

  public Optional<LogEntry> parse(String line) {
    if (line == null || line.isBlank()) return Optional.empty();

    String[] parts = line.split(" ", 5);
    if (parts.length < 5) return Optional.empty();

    try {
      LocalDateTime timestamp = LocalDateTime.parse(parts[0]);
      LogLevel level = LogLevel.valueOf(parts[1].toUpperCase());
      String user = parts[2];
      String ipAddress = parts[3];
      String message = parts[4];

      return Optional.of(new LogEntry(timestamp, level, user, message, ipAddress));
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}