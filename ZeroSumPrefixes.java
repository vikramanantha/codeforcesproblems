// Vikram Anantha
// Nov 22 2022
// 1748C - Zero-Sum Prefixes -- 1600
// Accepted

/* 
Strat: You can divide the number sequence based on when there are 0s into diff segments
       From that you can go through each segment, and find the most freq number in the prefix sum
       This tells you when there would most likely be the most number of 0s in the optimal sequence
       count all the max freqs to get the result
*/

import java.util.*;
import java.io.*;
public class ZeroSumPrefixes {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    long[] ttt = new long[tt];
    for (int t = 0; t < tt; t++) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int tsawn = 0; tsawn < a.length; tsawn++) a[tsawn] = in.nextInt();
        long[] prefix = new long[n];
        prefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + a[i];
        }
        
        long result = 0;
        long maxval = 0;

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int i = n-1; i >= 0; i--) {

            int val = freq.getOrDefault(prefix[i], 0);
            val++;
            freq.put(prefix[i], val);
            maxval = Math.max(val, maxval);

            if (a[i] == 0) {
                result += maxval;
                freq.clear();
                maxval = 0;
            }


        }

        result += freq.getOrDefault(0L, 0);

        

        // System.out.println(result);
        ttt[t] = result;
        
    }
    for (long result : ttt) System.out.println(result);
    in.close();
    }
}
/*


 | |      |   |   
1|0|0 1 -1|0 1|0 -1
1|1|1 2  1|1 2|2  1
 | |      |   |

0 2 0 1 -1 0     
0 2 2 3  2 2

3 0 2 -10 10 -30 30 0
3 3 5 -5  5  -25 5  5



 */