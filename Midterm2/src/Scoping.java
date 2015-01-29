/**
 * Created by lrraymond13 on 11/23/14.
 */
public class Scoping {  // class scope begins

    // Because 'a' is declared just inside the *class curly braces* it is in 'class scope'
    // and therefore its visible everywhere inside the class. This is the 'widest' scope in this file.
    private int a = 0;

    public void methodOne() {  // methodOne scope begins
        // Because 'b' is declared just inside the *methodOne curly braces* its only visible in methodOne
        int b = 0;
        if (a == b) { // conditional scope begins
            // Because 'c' is declared inside conditional curly braces its only visible inside the conditional
            int c = 1;
            // Because 'b' is declared in a scope which surrounds the scope of the conditional, 'b' is visible.
            b += c;
            // Because 'a' is declared in a scope that surrounds this scope of the conditional, 'a' is visible.
            a += c;
        }
        // 'c' is no longer visible
    }

    // 'b' not visible

    public void methodTwo() { // methodTwo scope begins
        int d = a;
        // 'a' is is visible since its in a scope that surrounds this scope (class scope)
        // 'b' and 'c' are not visible since they are in scope that does not surround the scope of this method
        // 'd' only visible inside methodTwo

    }

    // 'd' not visible

    // Note: Constructors obey the same rules as methods w.r.t. variable scoping

}
