package ch.wiss.m323.loganalyzer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReportGeneratorTest {

  private final ReportGenerator generator = new ReportGenerator();

  @Test
  void reportShouldContainMostActiveUserAndMostCommonIp() {
    List<LogEntry> entries = List.of(
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 15, 22), LogLevel.ERROR, "admin", "Login failed", "192.168.1.10"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 16, 3), LogLevel.INFO, "admin", "Backup started", "192.168.1.10"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 18, 44), LogLevel.WARNING, "guest", "Low disk space", "192.168.1.11"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 19, 44), LogLevel.INFO, "admin", "System check", "192.168.1.10")
    );
    String report = generator.createReport(entries);
    assertTrue(report.contains("Aktivster Benutzer: admin"));
    assertTrue(report.contains("Häufigste IP: 192.168.1.10"));
  }

  @Test
  void reportShouldShowCorrectCountsForLevels() {
    List<LogEntry> entries = List.of(
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 15, 22), LogLevel.ERROR, "admin", "Login failed", "192.168.1.10"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 16, 3), LogLevel.INFO, "admin", "Backup started", "192.168.1.10"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 18, 44), LogLevel.WARNING, "guest", "Low disk space", "192.168.1.11")
    );
    String report = generator.createReport(entries);
    assertTrue(report.contains("Anzahl ERROR: 1"));
    assertTrue(report.contains("Anzahl WARNING: 1"));
    assertTrue(report.contains("Anzahl INFO: 1"));
  }

  @Test
  void reportShouldListAllDistinctIps() {
    List<LogEntry> entries = List.of(
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 15, 22), LogLevel.ERROR, "admin", "Login failed", "192.168.1.10"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 16, 3), LogLevel.INFO, "admin", "Backup started", "192.168.1.11"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 18, 44), LogLevel.WARNING, "guest", "Low disk space", "192.168.1.12")
    );
    String report = generator.createReport(entries);
    assertTrue(report.contains("192.168.1.10"));
    assertTrue(report.contains("192.168.1.11"));
    assertTrue(report.contains("192.168.1.12"));
  }
}
