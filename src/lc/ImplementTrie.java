package lc;

import java.util.*;

public class ImplementTrie {
    class Trie {
        public class TrieNode {
            char ch;
            TrieNode[] trie;
            boolean endWord;
            TrieNode(char c) {
                ch = c;
                trie = new TrieNode[26];
                endWord = false;
            }
        }

        TrieNode root = new TrieNode('0');

        /** Initialize your data structure here. */

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
            for (int i=0; i<word.length(); i++) {
                if (curr.trie[word.charAt(i) - 'a'] != null) {
                    curr = curr.trie[word.charAt(i) - 'a'];
                } else {
                    TrieNode tmp = new TrieNode(word.charAt(i));
                    curr.trie[word.charAt(i) - 'a'] = tmp;
                    curr = curr.trie[word.charAt(i) - 'a'];
                }
            }
            curr.endWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
            for (int i=0; i<word.length(); i++) {
                if (curr == null) return false;
                if (curr.trie[word.charAt(i) - 'a'] == null) return false;
                curr = curr.trie[word.charAt(i) - 'a'];
            }
            if (curr.endWord) return true;
            else return false;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (int i=0; i<prefix.length(); i++) {
                if (curr == null) return false;
                if (curr.trie[prefix.charAt(i) - 'a'] == null) return false;
                curr = curr.trie[prefix.charAt(i) - 'a'];
            }
            return true;

        }
    }

}
