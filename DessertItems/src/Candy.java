/**
 * Written By : Lindsey Raymond
 * Created by lrraymond13 on 11/13/14.
 * NYU ID Number: N10905714
 */
public class Candy extends DessertItem {
//note that price per pound is in cents but output of getCost is cents
    private double weight;
    private double price_per_pound;


    public Candy(String Candyname, double amount, double ppp){
       super(Candyname);
       weight = amount;
       price_per_pound = ppp;
    }

    public String toString() {
        StringBuilder outString = new StringBuilder();
        int test = DessertShoppe.MAX_ITEM_NAME_SIZE;
        int int_weight = (int)weight;
        int int_ppp = (int)price_per_pound;
        String format_weight = Double.toString(weight);
        String format_price = DessertShoppe.cents2dollarsAndCents(int_ppp);
        outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s%n",format_weight+" lbs. @ "+format_price+" /lb."));
        outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s", this.name));
        return outString.toString();
    }

    public int getCost() {
        return ((int)(Math.round(weight * price_per_pound)));
    }

}

