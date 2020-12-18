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

    public Acceptor(ReceptionDepartment receptionDepartment,
                    GeneralStorage generalStorage,
                    ForklifterDepartment forklifterDepartment) {
        this.generalStorage = generalStorage;
        this.receptionDepartment = receptionDepartment;
        this.forklifterDepartment = forklifterDepartment;
        receptionDepartment.addAcceptor(this);
        this.setJobType(JobType.ACCEPTOR);
    }

    int findPlaceForGoods() {
        return generalStorage.getFreePlaceID();
    }

    boolean registerGood(String name, int amount) {
        if (findPlaceForGoods() != -1) {
            Good good = new Good(name, amount);
            good.setAccepted(true);
            generalStorage.goods.add(good);
            callForklifter(good.getGoodID());
            return true;
        } else {
            return false;
        }

    }

    void callForklifter(int goodID) {
        forklifterDepartment.tasks.add("Transfer this good from Reception department to General Storage " + goodID);
    }

    Scanner in = new Scanner(System.in);

    int z = 0;
    int amount;
    String name;

    @Override
    public void menu() {
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) registerGood (Enter name and amount)\n" +
                    "(-1) exit\n");
            z = in.nextInt();
            switch (z) {
                case (1):
                    name = in.next();
                    amount = in.nextInt();
                    boolean result = registerGood(name, amount);
                    if (result) {
                        System.out.println("Successfully added Good");
                    } else {
                        System.out.println("No more space");
                    }
                    break;
                case(-1):
                    System.out.println("exit");
                    break;
                default :
                    System.out.println("Unknown command");
            }
        }
    }
}
