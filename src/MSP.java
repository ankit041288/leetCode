import sun.jvm.hotspot.debugger.ppc.PPCThreadContext;

import java.util.*;

public class MSP {


    private static  class Interval {

        int start;

        int end;


        Interval() {
            start = 0;
            end = 0;
        }


        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public void reverseWords(char[] str) {
        int i=0;
        int j=str.length;
        helper(str,0,j-1);
        for(int k=0; k<str.length;k++){
            int x=k;
            while(str[k]!=' '){
                k++;
            }
            helper(str,x,k);
        }



    }
    public void helper(char[] str, int i, int j){
        while(i<j){
            char t = str[i];
            str[i]=str[j];
            str[j]=t;
            i++;
            j--;
        }
    }




    public static final String sep=",";
    public static StringBuilder sb = new StringBuilder();
      public static  class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args){
/*    LNode root = new LNode(-1);
    LNode head = root;
    for(int i=0; i< 10; i++){
        root.next = new LNode(i);
        root = root.next;
    }
    root.next=head;
    //removeAlternateNode(head);
   // getNthFromLast(head,2);
   // hasCycle(head);
      //  MakeTheNumbersMatch(1,1,3,2);
      //  reverseFib(5);
        // checkIfbracketsareBlanced("{a})");
        String[] v = new String[]{"1.0","1.1","1.1.0.2","1.1.1","1.2"};

        SortVersionStrings(v);
        sortVersionWithSplit(v);*/
      //  ("1.1").compareTo("1.1.0.1");
       // minimumDeleteSum("delete","leet");

        //reverseString("helo");
        //moveZeroes(new int[]{0,0,1});
       // myAtoi("   -42");
       // addStrings("9","99");
       // Queue<Integer> a = new LinkedList<>();
        // ArrayList<Integer> b= new ArrayList<>():
/*
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right= new TreeNode(3);
        root.right.right= new TreeNode(10);
        root.left.left=new TreeNode(15);
        serialize(root);
        int[] nums = new int[]{1,1,2};*/
       // char a[][] = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
       // numIslands1(a);
        //mergekArray(a);
       // shiftingLetters("abc", new int[]{3,5,9});
       // maxDistToClosest(new int[]{1,0,0,0});
        //generateMatrix(3);
        //Set<Integer> s = new HashSet<>();
        //reverseVowels("leetcode");
        //divide(-2147483648,-1);
        //int aa =12;
       // canPermutePalindrome("code");
    //    ListNode head = new ListNode(1);
     //   head.next = new ListNode(0);
      //  head.next.next = new ListNode(1);
      //  head.next.next.next=new ListNode(1);
       // isPalindrome(head);
        //countPalindrome("aaa");
       // longestPalindrome("babac");
        //letterCombinations("23");
      //  int[] a1 = new int[]{0,2,1,0,2,1,2,2,0};
      //  sortColors(a1);
        int[][] a2 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        searchMatrix(a2,2);

