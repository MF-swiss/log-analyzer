package ch.wiss.m323.loganalyzer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalyzer {

  public List<LogEntry> findErrors(List<LogEntry> entries) {
    return entries.stream()
        .filter(e -> e.level() == LogLevel.ERROR)          
        .toList();                                         
  }

  public long countErrors(List<LogEntry> entries) {
    return entries.stream()
        .filter(e -> e.level() == LogLevel.ERROR)
        .count();
  }

  public List<String> findDistinctIpAddresses(List<LogEntry> entries) {
    return entries.stream()
        .map(LogEntry::ipAddress)
        .distinct()
        .toList();
  }

  public Map<String, Long> countEntriesByUser(List<LogEntry> entries) {
    return entries.stream()
        .collect(Collectors.groupingBy(LogEntry::user, Collectors.counting()));
  }

  public Map<String, Long> findMostCommonErrorMessages(List<LogEntry> entries) {
    return entries.stream()
        .filter(e -> e.level() == LogLevel.ERROR)                                      // Nur Fehler
        .collect(Collectors.groupingBy(LogEntry::message, Collectors.counting()))      // Gruppieren nach Message   // und zählen
        .entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())                 // Häufigste zuerst
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> a,
            LinkedHashMap::new));      // LinkedHashMap statt HashMap, damit die Sortierung erhalten bleibt
  }

  public List<LogEntry> sortChronologically(List<LogEntry> entries) {
    return entries.stream()
        .sorted(Comparator.comparing(LogEntry::timestamp))
        .toList();
  }
}