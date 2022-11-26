// Vikram Anantha
// Nov 23 2022
// 1730B - Meeting on the Line -- 1600
// Accepted
/* Strat:
   Notice that it is easier to calculate the optimal spot when the time to get ready is 0
   Hence you can change the problem to make each time to get ready to 0 by changing the points
   Make it so that each cow is at a t away from their starting point, so that it is as if 
   the cow took t time to get to their starting point, then went to the optimal point
   this way we can calculate the midpoint of the highs and lows and call it a day
*/

import java.util.*;
import java.io.*;
public class MeetingOnTheLine {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    double[] ttt = new double[tt];
    for (int t = 0; t < tt; t++) {
        int n = in.nextInt();
        TreeSet<Long> line = new TreeSet<>();
        long[] input = new long[n];
        for (int tsawn = 0; tsawn < input.length; tsawn++) input[tsawn] = in.nextLong();
        for (int tsawn = 0; tsawn < input.length; tsawn++) {
            long a = in.nextLong();

            line.add(input[tsawn] + a);
            line.add(input[tsawn] - a);
        }

        
        double result = line.last() + line.first();

        result /= 2;
        // if (result == (long)result) result = (long)result;

        // System.out.println(result);
        ttt[t] = result;
        
    }
    for (double result : ttt) {
        if (result == (long)result) System.out.println((long)result);
        else System.out.println(result);
    }
    in.close();
    }
}
/*
6
5 4 7 2 10 4
3 2 5 1 4 6

it's much easier if the time to get ready is 0
hence add new points to act as if the time to get ready was zero

0---1---2---3---4---5---6---7---8---9---10
        1      2,6  3       5           4

-2- -1--0---1---2---3---4---5---6---7---8---9---10--11--12--13--14
4           2 4,5,7     2       4,10    5       4       5       10

6+4, 4+10 = 14
        6+2, 4+8 = 12
                6+0, 4+6 = 10
                    6+1, 4+5 = 9
                            6+3, 4+3 = 9
                                        6+6, 4+0 = 12


0---1---2---3---4---5---6---7---8---9---10
        1      2,6  3       5           4

1+2, 2+4, 6+4, 3+5, 5+7, 4+10 = 14
    1+1, 2+3, 6+3, 3+4, 5+6, 4+9 = 13
        1+0, 2+2, 6+2, 3+3, 5+5, 4+8 = 12
            1+1, 2+1, 6+1, 3+2, 5+4, 4+7 = 11
                1+2, 2+0, 6+0, 3+1, 5+3, 4+6 = 10
                    1+3, 2+1, 6+1, 3+0, 5+2, 4+5 = 9
                            1+5, 2+3, 6+3, 3+2, 5+0, 4+3 = 9
                                        1+8, 2+6, 6+6, 3+5, 5+3, 4+0 = 12
                
|xi - x| + ti = time
xi - x + ti = time ==> xi + ti - time = x
x - xi + ti = time ==> xi - ti + time = x



 */