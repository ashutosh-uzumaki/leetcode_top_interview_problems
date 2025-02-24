public class PlaceMaximumMats {
    import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int matLength = scn.nextInt();
        int matBreadth = scn.nextInt();
        
        int n = scn.nextInt();
        while (n > 0) {
            int hallLength = scn.nextInt();
            int hallBreadth = scn.nextInt();
            
            
            if ((hallLength < matLength && hallLength < matBreadth) || 
                (hallBreadth < matLength && hallBreadth < matBreadth)) {
                System.out.println(0);
            } else {
                int horizontallyPlacedMats = (hallLength / matLength) * (hallBreadth / matBreadth);
                int verticallyPlacedMats = (hallLength / matBreadth) * (hallBreadth / matLength);
                System.out.println(Math.max(horizontallyPlacedMats, verticallyPlacedMats));
            }
            n--;
        }
    }
}

}
