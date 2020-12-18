package Users;

import Components.Good;
import Components.JobType;
import Departments.*;

import java.util.Arrays;
import java.util.Scanner;

public class Manager extends User {
    SecuritySystemDepartment securitySystemDepartment;
    ReceptionDepartment receptionDepartment;
    ExpeditionDepartment expeditionDepartment;
    ForklifterDepartment forklifterDepartment;
    GeneralStorage generalStorage;
    PackingDepartment packingDepartment;

    public Manager(SecuritySystemDepartment securitySystemDepartment,
                   ReceptionDepartment receptionDepartment,
                   ExpeditionDepartment expeditionDepartment,
                   ForklifterDepartment forklifterDepartment,
                   GeneralStorage generalStorage,
                   PackingDepartment packingDepartment) {
        this.generalStorage = generalStorage;
        this.forklifterDepartment = forklifterDepartment;
        this.expeditionDepartment = expeditionDepartment;
        this.receptionDepartment = receptionDepartment;
        this.securitySystemDepartment = securitySystemDepartment;
        this.packingDepartment = packingDepartment;
        this.setJobType(JobType.MANAGER);
    }

    Scanner in = new Scanner(System.in);

    void sendCommandToOpenGates(String gatesID) {
        securitySystemDepartment.tasks.add("Open Gates " + gatesID);
    }

    void sendCommandToCloseGates(String gatesID) {
        securitySystemDepartment.tasks.add("Close Gates " + gatesID);
    }

    void sendCommandToAcceptGoods() {
        receptionDepartment.tasks.add("Accept goods");
    }

    void sendCommandToSendGoods(String goodsID) {
        generalStorage.tasks.add("Send goods " + goodsID);
        expeditionDepartment.tasks.add("Send goods " + goodsID);
    }

    void sendCommandToDeleteGoods(String goodsID) {
        generalStorage.tasks.add("Delete goods " + goodsID);
        forklifterDepartment.tasks.add("Delete goods " + goodsID);
    }

    Good findGood(int goodID) {
        for (Good x : generalStorage.goods) {
            if (x.getGoodID() == goodID)
                return x;
        }
        return null;
    }

    Good findGood(String name) {
        for (Good x : generalStorage.goods) {
            if (x.getName().equals(name))
                return x;
        }
        return null;
    }

    String listGuardTasks() {
        return securitySystemDepartment.tasks.toString();
    }

    String listForklifterTasks() {
        return forklifterDepartment.tasks.toString();
    }

    String listExpeditionTasks() {
        return expeditionDepartment.tasks.toString();
    }

    String listPackingTasks() {
        return packingDepartment.tasks.toString();
    }

    String listReceptionTasks() {
        return receptionDepartment.tasks.toString();
    }

    String listGeneralStorageTasks() {
        return generalStorage.tasks.toString();
    }

    public void menu() {
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) sendCommandToOpenGates (Enter Gates IDs)\n" +
                    "(2) sendCommandToCloseGates (Enter Gates IDs)\n" +
                    "(3) sendCommandToAcceptGoods\n" +
                    "(4) sendCommandToSendGood (Enter Goods IDs)\n" +
                    "(5) sendCommandToDeleteGoods (Enter Goods IDs)\n" +
                    "(6) findGoodByID (Enter Good's id)\n" +
                    "(7) findGoodByName (Enter Good's name)\n" +
                    "(8) listGuardTasks\n" +
                    "(9) listReceptionTasks\n" +
                    "(10) listForklifterTasks\n" +
                    "(11) listExpeditionTasks\n" +
                    "(12) listGeneralStorageTasks\n" +
                    "(13) listPackingTasks\n" +
                    "(-1) exit\n");

            z = in.nextInt();

            String ids;
            int id;
            String name;

            switch (z) {
                case (1):
                    ids = in.nextLine();
                    sendCommandToOpenGates(ids);
                    System.out.println("Command Sent Successfully");
                    break;
                case (2):
                    ids = in.nextLine();
                    sendCommandToCloseGates(ids);
                    System.out.println("Command Sent Successfully");
                    break;
                case (3):
                    sendCommandToAcceptGoods();
                    System.out.println("Command Sent Successfully");
                    break;
                case (4):
                    ids = in.nextLine();
                    sendCommandToSendGoods(ids);
                    System.out.println("Command Sent Successfully");
                    break;
                case (5):
                    ids = in.nextLine();
                    sendCommandToDeleteGoods(ids);
                    System.out.println("Command Sent Successfully");
                    break;
                case (6):
                    id = in.nextInt();
                    System.out.println("Good:\n" + findGood(id));
                    break;
                case (7):
                    name = in.nextLine();
                    System.out.println("Good:\n" + findGood(name));
                    break;
                case (8):
                    System.out.println(listGuardTasks());
                    break;
                case (9):
                    System.out.println(listReceptionTasks());
                    break;
                case (10):
                    System.out.println(listForklifterTasks());
                    break;
                case (11):
                    System.out.println(listExpeditionTasks());
                    break;
                case (12):
                    System.out.println(listGeneralStorageTasks());
                    break;
                case (13):
                    System.out.println(listPackingTasks());
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
