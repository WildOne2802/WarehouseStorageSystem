package Users;

import Components.Good;
import Components.Invoice;
import Components.JobType;
import Departments.ForklifterDepartment;
import Departments.GeneralStorage;
import Register.AccountingDatabase;
import Departments.PackingDepartment;

import java.util.Date;
import java.util.Scanner;

public class Packer extends User {
    PackingDepartment packingDepartment;
    GeneralStorage generalStorage;
    AccountingDatabase accountingDatabase;
    ForklifterDepartment forklifterDepartment;

    public Packer(String name,PackingDepartment packingDepartment,
                  GeneralStorage generalStorage,
                  AccountingDatabase accountingDatabase,
                  ForklifterDepartment forklifterDepartment) {
        super(name);
        this.generalStorage = generalStorage;
        this.packingDepartment = packingDepartment;
        this.accountingDatabase = accountingDatabase;
        this.forklifterDepartment = forklifterDepartment;
        packingDepartment.addPacker(this);
        this.setJobType(JobType.PACKER);
    }

    String getTasks() {
        return packingDepartment.tasks.toString();
    }

    boolean packGood(int goodID) {
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                x.setPacked(true);
                for (Invoice y : accountingDatabase.getInvoices()) {
                    if (y.getGood().getGoodID() == goodID) {
                        finishInvoice(y);
                    }
                }
                callForklifter(goodID);
                return true;
            }
        }
        return false;
    }

    void finishInvoice(Invoice invoice) {
        Date date = new Date();
        invoice.setPackerID(this.getUserID());
        invoice.setPackingDate(date);
    }

    void callForklifter(int goodID) {
        forklifterDepartment.tasks.add("Transfer this good from packing department to expeditor department: " + goodID);
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void menu() {
        int id;
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) getTasks\n" +
                    "(2) packGood (Enter goodID)\n" +
                    "(-1) exit\n");
            z = in.nextInt();

            switch (z) {
                case (1):
                    System.out.println(getTasks());
                    break;
                case (2):
                    id = in.nextInt();
                    if (packGood(id)) {
                        System.out.println("Packed successfully");
                    } else {
                        System.out.println("Error occured while packing");
                    }
                    break;
                case (-1):
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
}
