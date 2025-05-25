package algorithms.base.book.two.chapters;

public class Bubble extends Example {
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (less(j + 1, j)) {
                    exch(a, j, j + 1);
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }
}
