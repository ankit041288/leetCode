import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while ( n >0){
            int min = scan.nextInt();
            for(int i =1; i <=min; i++){
                if(i%3==0 && i%5==0) System.out.println("FizzBuzz");
                else if (i%3==0) System.out.println("Fizz");
                else if(i%5==0) System.out.println("Buzz");
                else System.out.println(i);
            }
            n--;
        }

    }
}