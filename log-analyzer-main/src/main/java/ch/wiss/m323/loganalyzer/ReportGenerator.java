package ch.wiss.m323.loganalyzer;

import java.util.List;
import java.util.Map;

public class ReportGenerator {

  private final LogAnalyzer analyzer = new LogAnalyzer();

  public String createReport(List<LogEntry> entries) {
    StringBuilder sb = new StringBuilder();
    sb.append("########### LOG REPORT ###########\n");
    sb.append("Einträge total: ").append(entries.size()).append("\n");
    sb.append("Fehler total:   ").append(analyzer.countErrors(entries)).append("\n\n");

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