import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    
    private final List<BankTransaction> bankTransactions;


    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    
    
    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public List<BankTransaction> selectInMonth (Month month) {
        
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for(final BankTransaction bankTransaction:bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction:bankTransactions) {
            if(bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double maximumExpenseInMonth(final Month month) {
        double max = 0;
        for(final BankTransaction bankTransaction:bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                if(bankTransaction.getAmount() < max){  //< because expenses are in negative
                    max = bankTransaction.getAmount();
                }
            }
        }
        return max;
    }
}
