/**
 * Created by david on 29/11/16.
 */



//SOLVED

import java.util.*;

public class tle16c1p1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        ArrayList<Integer> dimes = new ArrayList<>();

        for(int i = 0; i<D; i++){
            dimes.add(sc.nextInt());
        }

        int Q = sc.nextInt();
        ArrayList<Integer> quarters = new ArrayList<>();

        for(int i = 0; i<Q; i++){
            quarters.add(sc.nextInt());
        }

        Collections.sort(dimes);
        Collections.sort(quarters);

        int dH = dimes.get(dimes.size()-1);
        int dL = dimes.get(0);
        int qH = quarters.get(quarters.size()-1);
        int qL = quarters.get(0);

        double dV1 = (10.0/(double)dH);
        double qV1 = (25.0/(double)qL);

        double dV2 = (10.0/(double)dL);
        double qV2 = (25.0/(double)qH);

        if(((dV1>qV1)&&(dV2<qV2))||((dV1==qV1)&&(dV2==qV2))||((dV1<qV1)&&(dV2>qV2))){
            System.out.print("Neither coin is better");
        }
        else if(dV1>qV1){
            System.out.print("Dimes are better");
        }
        else if(dV2<qV2){
            System.out.print("Quarters are better");
        }
        else{   //somehow things fall through and end up at this case
            System.out.print("Neither coin is better");
        }

    }

}
