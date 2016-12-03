package Solved; /**
 * Created by david on 29/11/16.
 */



//SOLVED

import java.util.*;

public class gfssoc1j1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;

        for(int i = 0 ; i<M; i++){
            if(sc.nextInt()>=N){
                count++;
            }
        }

        System.out.println(count);

    }

}
