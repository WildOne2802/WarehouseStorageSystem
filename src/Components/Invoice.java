package Components;

import java.util.Date;

public class Invoice {
    static int nextInvoiceID;
    int invoiceID;
    Good good;
    int totalAmount;
    Date preparationDate;
    Date packingDate;
    Date exportDate;
    int storekeeperID;
    int packerID;
    int expeditorID;

    public Invoice (){
        invoiceID = nextInvoiceID++;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setPackerID(int packerID) {
        this.packerID = packerID;
    }

    public void setPackingDate(Date packingDate) {
        this.packingDate = packingDate;
    }
}
