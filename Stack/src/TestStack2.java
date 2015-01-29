/**
 * Created by lrraymond13 on 12/15/14.
 */
import java.util.*;
public class TestStack2 {
    public static void main(String[] args) {
        Stack<Integer> n = new Stack<Integer>();

        int[] arrI = {14, 42, 19, 2, 5};
        Integer[] arr = new Integer[5];
        int j =0;
        for (int i: arrI) {

            arr[j] = new Integer(i);
            j++;
        }
       n.push(arr[0]);
        n.push(arr[1]);
        System.out.println(n.pop());
        System.out.println(n.peek());
        n.push(arr[2]);
        n.push(arr[3]);
        System.out.println(n.pop());
        System.out.println(n.pop());
        n.push(arr[4]);
        System.out.println(n.peek());



    }

}
