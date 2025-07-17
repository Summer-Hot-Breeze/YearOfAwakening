package algorithms.base.book.two.chapters;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort extends Example {

    private static final int OFF_SET = 10;

    @Override
    public void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //对于小数组而言，插入排序比快速排序更快
        if (hi - lo <= OFF_SET) {
            Insertion insertion = new Insertion();
            insertion.sort(a);
            return;
        }
        //找出左中右的中位数,三样取中法
        medianOfThree(a,lo,hi);
        int partition = partition(a, lo, hi);
        sort(a, lo, partition - 1);
        sort(a, partition + 1, hi);
    }

    private Comparable medianOfThree(Comparable[] a, int lo, int hi) {
        //找出左中右的中位数,三样取中法
        int mid=lo+(hi-lo)/2;

        if(less(a[hi],a[lo])){
            exch(a, lo, hi);
        }
        if(less(a[hi],a[mid])){
            exch(a,mid,hi);
        }
        if(less(a[mid],a[lo])){
            exch(a,mid,lo);
        }

        exch(a,lo,mid);
        return a[lo];
    }

    private void sort3way(Comparable[] a, int lo, int hi) {
        if(hi<=lo){
            return;
        }
        //处理重复元素的三向切分
        Comparable comparable = a[lo];
        int left=lo;
        int right=hi;
        int i=lo+1;
        while (i<=right){
            if(less(a[i],comparable)){
                exch(a,i++,left++);
            }else if(less(comparable,a[i])){
                exch(a,i,right--);
            }else {
                i++;
            }

        }

        sort3way(a, lo, left - 1);
        sort3way(a, right + 1, hi);
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

            if (left >= right) {
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
