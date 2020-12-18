import Departments.*;
import Users.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GeneralStorage generalStorage = new GeneralStorage(100);
        ReceptionDepartment receptionDepartment = new ReceptionDepartment();
        ExpeditionDepartment expeditionDepartment = new ExpeditionDepartment();
        ForklifterDepartment forklifterDepartment = new ForklifterDepartment();
        PackingDepartment packingDepartment = new PackingDepartment();
        InvoiceDepartment invoiceDepartment = new InvoiceDepartment();

        SecuritySystemDepartment securitySystemDepartment = new SecuritySystemDepartment();
        Guard guard = new Guard(securitySystemDepartment);
        Forklifter forklifter = new Forklifter(forklifterDepartment, generalStorage);
        Manager manager = new Manager(securitySystemDepartment,
                receptionDepartment,
                expeditionDepartment,
                forklifterDepartment,
                generalStorage,
                packingDepartment);

        User user = null;
        Scanner in = new Scanner(System.in);
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите пользователя: \n" +
                    "(1) Manager\n" +
                    "(2) Acceptor\n" +
                    "(3) Expeditor\n" +
                    "(4) Forklifter\n" +
                    "(5) Guard\n" +
                    "(6) Packer\n" +
                    "(7) Storekeeper\n" +
                    "(-1) Exit\n");
            z = in.nextInt();
            switch (z) {
                case (1):
                    user = manager;
                    user.menu();
                    break;
                case(4):
                    user = forklifter;
                    user.menu();
                    break;
                case (5):
                    user = guard;
                    user.menu();
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
