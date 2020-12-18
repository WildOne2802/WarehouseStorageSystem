package Departments;

import Users.Packer;

import java.util.ArrayList;
import java.util.List;

public class PackingDepartment {
    List<Packer> packers = new ArrayList<>();
    public List<String> tasks = new ArrayList<>();

    public List<Packer> getPackers() {
        return packers;
    }

    public void addPacker(Packer packer) {
        packers.add(packer);
    }
}
