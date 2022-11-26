
// Vikram Anantha
// Nov 20 2022
// 1749C
// Number Gamebinary
// 1400

// import java.util.*;
// import java.io.*;
// public class NumberGameCF {
//     static int tt;
//     static int n;
//     static ArrayList<Integer> a = new ArrayList<>();
//     static long result;
//     public static void main(String[] args) throws IOException {
//     Scanner in = new Scanner(System.in);
//     // Scanner in = new Scanner(new File("__fillerFile__.in"));
//     tt = in.nextInt();
//     for (int t = 0; t < tt; t++) {
        
//         n = in.nextInt();
//         for (int tsawn = 0; tsawn < n; tsawn++) a.add(in.nextInt());
//         Collections.sort(a);

//         result = binarySearch();



//         // ArrayList<Integer> b = new ArrayList<>();
//         // b.add(1);
//         // b.add(3);
//         // b.add(5);
//         // b.add(7);

//         // System.out.println(b);
//         // for (int i = 0; i <= 8; i++) {
//         //     Integer c = floor(b, i);
//         //     System.out.println(i + ": " + c);
//         // }
        

//         System.out.println(result);
//     }
//     in.close();
//     }

//     static int binarySearch() {
//         int high = n+1;
//         int low = 0;
//         int mid = (high + low) / 2;

//         while (low +1 < high) {
//             mid = (low + high) / 2;
            
//             boolean good = simulate(mid);

//             // System.out.println(Arrays.toString(new Object[]{low, mid, high, good}));

//             if (!good) high = mid-1;
//             else low = mid;
//         }

//         return low;
//     }

//     static boolean simulate(int k) { // true if alice can win, false if bob wins
//         // System.out.println(a);
//         for (int i = 1; i <= k; i++) {

//             int j = k-i+1;
//             Integer toremove = floor(a, j);
//             // Collections.binarySearch(a, j);
//             if (toremove < 0) return false;
//             a.remove(a.get(toremove));
//             // System.out.println(a);

//             if (a.size() == 0) {
//                 return true;
//             }

//             Integer toadd = floor(a, j-1);
//             if (toadd < 0) toadd = 0;
//             // a.set(toadd, a.get(toadd) + j);
//             int whattoadd = a.get(toadd) + j;
//             a.remove(a.get(toadd));
//             int placetoadd = Collections.binarySearch(a, toadd+j);
//             if (placetoadd < 0) placetoadd = placetoadd * (-1) - 1;

//             a.add(placetoadd, whattoadd);
//             // System.out.println(a);
            

//         }
//         return true;
//     }

//     static Integer floor(ArrayList<Integer> a, int j) {
//         int b = Collections.binarySearch(a, j);
//         if (b < 0) b = b * (-1) - 2;


//         return b;
//     }
// }


import java.util.Arrays;
import java.util.Scanner;

public class NumberGameCF {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int n=0; n<N; n++) {
                A[n] = in.nextInt();
            }
            Arrays.sort(A);
            System.out.println(Arrays.toString(A));
            int k = 1;
            while (2*k-1 <= N) {
                System.out.println("K: " + k);
                boolean ok = A[k-1] == 1;
                System.out.println("   ok: " + ok);
                for (int i=1; i<=k; i++) {
                    ok &= A[k-1+i-1] <= i;
                    System.out.println("   ok: " + ok + " (A[" + (k-1+i-1) + "] = " + A[k-1+i-1] + " <= " + i + ")");
                }
                if (!ok) {
                    break;
                }
                k++;
            }
            System.out.println(k-1);
        }
    }

}




/*
4 <-- t
3 <-- n
1 1 2 <-- a
4
4 4 4 4
1
1
5
1 3 2 1 1

[1, 1, 2]
k = 2
1:  remove a numnber <= 2-1+1 = 2 --- alice wants to remove the highest number she can
    [1, 1]
    [1, 1+2] --> [3, 1]
2:  remove a numnber <= 2-2+1 = 1


[1, 1, 1, 2, 3]
k=3
1:  remove number <= 3-1+1 = 3
    [1, 1, 1, 2]
    add 3-1+1 to a number
    [1, 1, 4, 2]
2:  remove numnber <= 2
    [1, 1, 4]
    add 2 to a number
    []

alice should remove the highest number
bob should add k-i+1 to any number within the range (0, k-i+1-1)

algorithm for each test case:
binary search to find a k:
for each k:




 */