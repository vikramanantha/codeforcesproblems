// Vikram Anantha
// Nov 25 2022
// 1742F - Smaller -- 1500

import java.util.*;
import java.io.*;
public class Smaller {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    // int tt = 1;
    String[] ttt = new String[tt];
    for (int testcase = 0; testcase < tt; testcase++) {
        int n = in.nextInt();
        String[] st = new String[2];
        st[0] = "a";
        st[1] = "a";
        String result = "";

        for (int i = 0; i < n; i++) {

            int d = in.nextInt()-1;
            int k = in.nextInt();
            String x = in.next();
            // System.out.println(d + " " + k);

            for (int j = 0; j < x.length(); j++) {
                int ind;
                if (d == 0) ind = binarySearchS(st[d], x.charAt(j));
                else ind = binarySearchT(st[d], x.charAt(j));
                String toput = "";
                for (int kk = 0; kk < k; kk++) toput += x.substring(j, j+1);
                st[d] = st[d].substring(0, ind) + toput + st[d].substring(ind);
                // System.out.println("  " + d + ": " + st[d]);
            }

            if (st[0].compareTo(st[1]) < 0) result += "YES\n";
            else result += "NO\n";  

        }

        
        

        // String s = "abuiucanibuiucani";
        // Character[] c = new Character[s.length()];
        // char[] cprime = s.toCharArray();
        // for (int i = 0; i < cprime.length; i++) c[i] = cprime[i];
        // Arrays.sort(c, Collections.reverseOrder());
        // System.out.println(Arrays.toString(c));

        // System.out.println(result);
        ttt[testcase] = result;
        
    }
    for (String result : ttt) System.out.print(result);
 
    in.close();
    }

    static int binarySearchS(String s, char c) {
        int high = s.length()-1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            
            if (s.charAt(mid) < c) low = mid+1;
            else if (s.charAt(mid) > c) high = mid-1;
            else return mid;
        }

        return low;
    }

    static int binarySearchT(String s, char c) {
        int high = s.length()-1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            
            if (s.charAt(mid) > c) low = mid+1;
            else if (s.charAt(mid) < c) high = mid-1;
            else return mid;
        }

        return low;
    }
}
/*
5
2 1 aa
1 2 a
2 3 a
1 2 b
2 3 abca

a    a a       b b
a aa     a a a     aaaaaabbbccc



s: a a a b b                 --> aaabb
t: a aa a a a abca abca abca --> aaaaaaabcaabcaabca

2
1 5 mihai
2 2 buiucani

s: a mihaimihaimihaimihaimihai --> amihaimihaimihaimihaimihai --> 
   [a, a, a, a, a, a, h, h, h, h, h, i, i, i, i, i, i, i, i, i, i, m, m, m, m, m]
t: a buiucanibuiucani --> abuiucanibuiucani -->
   [u, u, u, u, n, n, i, i, i, i, c, c, b, b, a, a, a]

3
1 5 b
2 3 a
2 4 paiu


 s: a b b b b b
 t: a

 how long would binary search placing characters take?

 q = 10^5
 |x| = 5*10^5

YES
NO
YES
NO
YES
NO
YES
NO
NO
YES

YES
NO
YES
NO
YES
NO
YES
NO
NO
YES


 */