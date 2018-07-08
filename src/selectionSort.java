public class selectionSort {

    public static int[] sSort(int[] arr){
        for(int pass=0; pass<arr.length;pass++){
            int min = pass;
            for(int i=pass+1; i<arr.length;i++){
                if(arr[i]<arr[min]){
                    min=i;
                }

            }
            int temp =arr[min];
            arr[min]=arr[pass];
            arr[pass]=temp;

        }
        return arr;
    }
}
