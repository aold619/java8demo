package main.sortMethod;

/**
 * 希尔排序：
 * <p>
 * 原理：又称增量缩小排序。先将序列按增量划分为元素个数相同的若干组，
 * 使用直接插入排序法进行排序，然后不断缩小增量直至为1，最后使用直接插入排序完成排序。
 * <p>
 * 要点：增量的选择以及排序最终以1为增量进行排序结束。
 */
public class ShellSort {
    private static void shellSort(int[] a) {
        int j;
        int tmp;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                tmp = a[i];
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }
}
