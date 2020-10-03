package lab2_package;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store locations of an object in a matrix using dynamic array
 *
 */
public class Locator {
    protected String name;
    protected ArrayList<Integer[]> coordinate = new ArrayList<Integer[]>();
    protected Iterator itr;

    /**
     * Store locations of an object in a matrix
     *
     * @param name  Name of the object
     */
    Locator(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPosition(int x, int y) {
        Integer[] tmp = new Integer[2];
        tmp[0] = x;
        tmp[1] = y;
        coordinate.add(tmp);
    }

    /**
     * get iterator of the coordinates
     */
    public Iterator getBegin() {
        itr = coordinate.iterator();
        return itr;
    }

    /**
     * Checking if the program has iterated through all the array
     * @return Status of array end
     */
    public Boolean hasNext() {
        return itr.hasNext();
    }

    /**
     * Check if the object is in the matrix
     *
     * @return Status if the object location exist or not
     */
    public boolean exist() {
        return (coordinate.size() == 0);
    }

    /**
     * Advance the iterator
     * @return the coordinate
     */
    public Integer[] getNext() {
        Integer[] result = (Integer[])itr.next();
        return result;
    }


    public static void main(String[] args) {
        Locator t1 = new Locator("TestName");
        t1.addPosition(1 ,2);
        t1.addPosition(1 ,3);
        t1.addPosition(1 ,4);

        Iterator it = t1.getBegin();
        while(it.hasNext()) {
            System.out.println(t1.getNext()[1]);
        }


    }
}
