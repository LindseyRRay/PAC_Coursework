/**
 * Created by lrraymond13 on 11/13/14.
 */
public class IceCream extends DessertItem {
    private int cost;

    IceCream(String flavor, int cost){
        super(flavor);
        this.cost = cost;
    }

    public String toString() {
        StringBuilder outString = new StringBuilder(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s",this.name));
        return outString.toString();
    }

    public int getCost() {
        return cost;
    }

}
