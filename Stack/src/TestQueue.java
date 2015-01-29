/**
 * Created by lrraymond13 on 11/23/14.
 */
public class TestQueue {
    public static void main(String[] args) {
        ListBasedQueue q = new ListBasedQueue();
        System.out.println(q.isEmpty());
        q.enqueue(1);
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.isEmpty());


    }
}
