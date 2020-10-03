import lab2_package.Locator;

import java.util.Arrays;
import java.util.Iterator;

import static lab2_package.MultiArray.multiArrayTraverse;

/**
 * Lab 2: Debugging with an IDE and Prefix Tree) <br />
 * The {@code ResearchGroup} class uses a 2D array to store the names of group members
 */


public class ResearchGroups {

    /**
     * Search a person to check whether he/she is in the groups
     * @param groups    {@code String[]} The 2D array of groups to be searched
     * @param name      {@code String} name of the person
     */
    public static void searchMember(String[][] groups, String name) {
        Locator t1 = multiArrayTraverse(groups, name);

        // If cannot found subject, state it and exit
        if (t1.notExist()) {
            System.out.println("Member does not exist in the list");
            return;
        }

        t1.resetItr();

        System.out.print(name + " is found in group: ");
        while (t1.hasNext()) {

            Integer[] pos = t1.getNext();
            System.out.print((pos[0] + 1) + ", ");
        }
        System.out.println();

        t1.resetItr();
        while (t1.hasNext()) {
            Integer[] pos = t1.getNext();
            if (pos[1] == 0) {
                System.out.println(name + " is the group leader of group: " + (pos[0] + 1));
            }
        }


    }

    /**
     * Sort groups by number of members <br />
     * @param groups    (<code>String[][]</code>) The 2D array of groups to be sorted
     */
    public static void sortGroups(String[][] groups) {
        // TODO: Lab 2 Part 1-2 -- sort and print the results here. Reuse your heapsort

    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String[][] groups = { {"Bob", "Carol", "Eric", "Matt"},             // 0
                              {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                              {"Susan", "Brad", "Jim"},                     // 2
                              {"Sue", "Wendy", "Sam"},                      // 3
                              {"Kate", "Jack", "James", "Sydney"},          // 4
                              {"Mohammad", "Tim", "Kian"},                  // 5
                              {"Emma", "Carol"},                            // 6
                              {"Nick", "Osama", "Harry", "Ben"},            // 7
                              {"Mary", "John", "Ricky"} };                  // 8

        // ResearchGroups.searchMember(groups, "Jim");
        // ResearchGroups.searchMember(groups, "Lucy");
        // ResearchGroups.searchMember(groups, "John Doe");
        // ResearchGroups.sortGroups(groups);

        searchMember(groups, "Mary");
    }

}
