import sun.tools.jstat.Literal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Tree_main {
    public static Integer i2;

    public  static void main(String[] args ){
         Integer i1;
        int[] i = {1,2,3,4,5,6,7,8,9,10};

       TNode root = createBalancedBinaryTreeWithLeastHeight(i);
        findHEightOfATreeRecursivey(root);
        findHeightOfATreeNonRecursively(root);
       getNodesByLevel(root);



    }

    static public  TNode createBalancedBinaryTreeWithLeastHeight(int[] arr){
        return createTree(arr,0,arr.length-1);

    }

    public static TNode createTree(int[] arr, int s, int e){
        if(s>e) return null;
        else{
            int m = (s+e)/2;
            TNode n = new TNode(arr[m]);
            n.left=createTree(arr,s,m-1);
            n.right=createTree(arr,m+1,e);
            return n;
        }
    }



    private static List<ArrayList<TNode>> getNodesByLevel(TNode root){
        List<ArrayList<TNode>> r = new ArrayList<>();
        ArrayList<TNode> c = new ArrayList<>();
        c.add(root);
        if(root==null) return r;

        else {

            while(c.size()>0){
                r.add(c);
                List<TNode> parents = new ArrayList<>();
                parents.addAll(c);
                c = new ArrayList<>();
                for(TNode p : parents){
                    if(p.left !=null) c.add(p.left);
                    if(p.right !=null) c.add(p.right);
                }
            }
        }

        return  r;
    }


    private static  int findHEightOfATreeRecursivey(TNode root){
        if(root ==null) return 0;
        int l = findHEightOfATreeRecursivey(root.left);
        int r = findHEightOfATreeRecursivey(root.right);
        return l>r? l+1: r+1;
    }

    private static int findHeightOfATreeNonRecursively(TNode root){
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int count =1;
        while(!q.isEmpty()){
            TNode n = q.remove();
            if(n!=null){
                    if(n.right==null && n.left==null) return count;

                    if(n.left != null) q.add(n.left);
                    if(n.right !=null) q.add(n.right);

            }
            else
            {
                if(!q.isEmpty()){
                    count++;
                    q.add(null);

                }
            }
        }
        return  count;
    }





}
