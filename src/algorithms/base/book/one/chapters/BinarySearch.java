package algorithms.base.book.one.chapters;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int rank(int[] arr, int num) {
        if (arr == null) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        //这里为什么要加等于号？（拿1带入运行下）
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (num > arr[mid]) {
                //这里可以不加1吗
                start = mid + 1;
            }
            if (num < arr[mid]) {
                //这里可以不减1吗
                end = mid - 1;
            }
            if (num == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 234, 4356, 43, 2134, 1234, 1235, 456, 433, 3, 12, 79, 54, 423, 23424};
        Arrays.sort(arr);

        System.out.println(rank(arr, 1));
        System.out.println(rank(arr, 2));
        System.out.println(rank(arr, 1456));
        System.out.println(rank(arr, 3));
        System.out.println(rank(arr, 23424));


    }
}
