package Departments;

import Components.Good;
import Users.Storekeeper;

import java.util.ArrayList;
import java.util.List;

public class GeneralStorage {
    public int[] placesID;
    public List<Good> goods = new ArrayList<>();
    List<Storekeeper> storekeepers = new ArrayList<>();
    public List<String> tasks = new ArrayList<>();


    public GeneralStorage(int maxCapacity) {
        placesID = new int[maxCapacity];
    }

    public List<Storekeeper> getStorekeepers() {
        return storekeepers;
    }


    public int getFreePlaceID() {
        for (int i = 0; i < placesID.length; i++) {
            if (placesID[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    public void addStorekeeper(Storekeeper storekeeper){
        storekeepers.add(storekeeper);
    }
}
