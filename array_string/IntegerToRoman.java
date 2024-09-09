package array_string;
import java.util.*;
public class IntegerToRoman {
    public String intToRoman(int num) {
        List<Integer> numbers = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> symbol = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        StringBuilder res = new StringBuilder();
        for(int i=0; i<13; i++){
            if(num == 0){
                break;
            }

            int times = num / numbers.get(i);
            while(times > 0){
                times --;
                res.append(symbol.get(i));
            }

            num %= numbers.get(i);
        } 

        return res.toString();
    }
    
}

//MISTAKE
//missed the test case of 400 and 90.
