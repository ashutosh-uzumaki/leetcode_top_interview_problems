package tries;

public class MaximumXorOfTwoNums {
    class Node{
        Node left;
        Node right;
    }
    
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
    
        public void insert(int num){
            Node curr = root;
            for(int i=31; i>=0; i--){
                int ithBit = ((num >> i) & 1);
    
                if(ithBit == 0){
                    if(curr.left == null){
                        curr.left = new Node();
                    }
                    curr = curr.left;
                }else{
                    if(curr.right == null){
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }
            }
        }
    
        public int findMaxXor(int num){
            Node curr = root;
            int xor = 0;
            for(int i=31; i>=0; i--){
                int ithBit = ((num >> i) & 1);
                if(ithBit == 0){
                    if(curr.right != null){
                        xor += (int)Math.pow(2,i);
                        curr = curr.right;
                    }else{
                        curr = curr.left;
                    }
                }else{
                    if(curr.left != null){
                        xor += (int)Math.pow(2, i);
                        curr = curr.left;
                    }else{
                        curr = curr.right;
                    }
    
                }
            }
    
            return xor;
        }
    }
    
    class Solution {
        public int findMaximumXOR(int[] nums) {
            Trie trie = new Trie();
            for(int num: nums){
                trie.insert(num);
            }
    
            int result = 0;
            for(int num: nums){
                result = Math.max(trie.findMaxXor(num), result);
            }
    
            return result;
        }
    }
}
