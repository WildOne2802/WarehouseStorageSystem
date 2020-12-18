package Users;

import Components.Good;
import Components.Invoice;
import Components.JobType;
import Departments.ForklifterDepartment;
import Departments.GeneralStorage;
import Departments.ReceptionDepartment;

import java.util.Scanner;


public class Acceptor extends User {

    ReceptionDepartment receptionDepartment;
    GeneralStorage generalStorage;
    ForklifterDepartment forklifterDepartment;

    public Acceptor(String name, ReceptionDepartment receptionDepartment,
                    GeneralStorage generalStorage,
                    ForklifterDepartment forklifterDepartment) {
        super(name);
        this.generalStorage = generalStorage;
        this.receptionDepartment = receptionDepartment;
        this.forklifterDepartment = forklifterDepartment;
        receptionDepartment.addAcceptor(this);
        this.setJobType(JobType.ACCEPTOR);
    }

    int findPlaceForGoods() {
        int id = generalStorage.getFreePlaceID();
        generalStorage.placesID[id] = 1;
        return id;
    }

    boolean registerGood(String name, int amount) {
        int placeID = findPlaceForGoods();
        if (placeID != -1) {
            Good good = new Good(name, amount);
            good.setAccepted(true);
            good.setPlaceID(placeID);
            generalStorage.goods.add(good);
            callForklifter(good.getGoodID());
            return true;
        } else {
            return false;
        }
    }

    void callForklifter(int goodID) {
        forklifterDepartment.tasks.add("Transfer this good from Reception department to General Storage (goodID: " + goodID + ")");
    }

    String getTasks() {
        return generalStorage.tasks.toString();
    }

    Scanner in = new Scanner(System.in);

    int amount;
    String name;

    @Override
    public void menu() {
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) getTasks\n" +
                    "(2) registerGood (Enter name and amount)\n" +
                    "(-1) exit\n");

            z = in.nextInt();

            switch (z) {
                case (1):
                    System.out.println(getTasks());
                    break;
                case (2):
                    name = in.next();
                    amount = in.nextInt();
                    boolean result = registerGood(name, amount);
                    if (result) {
                        System.out.println("Successfully added Good");
                    } else {
                        System.out.println("No more space");
                    }
                    break;
                case (-1):
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
