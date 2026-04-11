package ch.wiss.m323.loganalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class LogAnalyzerTest {

  private final LogAnalyzer analyzer = new LogAnalyzer();

  @Test
  void shouldCountOnlyErrorEntries() {
    List<LogEntry> entries = List.of(
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 15, 22), LogLevel.ERROR, "admin",
            "Login failed", "192.168.1.10"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 16, 3), LogLevel.INFO, "system",
            "Backup started", "127.0.0.1"),
        new LogEntry(LocalDateTime.of(2026, 3, 28, 10, 18, 44), LogLevel.ERROR, "guest",
            "Too many requests", "192.168.1.25"));

    long errorCount = analyzer.countErrors(entries);

    assertEquals(2, errorCount);
  }
}
