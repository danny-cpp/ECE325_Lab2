package TwoDimensionalArray;

/**
 * Package to work with 2D string array
 */
public class MultiArray {
    /**
     * Find all the instances in a 2D string array, then return an object that store
     * all the necessary information
     *
     * @param table    The 2D string array
     * @param seeker   The string
     * @return         The Locator object which store name and a list of all the position
     */
    public static Locator multiArrayTraverse(Object[][] table, String seeker) {
        // Prepare the return object
        Locator result = new Locator(seeker);

        // Retrieve the total row then iterate through each one.
        int row_len = table.length;;

        for (int i = 0; i < row_len; i++) {
            // Update the column length since each row may have different column
            int col_len = table[i].length;

            for (int j = 0; j < col_len; j++) {
                // If they match, update the position
                if (table[i][j].equals(seeker)) {
                    result.addPosition(i, j);
                }
            }
        }

        return result;
    }
}
