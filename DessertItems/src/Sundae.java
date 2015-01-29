/**
 * Created by lrraymond13 on 11/13/14.
 */
public class Sundae extends IceCream {
    private String topping;
    private int costTopping;

    public Sundae(String flavorIceCream, int costIceCream, String topping, int costTopping) {
        super(flavorIceCream, costIceCream);
        this.topping = topping;
        this.costTopping = costTopping; }

    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s %n%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s",topping+" Sundae with", this.name));
        return outString.toString();


    }

    public int getCost() {
        int baseCost = super.getCost();
        return (baseCost + costTopping);
    }

    }
/*
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append(String.format("%-40s %n%-40s",topping+" Sundae with", this.name));
        return outString.toString();

    }
    */