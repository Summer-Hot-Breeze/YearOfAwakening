package algorithms.base.book.two.chapters;

public class BinaryInsertionSort extends Example {
    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable key = a[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (less(a[mid], key)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.arraycopy(a, left, a, left + 1, i - left);
            a[left] = key;
        }
    }

}
