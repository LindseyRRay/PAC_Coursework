/**
 * Created by lrraymond13 on 11/23/14.
 */
public class Constructors {

    // Constructors initializes a class for use
    // They must have the same name as the name of the class
    public static class Cube {

        // You can provide initial values for your instance variables like so
        // (You don't necessarily need to do this in a constructor)
        private int length = 1;
        private int width = 1;
        private int height = 1;

        // Syntax does not include a return type, since constructors don't return a value.
        public Cube() {
            // This no-arg constructor is what the compiler will
            // generate for you if you provide no constructors of your own
        }

        // Constructors can be 'overloaded', like methods.
        // Here is an example of a custom constructor that initializes
        // class based on arguments from the caller.
        public Cube(int l, int w, int h) {
            length = l;
            width = w;
            height = h;
        }

        // Constructors can be 'chained'. Here one takes two arguments from
        // the caller, provide a third value and uses the second constructor just above here.
        public Cube(int l, int w) {
            this(l, w, 1); // this calls the above three argument constructor
        }

        // We would probably normally have getters (accessors) and setters (mutators) here.

        public int getVolume() {
            return length * width * height;
        }

        public static void main(String[] args) {
            Cube c1 = new Cube();
            System.out.println("Volume of c1 is " + c1.getVolume());
            Cube c2 = new Cube(10, 10);
            System.out.println("Volume of c2 is " + c2.getVolume());
            Cube c3 = new Cube(10, 20, 30);
            System.out.println("Volume of c3 is " + c3.getVolume());
        }
    }

    public static class ColoredCube extends Cube {
        private String color = "black";

        public ColoredCube() {
            // The super() statement invokes a constructor of the super class.
            super();
            // This constructor is what the compiler will
            // generate for you if you provide no constructors of your own
        }

        // Every constructor calls its superclass constructor.
        // An implied super() is included in each constructor which does not include
        // either the this() function or an explicit super() call as its *first statement*.
        public ColoredCube(int l, int w, String c) {
            super(l, w);
            // this();  // What happens if I do this instead? What will the l,w,h be?
            color = c;
        }

        public ColoredCube(int l, int b, int h, String c) {
            super(l, b, h);
            color = c;
        }

        public String getColor() {
            return color;
        }

        // Note: If a class only defines non-default constructors (constructors with parameters),
        // then its subclasses will not include an implicit super() call. This will be a compile-time error.
        // The subclasses must then explicitly call a superclass constructor, using the super()
        // construct with the right arguments to match the appropriate constructor of the superclass.

        public static void main(String[] args) {
            Cube c1 = new ColoredCube();
            System.out.println("Volume of c1 is " + c1.getVolume());
            Cube c2 = new ColoredCube(10, 10, "Baby Blue");
            System.out.println("Volume of c2 is " + c2.getVolume());
            Cube c3 = new ColoredCube(10, 20, "Fuchsia");
            System.out.println("Volume of c3 is " + c3.getVolume());
            // Why can't I do this?
            // System.out.println("Color of c3 is " + c3.getColor());
        }
    }
}
