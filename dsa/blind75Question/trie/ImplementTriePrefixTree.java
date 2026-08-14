package dsa.blind75Question.trie;

/*
LC 208

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a
 dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false
otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


 */

public class ImplementTriePrefixTree {


    class Trie {
        private Node root;

        public Trie() {
            root = new Node();

        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    node.put(word.charAt(i), new Node());

                }
                //move the reference
                node = node.get(word.charAt(i));

            }
            node.setEnd();


        }

        public boolean search(String word) {

            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i)))
                    return false;
                node = node.get(word.charAt(i));
            }
            return node.isEnd();


        }

        public boolean startsWith(String prefix) {

            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (!node.containsKey(prefix.charAt(i))) {
                    return false;
                }
                node = node.get(prefix.charAt(i));
            }
            return true;

        }
    }

}
