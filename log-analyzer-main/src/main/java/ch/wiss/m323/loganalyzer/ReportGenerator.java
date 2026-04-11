package ch.wiss.m323.loganalyzer;

import java.util.List;
import java.util.Map;

public class ReportGenerator {

  private final LogAnalyzer analyzer = new LogAnalyzer();

  public String createReport(List<LogEntry> entries) {
    StringBuilder sb = new StringBuilder();
    sb.append("########### LOG REPORT ###########\n            **********\n \n");
    sb.append("Einträge total: ").append(entries.size()).append("\n");
    sb.append("Fehler total:   ").append(analyzer.countErrors(entries)).append("\n");

    // Zusätzliche Informationen
    long errorCount = entries.stream().filter(e -> e.level() == LogLevel.ERROR).count();
    long warningCount = entries.stream().filter(e -> e.level() == LogLevel.WARNING).count();
    long infoCount = entries.stream().filter(e -> e.level() == LogLevel.INFO).count();
    sb.append("----------------------------------\n");
    sb.append("Anzahl ERROR: ").append(errorCount).append("\n");
    sb.append("Anzahl WARNING: ").append(warningCount).append("\n");
    sb.append("Anzahl INFO: ").append(infoCount).append("\n");
    sb.append("----------------------------------\n");

    String mostCommonIp = entries.stream()
        .collect(java.util.stream.Collectors.groupingBy(LogEntry::ipAddress, java.util.stream.Collectors.counting()))
        .entrySet().stream()
        .max(java.util.Map.Entry.comparingByValue())
        .map(java.util.Map.Entry::getKey)
        .orElse("-");
    sb.append("Häufigste IP: ").append(mostCommonIp).append("\n");

    String mostActiveUser = entries.stream()
        .collect(java.util.stream.Collectors.groupingBy(LogEntry::user, java.util.stream.Collectors.counting()))
        .entrySet().stream()
        .max(java.util.Map.Entry.comparingByValue())
        .map(java.util.Map.Entry::getKey)
        .orElse("-");
    sb.append("Aktivster Benutzer: ").append(mostActiveUser).append("\n\n");

    sb.append("~~~ Einträge pro Benutzer ~~~\n");
    Map<String, Long> byUser = analyzer.countEntriesByUser(entries);
    byUser.forEach((user, count) ->
        sb.append(String.format("  %-20s %d%n", user, count)));

    sb.append("\n~~~ Häufigste Fehlermeldungen ~~~\n");
    Map<String, Long> errorMessages = analyzer.findMostCommonErrorMessages(entries);
    errorMessages.forEach((msg, count) ->
        sb.append(String.format("  [%d×] %s%n", count, msg)));

    sb.append("\n~~~ Eindeutige IP-Adressen ~~~\n");
    analyzer.findDistinctIpAddresses(entries).forEach(ip ->
        sb.append("  ").append(ip).append("\n"));

    sb.append("###################################\n");
    return sb.toString();
  }
}