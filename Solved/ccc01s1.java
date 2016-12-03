package Solved; /**
 * Created by david on 01/12/16.
 */



//SOLVED

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class ccc01s1 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] C = new int[4][13];
        int[] V = new int[4];
        String[] S = {"","","",""};

        String in = br.readLine();
        char[] ch = in.toCharArray();

        int suit = 0;

        end:
        for(int i = 0; i<in.length(); i++){

            char x = ch[i];

            while(x=='C'||x=='D'||x=='H'||x=='S'){
                switch(x){
                    case 'C':
                        suit = 0;
                        if(i<in.length()-1){
                            i++;
                        }
                        else{
                            break end;
                        }
                        break;
                    case 'D':
                        suit = 1;
                        if(i<in.length()-1){
                            i++;
                        }
                        else{
                            break end;
                        }
                        break;
                    case 'H':
                        suit = 2;
                        if(i<in.length()-1){
                            i++;
                        }
                        else{
                            break end;
                        }
                        break;
                    case 'S':
                        suit = 3;
                        if(i<in.length()-1){
                            i++;
                        }
                        else{
                            break end;
                        }
                        break;
                }
                x = ch[i];
            }

            switch (x){
                case 'A':
                    C[suit][12] = 1;
                    V[suit]+=4;
                    break;
                case 'K':
                    C[suit][11] = 1;
                    V[suit]+=3;
                    break;
                case 'Q':
                    C[suit][10] = 1;
                    V[suit]+=2;
                    break;
                case 'J':
                    C[suit][9] = 1;
                    V[suit]+=1;
                    break;
                case 'T':
                    C[suit][8] = 1;
                    break;
                case '9':
                    C[suit][7] = 1;
                    break;
                case '8':
                    C[suit][6] = 1;
                    break;
                case '7':
                    C[suit][5] = 1;
                    break;
                case '6':
                    C[suit][4] = 1;
                    break;
                case '5':
                    C[suit][3] = 1;
                    break;
                case '4':
                    C[suit][2] = 1;
                    break;
                case '3':
                    C[suit][1] = 1;
                    break;
                case '2':
                    C[suit][0] = 1;
                    break;
            }

            if(x!=1){
                S[suit] = S[suit].concat(" "+Character.toString(x)+" ");
            }
            else{
                S[suit] = S[suit].concat(" "+Character.toString(x)+"0 ");
            }



        }

        for(int i = 0; i<4; i++){   //Check for additional suit points
            int sum = IntStream.of(C[i]).sum();

            switch (sum){
                case 0:
                    V[i]+=3;
                    break;
                case 1:
                    V[i]+=2;
                    break;
                case 2:
                    V[i]+=1;
                    break;
            }
        }

        System.out.println("Cards Dealt     Points");

        for(int i = 0; i<4; i++){
            switch(i){
                case 0:
                    System.out.print("Clubs");
                    break;
                case 1:
                    System.out.print("Diamonds");
                    break;
                case 2:
                    System.out.print("Hearts");
                    break;
                case 3:
                    System.out.print("Spades");
            }

            System.out.print(S[i]);
            System.out.println(V[i]);

        }

        System.out.println("Total "+IntStream.of(V).sum());

    }
}
