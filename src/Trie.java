
/**
 * Lab 2: Debugging with an IDE and Prefix Tree)
 * 
 */

class Trie {
	
	static final int ALPHABET_SIZE = 26;
	
	static class TrieNode {
  
	        TrieNode[] child = new TrieNode[ALPHABET_SIZE];
	        boolean isEndOfWord;
	        
	        TrieNode(){ 
				isEndOfWord = false; 
				for (int i = 0; i < ALPHABET_SIZE; i++) 
					child[i] = null; 
			}
	        
	    }
	
	
	
	
    /**
     * Root node of the Prefix Tree
     */	 
	static TrieNode root;


	/**
	 * Insert a word in English with no number in it and all in lowercase
	 * @param word
	 */
	public static void insert(String word) {
		// As we iterate through the word, we place each of them in 1 depth level
		// of the Trie, starting at the root node.
		TrieNode current_node = root;
		for (int depth = 0; depth < word.length(); depth++) {
			// Where to put the character in the node array completely according to the
			// alphabetical order, i.e. 'a' is at position 0.
			int location = word.charAt(depth) - 'a';

			// If the node doesn't exist yet, we create that node
			if (current_node.child[location] == null) {
				current_node.child[location] = new TrieNode();
			}

			// Advance the insertion to the next level
			current_node = current_node.child[location];
		}

		// After finish adding the word, raise the word ending flag
		current_node.isEndOfWord = true;
    }

	/**
	 * Search a word in a Trie if it exists or not
	 * @param word word to be found
	 * @return	   status of word existence in trie
	 */
	public static boolean search(String word) {
    	// The same for insert, we will iterate through the word and trace through the level
		TrieNode current_node = root;
		for (int depth = 0; depth < word.length(); depth++) {
			int location = word.charAt(depth) - 'a';

			// If the node doesn't exist, immediately report that the word doesn't exist
			if (current_node.child[location] == null) {
				return false;
			}

			// Advance the node
			current_node = current_node.child[location];
		}

		// After finish iterating, don't forget to check if it is the end of a word or
		// just a prefix. i.e. search for "car" when the word stored was "care".
		if (current_node.isEndOfWord) {
			// We don't need to check the last node is null because if it were null
			// then the boolean flag cannot be raised
			return true;
		}
		else {
			return false;
		}
    }
    
   
    public static boolean startWith(String prefix) {
    	// Same as other methods we should iterate through the prefix
		TrieNode current_node = root;
		for (int depth = 0; depth < prefix.length(); depth++) {
			int location = prefix.charAt(depth) - 'a';

			// If that node is null, we cannot find any
			if (current_node.child[location] == null) {
				return false;
			}

			// Advance the node
			current_node = current_node.child[location];
		}

		// After finish checking the prefix, we check if the node we reach is must be not null.
		if (current_node != null) {
			return true;
		}
		else {
			return false;
		}
    }

   
    
    
    public static void main(String args[])
	{

		String words[] = {"ece", "lab", "java", "jar", "car",
						"cat", "care", "laboratory", "ebook"};

		String output[] = {"is NOT in the prefix tree", "is in the prefix tree"};


		root = new TrieNode();

		// Construct trie
		int i;
		for (i = 0; i < words.length ; i++)
			insert(words[i]);

		// Search for different keys
		if(search("lab") == true)
			System.out.println("lab --- " + output[1]);
		else System.out.println("lab --- " + output[0]);

		if(search("java") == true)
			System.out.println("java --- " + output[1]);
		else System.out.println("java --- " + output[0]);

		if(startWith("eced") == true)
			System.out.println("eced --- " + output[1]);
		else System.out.println("eced --- " + output[0]);

		if(startWith("ca") == true)
			System.out.println("ca --- " + output[1]);
		else System.out.println("ca --- " + output[0]);

		if(search("book") == true)
			System.out.println("book --- " + output[1]);
		else System.out.println("book --- " + output[0]);

	}

}


