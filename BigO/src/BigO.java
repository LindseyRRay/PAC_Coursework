/**
 * Created by lrraymond13 on 11/23/14.
 */
public class BigO {

    // Big O notation is used in Computer Science to describe the performance or complexity of an algorithm.

    // Big O specifically describes the worst-case scenario, and can be used to describe
    // the execution time required or the space used

    // O(1) describes an algorithm that will always execute in the same time (or space)
    // regardless of the size of the input data set.
    private String[] strings = { "", null };
    public boolean isFirstElementNull(String[] strings)
    {
        if(strings[0] == null)
        {
            return true;
        }
        return false;
    }

    // O(N) describes an algorithm whose performance will grow linearly
    // and in direct proportion to the size of the input data set.
    public boolean containsValue(String[] strings, String value)
    {
        for (String string : strings) {
            if (string.equals(value)) {
                return true;
            }
        }
        return false;
    }

    // O(N2) represents an algorithm whose performance is directly proportional
    // to the square of the size of the input data set. This is common with
    // algorithms that involve nested iterations over the data set.
    // Deeper nested iterations will result in O(N3), O(N4) etc.
    public boolean containsDuplicates(String[] strings)
    {
        for(int i = 0; i < strings.length; i++)
        {
            for(int j = 0; j < strings.length; j++)
            {
                if(i == j) // Don't compare with self
                {
                    continue;
                }

                if(strings[i].equals(strings[j]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // O(log N) denotes an algorithm that produces a growth curve that
    // peaks at the beginning and slowly flattens out as the size of the
    // data sets increase e.g. an input data set containing 10 items
    // takes one second to complete, a data set containing 100 items
    // takes two seconds, and a data set containing 1000 items will
    // take three seconds. ex  Binary search.


}