package algorithms.base.book.two.chapters;

public class Selection extends Example {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            if (i != min) {
                exch(a, i, min);
            }
        }
    }
}
