package algorithms.base.book.two.chapters;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort extends Example {
    @Override
    public void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a, lo, partition-1);
        sort(a, partition + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable comparable = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (less(a[++left], comparable)) {
                if (left == hi) {
                    break;
                }
            }
            while (less(comparable, a[--right])) {
                if (right == lo) {
                    break;
                }
            }

            if(left>=right){
                break;
            }

            exch(a, left, right);
        }

        exch(a, lo, right);

        return right;

    }

    private void shuffle(Comparable[] a) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            exch(a, i, j);
        }
    }

}
