/**
 * Created by david on 28/11/16.
 */

import java.util.*;

public class dmpg15g1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] maze = new int[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                maze[i][j] = sc.nextInt();
            }
        }


    }
}
