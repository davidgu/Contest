/**
 * Created by david on 28/11/16.
 */



//SOLVED

import java.util.*;

public class _16bitswonly {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i<N; i++){
            long A = sc.nextLong();
            long B = sc.nextLong();
            long P = sc.nextLong();

            A*=B;

            if(A==P){
                System.out.println("POSSIBLE DOUBLE SIGMA");
            }
            else{
                System.out.println("16 BIT S/W ONLY");
            }
        }
    }
}
