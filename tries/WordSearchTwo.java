package tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchTwo {
    class Node{
    private Node[] children;
    private boolean isEnd;
    private String word;

    public Node(){
        children = new Node[26];
        isEnd = false;
        word = "";
    }
    public boolean containsChildren(char c){
        return children[c - 'a'] != null;
    }

    public Node getChildren(char c){
        return children[c - 'a'];
    }

    public void setChildren(char c){
        children[c - 'a'] = new Node();
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setWord(String word){
        this.word = word;
    }
    public String getWord(){
        return word;
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
            curr = curr.getChildren(ch);
        }
        curr.setEnd();
        curr.setWord(word);
    }
}

class Solution {
    Trie trie = new Trie();
    HashSet<String> foundWords = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words){
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                search(i, j, board, trie.root, m, n);
            }
        }

        return new ArrayList<>(foundWords);
    }


    public void search(int i, int j, char[][] board, Node node, int m, int n){
        if(i < 0 || i >= m ||  j < 0 || j >= n || board[i][j] == '$'){
            return;
        }

        if(!node.containsChildren(board[i][j])){
            return;
        }

        node = node.getChildren(board[i][j]);
        if(node.isEnd()){
            foundWords.add(node.getWord());
        }
        char a = board[i][j];
        board[i][j] = '$';

        search(i + 1, j, board, node, m, n);
        search(i - 1, j, board, node, m, n);
        search(i, j + 1, board, node, m, n);
        search(i, j - 1, board, node, m, n);

        board[i][j] = a;


    }

}
}
