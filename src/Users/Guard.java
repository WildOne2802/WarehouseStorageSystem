package Users;

import Components.Gate;
import Components.JobType;
import Departments.SecuritySystemDepartment;

import java.util.Scanner;

public class Guard extends User {
    SecuritySystemDepartment securitySystemDepartment;

    public Guard(String name, SecuritySystemDepartment securitySystemDepartment) {
        super(name);
        this.securitySystemDepartment = securitySystemDepartment;
        securitySystemDepartment.addGuard(this);
        this.setJobType(JobType.GUARD);
    }

    void turnAlarmOn() {
        securitySystemDepartment.alarm = true;
    }

    void turnAlarmOff() {
        securitySystemDepartment.alarm = false;
    }

    void openGates(int gatesID) {
        for (Gate x : securitySystemDepartment.getGates()) {
            if (x.getGateID() == gatesID) {
                x.setOpened(true);
            }
        }

    }

    void closeGates(int gatesID) {
        for (Gate x : securitySystemDepartment.getGates()) {
            if (x.getGateID() == gatesID) {
                x.setOpened(false);
            }
        }

    }

    String getTasks() {
        return securitySystemDepartment.tasks.toString();
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void menu() {
        int z = 0;
        while (z != -1) {
            System.out.println("Выберите команду: \n" +
                    "(1) turnAlarmOn\n" +
                    "(2) turnAlarmOff\n" +
                    "(3) openGates (Enter Gates ID)\n" +
                    "(4) closeGates (Enter Gates ID)\n" +
                    "(5) getTasks\n" +
                    "(-1) exit\n");

            z = in.nextInt();

            int id;

            switch (z) {
                case (1):
                    turnAlarmOn();
                    System.out.println("Alarm on");
                    break;
                case (2):
                    turnAlarmOff();
                    System.out.println("Alarm off");
                    break;
                case (3):
                    id = in.nextInt();
                    openGates(id);
                    System.out.println("Opened gate: " + id);
                    break;
                case (4):
                    id = in.nextInt();
                    closeGates(id);
                    System.out.println("Closed gate: " + id);
                    break;
                case (5):
                    System.out.println(getTasks());
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
