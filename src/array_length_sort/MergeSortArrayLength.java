package array_length_sort;

import java.util.*;


public class MergeSortArrayLength extends MergeSort {

    /**
     * Hashing the length of each row of a 2D array into a dictionary (each key
     * can contains multiple values).
     *
     * @param table  2D array
     * @return       A hashmap with key as length and value as row number
     */
    protected static Map<Integer, List<Integer>> lengthHash(Object[][] table) {
        // Prepare the hashmap
        Map<Integer, List<Integer>> mp = new HashMap<>();

        // Measure the length of each row and store it in the hashmap with value as the row number
        for (int i = 0; i < table.length; i++) {
            int row_length = table[i].length;

            // We will insert the length to the HM but to allow duplicate values, we need to check
            // if the key exist first
            if (mp.get(row_length) == null) {
                List<Integer> dummy_list = new LinkedList();
                dummy_list.add(i);
                mp.put(row_length, dummy_list);
            }
            // or if it already existed, we update the list of rows with the same length
            else {
                List<Integer> dummy_list = mp.get(row_length);
                dummy_list.add(i);
                mp.put(row_length, dummy_list);
            }
        }

        return mp;
    }

    // Now we simply sort the length (which is the key) and create a new LinkedHM (which
    // preserves the order). We will enforce return type here instead of going for
    // polymorphism since we need the order
    /**
     * Take a hash map and sort it by the keys
     * @return A sorted LinkedHashMap by the keys
     */
    public static Object[][] ArrayLengthSort(Object[][] arr) {
        Map<Integer, List<Integer>> input = lengthHash(arr);

        // Create an array of key from the input map
        Set<Integer> keys = input.keySet();
        Integer[] key_arr = new Integer[keys.size()];
        keys.toArray(key_arr);

        // The following steps convert the array of Integer to primitive type int,
        // because our mergesort program was designed without polymorphism approach
        // (in compliance with Lab_1 specification)
        // This mistake highlight one of the most important aspect of OOP design
        int[] key_arr_primitive = new int[key_arr.length];
        for (int i = 0; i < key_arr.length; i++) {
            key_arr_primitive[i] =key_arr[i];
        }

        // Sort the array using our Lab1 function
        key_arr_primitive = sort(key_arr_primitive);

        // Create a return list
        List<Object[]> l = new LinkedList<>();

        // Follow the order in the key array, we append the final result with arrays
        // from the original 2D array
        for (int i = 0; i < key_arr_primitive.length; i++) {
            List l_retrieved = input.get(key_arr_primitive[i]);
            for (Object x: l_retrieved) {
                l.add(arr[(Integer) x]);
            }
        }

        // Converting the linked list to array
        Object[][] final_result = new Integer[l.size()][];
        for (int i = 0; i < l.size(); i++) {
            Object[] tmp = l.get(i);
            final_result[i] = tmp;
        }

        return final_result;
    }




    public static void main(String[] args) {
        String[][] groups = { {"Bob", "Carol", "Eric", "Matt"},             // 0
                {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                {"Kate", "Jack", "James", "Sydney"},          // 4
                {"Kate", "Jack", "James", "Sydney"},          // 4
                {"Kate", "Jack", "James", "Sydney", "Sydney", "Sydney", "Sydney", "Sydney"},          // 4
                {"Susan", "Brad", "Jim"},                     // 2
                {"Sue", "Wendy", "Sam"},                      // 3

                {"Mohammad", "Tim", "Kian"},                  // 5
                {"Emma", "Carol"},                            // 6
                {"Emma", "Carol"},                            // 6
                {"Emma", "Carol"},                            // 6
                {"Emma", "Carol"},                            // 6
                {"Emma", "Carol"},                            // 6
                {"Susan", "Brad", "Jim", "Jim", "Jim"},                     // 2
                {"Sue", "Wendy", "Sam"},                      // 3

                {"Mohammad", "Tim", "Kian"},                  // 5
                {"Emma", "Carol"},
                {"Nick", "Osama", "Harry", "Ben"},            // 7
                {"Mary", "John", "Ricky"} };                  // 8

        MergeSortArrayLength a = new MergeSortArrayLength();
        Object[][] done = a.ArrayLengthSort(groups);

    }

}
