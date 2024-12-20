package tries;

public class CommonPrefixOfTwoArrays {
    class Node{
        private Node[] children = new Node[100];
        boolean isEnd;
        public boolean containsChildren(char val){
            return children[val-'0'] != null;
        }
        public Node getChildren(char val){
            return children[val-'0'];
        }
        public void setChildren(char val){
            children[val-'0'] = new Node();
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
    Trie(){
        root = new Node();
    }

    public void insert(String num){
        Node curr = root;
        for(char ch:  num.toCharArray()){
            if(!curr.containsChildren(ch)){
                curr.setChildren(ch);
            }
            // curr.getChildren(ch).count++;
            curr = curr.getChildren(ch);
        }
        curr.setEnd();
    }

    public int search(String num){
        Node curr = root;
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            if(!curr.containsChildren(ch)){
                return i;
            }
            curr = curr.getChildren(ch);
        }
        return num.length();
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        if(arr2.length == 0 || arr1.length == 0){
            return 0;
        }

        for(int val: arr2){
            trie.insert(String.valueOf(val));
        }
        int maxLength = 0;
        for(int val1: arr1){
            maxLength = Math.max(trie.search(String.valueOf(val1)), maxLength);
        }

        return maxLength;
    }
}
}
