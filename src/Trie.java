import java.util.ArrayList;
import java.util.List;

public class Trie {
   private class Node {
       char c;
       Node[] arr;
       boolean isEnd;
       Node(){
           this.arr= new Node[26];
       }
       Node(char c){
           this.c=c;
           this.arr= new Node[26];
       }

    }


    Node head = null;

   Trie(){

       head = new Node();
   }

   public void insert(String word){
       if(word==null && word.length()==0) return;
       char[] chars = word.toCharArray();
       Node curr=head;
       for(char c : chars){
           if(curr.arr[c-'a']==null){
               Node n = new Node(c);
               curr.arr[c-'a']=n;
           }
           curr =curr.arr[c-'a'];
       }
       curr.isEnd=true;
   }

   public boolean search (String word){
       if(word==null && word.length()==0) return false;
       char[] chars = word.toCharArray();
       Node curr=head;
       for(char c : chars){
           if(curr.arr[c-'a'] ==null) return false;
           curr=curr.arr[c-'a'];
       }
       return curr.isEnd;
   }
   public List<String> getAllWithPrefix(String p){
       List<String> res = new ArrayList<>();
       if(p==null && p.length()==0) return res;
       char[] chars = p.toCharArray();
       Node curr=head;
       for(char c : chars){
           if(curr.arr[c-'a'] ==null) return res;
           curr=curr.arr[c-'a'];
       }
       StringBuilder sb = new StringBuilder();
       sb.append(p);
       helper(curr,res,sb);
       return res;
   }

   public void helper(Node root, List<String>r,StringBuilder sb){
       if(root.isEnd=true) r.add(sb.toString());
       for(Node i : root.arr){
           if(i!=null) {
               sb.append(i.c);
               helper(i, r, sb);
               sb.setLength(sb.length() - 1);
           }
       }
   }





    public boolean  startsWith(String word){
        if(word==null && word.length()==0) return false;
        char[] chars = word.toCharArray();
        Node curr=head;
        for(char c : chars){
            if(curr.arr[c-'a'] ==null) return false;
            curr=curr.arr[c-'a'];
        }
        return true;
    }

}
