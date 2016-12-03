/**
 * Created by david on 29/11/16.
 */



//SOLVED

import java.util.*;

public class gfssoc1j2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int x = 0;
        int y = 0;

        for(int i = 0; i<N; i++){
            String A = sc.next();
            int B = sc.nextInt();

            switch(A){
                case "North":
                    y+=B;
                    break;
                case "South":
                    y-=B;
                    break;
                case "East":
                    x+=B;
                    break;
                case "West":
                    x-=B;
                    break;

            }
        }

        System.out.println(x+" "+y);
    }

}
