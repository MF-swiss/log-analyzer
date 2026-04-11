package ch.wiss.m323.loganalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class LogParserTest {

  private final LogParser parser = new LogParser();

  @Test
  void shouldParseValidLogLineIntoLogEntry() {
    String line = "2026-03-28 10:15:22;ERROR;admin;Login failed;192.168.1.10";

    var result = parser.parse(line);

    assertTrue(result.isPresent());
    assertEquals(LocalDateTime.of(2026, 3, 28, 10, 15, 22), result.get().timestamp());
    assertEquals(LogLevel.ERROR, result.get().level());
    assertEquals("admin", result.get().user());
    assertEquals("Login failed", result.get().message());
    assertEquals("192.168.1.10", result.get().ipAddress());
  }

  @Test
  void shouldReturnEmptyForMalformedLogLine() {
    String line = "2026-03-28 10:15:22;ERROR;admin;Login failed";

    var result = parser.parse(line);

    assertTrue(result.isEmpty());
  }
}
