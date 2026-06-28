package trie;

public class wordbreakdown {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Insert a word into Trie
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // Search a word in Trie
    public static boolean search(String key) {
        Node curr = root;

        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    // Word Break Method
    public static boolean wordBreak(String key) {//O(L)

        // Base Case
        if (key.length() == 0) {
            return true;
        }

        // Try every possible prefix
        for (int i = 1; i <= key.length(); i++) {

            if (search(key.substring(0, i)) &&
                wordBreak(key.substring(i))) {

                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {

        String words[] = {
                "i",
                "like",
                "sam",
                "sung",
                "samsung",
                "mobile",
                "ice",
                "cream",
                "icecream",
                "man",
                "go",
                "mango"
        };

        // Insert all dictionary words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Test Cases
        System.out.println(wordBreak("ilikesamsung"));   // true
        System.out.println(wordBreak("ilikeicecream"));  // true
        System.out.println(wordBreak("mango"));          // true
        System.out.println(wordBreak("ilikemobile"));    // true
        System.out.println(wordBreak("ilikexyz"));       // false
    }
}