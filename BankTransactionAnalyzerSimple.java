import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "statement.csv";

    public static void main(String[] args) throws IOException {
        
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        //get profit or loss for the statement
        double total = 0d;
        for(final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }
        System.out.println("The total for all transactions is " + total);

        int transactionCount = lines.size();
        System.out.println("The total number of transactions is " + transactionCount);


        //get the sum for april
        double aprilTotal =0;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for(final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if(date.getMonth() == Month.APRIL) {
                final double amount = Double.parseDouble(columns[1]);
                aprilTotal += amount;
            }
        }
        System.out.println("The total for transactions in April is " + aprilTotal);

    }
}

