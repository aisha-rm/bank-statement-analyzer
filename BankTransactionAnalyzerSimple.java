import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "statement.csv";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {
                
        //final String fileName = args[0];
        final Path path = Paths.get(RESOURCES); // + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions 
            = bankStatementParser.parseLinesFromCSV(lines);

        final BankStatementProcessor bankStatementProcessor 
            = new BankStatementProcessor(bankTransactions);

            collectSummary(bankStatementProcessor);
    }
    
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
            + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in March is " +
            bankStatementProcessor.calculateTotalInMonth(Month.MARCH));
        System.out.println("The total for transactions in April is " +
            bankStatementProcessor.calculateTotalInMonth(Month.APRIL));
        System.out.println("The total salary received is " +
            bankStatementProcessor.calculateTotalForCategory("Salary"));
    }        
    
}
        // System.out.println("Total for transactions in April is " + 
        // calculateTotalAmount(selectInMonth(bankTransactions, Month.APRIL)));

        //get profit or loss for the statement
        // double total = 0d;
        // for(final String line : lines) {
        //     final String[] columns = line.split(",");
        //     final double amount = Double.parseDouble(columns[1]);
        //     total += amount;
        // }
        // System.out.println("The total for all transactions is " + total);

        // int transactionCount = lines.size();
        // System.out.println("The total number of transactions is " + transactionCount);


        //get the sum for april
    //     double aprilTotal =0;
    //     final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //     for(final String line : lines) {
    //         final String[] columns = line.split(",");
    //         final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
    //         if(date.getMonth() == Month.APRIL) {
    //             final double amount = Double.parseDouble(columns[1]);
    //             aprilTotal += amount;
    //         }
    //     }
    //     System.out.println("The total for transactions in April is " + aprilTotal);
