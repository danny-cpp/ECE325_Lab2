package array_length_sort;

import java.util.*;


public class MergeSortArrayLength extends MergeSort {

    /**
     * This function takes in a 2 dimension array and sort the rows by length.
     * It implements custom mergesort from lab1.
     * @param table
     * @return A sorted 2D array by row length
     */
    public static Object[][] sortArrayLength(Object[][] table) {
        Map<Integer, List<Integer>> m = sortMap(lengthHash(table));

        Object[][] result = new Object[getSizeDuplicate(m)][];

        // We iterate through the hashmap and map it to our 2D array
        Iterator it = m.entrySet().iterator();
        int index1 = 0;

        while (it.hasNext()) {
            Map.Entry map_ele = (Map.Entry)it.next();
            List<Integer> rows_with_equal_length = (List<Integer>)map_ele.getValue();

            // We iterate through a block and append to final 2D array
            for (Integer x: rows_with_equal_length) {
                result[index1] = table[x];
                index1++;
            }
        }

        return result;

    }

    /**
     * Print out a 2D array with ascending row length order
     *
     * @param res a 2D array
     */
    public static void print2DArray(Object[][] res) {
        int row_len = res.length;
        for (int i = 0; i < row_len; i++) {
            System.out.print("[ ");

            // Update the column length since each row may have different column
            int col_len = res[i].length;
            for (int j = 0; j < col_len; j++) {
                System.out.print(res[i][j] + ", ");
            }
            System.out.println("]");
        }
    }


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

    /**
     * Count total number of elements in a duplicate hashmap
     * @param m
     * @return count
     */
    protected static Integer getSizeDuplicate(Map<Integer, List<Integer>> m) {
        Iterator it = m.entrySet().iterator();
        int counter = 0;

        while (it.hasNext()) {
            Map.Entry map_ele = (Map.Entry)it.next();
            List<Integer> row = (List<Integer>)map_ele.getValue();
            counter += row.size();
        }

        return counter;
    }

    // Now we simply sort the length (which is the key) and create a new LinkedHM (which
    // preserves the order). We will enforce return type here instead of going for
    // polymorphism since we need the order
    /**
     * Take a hash map and sort it by the keys
     * @return A sorted LinkedHashMap by the keys
     */
    public static LinkedHashMap<Integer, List<Integer>> sortMap(Map<Integer, List<Integer>> input) {

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

        LinkedHashMap<Integer, List<Integer>> result = new LinkedHashMap<>();
        for (int i = 0; i < key_arr_primitive.length; i++) {
            result.put(key_arr_primitive[i], input.get(key_arr_primitive[i]));
        }

        return result;
    }

}
