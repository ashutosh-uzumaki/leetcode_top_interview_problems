package strings;

public class CompressString {
    public class Solution {
        public static String getCompressedString(String str) {
            
            StringBuilder sb = new StringBuilder();
            int i = 0;
    
            while (i < str.length()) {
                char ch = str.charAt(i);
                int cnt = 0;
    
                while (i < str.length() && str.charAt(i) == ch) {
                    cnt++;
                    i++;
                }

                sb.append(ch);

                if (cnt > 1) {
                    sb.append(cnt);
                }
            }
            return sb.toString();
        }
    }
    
}
