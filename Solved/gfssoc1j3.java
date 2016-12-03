package Solved; /**
 * Created by david on 30/11/16.
 */



//SOLVED

import java.util.*;

public class gfssoc1j3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        int a = 0;
        int b = 0;

        String[] m = A.split(":");
        String[] n = B.split(":");

        a+=(Integer.valueOf(m[0])*3600);
        a+=(Integer.valueOf(m[1])*60);
        a+=(Integer.valueOf(m[2]));

        b+=(Integer.valueOf(n[0])*3600);
        b+=(Integer.valueOf(n[1])*60);
        b+=(Integer.valueOf(n[2]));

        System.out.println(b-a);
    }
}
