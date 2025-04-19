package algorithms.base.book.one.chapters;

import java.util.Arrays;

public class TwoSum {
    public static int twoSun(int[] arr) {
        int ctn = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    ctn++;
                }
            }
        }
        return ctn;
    }

    public static int twoSunFast(int[] arr) {
        int ctn = 0;
        for (int i = 0; i < arr.length; i++) {
            if (BinarySearch.rank(arr, -arr[i]) > i) {
                ctn++;
            }
        }
        return ctn;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 678, 456, 3245, -2, 3464536, 234, 32, 2, 5, -6, 456};
        System.out.println(twoSun(arr));
        Arrays.sort(arr);
        //如果数组里面有重复的值会有什么影响
        System.out.println(twoSunFast(arr));
    }
}
