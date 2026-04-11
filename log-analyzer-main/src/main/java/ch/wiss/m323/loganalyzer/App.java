package ch.wiss.m323.loganalyzer;

import java.nio.file.Path;
import java.util.List;
import javax.swing.JFrame;             // Das Fenster
import javax.swing.JScrollPane;        // Scrollbar
import javax.swing.JTextArea;          // Textfeld
import javax.swing.SwingUtilities;     // Swing-Thread-Helfer

public class App {

  public static void main(String[] args) {
    // Objekte erstellen um die Log-Datei zu lesen und den Report zu generieren
    LogReader reader = new LogReader();
    ReportGenerator generator = new ReportGenerator();

    // Pfad zur Log-Datei angeben
    Path logFile = Path.of("logs/app.log");
    // Alle Zeilen der Log-Datei einlesen und parsen (Parsen = Zerlegt um weiter zu verwenden)
    List<LogEntry> entries = reader.read(logFile);
    String report = generator.createReport(entries);

    // Swing muss im eigenen Thread laufen (Event Dispatch Thread)
    // invokeLater stellt sicher, dass das Fenster sicher erstellt wird
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Log Analyzer Report");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 400);

      // Textfeld mit dem Report-Inhalt befüllen
      JTextArea textArea = new JTextArea(report);
      textArea.setEditable(false);
      textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));

      // Textfeld in eine Scrollbar einbetten (falls Report zu lang ist)
      JScrollPane scrollPane = new JScrollPane(textArea);
      frame.add(scrollPane);

      frame.setLocationRelativeTo(null);
      // Fenster sichtbar machen
      frame.setVisible(true);
    });
  }
}