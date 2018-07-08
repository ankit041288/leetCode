public class String_duplicates {
    int a;

    public static void main(String args[]){
      System.out.println( isDupeinChar("aba"));


        hackerrankInString("hereiamstackerrank");
    }
    public static void add(int a){
        System.out.println(a);
    }

    static String hackerrankInString(String s) {
        String h = "hackerrank";
        if(h.length()>s.length()) return "No";
        int j=0;
        for(int i=0; (i<s.length() && j < h.length()); ){
            if(h.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }
            else {i++;}
        }

        if(j<h.length()) return "NO";
        return "Yes";


    }

    private static boolean isDupeinChar(String s){
        int c =0;
        for(int i =0; i<s.length();i++){
            int v = s.charAt(i)-'a';
            if((c &(1<<v))>0) return  false;
            c=(c |(1<<v));
        }
        return true;
    }

    private static boolean compareStrings(String s, String p){
        if(s.length()-p.length()!=0) return false;
        int[] arr = new int[128];

        for(int i=0; i< s.length(); i++) arr[s.charAt(i)]++;

        for(int j=0; j< p.length(); j++){
            arr[p.charAt(j)]--;
            if(arr[p.charAt(j)]<0) return false;
        }
        return true;
    }

    private static boolean findIfPermutationOFStringIsPalindrome(String p){
        int numOddChar=0;
        int[] arr = new int[128];

        for(int i=0; i<p.length(); i++){
            int a = getAddress(p.charAt(i));
            arr[a]++;
            if(arr[a]%2 !=0) numOddChar++;
            else numOddChar--;
        }

        return numOddChar<=1 ;

    }


    private static int getAddress(Character s){
        int a = Character.getNumericValue('a');
        int b = Character.getNumericValue('z');
        int c = Character.getNumericValue(s);
        if(c>=a && c<=b)
        {
            return c-a;
        }
        else return -1;
    }

    private static boolean stringsOneEditAway(String a, String b){
        String s1, s2;
        if(a.length()>=b.length()){
            s1 = a;
            s2=b;
        }
        else
        {
            s1=b; s2=a;
        }
        boolean fd =false;

        int i1=0; int i2=0;

        while(i1<s1.length() && i2 <s2.length()){
            if(s1.charAt(i1)!=s2.charAt(i2)){
                if(fd) return false;
                fd=true;

                if(s1.length()==s2.length()) i2++;
            }
            else {
                i2++;
            }
            i1++;
        }
        return true;

    }


}
