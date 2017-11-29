package main.sortMethod;

/**
 * 归并排序算法：
 * <p>
 * 原理：将原序列划分为有序的两个序列，然后利用归并算法进行合并，合并之后即为有序序列。
 * <p>
 * 要点：归并、分治
 */
public class MergeSort {
    private static void mergeSort(int[] a) {
        int[] b = new int[a.length];
        mergeSort(a, b, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] b, int left, int right) {
        if (left < right) {
            int center = left + (right - left) / 2;
            mergeSort(a, b, left, center);
            mergeSort(a, b, center + 1, right);
            merge(a, b, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] b, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                b[tempPos] = a[leftPos];
                tempPos++;
                leftPos++;
            } else {
                b[tempPos] = a[rightPos];
                tempPos++;
                rightPos++;
            }
        }
        while (leftPos <= leftEnd) {
            b[tempPos] = a[leftPos];
            tempPos++;
            leftPos++;
        }
        while (rightPos <= rightEnd) {
            b[tempPos] = a[rightPos];
            tempPos++;
            rightPos++;
        }
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = b[rightEnd];
        }
    }
}
