// Vikram Anantha
// [[Date]]
// [[Code]] - [[Name]] -- [[difficulty]]

import java.util.*;
import java.io.*;
public class EvenNumberAddicts {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    long[] ttt = new long[tt];
    for (int t = 0; t < tt; t++) {
        int n = in.nextInt();

        
        long result = 0;

        

        // System.out.println(result);
        ttt[t] = result;
        
    }
    for (long result : ttt) System.out.println(result);
    in.close();
    }
}
/*
o o -- B wins -- 2o
o e -- A wins -- 1o 1e
e e -- A wins --    2e

2o bob wins
3o alice wins
4o alice wins

o o o -- A wins -- 3o ==== o-o
o o e -- B wins -- 2o 1e = e-o
o e e -- B wins -- 1o 2e = o-o
e e e -- A wins --    3e = e

o o o o -- A wins -- 4o ==== e
o o o e -- A wins -- 3o 1e = o
o o e e -- B wins -- 2o 2e = e
o e e e -- A wins -- 1o 3e = o
e e e e -- A wins --    4e = e

o o o o o -- B wins -- 5o
o o o o e -- A wins -- 4o 1e
o o o e e -- B wins -- 3o 2e
o o e e e -- B wins -- 2o 3e
o e e e e -- B wins -- 1o 4e
e e e e e -- A wins --    5e

o o o o o o -- B wins -- 6o
e o o o o o -- A wins -- 6o 1e
e e o o o o -- A wins -- 5o 2e
e e e o o o -- A wins -- 4o 3e




 */