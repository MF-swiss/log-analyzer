package ch.wiss.m323.loganalyzer;

import java.time.LocalDateTime;

public record LogEntry(
    LocalDateTime timestamp,
    LogLevel level,
    String user,
    String message,
    String ipAddress) {
}
