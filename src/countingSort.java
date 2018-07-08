import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class countingSort {


    public static void  main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0; i<n; i++){
            int q= scan.nextInt();
            Map<Integer,Integer> hashMap = new HashMap<>();
            hashMap.put(0,0); hashMap.put(1,0); hashMap.put(2,0);
            for(int j =0;j<q;j++ ){
                int x=scan.nextInt();
                hashMap.put(x,hashMap.get(x)+1);

            }
hashMap.toString();
        }

    }
}
