package main.sortMethod;

/**
 * 简单选择排序算法：
 * <p>
 * 原理：将序列划分为无序和有序区，寻找无序区中的最小值和无序区的首元素交换，有序区扩大一个，循环最终完成全部排序
 */
public class SelectSort {
    private static void selectSort(int[] a) {
        int idx;
        for (int i = 0; i < a.length; i++) {
            idx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[idx] > a[j]) {
                    idx = j;
                }
            }
            swap(a, idx, i);
        }
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
