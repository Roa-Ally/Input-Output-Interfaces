import java.io.PrintWriter;

interface CSVPrintable {
    String getName();
    int getID();
    void csvPrintln(PrintWriter out);
}
