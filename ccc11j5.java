import java.util.*;

/**
 * Created by David on 11/26/2016.
 */
public class ccc11j5 {

    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] ways = {1, 1, 1, 1, 1, 1, 1};

        for(int i = 1; i<N; i++){
            int y = sc.nextInt();
            ways[y] = ways[y] * (1+ways[i]);
        }

        System.out.println(ways[N]);

    }

}
