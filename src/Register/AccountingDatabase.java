package Register;

import Components.Invoice;

import java.util.ArrayList;
import java.util.List;

public class AccountingDatabase {
    List<Invoice> invoices = new ArrayList<>();

    public List<Invoice> getInvoices() {
        return invoices;
    }
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}
