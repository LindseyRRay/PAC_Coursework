/**
 * Created by lrraymond13 on 11/13/14.
 */
public class Cookie extends DessertItem {
    private int number;
    private int price_per_dozen;

    public Cookie(String cookieName, int number, int price_per_dozen) {
        super(cookieName);
        this.number = number;
        this.price_per_dozen = price_per_dozen;
    }

    public String toString() {
        StringBuilder outString = new StringBuilder();
        String format_number = Integer.toString(number);
        String format_price = DessertShoppe.cents2dollarsAndCents(price_per_dozen);
        outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s %n", format_number+" @ "+format_price+" /dz."));
        outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s",this.name));
        return outString.toString();

    }

    public int getCost() {
        double dozen_fraction = ((number*1.0)/12);
        return ((int)(dozen_fraction*price_per_dozen));
    }
}
