// Vikram Anantha
// Nov 25 2022
// 1742F - Smaller -- 1500

import java.util.*;
import java.io.*;
public class SmallerV2 {
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    String[] ttt = new String[tt];
    for (int testcase = 0; testcase < tt; testcase++) {
        int n = in.nextInt();
        String result = "";
        String[] st = new String[2];
        st[0] = "a";
        st[1] = "a";
        boolean incarcirateT = false;
        boolean incarcirateS = false;
        int longT = 1;
        int longS = 1;
        for (int nn = 0; nn < n; nn++) {
        
            int d = in.nextInt()-1;
            long k = in.nextLong();
            String x = in.next();
            // if (boogie) {result += "YES\n"; coxntinue;}
            // // for (int kk = 0; kk < k; kk++) {
            //     if (d == 1) {
            //         for (int i = 0; i < x.length(); i++) {
            //             if (x.charAt(i) > 'a') {
            //                 st[1] = x.charAt(i) + st[1];
            //                 boogie = true;
            //                 break;
            //             }
            //             else st[1] += x.charAt(i);
            //         } 
            //         if (boogie) break;
            //     } else {
            //         st[d] += x;
            //     }
            // // }
            
            for (int i = 0; i < x.length(); i++) {
                if (d == 1) {
                    if (x.charAt(i) > 'a')
                        incarcirateT = true;
                    longT += k;
                } else {
                    longS += k;
                    if (x.charAt(i) > 'a')
                        incarcirateS = true;
                }
            }

            // System.out.println("S: " + st[0]);
            // System.out.println("T: " + st[1]);
            // System.out.println(incarcirateS + " " + incarcirateT + " " + longS + " " + longT);
            if (incarcirateT) {
                result += "YES\n";
            } else {
                if (!incarcirateS) {
                    if (longS < longT) result += "YES\n";
                    else result += "NO\n";
                } else {
                    result += "NO\n";
                }
            }

            

            // System.out.println(result);

        }
        ttt[testcase] = result;
        
    }
    for (String result : ttt) System.out.print(result);
    in.close();
    }
}
/*

1
6
2 1 a
1 1 f
2 1 b
1 1 e
2 1 ab
1 1 dd


YES
NO
YES
YES
YES
YES


 */