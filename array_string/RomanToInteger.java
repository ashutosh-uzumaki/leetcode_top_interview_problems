package array_string;

public class RomanToInteger{
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(i + 1 < s.length() && roman.get(c) < roman.get(s.charAt(i+1))){
                res -= roman.get(c);
            }else{
                res += roman.get(c);
            }
        }

        return res;
    }
}

//mistake missed the logic of subtraction. Instead did only addition.

//subtraction when current character has less value than next character.