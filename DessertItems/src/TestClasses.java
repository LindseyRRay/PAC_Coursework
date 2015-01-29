/**
 * Created by lrraymond13 on 11/13/14.
 */
public class TestClasses {

    public static void main(String[] args) {


        DessertItem[] test = new DessertItem[4];
        test[0] = new Candy("Lollipop", 2.23, .78);
        test[1] = new Cookie("Cookie", 4, 399);
        test[2] = new IceCream("vanilla", 105);
        test[3] = new Sundae("vanilla", 105, "Fudge", 115);


        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
            System.out.println(test[i].getCost());
        }


        Checkout checkout = new Checkout();

        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
        System.out.println(checkout);

        checkout.clear();

        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));

        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
        System.out.println(checkout);
    }



}
