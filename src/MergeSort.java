public class MergeSort {

    public static int[] mergeSort(int[] a, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,r);
            merge(a,l,mid,r);
        }
        return a;
    }

    public static void merge(int[] a, int l, int m, int r){
        int n1 = m-l+1;
        int n2= r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        int i,j,k;
        i=0;j=0;
        k=l;

        for(int n=0; n<n1;n++) L[n]=a[l+n];

        for(int o=0; o<n2;o++) R[o]=a[m+1+o];

        while(i<n1 && j <n2){
            if(L[i]<=R[j]){
                a[k]=L[i];
                i++;
            }
            else
            {
                a[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=R[j];
            k++;
            j++;
        }
    }
}