    //    spiralOrder1(a2);
        //rotate1(a2);
      //  Interval[] m = new Interval[2];
     //   m[0]= new Interval(7,10);
       // m[1]= new Interval(2,8);
      //  canAttendMeetings(m);
        subsets(new int[]{1,2,3});
    }




    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
        helper(nums,0,new ArrayList<>(), res);
        return res;

    }

    public static void helper(int[] nums, int i, List<Integer> path, List<List<Integer>> all){
        all.add(new ArrayList<>(path));
        for(int k=i; k<nums.length;k++){
            path.add(nums[k]);
            helper(nums,i+1,path,all);
            path.remove(path.size()-1);
        }
    }


    private boolean isChangeable(int[] dollars){
          int five=0;
          int ten=0;

          for(int i: dollars){
              if(i==5){
                  five++;
              }
              else if(i==10){
                  if(five==0){
                      return false;
                  }
                  else {
                      five--;
                      ten++;
                  }
              }
              else if(i==20){
                  if(ten>0){
                      ten--;
                      if(five==0) return false;
                      five--;
                  }
                  else if(five>2){
                      five=five-3;
                  }
                  else return false;
              }
          }

          return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs) {
            String sorted = helper(s);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
                map.put(sorted, map.get(sorted));
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }
            List<List<String>> res = new ArrayList<>();
            for(List<String> l: map.values()) res.add(l);

            return res;
        }
        public String helper(String str){
            int[] arr = new int[26];
            for(char c : str.toCharArray()) arr[c-'a']=arr[c-'a']+1;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26 ;i++){
                while(arr[i]>0){
                    sb.append((char)(i+'a'));
                    arr[i]--;
                }
            }
            return sb.toString();
        }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int top =0;
        int down = matrix.length-1;
        int cols = matrix[0].length-1;
        while(top<=down){
            int mid=(top+down)/2;
            if(matrix[mid][0]<=target && matrix[mid][cols]>=target) return helper(mid,matrix,target);
            if(matrix[mid][0]> target){
                down = mid-1;
            }
            if(matrix[mid][0]<target) top = mid+1;
        }

        return false;
    }

    public static boolean helper(int row, int[][] m, int target){
        int left =0;
        int right = m[0].length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(m[row][mid]==target) return true;
            if(m[row][mid]<target) left =mid+1;
            if(m[row][mid]>target) right=mid-1;
        }
        return false;
    }
    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(Interval i : intervals){
            if(map.containsKey(i.start)) map.put(i.start,map.get(i.start)+1);
            else map.put(i.start,1);
            if(map.containsKey(i.end)) map.put(i.end,map.get(i.end)-1);
            else map.put(i.end,-1);
        }
        int localmax=0;
        int max=0;
        for(int i:map.values()){
            localmax = localmax+i;
            max = Math.max(localmax,max);

        }
        return max;


    }



    public static List<Integer> spiralOrder1(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        int left=0;
        int right = matrix[0].length;
        int top=0;
        int bottom=matrix.length;
        int n = (right)*(bottom);
        while(top<bottom && left<right){


            for(int i=left; i<right;i++){
                res.add(matrix[top][i]);
            }
            top++;


            if(res.size()>=n) break;


            for(int i=top; i<bottom; i++){
                res.add(matrix[i][right-1]);
            }
            right--;


            if(top<bottom){
                for(int i=right-1;i>=left;i--){
                    res.add(matrix[bottom-1][i]);
                }
                bottom--;
            }
            if(res.size()>=n) break;
            if(left<right){
                if(res.size()>=n) break;
                for(int i=bottom-1;i>=top;i++){
                    res.add(matrix[left][i]);
                }
                left++;
            }
            if(res.size()>=n) break;


        }

        return res;
    }







    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, Long min, Long max){
        if(root ==null) return true;
        if(root.val<min || root.val>max ) return false;
        return helper(root.left,min, (long) (root.val-1)) && helper(root.right, (long) (root.val+1),max);
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        //buildings are in form [Start,End,height]
        for(int i=0; i<buildings[0].length; i++){
            height.add(new int[]{buildings[i][0],-buildings[i][2]});// Starting height is negative
            height.add(new int[]{buildings[i][1],buildings[i][2]});
        }
        Collections.sort(height,(a,b)->{
            //sort by endpoints or sort by height;
            //Keeping height as minum maxes sure that the
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];

        });
        int prev=0;
        Queue<Integer> q = new PriorityQueue<>((a,b)-> b-a);

        for(int[] h : height){
            //if its a start height
            if(h[1]<0){
                q.offer(-h[1]);
            }
            else
            {
               q.remove(h[1]);
            }
            int curr = q.peek();
            if(curr !=prev){
                res.add(new int[]{h[0],curr});
                prev =curr;
            }
        }
        return res;


    }

    public static  boolean canAttendMeetings(Interval[] intervals) {
          Arrays.sort(intervals,(a,b)-> (a.start-b.start));

        for(int i =0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start) return false;
        }
        return true;

    }
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n/2;i++){
            int start =0+i;
            int end =n-1-i;
            while(start<end){
                int temp=matrix[start][start];
                matrix[start][start] = matrix[start][end-1];
                matrix[start][end-1]=matrix[end-1][end-1];
                matrix[end-1][end-1]=matrix[end-1][start];
                matrix[end-1][start]=temp;
                start++;
                end--;
            }

        }


    }






    public static  void rotate(int[][] matrix) {
        int left=0;
        int right = matrix[0].length;
        int down = matrix.length;
        int top=0;
        while(left<right && top<down){

            for(int i=0; i<=matrix[0].length/2;i++){
                int temp=matrix[top][left];
                matrix[top][left]= matrix[down-1][left];
                matrix[down-1][left]=matrix[down-1][right-1];
                matrix[down-1][right-1]=matrix[top][right-1];
                matrix[top][right-1]=temp;
            }
            left++;
            right--;
            down--;
            top++;

        }

    }



    public static  void sortColors(int[] nums) {
        int l=0;
        int r= nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) {
                nums[i]=nums[l];
                nums[l]=0;
                l++;
                i++;
            }
            if(nums[i]==2){
                nums[i]=nums[r];
                nums[r]=2;
                r--;
            }

        }

    }
    public static  int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static List<String> findWords(char[][] b, String[] words) {
        List<String> res = new ArrayList<>();
        if(b.length ==0) return res;
        Set<String> set = new HashSet<>();
        for(String w : words ){
            for(int i =0; i<b.length; i++){
                for(int j=0;j<b[0].length; j++){
                    if(b[i][j]==w.charAt(0)){
                        if(w.length()==1) set.add(w);
                        else if(helper(b,w,1,i,j,b.length,b[i].length)) {
                            set.add(w);
                            break;
                        }
                    }
                }
            }
        }
        res.addAll(set);

        return res;

    }

    public static  boolean helper(char[][] b,String s, int c, int i, int j, int r, int cols){
        if(c==s.length()-1) return true;
        boolean res =false;
        for(int[] dir : dirs){
            int x= dir[0]+i;
            int y= dir[1]+j;
            if(x<0 ||  y<0 || x>=r || y>=cols || b[x][y]!=s.charAt(c)) return false;
            b[i][j]='\0';
            res= true && helper(b,s,c+1,x,y,r,cols);
        }
        b[i][j]=s.charAt(c);

        return res;
    }


    static String  map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        helper(res,new StringBuilder(),digits,0);
        return res;

    }

    public static void helper(List<String> res, StringBuilder sb, String digits, int n){
        if(n==digits.length()){
            res.add(sb.toString());
        }
        else {
            String str = map[digits.charAt(n)-'0'];
            for(char c : str.toCharArray()){
                sb.append(c);
                helper(res,sb,digits,n+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static String   res = new String();
    public static String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            helper(s,i,i);
            helper(s,i,i+1);

        }
        return res;
    }

    public static void helper(String s, int i, int j){
        while(i>=0 && j < s.length() && s.charAt(i)== s.charAt(j)){
            if((res.length()-1) < ((j+1)-i)) res = s.substring(i,j+1);
            i--;
            j++;
        }
    }

    public static int countPalindrome(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++) {
            res +=expand(s,i,i);
            res +=expand(s,i,i+1);
        }
        return res;
    }
    public static int expand(String s, int i, int j){
        int r=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            r++;
            i--;
            j++;
        }
        return r;
    }



    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev =null;
        ListNode t=null;
        while(fast !=null && fast.next !=null){
            fast=fast.next.next;
            t = slow.next;
            slow.next = prev;

            prev =slow;
            slow=t;

        }
        if(fast!=null) slow =slow.next;
        while(prev !=null || slow !=null){
            if(prev.val !=slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        if(slow !=null || prev !=null) return false;
        return true;



    }


    public static boolean canPermutePalindrome(String s) {
        int odd=0;
        if(s.length()>=0) return true;
        int[] a = new int[256];
        for(int i =0; i < s.length();i++){
            int index = s.charAt(i);
            a[index]++;
            if(a[index]%2!=0) {
                odd++;
            }else {
                odd--;
            }
        }
        return odd>1?false:true;


    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] v = new int[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        v[0]=1;
        q.offer(0);
        while(!q.isEmpty()){
            int l = q.poll();
            for(int i:rooms.get(l)){
                if(v[i]!=1){
                    v[i]=1;
                    q.offer(i);
                }

            }
        }
        for(int i =0; i<v.length;i++){
            if(v[i]==0) return false;
        }
        return true;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return helper(0,graph,new ArrayList<>(),new ArrayList<>());
    }

    public List<List<Integer>> helper(int l,int[][] graph, List<List<Integer>> out, List<Integer> path){
        path.add(l);
        if(l==graph.length-1) out.add(path);
        else{
            for(int i =0; i<graph[l].length;i++){
                helper(graph[l][i],graph,out,path);
            }
        }
        return out;
    }


    public static int numIslands1(char[][] grid) {
        if(grid.length==0) return 0;
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid= helper(grid,i,j);
                    count++;
                }

            }
        }
        return count;
    }

    public static char[][] helper(char[][] grid, int i,int j){
        int r= grid.length;
        int m=grid[0].length;
        for(int[] d:dirs){
            int x=d[0]+i;
            int y=d[1]+j;
            if(x<0 || y<0 || x>=r || y>=m || grid[x][y]==0) continue;
            if(grid[x][y]=='1'){
                grid[x][y]='0';
                helper(grid,x,y);
            }

        }
        return grid;

    }

    public static  int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        boolean sign =((dividend<0 && divisor>0) ||(dividend>0 && divisor<0));
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        int i=0;
        if(d2==1) return (int) (sign?-d1:d1);
        while(d1>d2){
            d1= d1-d2;
            i++;
        }
        if(d1  > (d2/2)) i++;
        return sign?-i:i;

    }

    public static String reverseVowels(String s) {
        Set<Character> v= new HashSet<>();
        v.add('a');v.add('e');v.add('i');v.add('o');v.add('u');
        int i=0;
        int j=s.length()-1;
        char[] arr = s.toCharArray();
        while(i<=(j/2)){
            if(v.contains(arr[i]) && v.contains(arr[j])){
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
                continue;
            }
            if(!v.contains(arr[i])){
                i++;
            }
            if(!v.contains(arr[j])){
                j--;
            }
        }
        return new String(arr);

    }



    static int[][]  d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static boolean exist(char[][] board, String word) {
        char i = word.charAt(0);

        for(int j=0; j<board.length;j++){
            for(int k=0; k<board[0].length;k++){
                if(board[j][k]==i){
                    if(word.length()==1){
                        return true;
                    }
                    if( helper( board,word,j,k,1)) return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int x1, int y1, int c){
        int r=board.length-1;
        int c1=board[0].length-1;
        for(int[] dir : d){
            int x,y;
            x=x1+dir[0];
            y=y1+dir[1];
            if(x<0 || x>r || y<0 || y>c1 || word.charAt(c)!=board[x][y]) continue;
            else if(board[x][y]==word.charAt(c)){
                board[x][y]='\0';
                c++;
                if(c==word.length()-1) return true;
                return true && helper(board,  word,  x,  y,  c);
            }

        }
        return false;
    }




    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l=0;
        int r =n;
        int b=n;
        int t=0;
        int c=1;
        int e =n*n;
        while(l<r && t<b){
            for(int i=l;i<r;i++){
                matrix[t][i]=c;
                c++;
            }
            t++;
            if(c>e) break;

            for(int i=t;i<b;i++){
                matrix[i][r-1]=c;
                c++;
            }
            r--;

            if(c>e) break;

            if(l<r){
                for(int i=r-1;i>=l;i--){
                    matrix[b-1][i]=c;
                    c++;
                }
                b--;
            }
            if(c>e) break;



            if(t<b)
            {
                for(int i=b-1; i>=t;i++){
                    matrix[i][l]=c;
                    c++;
                }
                l++;

            }
            if(c>e) break;

        }
        return matrix;

    }


    public static  int maxDistToClosest(int[] seats) {
        int[] fb = new int[seats.length];
        if(seats[0]==0) {fb[0]=1;}
        else fb[0]=-1;
        if(seats[seats.length-1]==0){fb[seats.length-1]=1;}
        else fb[seats.length-1]=-1;

        for(int i=1; i<seats.length;i++){
            int k=i;
            while(k>=0){
                if(seats[k]==0) fb[k]=fb[k-1]+1;
                else fb[k]=-1;
                k--;
            }
        }
        int max =0;
        for(int i=seats.length-2; i>=0;i--){
            int k=i;
            while(k<seats.length-1){
                if(seats[k]==0)
                {fb[k]=(fb[k]<(fb[k+1]+1)?fb[k]:(fb[k+1]+1));
                    if(max<fb[k]){
                        max=fb[k];
                    }}
                else fb[k]=-1;
                k++;
            }
        }
        return (max>fb[seats.length-1]?max:fb[seats.length-1])+1;

    }

    public static  String shiftingLetters(String S, int[] shifts) {
        Long[] shiftsL=new Long[shifts.length];
        shiftsL[0]=Long.valueOf(shifts[0]);
        for(int j=1; j<shiftsL.length;j++){
            int k=j-1;
            while(k>=0){
                shiftsL[k]=Long.valueOf(shiftsL[k])+Long.valueOf(shifts[j]);
                k--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length();i++){
            Long a = Long.valueOf(S.charAt(i)-'a');
            char c =(char) ('a'+((a+shiftsL[i])%26));
            sb.append(c+"");
        }
        return sb.toString();
    }

    public static  int numIslands(char[][] grid) {
        int count=0;
        int[] v = new int[(grid.length>grid[0].length?grid.length:grid[0].length)];
        for(int i=0; i< v.length; i++){
            if(v[i]==0){
                for(int j=0; j<grid.length; j++){
                    if(grid[i][j]=='1'){
                        v=bfs(grid,v,i);
                        count++;
                        break;
                    }
                }
            }
        }
        return count;

    }
    public static  int[] bfs(char[][] a, int[] v, int s){
        v[s]=1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int l = q.poll();
                for(int i=0;i<a[0].length;i++ ){
                if(a[l][i]=='1' && v[i]==0){
                    v[i]=1;
                    q.offer(i);
                }
            }
        }
        return v;
    }









    public static int[] mergekArray(int[][] a){
          int[] res = new int[a.length*a[0].length];
          int i=0;
          Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
              @Override
              public int compare(Integer i, Integer j){
                  return i-j;
              }
          });
          for (int k=0; k <a[0].length;k++){
              for(int l=0; l<a.length;l++){
                  q.offer(a[l][k]);
              }


          }
        while(!q.isEmpty()){
            res[i]=q.poll();
            i++;
        }

          return res;
      }













    public static int removeDuplicates(int[] nums) {
        int length =0;
        int i=0;
        for( i=0; i < nums.length-1; i++){
            if(nums[i]==nums[i+1]){}
            else {nums[length]=nums[i];length++; };
        }
        if(nums[i-1]!=nums[i]){nums[length]=nums[i];length++;}
        return length;

    }

    public static String serialize(TreeNode root) {
        sHelper(root);
        return sb.toString();

    }
    public static void sHelper(TreeNode root){
        if(root ==null){sb.append("X").append(sep); return ;}
        sb.append(root.val).append(sep);
        sHelper(root.left);
        sHelper(root.right);
    }



    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        boolean zig = false;
        while(curr.size()>0){
            zig = zig==true? false : true;
            List<Integer> local = new ArrayList();
            for(TreeNode n : curr){
                local.add(n.val);
            }
            result.add(local);
            List<TreeNode> parents = new ArrayList<>();
            parents.addAll(curr);
            curr = new ArrayList<>();
            for(TreeNode n : parents){
                if(zig ==true){
                    if(n.right !=null) curr.add(n.right);
                    if(n.left !=null) curr.add(n.left);

                }else if (zig==false) {
                    if(n.left !=null) curr.add(n.left);
                    if(n.right !=null) curr.add(n.right);


                }

            }
        }
        return result;

    }



    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.add(null);
        List<Integer> parents = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode l = q.poll();
            if(l !=null){
                parents.add(l.val);
               if(l.left!=null) q.offer(root.left);
               if(l.right!=null) q.offer(root.right);

            }else {
                if(!q.isEmpty() && q.peek()!=null) {
                    q.add(null);
                    result.add(parents);
                    parents = new ArrayList<>();
                }

            }
        }
        result.add(parents);
        return result;

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        int left=0;
        int right = matrix[0].length;
        int top=0;
        int bottom=matrix.length;
        int n = (right-1)*(bottom-1);
        while(top<bottom && left<right){
            for(int i=left; i<right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(res.size()>=n) break;
            for(int i=top; i<bottom; i++){
                res.add(matrix[right-1][i]);
            }
            right--;
            if(top<bottom){
                for(int i=right-1;i>=left;i--){
                    res.add(matrix[bottom-1][i]);
                }
                bottom--;
            }
            if(res.size()>=n) break;
            if(left<right){
                if(res.size()>=n) break;
                for(int i=bottom-1;i>=top;i++){
                    res.add(matrix[left][i]);
                }
                left++;
            }
            if(res.size()>=n) break;


        }

        return res;
    }

    public  static String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j = num2.length()-1;
        int carry=0;
        String res ="";
        while(i>=0 || j >=0){
            int a=0;
            int b=0;
            if(j<0)  b =0;
            else b = Integer.parseInt(num2.charAt(j)+"");

            if(i<0)  a =0;
            else a = Integer.parseInt(num2.charAt(j)+"");
            int sum = a+b+carry;
            if (sum >= 10) carry =1; else carry =0;
            sum = sum%10;
            res = sum+res;
            i--;
            j--;
        }
        if(carry!=0) res = carry+res;

        return res;
    }



    public static  int myAtoi(String str) {
        str.trim();
        String[] arr=str.trim().split(" ");
        if(arr.length>0){
            if(arr[0].matches("^-?\\d+")){
                Double d = Double.parseDouble(arr[0]);
                if(d<Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if(d>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
                return Integer.parseInt(arr[0]);

            }
        }
        return 0;
    }
    public static String reverseString(String s) {
        char[] a = s.toCharArray();
        for(int i=0; i < a.length/2; i++){
            char temp = a[a.length-1-i];
            a[a.length-1-i]=a[i];
            a[i]=temp;
        }
        return new String(a);
    }


    public static void moveZeroes(int[] nums) {
        int z=0;
        for(int i=0; i < nums.length ; i ++){
            if (nums[i]==0){
                z++;
                for(int j=i; j<nums.length-z;j ++){
                    nums[j]=nums[j+1];
                }

            }
        }
        for(int k=nums.length-1; z>0; k--){
            nums[k]=0;
            z--;
        }

    }




    public int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        for(int i =0; i< nums.length -1 ; i++){
            for( int j=i+1; j<nums.length ; j++){
                if(nums[i]+nums[j]==target) {re[0]=i; re[1]=j; return re;};
            }
        }
        return re;
    }

    public static int minimumDeleteSum(String s1, String s2) {
        Map<Character,Integer> m1 = new HashMap<>();
        for(int i=0; i < s1.length(); i++){
            Character c = s1.charAt(i);
            if(m1.containsKey(c)) m1.put(c, m1.get(c)+1);
            else m1.put(c,1);
        }
        for(int i=0; i < s2.length(); i++){
            Character c = s2.charAt(i);
            if(m1.containsKey(c)) m1.put(c, m1.get(c)-1);
            else m1.put(c,1);
        }
        int res =0;

        for(Map.Entry<Character,Integer> entry:m1.entrySet() ){
            if(entry.getValue()>0) res = res + entry.getValue()* entry.getKey();
        }

    return res;
    }

    public static LNode removeAlternateNode(LNode head){
        LNode prev = head;
        LNode next = head.next;

        while(prev !=null && next !=null){
            prev.next = next.next;
            prev=next.next;
            if(prev !=null)
            next = prev.next;
        }

        return head;
    }


    public static LNode getNthFromLast(LNode head, int n) {
        LNode PTemp = head;
        LNode nth = null;
        for (int i = 1; i < n; i++) if (PTemp != null) PTemp = PTemp.next;
        while (PTemp != null) {
            if (nth == null) nth = head;
            else {
                nth = nth.next;
            }
            PTemp = PTemp.next;

        }
        if (nth != null) return nth;
        return null;
    }

    public static boolean hasCycle(LNode head){
        if(head==null) return false;
        LNode slow = head;
        LNode fast = head;
        while (slow !=null && fast !=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.data == fast.data) return true;
        }
        return false;
    }

    public static void reverseFib(int n){
        int[] a = new int[n];
        a[0]=0;
        a[1]=1;
        for (int i=2; i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        for(int j=n-1; j>=0; j--){
            System.out.println(a[j]+" ");
        }
    }

    public static void MakeTheNumbersMatch(int a, int b, int x, int y)
    {
        while(a!=x && b!=y)
        {
            if(a> x)
            {
                a--;
            }
            else
            {
                a++;
            }
            if(b>y)
            {
                b--;
            }
            else
            {
                b++;
            }
        }
        System.out.println(" a= "+a+"; x="+x+"b="+b+"; y="+y);
    }

    /** This call will check if the brackets in string are balanced
     * Run time complexity : Big-O(n) (n is length of input)
     * example :
     *      input :"{[(()]}"
     *      output: false
     *
     * @param input the string to be checked
     * @return A Boolean
     */

    public static boolean checkIfbracketsareBlanced(String input){
        Stack<Character> stack = new Stack<Character>();
        //initializing place holer for open brackets
        Set<Character> open= new HashSet<>(Arrays.asList('{','(','['));
        //Creating hashmap with closing bracket as key and respective open bracket
        Map<Character,Character> p = new HashMap<Character, Character>(){{put('}','{');
                                                    put(')','(');
                                                    put(']','[');
                                                    }};
        for(int i=0; i<input.length(); i++){
            Character n = input.charAt(i);
            //Checking is the character is one of the open character.If yes then pushing it to stack.
            if(open.contains(n)) stack.push(n);
            //else if checking if its closing character. If yes we will pop the stack and see if the popped element matches.
            else if (p.containsKey(n)){
                if(stack.isEmpty()) return false;
                if(stack.pop().equals(p.get(n))) ;
                else return false;

            }
        }
        return true;
    }


    public static void hashMapIterator(HashMap a){
        Map<String,String> ab = new HashMap<>();

        for(Map.Entry<String,String> entry: ab.entrySet()){

        }

    }



    public static String[] SortVersionStrings(String[] arr){
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Scanner s1 = new Scanner(o1);
                Scanner s2 = new Scanner(o2);
                s1.useDelimiter("\\.");
                s2.useDelimiter("\\.");
                while(s1.hasNextInt() && s2.hasNextInt()){
                    int v1= s1.nextInt();
                    int v2 = s2.nextInt();
                    if(v1>v2) return 1;
                    else if (v1<v2) return -1;
                }
                if(s1.hasNextInt()) return 1;
                return 0;
            }
        });
        return arr;
    }

    /** Following method sorts versions in descending order
     * Run time complexity : Big-O(n*m) where n are the number of elements in input array and m is max length of version
     * example :
     *      input :{"1.1","2.1","1.3"}
     *      output: {"2.1","1.3","1.1"}
     *
     * @param arr Input version string array
     * @return sorted array of version string
     */

    public static String[] sortVersionWithSplit(String[] arr){
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1= o1.split("\\.");
                String[] s2 = o2.split("\\.");
                int i=0;
                while(i<s1.length && i<s2.length){
                    if(Integer.parseInt(s1[i])<Integer.parseInt(s2[i])) return 1;
                    else if (Integer.parseInt(s1[i])>Integer.parseInt(s2[i])) return -1;
                i++;
                }
                if(i<s1.length-1) return 1;
                return 0;
            }
        });

        return arr;
    }


}
