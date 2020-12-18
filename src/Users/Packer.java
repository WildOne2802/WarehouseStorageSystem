package Users;

import Components.Good;
import Components.Invoice;
import Departments.ForklifterDepartment;
import Departments.GeneralStorage;
import Departments.InvoiceDepartment;
import Departments.PackingDepartment;

import java.util.Date;

public class Packer extends User {
    PackingDepartment packingDepartment;
    GeneralStorage generalStorage;
    InvoiceDepartment invoiceDepartment;
    ForklifterDepartment forklifterDepartment;

    public Packer(PackingDepartment packingDepartment,
                  GeneralStorage generalStorage,
                  InvoiceDepartment invoiceDepartment,
                  ForklifterDepartment forklifterDepartment) {
        this.generalStorage = generalStorage;
        this.packingDepartment = packingDepartment;
        this.invoiceDepartment = invoiceDepartment;
        this.forklifterDepartment = forklifterDepartment;
        packingDepartment.addPacker(this);
    }

    void packGood(int goodID) {
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                x.setPacked(true);
            }
        }
    }

    void finishInvoice(int invoiceID) {
        Date date = new Date();
        for (Invoice x : invoiceDepartment.getInvoices()) {
            if (x.getInvoiceID() == invoiceID) {
                x.setPackerID(this.getUserID());
                x.setPackingDate(date);
            }
        }
    }

    void callForklifter(int goodID) {
        forklifterDepartment.tasks.add("Transfer this good from packing department to expeditor department: " + goodID);
    }
}
