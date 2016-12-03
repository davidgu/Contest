/**
 * Created by David on 2016-11-30.
 */



//SOLVED

import java.util.*;

public class ccc00s1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        int a=0, b=0, c=0;
        int cur = 0;
        int count = 0;

        while(Q!=0){
            Q--;
            count++;

            if(cur>2){
                cur = 0;
            }

            switch(cur){
                case 0:
                    A++;
                    if(A==35){
                        Q+=30;
                        A=0;
                    }
                    break;

                case 1:
                    B++;
                    if(B==100){
                        Q+=60;
                        B=0;
                    }
                    break;

                case 2:
                    C++;
                    if(C==10){
                        Q+=9;
                        C=0;
                    }
                    break;
            }
            cur++;
        }

        System.out.println("Martha plays "+count+" times before going broke.");
    }

}