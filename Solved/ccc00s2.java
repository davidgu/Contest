package Solved; /**
 * Created by david on 30/11/16.
 */



//SOLVED

import java.util.*;

public class ccc00s2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Double> streams = new ArrayList<>();

        int m = sc.nextInt();

        for(int i = 0; i<m; i++){
            streams.add((double)sc.nextInt());
        }

        int buffer = sc.nextInt();

        while(buffer!=77){
            switch(buffer){
                case 99:
                    int place = sc.nextInt();
                    int percent = sc.nextInt();
                    streams.add(place, (double)(streams.get(place-1)*(((double)(100-percent))/100)));
                    streams.set(place-1,streams.get(place-1)-streams.get(place));
                    break;

                case 88:
                    int place2 = sc.nextInt();
                    streams.set(place2-1,streams.get(place2-1)+streams.get(place2));
                    streams.remove(place2);
                    break;
            }

            buffer = sc.nextInt();
        }

        for(double x : streams){
            System.out.print((int)x);
            System.out.print(" ");
        }

    }
}
