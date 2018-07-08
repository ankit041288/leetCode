import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {

        int u=0;
        int s=0;
        int n1=0;
        // Return the minimum number of characters to make the password strong
        for(int i=0; i<password.length(); i++){
            Character c = password.charAt(i);
            if(c >=65 && c<=90) u=1;
            else if(c>=97 && c<=122) u=1;
            else if(c>=33 && c<=45) s=1;
            else if(c>=48 && c<57) n=1;
        }
        if (password.length() <6 ){
            return (password.length()+((u^1)+(s^1)+(n1^1))>= 6 ) ? (password.length()+((u^1)+(s^1)+(n1^1))) : 6-password.length() ;
        }
        else return ((u^1)+(s^1)+(n1^1));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
