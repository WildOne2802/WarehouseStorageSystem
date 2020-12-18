package Departments;

import Components.Good;
import Users.Storekeeper;

import java.util.ArrayList;
import java.util.List;

public class GeneralStorage {
    int maxCapacity;
    public List <Integer> placesID = new ArrayList<>(maxCapacity);
    public List<Good> goods = new ArrayList<>(maxCapacity);
    List<Storekeeper> storekeepers = new ArrayList<>();
    public List<String> tasks = new ArrayList<>();


    public GeneralStorage(int maxCapacity){
        this.maxCapacity = maxCapacity;
        for (int x: placesID) {
            x = 0;
        }
    }

    public List<Storekeeper> getStorekeepers() {
        return storekeepers;
    }


    public int getFreePlaceID(){
        for (int x: placesID) {
            if (x == 0){
                return x;
            }
        }
        return -1;
    }
}
