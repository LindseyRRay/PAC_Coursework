/**
 * Created by lrraymond13 on 11/23/14.
 */
public class Node {
    public Object data;
    public Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data) {
        this(data, null);
    }


}
