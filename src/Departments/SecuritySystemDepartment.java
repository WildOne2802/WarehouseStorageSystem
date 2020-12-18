package Departments;

import Components.Gate;
import Users.Guard;

import java.util.ArrayList;
import java.util.List;

public class SecuritySystemDepartment {
    public boolean alarm = false;
    Gate[] gates;
    List<Guard> guards = new ArrayList<>();

    public List<String> tasks = new ArrayList<>();

    public Gate[] getGates() {
        return gates;
    }

    public void setGates(Gate[] gates) {
        this.gates = gates;
    }

    public List<Guard> getGuards() {
        return guards;
    }

    public void addGuard(Guard guard) {
        guards.add(guard);
    }
}
