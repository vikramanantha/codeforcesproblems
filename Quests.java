// Vikram Anantha
// Nov 24 2022
// 1760F - Quests -- 1500
/*
Strat: Whenever it says "find the max k" that means we have to do binary search
       Binary search on k, and for each k, simulate what the coin collecting would be like:
          cycle through the coin collecting from greatest to least, but every k days go back to the greatest coin
 */

import java.util.*;
import java.io.*;
public class Quests {
    static int d;
    static long c;
    static Long[] coins;
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    String[] ttt = new String[tt];
    for (int t = 0; t < tt; t++) {
        int n = in.nextInt();
        c = in.nextLong();
        d = in.nextInt();
        coins = new Long[n];
        for (int tsawn = 0; tsawn < coins.length; tsawn++) coins[tsawn] = in.nextLong();
        Arrays.sort(coins, Collections.reverseOrder());
        
        long result = binarySearch();

        if (result > d) ttt[t] = "Infinity";
        else if (result == -1) ttt[t] = "Impossible";
        else ttt[t] = "" + result;

        
    }
    for (String result : ttt) System.out.println(result);
    in.close();
    }

    static long binarySearch() {
        long high = d+1;
        long low = 0;
        long mid = 0;
        while (low <= high) {
            mid = (high+low)/2;
            // System.out.println(low + "--" + mid + "--" + high);
            boolean isgood = simulate(mid);
            if (isgood) {
                low = mid+1;
                // if (low == 0) break;
            }
            else {
                high = mid-1;
                if (high < 0) return -1;
            }
        }
        mid = (low + high)/2;
        // System.out.println(low + "--" + mid + "--" + high);
        // System.out.println(mid);
        return mid;
    }

    static boolean simulate(long k) { // true means k is fine, so make k go bigger
        int ind = 0;
        long total = 0;
        for (int day = 0; day < d; day++) {
            if (ind >= coins.length) total += 0;
            else total += coins[ind];


            ind++;
            if (ind == k+1) ind = 0;
        }
        // System.out.println("k: " + k + " total: " + total);
        return c <= total;
    }
}
/*

2 5 4
1 2

4 20 3
4 5 6 7

7 6 5 4

0 <= k <= d+1
for each k
cycle through the days
add to the sum of the coins coins[daynum % k]




 */