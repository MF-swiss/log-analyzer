package ch.wiss.m323.loganalyzer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class LogEntryTest {

  // Hilfsmethode zur IP-Prüfung
  private boolean isValidIp(String ip) {
    String[] parts = ip.split("\\.");
    if (parts.length != 4) return false;
    for (String part : parts) {
      try {
        int n = Integer.parseInt(part);
        if (n < 0 || n > 255) return false;
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }

  @Test
  void shouldAcceptValidIpAddresses() {
    assertTrue(isValidIp("192.168.1.10"));
    assertTrue(isValidIp("0.0.0.0"));
    assertTrue(isValidIp("255.255.255.255"));
  }

  @Test
  void shouldRejectInvalidIpAddresses() {
    assertFalse(isValidIp("256.100.100.100"));
    assertFalse(isValidIp("192.168.1"));
    assertFalse(isValidIp("192.168.1.256"));
    assertFalse(isValidIp("abc.def.ghi.jkl"));
    assertFalse(isValidIp("123.456.78.90"));
  }
}
