package Components;

public class Good {
    static int nextGoodID = 0;
    int goodID;
    String name;
    int placeID;
    int amount;
    boolean packed;
    boolean accepted;

    public Good(String name, int amount) {
        goodID = nextGoodID++;
        this.name = name;
        this.amount = amount;
    }

    public int getGoodID() {
        return goodID;
    }

    public String getName() {
        return name;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }
}
