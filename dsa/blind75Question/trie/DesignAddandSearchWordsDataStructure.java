package dsa.blind75Question.trie;
/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
word may contain dots '.' where dots can be matched with any letter.



Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

 */

public class DesignAddandSearchWordsDataStructure {


    class WordDictionary {
        private Node root;

        public WordDictionary() {
            root = new Node();

        }

        public void addWord(String word) {
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
            return searchUtil(node, word,0);

        }

        private boolean searchUtil(Node node, String word, int index) {
            if (node == null) {
                return false;
            }
            if (index == word.length()) {
                return node.isEnd();
            }

            char ch = word.charAt(index);

            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    Node child = node.links[j];
                    if (searchUtil(child, word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.containsKey(ch)) {
                    return false;
                }
                return searchUtil(node.get(ch), word, index + 1);
            }
        }
    }
}
