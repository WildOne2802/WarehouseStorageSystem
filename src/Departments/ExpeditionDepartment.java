package Departments;

import Users.Expeditor;

import java.util.ArrayList;
import java.util.List;

public class ExpeditionDepartment {
    List<Expeditor> expeditors = new ArrayList<>();
    public List<String> tasks = new ArrayList<>();

    public List<Expeditor> getExpeditors() {
        return expeditors;
    }

    public void addExpeditor(Expeditor expeditor) {
        expeditors.add(expeditor);
    }
}
