// Vikram Anantha
// Nov 23 2022
// 1714D - Color with Occurrences -- 1600
// Accepted

/* Strat
   Notice that prioritizing the longest substrings is better because it means you'll use less
   Go through the string, at the index check if a substring could be there
   If it could, then go through the string right after the index you were at, but keep in mind
   which indexes have already been covered (so they don't have to be covered again)
 */

import java.util.*;

import java.io.*;
public class ColorWithOccurences {
    static ArrayList<int[]> pairs;
    static String s;
    static int n;
    static String[] ss;
    public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("__fillerFile__.in"));
    int tt = in.nextInt();
    String[] ttt = new String[tt];
    for (int t = 0; t < tt; t++) {
        s = in.next();
        n = in.nextInt();
        ss = new String[n];
        for (int tsawn = 0; tsawn < ss.length; tsawn++) ss[tsawn] = in.next();
        pairs = new ArrayList<>();
        
        
        String result = "";

        int output = search(0, 0);
        if (output == -1) {
            ttt[t] = "-1";
            continue;
        } else {
            result += pairs.size();
            for (int[] pair : pairs) result += "\n" + pair[0] + " " + pair[1];
            ttt[t] = result;
        }

    }
    for (String result : ttt) System.out.println(result);
    in.close();
    }

    static int search(int l, int r) {
        int gonefar = 0;
        int id = -1;
        int pos = -1;
        // System.out.println("  L: " + l + " R: " + r);
        for (int i = l; i <= r; i++) {
            for (int j = 0; j < ss.length; j++) {
                String w = ss[j];
                // System.out.println("    i: " + i + " j: " + j + " w: " + w);
                if (w.length() + i > s.length()) continue; // IS NEEDED?
                if (w.length() + i <= r) continue; // IS NEEDED?
                if (w.equals(s.substring(i, w.length() + i))) {
                    // System.out.println("      alright");
                    if (w.length() + i >= gonefar) {
                        // System.out.println("        ALRIGHT");
                        gonefar = w.length() + i;
                        id = j;
                        pos = i;
                    }
                }
            }
        }

        if (id == -1) return -1;
        pairs.add(new int[]{id+1, pos+1});
        if (gonefar >= s.length()) return 0;
        else return search(Math.max(r, pos)+1, gonefar);
        // return 0;

    }
}
/*

abacabaca
3
aba
bac
aca

abacabaca
aba aba
 bac bac
  aca aca

--- ---
 --- ---
  --- ---
abacabaca

[aba]cabaca
 aba
 [ba]cabaca
   aca
   [ ]abaca
      aba
    


check if each substring works
go through the longest substrings that exist, in order of least repeating to greatest
record the segments

do coord compression adding and substracting to see if it works

 */