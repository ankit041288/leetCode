public class Heap {
    private int[] arr;
    private int count;
    private int max_size;

    Heap(int size){
        this.max_size = size;
        arr = new int[this.max_size];
        this.count=0;
    }

    private int getParent(int i ){
        if(i>=count) return -1;
        else return (i-1)/2;
    }

    private int getLeftChild(int i ){
        if(i>=count) return -1;
        else return i*2+1;
    }

    private int getRightChild(int i){
        if(i>=count) return -1;
    else return  i*2+2;
    }


    public void add(int i){
        if(count+1 == max_size) return;
        else {
            int pa= count-1;
            while(pa>=0 && this.arr[getParent(pa)]>i){
                arr[i]= arr[getParent(pa)];
                pa=getParent(pa);
            }
            arr[pa]=i;
        }
        count++;
    }

    public int percolateDown(int i ){
        int l,r,ma,temp;

         l = getLeftChild(i);
         r=getRightChild(i);

         if(l!=-1 && arr[l]>arr[i]){
             ma=l;
         }
         else ma=i;
         if(r!=-1 && arr[r]>arr[i]) ma=r;

         if(ma!=i){
              temp = arr[ma];
             arr[ma]=arr[i];
              arr[i]=temp;

         }
         percolateDown(ma);

return 0;
    }

}
