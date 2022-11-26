// Vikram Anantha
// Nov 26 2022
// 1703G - Good Key, Bad Key -- 1600
// Accepted
/* Strat: 
   Notice that the best time to put a bad key is at the end (never in the middle)
   To calculate when is optimal to stop putting good key and start putting bad keys, cycle through the array of coins
   backwards, remove from the goodkey sum, and recalculate badkey sum
   To recalculate badkey sum, only calculate the sum of the coins for the last 32ish chests, because after that the amount you
   get from the chest will be 0
   then use bitshifting to divide by 2s really fast
 */

import java.util.*;
import java.io.*;
public class GoodKeyBadKey {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    long[] ttt = new long[tt];
    for (int testcase = 0; testcase < tt; testcase++) {
        int n = in.nextInt();
        long k = in.nextLong();
        long [] coins = new long[n];
        long goodsum = 0L;
        for (int tsawn = 0; tsawn < coins.length; tsawn++) {coins[tsawn] = in.nextLong(); goodsum += coins[tsawn];}
        goodsum -= k*n;
        
        long result = goodsum;

        

        // System.out.println(goodsum + " + " + badsum + " = " + (badsum + goodsum));

        for (int i = n-1; i >= 0; i--) {
            goodsum -= coins[i];
            goodsum += k;

            long badsum = 0L;

            for (int j = 0; j < 32; j++) if (j+i < n) {
                badsum += coins[j+i] >> j+1;
            }

            // System.out.println(goodsum + " + " + badsum + " = " + (badsum + goodsum));

            result = Math.max(badsum + goodsum, result);
        }
        

        // System.out.println(result);
        ttt[testcase] = result;
        
    }
    for (long result : ttt) System.out.println(result);
    in.close();
    }
}
/*

5

4 5
10 10 3 1

1 2
1

3 12
10 10 29

12 51
5 74 89 45 18 69 67 67 11 96 23 59

2 57
85 60

85-57 + 60-57 = 31
85/2 + 60/4 = 57
85-57 + 60/2 = 58


3 12
10 10 29

10-12 + 10-12 + 29-12 ==> 13
10-12 + 10-12 + 29/2 ==> 10
10-12 + 10/2 + 29/2 -12 ==> 5


12 51
5 74 89 45 18 69 67 67 11 96 23 59

5-51 + 74-51 + 89-51 + 45-51 + 18-51 + 69-51 + 67-51 + 67-51 + 11-51 + 96-51 + 23-51 + 59-51 = 11
5-51 + 74-51 + 89-51 + 45-51 + 18-51 + 69-51 + 67-51 + 67-51 + 11-51 + 96-51 + 23-51 + 59/2 = 32
5-51 + 74-51 + 89-51 + 45-51 + 18-51 + 69-51 + 67-51 + 67-51 + 11-51 + 96-51 + 23/2 + 59/4 = 56
5-51 + 74-51 + 89-51 + 45-51 + 18-51 + 69-51 + 67-51 + 67-51 + 11-51 + 96/2 + 23/4 + 59/8 = 46
5-51 + 74-51 + 89-51 + 45-51 + 18-51 + 69-51 + 67-51 + 67-51 + 11/2 + 96/4 + 23/8 + 59/16 = 60 <---




Math:

a1 + a2 + a3 + a4 + a5 + a6 - (6*k)

a1 + a2 + a3 + a4 + a5 + a6/2 - (5*k)
a1 + a2 + a3 + a4 + a5/2 + a6/2 - (5*k)
a1 + a2 + a3 + a4/2 + a5/2 + a6/2 - (5*k)
etc

a1 + a2 + a3 + a4 + a5/2 + a6/4 - (4*k)
a1 + a2 + a3 + a4/2 + a5/2 + a6/4 - (4*k)

only get bad keys at the end

a1 + a2 + a3 + a4 + a5/2 + a6/4

floor(a5/2) + floor(a6/4) = halfsum
floor((halfsum + a4) / 2) = (floor(a4/2) + floor(a5/4) + floor(a6/4)) <-- is this true?

floor((halfsum + a4) / 2) = floor((floor(a5/2) + floor(a6/4) + a4) / 2) = floor(floor(a5/2)/2 + floor(a6/4)/2 + a4/2)
i think that equals (floor(a4/2) + floor(a5/4) + floor(a6/4))



 */


