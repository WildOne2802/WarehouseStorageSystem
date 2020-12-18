package Users;

import Components.Good;
import Components.Invoice;
import Components.JobType;
import Departments.ExpeditionDepartment;
import Departments.GeneralStorage;
import Register.AccountingDatabase;

import java.util.Date;
import java.util.Scanner;

public class Expeditor extends User {
    AccountingDatabase accountingDatabase;
    GeneralStorage generalStorage;
    ExpeditionDepartment expeditionDepartment;

    public Expeditor(String name, AccountingDatabase accountingDatabase,
                     GeneralStorage generalStorage,
                     ExpeditionDepartment expeditionDepartment) {
        super(name);
        this.accountingDatabase = accountingDatabase;
        this.generalStorage = generalStorage;
        this.expeditionDepartment = expeditionDepartment;
        expeditionDepartment.addExpeditor(this);
        this.setJobType(JobType.EXPEDITOR);
    }

    Invoice checkInvoice(int goodID) {
        for (Invoice x : accountingDatabase.getInvoices()) {
            if (x.getGood().getGoodID() == goodID) {
                return x;
            }
        }
        return null;
    }

    void loadGoodIntoTrucks(int goodID, int invoiceID) {
        System.out.println("Loaded good (goodID: " + goodID + ", invoiceID: " + invoiceID + ") into trucks");
    }

    void registerExport(int goodID) {
        Invoice invoice = checkInvoice(goodID);
        if (invoice == null) {
            System.out.println("Invoice not found");
            return;
        }
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                if (x.getAmount() <= invoice.getAmount()) {
                    generalStorage.placesID[x.getGoodID()] = 0;
                    generalStorage.goods.remove(x);
                } else
                    x.setAmount(x.getAmount() - invoice.getAmount());
                invoice.setExpeditorID(this.getUserID());
                invoice.setExportDate(new Date());
                loadGoodIntoTrucks(x.getGoodID(), invoice.getInvoiceID());
            }
        }
    }

    Scanner in = new Scanner(System.in);

    String getTasks(){
        return expeditionDepartment.tasks.toString();
    }

    @Override
    public void menu() {
        int z = 0;
        int goodID;
        while (z != -1) {
            System.out.println("Выберите команду:\n" +
                    "(1) getTasks\n" +
                    "(2) registerExport (Enter goodID)\n" +
                    "(-1) exit\n");
            z = in.nextInt();
            switch (z){
                case(1):
                    System.out.println(getTasks());
                    break;
                case(2):
                    goodID = in.nextInt();
                    registerExport(goodID);
                    break;
                case(-1):
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
}
