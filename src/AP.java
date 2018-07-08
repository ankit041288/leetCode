import com.sun.applet2.AppletParameters;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

public class AP {

    public class test {
        private String page;
        private float per_page;
        private float total;
        private float total_pages;
        ArrayList < Object > data = new ArrayList < Object > ();


        // Getter Methods

        public String getPage() {
            return page;
        }

        public float getPer_page() {
            return per_page;
        }

        public float getTotal() {
            return total;
        }

        public float getTotal_pages() {
            return total_pages;
        }

        // Setter Methods

        public void setPage(String page) {
            this.page = page;
        }

        public void setPer_page(float per_page) {
            this.per_page = per_page;
        }

        public void setTotal(float total) {
            this.total = total;
        }

        public void setTotal_pages(float total_pages) {
            this.total_pages = total_pages;
        }
    }
    public static  class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) throws IOException {
/*        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        inorderSuccessor(n,n);
        n.left.left = new TreeNode(4);
        n.right = new TreeNode(3);
        sumNumbers(n);
        Stack<Integer> s = new Stack<>();*/

       // findRepeatedDnaSequences("AAAAAAAAAAA");
       // threeSum(new int[]{-1,1,0,-2,2,});
/*        List<String> word = new ArrayList<>();
        word.add("hot");
        word.add("dot");
        word.add("dog");
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        findTarget(root,6);

      //  sumNumbers1(root);
      //  findLadders("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","lot","log","cog")));
       // findAnagrams("efg","abc");


       // getMovieTitles("spiderman");

        //reductionCost(new int[]{1,2,3});
        //reflectString("ab");
        //search(new int[]{1,3},3);
        //productExceptSelf(new int[]{2,3,4,5});

        //findAnagrams1("baa","aa");
        Trie t = new Trie();
        t.insert("ab");
        t.insert("acb");
        t.insert("abq");
        t.getAllWithPrefix("a");
    }



    public static  List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length()) return res;
        int[] arr = new int[26];
        int n = p.length();
        int diff = n;
        for(char c : p.toCharArray()) arr[c-'a']++;
        for(int i =0 ; i< n ; i++){
            char c = s.charAt(i);
            if(arr[c-'a']>0){
                 diff--;
            }
            arr[c-'a']--;

        }
        if(diff==0) res.add(0);
        int i=0;
        int j =n;
        while(j<s.length()){
            char c = s.charAt(i);
            if(arr[c-'a']>=0) {
                diff++;
            }
            arr[c-'a']++;
            i++;
            c = s.charAt(j);
            arr[c-'a']--;
            if(arr[c-'a']>=0) {
                 diff--;
            }
            if(diff==0) res.add(i);
            j++;

        }
        return res;

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        leftProduct[0]=1;

        int[] rightProduct = new int[nums.length];
        rightProduct[rightProduct.length-1]=1;


        for(int i =1; i <nums.length; i ++){
            leftProduct[i]=nums[i-1]*leftProduct[i-1];
        }


        for(int i = rightProduct.length-2; i >=0; i--){
            rightProduct[i]= rightProduct[i+1]* nums[i+1];
        }

        for(int i =0; i <leftProduct.length;i++){
            leftProduct[i]= leftProduct[i]*rightProduct[i];
        }
        return leftProduct;


    }

    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                pq.offer(new int[]{i,j,forest.get(i).get(j)});
        int[] start = new int[]{0,0};
        int res=0;
        while(!pq.isEmpty()){
            int[] end = pq.poll();
            int sl = helper(forest,start,end,n,m);
            if(sl==-1) return -1;
             res = res + sl;
            start[0]=end[0];
            start[1]=end[1];

        }
        return res;
    }
    public int helper(List<List<Integer>> forest, int[] start,int[] end, int n, int m){
        int step=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int[][] v = new int[n][m];
        v[start[0]][start[1]] = 1;
        while(!q.isEmpty()){
            int count = q.size();
            for( int i=0; i <count ; i ++){
                int[] l = q.poll();
                for(int[] d: dir){
                    int li = l[0]+d[0];
                    int lj= l[1]+d[1];
                    if(li<0 || lj<0 || li>=n || lj>=m ||v[li][lj]==1 ||forest.get(li).get(lj)==0) continue;
                    q.offer(new int[]{li, lj});
                    v[li][lj]=1;
                }


            }
            step++;
        }
        return step;
    }





    public static  int search(int[] nums, int target) {
        int i =0;
        int j =nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]==target) return mid;
            else if ( nums[mid]>nums[j] && nums[mid]>=target) i = mid+1;
            else j = mid-1;
        }
        return -1;

    }


    public static boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        Set<Integer> set = new HashSet<>();
        while(!s.isEmpty()|| root !=null){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            if(s.contains(k-root.val)) return true;
            set.add(root.val);
            root = root.right;
        }
        return false;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int[] nums, int start, int end){
        int max =start;
        for(int i=start+1; i<=end; i++){
            if(nums[i]>nums[max])   max = i;
        }
        TreeNode root= new TreeNode(nums[max]);
        root.left = helper(nums,max+1,end);
        root.right = helper(nums,start,max-1);
        return root;
    }


    static String reflectString(String inputString) {
        char[] arr = inputString.toCharArray();
        for(int i =0; i<arr.length; i++){
            int a =25- (arr[i]-'a');
            arr[i]= (char) (arr[i]+(a));
        }
        return new String(arr);
    }




    public static  int sumNumbers1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root ==null) return 0;
        StringBuilder sb = new StringBuilder(root.val);
        helper1(root,sb,paths);
        int res = 0;
        for(String s : paths) res = res + Integer.parseInt(s);
        return res;

    }

    public static  void helper1(TreeNode curr, StringBuilder sb, List<String> p){
        if(curr.left ==null && curr.right ==null) p.add(new String(sb));
        if(curr.left !=null){
            sb.append(curr.left.val);
            helper1(curr.left,sb,p);
            sb.setLength(sb.length()-1);
        }
        if(curr.right !=null){
            sb.append(curr.right.val);
            helper1(curr.right,sb,p);
            sb.setLength(sb.length()-1);
        }
    }

    static String[] getMovieTitles(String substr) {

        TreeSet<String> set= new TreeSet<String>();
        try {
            String base_url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
            URL url = null;
            try {
                url = new URL(base_url + substr);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                con.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuffer content = new StringBuffer();
            String inputLine = "";
            while ((inputLine = in.readLine()) != null) content.append(inputLine);

            in.close();
            String contentStr = content.toString();
            int pages = Integer.parseInt(contentStr.split("total_pages")[1].split(":")[1].split(",")[0]);


            String[] title_raw = contentStr.split("Title");
            for (int i = 1; i < title_raw.length; i++) {
                String l = title_raw[i];
                set.add(l.split(":")[1].split(",")[0].replace("\"", ""));
            }

            while (pages > 1) {
                url = new URL(base_url + "substr" + "&page=" + pages);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                content = new StringBuffer();
                inputLine = "";
                while ((inputLine = in.readLine()) != null) content.append(inputLine);

                in.close();
                contentStr = content.toString();
                title_raw = contentStr.split("Title");
                for (int i = 1; i < title_raw.length; i++) {
                    String l = title_raw[i];
                    set.add(l.split(":")[1].split(",")[0].replace("\"", ""));
                }
                pages--;
            }



        } catch (Exception e) {
            e.printStackTrace();

        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String t : set) {
            res[i] = t;
            i++;
        }
        return res;
    }






    static int reductionCost(int[] num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        int cost=0;
        for(int i : num) pq.offer(i);
        while(!pq.isEmpty() && pq.size()>1){
            int l = pq.poll();
            int l2 = pq.poll();
            int n =l+l2;
            pq.offer(n);
            cost=cost+n;
        }
        int l4=0;
        if(!pq.isEmpty()){
            l4 = pq.poll();
        }

        return cost+l4;
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++) map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for(Map.Entry<Character,Integer> entry: map.entrySet()) pq.offer(entry);
        char[] arr = new char[s.length()];
        int j=0;
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            char c = entry.getKey();
            int n = entry.getValue();
            while(n>0){
                arr[j]=c;
                j++;
                n--;
            }
        }
        return new String(arr);

    }

    public static  List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }


    public  static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> w = new HashSet<>(wordList);
        HashMap<String,Integer> d = new HashMap<>();
        List<String> localSolution = new ArrayList<>();
        HashMap<String,List<String>> graph = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        bfs(beginWord,endWord,graph,w,d);
        dfs(beginWord,endWord,graph,d,localSolution,result);
        return result;

    }



    public static void dfs(String s, String e,HashMap<String,List<String>> g, HashMap<String,Integer>d,List<String> solution,List<List<String>> res){
        solution.add(s);
        if(e.equals(s)) res.add(new ArrayList<>(solution));
        else {
                for(String s1: g.get(s)){
                    if(d.get(s1)==d.get(s)+1){
                        dfs(s1,e,g,d,solution,res);
                    }

                }
        }
        solution.remove(solution.size() - 1);
    }




    public static  void bfs(String s, String e, HashMap<String,List<String>> g, Set<String> w, HashMap<String,Integer>d ){
        Queue<String> q = new LinkedList<>();
        boolean found = false;
        q.offer(s);
        d.put(s,0);
        while(!q.isEmpty()) {
            int count = q.size(); // Process one level at a time
            for (int i = 0; i < count; i++) {
                String l = q.poll();
                List<String> nList = findNext(w, l);
                g.put(l, new ArrayList(nList)); //Creating adj list graph rep
                int localDistance = d.get(l);
                for (String n : nList) {
                    if (!d.containsKey(n)) {
                        d.put(n, localDistance + 1); //Make sure not to override shortest distance
                        if (n.equals(e)) found = true;
                        else q.offer(n);
                    }
                }
                if(found) break;
            }

        }
    }



    public static List<String> findNext(Set<String> w, String s){
        char[] arr = s.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i=0; i < s.length(); i++){
            for(char c='a'; c<='z'; c++){
                if (arr[i] == c) continue;
                char temp = arr[i];
                arr[i]=c;
                if(w.contains(new String(arr))){
                    res.add(new String(arr));
                }
                arr[i]=temp;
            }
        }
        return res;
    }








    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root ==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.offer(root);
        cols.offer(0);
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        while(!q.isEmpty()){
            int l = cols.poll();
            TreeNode ln = q.poll();
            if(map.containsKey(l)) map.get(l).add(ln.val);
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(ln.val);
                map.put(l,newList);
            }
            if(ln.left!=null){
                q.offer(ln.left);
                cols.offer(l-1);
            }
            if(ln.right!=null){
                q.offer(ln.right);
                cols.offer(l+1);
            }

        }
        for(List<Integer> list: map.values()) res.add(list);
        return res;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        int level=1;
        q.add(beginWord);
        q.add(null);
        Set<String> words= new HashSet<>(wordList);
        while(!q.isEmpty()){
            String s1 = q.poll();
            if(s1 !=null){
                if(s1.equals(endWord)) return level;
                char[] curr = s1.toCharArray();
                for(int i=0;i<curr.length; i++){
                    for(char c='a'; c<='z'; c++){
                        char temp = curr[i];
                        curr[i]=c;
                        String changedCurr = new String(curr);
                        if(words.contains(changedCurr)){
                            q.offer(changedCurr);
                            words.remove(changedCurr);

                        }
                        curr[i]=temp;
                    }
                    q.offer(null);
                }
            }
            else {
                level++;
            }
        }
        return 0;

    }


    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return res;

    }



    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String>  set = new HashSet<>();
        int i=0; int j=10;
        while(j<s.length()){
            if(s.indexOf(s.substring(i,j+1),j+1)!=-1){
                j++;
            }else{
                if(s.substring(i,j).length()==10) set.add(s.substring(i,j));
                i++;
            }
        }
        List<String> sl = new ArrayList<>();
        for(String s1: set) sl.add(s1);
        return sl;

    }





    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        boolean f= false;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        s.push(root);
        while(!s.isEmpty()){
            curr=s.pop();
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            TreeNode local = s.pop();
            if(f) return local;
            if(local.val==p.val) f=true;
            if(local.right!=null) s.push(local.right);

        }
        return null;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int k1=0;
        for(int i=0; i <nums.length;i++ ){
            while(!d.isEmpty() && d.peek()<i-k+1){
                d.pollFirst();
            }
            while (!d.isEmpty() && nums[d.peekLast()]<nums[i]){
                d.pollLast();
            }
            d.offer(i);
            if(i>=k-1){
                res[k1]=nums[d.peek()];
                k1++;
            }
        }


        return res;
    }







    public static int sumNumbers(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        if(root==null) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        helper(root,sb,path);
        int res=0;
        for(int i : path) res = res+i;
        return res;

    }
    public static void helper(TreeNode root, StringBuilder sb,List<Integer> path ){
        if(root.left==null && root.right ==null) path.add(Integer.parseInt(sb.toString()));
        if(root.left!=null){
            sb.append(root.left.val);
            helper(root.left,sb,path);
            sb.setLength(sb.length()-1);
        }
        if(root.right!=null){
            sb.append(root.right.val);
            helper(root.right,sb,path);
            sb.setLength(sb.length()-1);
        }
    }
}
