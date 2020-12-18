package Departments;

import Components.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDepartment {
    List<Invoice> invoices = new ArrayList<>();

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
