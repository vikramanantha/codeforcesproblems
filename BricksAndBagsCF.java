// Vikram Anantha
// Nov 21 2022
// 1740C - Bricks and Bags - 1400
// Accepted

// Strat: Notice that consecutive numbers have to be in the same bag,
//           and that numbers should be divided based on where the gap is the biggest
//           and that the order of the bags should be smallest - biggest - middle
                      

import java.util.*;
import java.io.*;
public class BricksAndBagsCF {
    static int n;
    static long result;
    static int[] arr;
    static int r1 = 0;
    static int r2 = 0;
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    long[] ttt = new long[tt];
    for (int t = 0; t < tt; t++) {

        n = in.nextInt();
        arr = new int[n];
        
        for (int tsawn = 0; tsawn < arr.length; tsawn++) arr[tsawn] = in.nextInt();
        result = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n-1; i++) {
            int a = arr[i];
            int b = arr[i+1];

            r1 = Math.abs(b - a) + Math.abs(b - arr[0]);
            r2 = Math.abs(b - a) + Math.abs(a - arr[arr.length-1]);
            result = Math.max(r1, result);
            result = Math.max(r2, result);
        }
        
        ttt[t] = result;
    }
    for (long t : ttt) System.out.println(t);
    in.close();
    }
}

/*
3
5
3 1 5 2 3
4
17 8 19 45
8
265 265 265 265 265 265 265 265


1 2 3 3 5
 1 1 0 2

[ 3, 3, 2 ] [ 5 ] [ 1 ]
        2     4
           6


8, 17, 19, 45
[ 8 ], [ 45 ] [ 19, 17 ], 

                                a    b
                                |----|
1   2   3   4   10   11   12   13   20   21   22
  1   1   1   6    1    1    1    7    1    1

Math.max(|b-a| + |b-1|, |b-a| + |22-a|)

[ 1 ], [ 22 ], [ 2, 3, 4, 10, 11, 12, 13, 20, 21 ] ==> 21 + 1 = 22
[ 1, 2, 3, 4 ], [ 22, 21, 20 ], [ 11, 12, 13 ] ==> 16 + 7 = 23
[ 1 ], [ 22, 21, 20 ], [ 2, 3, 4, 10, 11, 12, 13 ] ==> 19 + 7 = 26
20 - 1 + 20 - 13

[ 22 ], [ 1, 2, 3, 4 ], [ 10, 11, 12, 13, 20, 21 ] ==> 18 + 6 = 24
10 - 1 + 10 - 4 = 15
4 - 22 + 4 - 10 = 24

*/