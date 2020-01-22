package diffiehellman;

import java.math.BigInteger;
import java.util.ArrayList;

public class Root {
    public static int Root (long p) {
        int g = 0;        
        for (int i = 2; i < 100; i++) {
            Boolean checker = true;
            ArrayList<Long> gSqrt = new ArrayList<>();
            long gSq = 0;
            for (int j = 1; j < 5000; j++) {
                BigInteger gg = BigInteger.valueOf(i);
                gg = gg.pow(j);
                gg = gg.mod(BigInteger.valueOf(p));
                gSq = gg.longValue();
                if (gSqrt.contains(gSq)) {
                    checker = false;
                    //System.out.println("содержит");
                    break;
                }
                gSqrt.add(gSq);
            }
            if (checker){
                g = i;
                break;
            }
        }        
        return g;
    }
}
