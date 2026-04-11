package ch.wiss.m323.loganalyzer;

import java.nio.file.Path;
import java.util.List;

public class App {

  public static void main(String[] args) {
    LogReader reader = new LogReader();
    ReportGenerator generator = new ReportGenerator();

    Path logFile = Path.of("logs/app.log");
    List<LogEntry> entries = reader.read(logFile);

    System.out.println(generator.createReport(entries));
  }
}