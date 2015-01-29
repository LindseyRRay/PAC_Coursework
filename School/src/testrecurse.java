/**
 * Created by lrraymond13 on 11/18/14.
 */
public class testrecurse {

    public static void main(String[] args) {
        int ans = factorial(10);
        System.out.println(ans);
        int fibnum = fib(5);
        System.out.println(fibnum);

    }

    public static int factorial(int n) {
        if (n==1) {
            return 1;
        }
        else {
            System.out.println(n);
            return n*factorial(n-1);
        }
    }

    public static int fib(int n) {
        if (n==1 || n==0) {
            return n;
        }
        else {
            return (fib(n-1)+fib(n-2));
        }
    }

}
