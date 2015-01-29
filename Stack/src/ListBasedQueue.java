/**
 * Created by lrraymond13 on 11/23/14.
 */
public class ListBasedQueue {

    private Node first;
    private Node last;


    public ListBasedQueue(Node start, Node end){
        this.first = start;
        this.last = end;
    }
    public ListBasedQueue(){
        this(null, null);
    }
    //check if queue is empty
    public boolean isEmpty() {
        return (first == null);
    }

//add new item to the end of the queue
    public void enqueue(Object newdata) {
        Node newNode = new Node(newdata) ;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        }
        else {//change pointer on old last node
            last.next = newNode;
            //change last node pointer
            last = newNode;}
    }

    //remove first item from the queue
    public void dequeue() {
        //check if line is empty, if it is, throw error
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        //remove data from first data item in the series
        Object firstitem = first.data;
        //change pointer on first  node
        first = first.next;
    }
    //shows data from first item in queue
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return first.data;
    }


}
