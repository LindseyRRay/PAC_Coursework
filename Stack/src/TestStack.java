/**
 * Created by lrraymond13 on 11/18/14.
 */
public class TestStack {

    public static void main(String[] args) {
        stack testStack = new stack();

        assert testStack.isEmpty()==true;
        testStack.push("TEST");

        System.out.println(testStack.toString());

    }

}
