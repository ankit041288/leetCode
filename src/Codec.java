public  class Codec {
    public static void main(String[] args){
        TreeNode n = new TreeNode(0);
        n.left = new TreeNode(1);
        n.right =new  TreeNode(2);
        n.left.left = new TreeNode(3);
        n.left.left.left = new  TreeNode(4);
        Codec c = new Codec();
       // System.out.println(c.serialize(n));
        c.deserialize(c.serialize(n));
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    String del = ",";
    String NN ="X";
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        helper(root);
        return sb.toString();

    }

    public void helper(TreeNode root){
        if(root==null){
            sb.append(NN).append(del);
            return;
        }
        sb.append(root.val).append(del);
        helper(root.left);
        helper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(del);
        return helper_d(arr,0);



    }

    public TreeNode helper_d(String[] arr, int i){
        if(i >= arr.length || arr[i].equals(NN)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        root.left = helper_d(arr,i+1);
        root.right = helper_d(arr,i+2);
        return root;
    }

}