package array_length_sort;

import java.util.HashMap;

interface Sortables {

}

public class MergeSortArrayLength extends MergeSort {
    /**
     * Hashing the length of each row of a 2D array into a dictionary (each key
     * can contains multiple values).
     *
     * @param table  2D array
     * @return       A hashmap with key as length and value as row number
     */
    public static HashMap<Integer, Integer> lengthHash(Object[][] table) {
        HashMap<Integer, Integer> mp = new HashMap<>();


    }
    public static void main(String[] args) {
        HashMap<Integer, Character> m = new HashMap<>();
        m.put(1, 'a');
        m.put(1, 'b');
        m.put(2, 'c');
        System.out.println(m.get(3));
    }

}
