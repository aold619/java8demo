package main.sortMethod;

/**
 * 堆排序算法：
 * <p>
 * 原理：利用大根堆或小根堆思想，首先建立堆，然后将堆首与堆尾交换，堆尾之后为有序区。
 * <p>
 * 要点：建堆、交换、调整堆
 */
public class HeapSort {
    private static void heapSort(int[] a) {
        // 先创建大堆，从第一个非叶子结点开始调整，然后调整第二个非叶子结点...
        for (int i = a.length / 2; i >= 0; i--) {
            shiftDown(a, i, a.length);
        }
        // 调整大堆，将最大的元素调整到未排好序的部分的末尾
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            shiftDown(a, 0, i);
        }
    }

    private static void shiftDown(int[] a, int i, int n) {
        int child;
        int tmp;
        for (tmp = a[i]; i * 2 + 1 < n; i = child) {
            child = i * 2 + 1;
            if (child != n - 1 && a[child] < a[child + 1]) {
                child++;
            }
            if (tmp < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}