package Users;

import Components.Good;
import Components.JobType;
import Departments.ForklifterDepartment;
import Departments.GeneralStorage;

import java.util.Scanner;

public class Forklifter extends User {

    ForklifterDepartment forklifterDepartment;
    GeneralStorage generalStorage;

    public Forklifter(ForklifterDepartment forklifterDepartment, GeneralStorage generalStorage) {
        this.forklifterDepartment = forklifterDepartment;
        this.generalStorage = generalStorage;
        forklifterDepartment.addForklifter(this);
        this.setJobType(JobType.FORKLIFTER);
    }

    String getTasks() {
        return forklifterDepartment.tasks.toString();
    }

    void changeGoodsPlace(int goodID, int newPlaceID) {
        Good good = null;
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                good = x;
            }
        }
        assert good != null;
        good.setPlaceID(newPlaceID);
    }

    void dumpGood(int goodID) {
        Good good = null;
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                good = x;
            }
        }
        generalStorage.goods.remove(good);
    }

    void transportGoods(int goodID) {
        Good good = null;
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID) {
                good = x;
            }
        }
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void menu() {
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) getTasks\n" +
                    "(2) changeGoodsPlace (Enter good ID and new Place ID)\n" +
                    "(3) dumpGood\n" +
                    "(4) transportGoods\n" +
                    "(-1) exit\n");

            z = in.nextInt();

            int goodID;
            int placeID;

            switch (z) {
                case (1):
                    System.out.println(getTasks());
                    break;
                case (2):
                    goodID = in.nextInt();
                    placeID = in.nextInt();
                    changeGoodsPlace(goodID, placeID);
                    System.out.println("Changed goods place");
                    break;
                case (3):
                    goodID = in.nextInt();
                    dumpGood(goodID);
                    System.out.println("Dumped good");
                    break;
                case(4):
                    goodID = in.nextInt();
                    transportGoods(goodID);
                    System.out.println("Transported good");
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
