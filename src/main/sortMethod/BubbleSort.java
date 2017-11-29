package main.sortMethod;

/**
 * 冒泡排序算法：
 * <p>
 * 原理：将序列划分为无序和有序区，不断通过交换较大元素至无序区尾完成排序。
 * <p>
 * 要点：设计交换判断条件，提前结束以排好序的序列循环。
 */
public class BubbleSort {
    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
