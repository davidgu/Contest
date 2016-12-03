package Solved; /**
 * Created by david on 28/11/16.
 */



//SOLVED

import java.util.*;

public class ccc00j1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int T = sc.nextInt();

        int count = D;

        System.out.println("Sun Mon Tue Wed Thr Fri Sat");

        for(int i = 0; i<D-1; i++){
            System.out.print("    ");
        }

        for(int i = 1; i<=T; i++){
            if(count>7){
                System.out.println("");
                count = 1;
            }
            if(i<10) {
                System.out.print("  " + i + " ");
            }
            else{
                System.out.print(" " + i + " ");
            }
            count++;
        }

    }
}
