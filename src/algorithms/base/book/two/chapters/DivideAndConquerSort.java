package algorithms.base.book.two.chapters;

public class DivideAndConquerSort extends Example {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        mergeSort(a, 0, a.length - 1);
    }

    public void mergeSort(Comparable[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }

    }

    public void merge(Comparable[] a, int left, int mid, int right) {
        Comparable[] temp = new Comparable[right - left + 1];
        int k = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (less(a[i], a[j])) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }


        System.arraycopy(temp, 0, a, left, temp.length);

    }

    public void sortBu(Comparable[] a){
        if (a == null || a.length == 0) {
            return;
        }

        int N=a.length;
        for (int sz=1;sz<N;sz*=2){
            for (int lo=0;lo<N-sz;lo+=sz*2){
                int mid=lo+sz-1;
                int high= Math.min(lo + sz + sz - 1, N - 1);
                merge(a,lo,mid,high);
            }
        }
    }
}
