package tries;

public class SumOfPrefixScoreOfStrings {
    class Node{
        private Node[] children = new Node[26];
        int count = 0;
        boolean isEnd;
        public boolean containsChildren(char val){
            return children[val - 'a'] != null;
        }
        public Node getChildren(char val){
            return children[val - 'a'];
        }
        public void setChildren(char val){
            children[val -'a'] = new Node();
        }
        public boolean getEnd(){
            return isEnd;
        }
        public void setEnd(){
            isEnd = true;
        }
    }
    
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
    
        public void insert(String word){
            Node curr = root;
            for(char ch: word.toCharArray()){
                if(!curr.containsChildren(ch)){
                    curr.setChildren(ch);
                }
                curr.getChildren(ch).count++;
                curr = curr.getChildren(ch);
            }
            curr.setEnd();
        }
    
        public int search(String word){
            Node curr = root;
            int totalScore = 0;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(curr.containsChildren(ch) == false){
                    return 0;
                }
                totalScore += curr.getChildren(ch).count;
                curr = curr.getChildren(ch);
            }
            return totalScore;
        }
    }
    class Solution {
        public int[] sumPrefixScores(String[] words) {
            Trie trie = new Trie();
            for(String word: words){
                trie.insert(word);
            }
            int size = words.length;
            int[] ans = new int[size];
            int idx = 0;
            for(String word: words){
               ans[idx++] = trie.search(word);
            }
    
            return ans;
        }
    }
}
