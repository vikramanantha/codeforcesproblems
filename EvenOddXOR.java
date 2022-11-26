// Vikram Anantha
// Nov 25 2022
// [[Code]] - [[Name]] -- [[difficulty]]

import java.util.*;
import java.io.*;
public class EvenOddXOR {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    long[] ttt = new long[tt];
    for (int testcase = 0; testcase < tt; testcase++) {
        int n = in.nextInt();

        
        long result = 0;

        

        // System.out.println(result);
        ttt[testcase] = result;
        
    }
    for (long result : ttt) System.out.println(result);
    in.close();
    }
}
/*

4: 0100
1: 0001  0101
0: 0000
7: 0111  0111  0010 = 2

0010
0101
0110
0011

0000

0

 */