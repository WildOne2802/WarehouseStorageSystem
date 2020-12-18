package Users;

import Components.Good;
import Components.Invoice;
import Components.JobType;
import Departments.ForklifterDepartment;
import Departments.GeneralStorage;
import Register.AccountingDatabase;

import java.util.Scanner;

public class Storekeeper extends User {
    GeneralStorage generalStorage;
    ForklifterDepartment forklifterDepartment;
    AccountingDatabase accountingDatabase;

    public Storekeeper(String name, GeneralStorage generalStorage,
                       ForklifterDepartment forklifterDepartment,
                       AccountingDatabase accountingDatabase) {
        super(name);
        this.generalStorage = generalStorage;
        this.forklifterDepartment = forklifterDepartment;
        this.accountingDatabase = accountingDatabase;
        generalStorage.addStorekeeper(this);
        this.setJobType(JobType.STOREKEEPER);
    }

    boolean changeGoodsPlace(int goodID, int newPlaceID) {
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                generalStorage.placesID[x.getPlaceID()] = 0;
                callForklifterForPlaceChange(x.getGoodID(), x.getPlaceID(), newPlaceID);
                generalStorage.placesID[newPlaceID] = 1;
                x.setPlaceID(newPlaceID);
                return true;
            }
        }
        return false;
    }

    String getTasks() {
        return generalStorage.tasks.toString();
    }

    void createInvoice(Good good, int storekeeperID){
        accountingDatabase.addInvoice(new Invoice(good, storekeeperID));
    }

    boolean sendGood(int goodID) {
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                createInvoice(x, this.getUserID());;
                callForklifter(goodID);
                return true;
            }
        }
        return false;
    }

    void callForklifterForPlaceChange(int goodID, int oldPlaceID, int newPlaceID) {
        forklifterDepartment.tasks.add("Place this good (id: " + goodID + ") " +
                "from placeID: " + oldPlaceID + " to newPlaceID: " + newPlaceID);
    }

    void callForklifter(int goodID) {
        forklifterDepartment.tasks.add("Transfer this good from General Storage " +
                "to Packing Department (goodID: " + goodID + ")");
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void menu() {
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) getTasks\n" +
                    "(2) changeGoodsPlace (Enter goodID and newPlaceID)\n" +
                    "(3) sendGood (Enter goodID)\n" +
                    "(-1) exit\n");
            z = in.nextInt();

            int goodID;
            int newPlaceID;
            boolean res;
            switch (z) {
                case (1):
                    System.out.println(getTasks());
                    break;
                case (2):
                    goodID = in.nextInt();
                    newPlaceID = in.nextInt();
                    res = changeGoodsPlace(goodID, newPlaceID);
                    if (res)
                        System.out.println("Changed goods place successfully");
                    else System.out.println("Error occured while changing goods place");
                    break;
                case (3):
                    goodID = in.nextInt();
                    res = sendGood(goodID);
                    if (res)
                        System.out.println("Good sent successfully");
                    else System.out.println("Error occured while sending good");
                    break;
                case (-1):
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Unknown command");
            }

        }
    }
}
