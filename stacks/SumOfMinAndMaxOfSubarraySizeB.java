package stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SumOfMinAndMaxOfSubarraySizeB {
    class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        long sum = 0;
        long mod =(int) Math.pow(10, 9) + 7;
        Deque<Integer>s = new ArrayDeque<Integer>();
        Deque<Integer>g = new ArrayDeque<Integer>();

        for(int i=0; i<B; i++){
            while(s.size() > 0 && A.get(i) >= A.get(s.peekLast())){
                s.removeLast();
            }
            s.addLast(i);
            while(g.size() > 0 && A.get(i) <= A.get(g.peekLast())){
                g.removeLast();
            }
            g.addLast(i);
        }
        for(int i=B; i<A.size(); i++){
            sum = (sum%mod + (long)A.get(s.peekFirst())%mod + mod)%mod;
            sum = (sum%mod + (long)A.get(g.peekFirst())%mod + mod)%mod;
            while (s.size() > 0 && s.peekFirst() <= i - B)
                s.removeFirst();
            while (g.size() > 0 && g.peekFirst() <= i - B)
                g.removeFirst();
            while(s.size() > 0 && A.get(i) >= A.get(s.peekLast())){
                s.removeLast();
            }
            while(g.size() > 0 && A.get(i) <= A.get(g.peekLast())){
                g.removeLast();
            }
            s.addLast(i);
            g.addLast(i);
        }
        sum = (sum%mod + (long)A.get(s.peekFirst())%mod + mod)%mod;
        sum = (sum%mod + (long)A.get(g.peekFirst())%mod + mod)%mod;
        return (int) sum%(int)mod;
    }
}

}
