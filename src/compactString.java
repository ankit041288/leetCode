import java.util.Scanner;

public class compactString {



    static String super_reduced_string(String s){
        StringBuilder s1 = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            while(i != s.length()-1 &&s.charAt(i) == s.charAt(i+1)){

                i=i+2;
            }
            s1.append(s.charAt(i));
        }
        return s1.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }



}
