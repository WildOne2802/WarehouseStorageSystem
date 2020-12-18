package Departments;

import Users.Forklifter;

import java.util.ArrayList;
import java.util.List;

public class ForklifterDepartment {
    List<Forklifter> forklifters = new ArrayList<>();
    public List<String> tasks = new ArrayList<>();

    public List<Forklifter> getForklifters() {
        return forklifters;
    }

    public void addForklifter(Forklifter forklifter){
        forklifters.add(forklifter);
    }

}
