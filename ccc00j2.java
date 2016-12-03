/**
 * Created by david on 29/11/16.
 */



//SOLVED

import java.util.*;

public class ccc00j2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        String toCheck = "";

        int count = 0;

        for(int i = m; i<=n; i++){
            toCheck = Integer.toString(i);
            if(check(toCheck)){
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean check(String toCheck){
        char[] check = toCheck.toCharArray();
        char[] check2 = new char[toCheck.length()];
        char[] check3 = toCheck.toCharArray();
        for(int i = 0; i<check.length; i++){
            if(check[i] != '0'&& check[i] != '1'&& check[i]!= '8'&& check[i] != '6'&& check[i] != '9'){
                return false;
            }
            if(check[i] == '9'){
                check[i] = '6';
            }
            else if(check[i] == '6'){
                check[i] = '9';
            }

        }

        for(int i = 0; i<toCheck.length(); i++){
            check2[i] = check[toCheck.length()-1-i];
        }

        String a = new String(check3);
        String b = new String(check2);

        if(a.equals(b)){
            return true;
        }
        return false;
    }
}
