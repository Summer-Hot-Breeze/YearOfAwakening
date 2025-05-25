package algorithms.base.book.two.chapters;

public class Shell extends Example {

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int gap = 1;
        // 动态计算最大Sedgewick间隔
        while (gap > length / 3) {
            gap = 3 * gap + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                Comparable temp = a[i];
                int j = i;
                while (j > gap && less(temp, a[j - gap])) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
            gap = gap / 3;
        }
    }
}
