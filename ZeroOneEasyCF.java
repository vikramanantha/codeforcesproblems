// Vikram Anantha
// Nov 21 2022
// 1733D1 - Zero-One (Easy Version) -- 1400

import java.util.*;
import java.io.*;
public class ZeroOneEasyCF {
    static int n;
    static long x;
    static long y;
    static int[] a;
    static int[] b;
    static long result;
    static long[] ttt;
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    ttt = new long[tt];
    for (int t = 0; t < tt; t++) {

        n = in.nextInt();
        x = in.nextLong();
        y = in.nextLong();
        a = new int[n];
        b = new int[n];
        ArrayList<Integer> ind = new ArrayList<>();
        String line = in.next();
        // System.out.println(">>" + line);
        for (int i = 0; i < n; i++) a[i] = (int)(line.charAt(i)) - 48;
        line = in.next();
        for (int i = 0; i < n; i++) b[i] = (int)(line.charAt(i))-48;

        // System.out.println(Arrays.toString(a));
        
        result = 0;

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                c[i] = 1;
                ind.add(i);
            }
            if (a[i] == b[i]) c[i] = 0;
        }
        
        if (ind.size() % 2 == 1) {
            result = -1;
            // continue;
        }
        
        else if (ind.size() == 2) {
            if (ind.get(0) + 1 == ind.get(1)) {
                result = Math.min(x, 2*y);
            }
            else {
                result = Math.min((ind.get(1) - ind.get(0)) * x, y);
            }
        }

        else {
            result = ind.size()/2 * y;
        }

        // System.out.println(result);
        ttt[t] = result;
    }
    for (long t : ttt) System.out.println(t);
    in.close();
    }
}
/*
when there's an odd number of differences, it won't work


4
5 8 7 -- 8
01001
00101
01100

5 7 2 -- -1
01000
11011
10011

7 8 3 -- 6
0111001
0100001
0011000

5 10 1 -- 3
01100
01100
00000



0011001011100

[2,    3, 6,    8, 9,    10]
   x,2y     2x,y     x, 2y

1
5 6 7
01010
01010


 */