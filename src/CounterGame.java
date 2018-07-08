import java.util.Scanner;

public class CounterGame {
    static String counterGame(long n) {
        int i=0;
        while(n>1){
            i++;
            int reminder = powOf2(n);
            if(reminder!=0){
                counterGame(reminder);
            }
            else {

                counterGame(n/2);
            }

        }
        System.out.println(i);
        return null;
    }

    public static int powOf2(Long n){
        int diff=0;
        for(Long i=n; i>0; i--){
            if((i & (i-1))==0){
                return diff;
            }
            else {
                diff++;
            }

        }
        return diff;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            String result = counterGame(n);
            System.out.println(result);
        }
        in.close();
    }
}
