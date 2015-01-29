/**
 * Created by lrraymond13 on 11/13/14.
 */

import java.util.Formatter;

public class Checkout {
    private int pointerItems = -1;
    public DessertItem[] itemArray;

    public Checkout() {
       itemArray = new DessertItem[100];
    }

    public int numberOfItems(){
    //returns number of dessertitems in the list
        return (pointerItems+1);
    }

    public void enterItem(DessertItem item) {
        //adds new dessert item to end of list of items
        pointerItems += 1;
        itemArray[(pointerItems)] = item;

    }

    public void clear(){
        //clears checkout
        itemArray = new DessertItem[100];
        pointerItems = -1;
    }

    public int totalCost(){
        //returns total cost of items in cents without tax
        if (pointerItems < 0) {
            return 0;}
        int Cost = 0;
        for (int i =0; i<= pointerItems; i++) {
            Cost += itemArray[i].getCost();

        }
        return Cost;
    }

    public int totalTax(){
        return ((int)(Math.round(.01 *this.totalCost()*DessertShoppe.TAX_RATE)));
        //returns total tax on items in cents
    }

    public String toString(){
        //returns a receipt representing current list
        //Calculate Length of the correct header spacings
        int outWidth = DessertShoppe.MAX_ITEM_NAME_SIZE+1+DessertShoppe.COST_WIDTH;
        int spacers = (outWidth - DessertShoppe.STORE_NAME.length())/2 -1;
        StringBuilder outString = new StringBuilder();

        outString.append(String.format("%-"+spacers+"s%s%s%n", " ", DessertShoppe.STORE_NAME, " "));
        //build line seperator
        String lineSep ="-";
        for (int i=1; i < DessertShoppe.STORE_NAME.length(); i++) {
            lineSep+="-";
        }

        outString.append(String.format("%-"+spacers+"s%s%s%n", " ", lineSep, " "));
        for (int i=0; i<= pointerItems; i++) {
            outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s", itemArray[i].toString()+" "));
            outString.append(String.format("%"+DessertShoppe.COST_WIDTH+"s", DessertShoppe.cents2dollarsAndCents(itemArray[i].getCost())+"\n"));
        }

        outString.append(String.format("%n%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s%"+DessertShoppe.COST_WIDTH+"s%n", "Total Tax:", DessertShoppe.cents2dollarsAndCents(this.totalTax())));
        outString.append(String.format("%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s%"+DessertShoppe.COST_WIDTH+"s%n", "Total Cost:", DessertShoppe.cents2dollarsAndCents(this.totalTax()+this.totalCost())));
       return outString.toString();
    }



}
