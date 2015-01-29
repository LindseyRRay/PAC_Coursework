/**
 * Created by lrraymond13 on 11/18/14.
 */

import java.util.ArrayList;

public class stack {

    private ArrayList<Object> list = new ArrayList<Object>();

    public stack() {

    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize()-1);
    }

    public Object pop() {
        Object o = peek();
        list.remove(o);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    public String toString() {
        return "stack: " + list.toString();
    }


}
