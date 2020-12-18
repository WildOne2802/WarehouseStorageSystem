package Components;

import java.util.Date;

public class Invoice {
    static int nextInvoiceID;
    int invoiceID;
    Good good;
    int amount;
    Date preparationDate;
    Date packingDate;
    Date exportDate;
    int storekeeperID;
    int packerID;
    int expeditorID;

    public Invoice (Good good, int storekeeperID){
        invoiceID = nextInvoiceID++;
        this.good = good;
        this.amount = good.amount;
        preparationDate = new Date();
        this.storekeeperID = storekeeperID;
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

    public Good getGood() {
        return good;
    }

    public int getAmount() {
        return amount;
    }

    public void setExpeditorID(int expeditorID) {
        this.expeditorID = expeditorID;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID=" + invoiceID +
                ", good=" + good +
                ", amount=" + amount +
                ", preparationDate=" + preparationDate +
                ", packingDate=" + packingDate +
                ", exportDate=" + exportDate +
                ", storekeeperID=" + storekeeperID +
                ", packerID=" + packerID +
                ", expeditorID=" + expeditorID +
                "}\n";
    }
}
