package tries;

public class LongestCommonPrefix {
    class Node{
        private Node[] children;
        private boolean isEnd;
        int count;
    
        public Node(){
            children = new Node[26];
            isEnd = false;
            count = 0;
        }
        
        public boolean containsChildren(char ch){
            return children[ch - 'a'] != null;
        }
    
        public Node getChildren(char ch){
            return children[ch - 'a'];
        }
    
        public void setChildren(char ch){
            children[ch - 'a'] = new Node();
        }
    
        public void setEnd(){
            isEnd = true;
        }
    
        public boolean getEnd(){
            return isEnd;
        }
    }
    
    class Trie{
        Node root;
    
        public Trie(){
            root = new Node();
        }
    
        public void insert(String word){
            Node curr = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!curr.containsChildren(c)){
                    curr.setChildren(c);
                }
                curr.getChildren(c).count++;
                curr = curr.getChildren(c);
            }
            curr.setEnd();
        }
    
        public String search(String word, int size){
            Node curr = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.containsChildren(c) && curr.getChildren(c).count == size){
                    curr = curr.getChildren(c);
                }else{
                    return word.substring(0, i);
                }
            }
            return word;
        }
    }
    
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0){
                return "";
            }
    
            if(strs.length == 1){
                return strs[0];
            }
    
            Trie trie = new Trie();
            for(int i=0; i<strs.length; i++){
                trie.insert(strs[i]);
            }
    
            return trie.search(strs[0], strs.length);
        }
    }
}
