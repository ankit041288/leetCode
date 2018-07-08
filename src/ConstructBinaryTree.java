public class ConstructBinaryTree {

    public static Node root;

    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4};
        Node root = createBST(a,0,a.length-1);
        printInOrder(root);

    }

   static  Node createBST(int[] arr,int f, int l){
        if(f >l){
            return null;
        }
        int mid = (f+l)/2;
        Node node = new Node(arr[mid]);

        node.left =createBST(arr,f, mid-1);
        node.right = createBST(arr,mid+1,l);
        return node;
    }
    static void printInOrder(Node root){
        if(root == null) return ;
        System.out.println(root.data+" ");
        printInOrder(root.left);
        printInOrder(root.right);
    }


}
