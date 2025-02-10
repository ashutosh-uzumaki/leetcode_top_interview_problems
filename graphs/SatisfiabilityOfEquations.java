package graphs;

public class SatisfiabilityOfEquations {
    class Solution {
        int[] parent;
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
        public void union(int x, int y){
            int findParentX = find(x);
            int findParentY = find(y);
    
            if(findParentX != findParentY){
                parent[findParentX] = findParentY;
            }
        }
        public boolean equationsPossible(String[] equations) {
            parent = new int[26];
    
            for(int i=0; i<26; i++){
                parent[i] = i;
            }
    
            for(String equation: equations){
                if(equation.charAt(1) == '='){
                    int a = equation.charAt(0) - 'a';
                    int b = equation.charAt(3) - 'a';
                    union(a, b);
                }
            }
    
            for(String equation: equations){
                if(equation.charAt(1) == '!'){
                    int a = equation.charAt(0) - 'a';
                    int b = equation.charAt(3) - 'a';
    
                    int findParentA = find(a);
                    int findParentB = find(b);
    
                    if(findParentA == findParentB){
                        return false;
                    }
                }
            }
            return true;
        }
        
    }
}
