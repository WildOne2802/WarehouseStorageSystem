import Departments.*;
import Register.AccountingDatabase;
import Users.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GeneralStorage generalStorage = new GeneralStorage(100);
        ReceptionDepartment receptionDepartment = new ReceptionDepartment();
        ExpeditionDepartment expeditionDepartment = new ExpeditionDepartment();
        ForklifterDepartment forklifterDepartment = new ForklifterDepartment();
        PackingDepartment packingDepartment = new PackingDepartment();
        AccountingDatabase accountingDatabase = new AccountingDatabase();
        SecuritySystemDepartment securitySystemDepartment = new SecuritySystemDepartment();

        Packer packer = new Packer("Packer John",packingDepartment, generalStorage, accountingDatabase, forklifterDepartment);
        Expeditor expeditor = new Expeditor("Expeditor Dean", accountingDatabase, generalStorage, expeditionDepartment);
        Storekeeper storekeeper = new Storekeeper("Storekeeper Eleonore",generalStorage, forklifterDepartment, accountingDatabase);
        Acceptor acceptor = new Acceptor("Acceptor Spike", receptionDepartment, generalStorage, forklifterDepartment);
        Guard guard = new Guard("Guard Jet",securitySystemDepartment);
        Forklifter forklifter = new Forklifter("Forklifter Antony",forklifterDepartment, generalStorage);

        Manager manager = new Manager("Manager Timmy",securitySystemDepartment,
                receptionDepartment,
                expeditionDepartment,
                forklifterDepartment,
                generalStorage,
                packingDepartment,
                accountingDatabase);

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
                case (2):
                    user = acceptor;
                    user.menu();
                    break;
                case (3):
                    user = expeditor;
                    user.menu();
                    break;
                case (4):
                    user = forklifter;
                    user.menu();
                    break;
                case (5):
                    user = guard;
                    user.menu();
                    break;
                case (6):
                    user = packer;
                    user.menu();
                    break;
                case (7):
                    user = storekeeper;
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
