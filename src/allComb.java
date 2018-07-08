import java.util.Scanner;

public class allComb {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int f= scan.nextInt();
        int q = scan.nextInt();
        int a = (int) (Math.pow(2,f)-1);
        if(a>q) System.out.println(a-q);
        else  System.out.println(q-a);
    }
}
