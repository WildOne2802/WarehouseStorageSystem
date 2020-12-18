package Departments;

import Users.Acceptor;

import java.util.ArrayList;
import java.util.List;

public class ReceptionDepartment {
    List<Acceptor> acceptors = new ArrayList<>();
    int [] freeGatesIDs;
    public List<String> tasks = new ArrayList<>();;

    public List<Acceptor> getAcceptors() {
        return acceptors;
    }

    public int[] getFreeGatesIDs() {
        return freeGatesIDs;
    }

    public void setFreeGatesIDs(int[] freeGatesIDs) {
        this.freeGatesIDs = freeGatesIDs;
    }

    public void addAcceptor (Acceptor acceptor){
        acceptors.add(acceptor);
    }
}

