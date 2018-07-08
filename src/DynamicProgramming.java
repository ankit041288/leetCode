import java.util.*;

import static java.util.Arrays.*;

public class DynamicProgramming {
    public static void main(String[] args){

        isValid("()");
        reverseWords("the sky is blue".toCharArray());
    }

    public static void reverseWords(char[] str) {
        reverseHelper(str,0,str.length-1);
        int s=0;
        int e=-1;
        for(int i=0; i<str.length;i++){
            if(str[i]!=' '){
                e=e+1;
            }
            else {
                reverseHelper(str,s,e);
                s=i+1;
                e=i;
            }
        }




    }
    public List<List<String>> groupAnagrams(String[] strs1) {
        String[] strs = new String[strs1.length];
        strs=Arrays.copyOf(strs1,strs1.length);

        HashMap<String,List<Integer>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++ ){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);

            strs[i]=new String(arr);
            if(map.containsKey(strs[i])){
                map.get(strs[i]).add(i);
                map.put(strs[i],map.get(strs[i]));
            }
            else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(strs[i], index);
            }
        }
        List<List<String>> res = new ArrayList<>();

        for(List<Integer> val: map.values()){
            List<String> l = new ArrayList<>();
            for(Integer i: val){
                l.add(strs[i]);
            }
            res.add(l);

        }
        return res;

    }
     static  void reverseHelper(char[] str, int s, int e){

        while(s<e){
            char temp =str[e];
            str[e]=str[s];
            str[s]=temp;
            s++;e--;
        }
    }





    public static  boolean isValid(String s) {
        if(s.length() ==0 || s.length()==1) return false;
        Set<Character> open = new HashSet<>();
        open.add('(');open.add('[');open.add('{');
        HashMap<Character,Character> oc = new HashMap<>();
        oc.put(')','(');oc.put(']','[');oc.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            Character c = s.charAt(i);
            if(open.contains(c)){
                stack.push(c);
            }
            else if(oc.containsKey(c)){
                if(!stack.isEmpty()){
                    Character pop = stack.pop();
                    if(pop != oc.get(c)) return false;
                }else return false;
            }
        }
        return true;
    }

}
