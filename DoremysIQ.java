// Vikram Anantha
// Nov 26 2022  
// 1707A - Doremy's IQ -- 1600
// Accepted
/*  Strat: 
    reconstruct which contests she could have done backwards if you know she had to have ended at zero
    if a_i <= Q, then she had to have done the contest (bc why not)
    if a_i > Q
        if her current IQ is less than the original, then she did the contest
        else she didn't
 */

import java.util.*;
import java.io.*;
public class DoremysIQ {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    // String[] ttt = new String[tt];
    for (int testcase = 0; testcase < tt; testcase++) {
        int n = in.nextInt();
        long q = in.nextLong();
        long[] a = new long[n];
        for (int tsawn = 0; tsawn < a.length; tsawn++) a[tsawn] = in.nextLong();

        int[] result = new int[n];

        long Q = 0;
        for (int i = n-1; i >= 0; i--) {
            if (a[i] > Q) {
                if (Q < q) {
                    Q++;
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = 1;
            }
        }

        for (int r : result) System.out.print(r);
        // ttt[testcase] = result;
        System.out.println();
    }
    // for (String result : ttt) System.out.println(result);
    in.close();
    }
}


/*
5 2
5 1 2 4 3
2 2 2 1 0

  3 4 2 1 5
0 1 2 2 2 2

*/