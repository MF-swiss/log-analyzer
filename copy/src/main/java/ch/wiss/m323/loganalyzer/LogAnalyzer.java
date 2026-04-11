package ch.wiss.m323.loganalyzer;

import java.util.List;
import java.util.Map;

public class LogAnalyzer {

  public List<LogEntry> findErrors(List<LogEntry> entries) {
    return List.of();
  }

  public long countErrors(List<LogEntry> entries) {
    return 0L;
  }

  public List<String> findDistinctIpAddresses(List<LogEntry> entries) {
    return List.of();
  }

  public Map<String, Long> countEntriesByUser(List<LogEntry> entries) {
    return Map.of();
  }

  public Map<String, Long> findMostCommonErrorMessages(List<LogEntry> entries) {
    return Map.of();
  }

  public List<LogEntry> sortChronologically(List<LogEntry> entries) {
    return List.of();
  }
}
