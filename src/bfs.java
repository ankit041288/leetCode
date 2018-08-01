import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {
    public static void main(String[] args){
        int[][] p = new int[][]{{1,0},{0,1}};
        canFinish(2,p);

    }
    public static  boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] v = new int[numCourses];
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0; i < numCourses; i ++) g.add(new ArrayList<>());
        for(int[] c : prerequisites){
            g.get(c[0]).add(c[1]);
        }
        for(int[] c : prerequisites)
            if(v[c[0]]==0) if(!bfs(g,c[0],v)) return false;

        return true;

    }
    public static  boolean bfs(List<List<Integer>> g , int i1, int[] v ){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i1);
        v[i1]=1;
        while(!q.isEmpty()){
            int l = q.poll();
            for(int i : g.get(l)){
                if(v[i]==1) return false;
                q.add(i);
                v[i]=1;
            }
        }
        return true;
    }

}
