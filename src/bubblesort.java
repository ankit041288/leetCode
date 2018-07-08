 class bubblesort {

    public static   int[] bSort(int[] a){
        for(int pass=a.length-1; pass>=0; pass--){
            for(int i=0; i<=pass-1;i++){
                if(a[i]>=a[i+1]){
                    int temp = a[i];
                    a[i]= a[i+1];
                    a[i+1]=temp;
                }
            }
        }
        return a;
    }



    public static int[] opBSort(int[] a){
        boolean swapped =true;

        for(int pass= a.length-1; pass>=0 && swapped; pass--){
            swapped = false;
            for(int i=0; i<=pass-1; i++){
                if(a[i]>=a[i+1]){
                    int temp = a[i];
                    a[i]= a[i+1];
                    a[i+1]=temp;
                    swapped=true;
                }
            }
        }
        return a;
    }
}
