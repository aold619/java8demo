package main.sortMethod;

/**
 * 插入排序算法：
 * <p>
 * 原理：将数组分为无序区和有序区两个区，
 * 然后不断将无序区的第一个元素按大小顺序插入到有序区中去，
 * 最终将所有无序区元素都移动到有序区完成排序。
 * <p>
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 */
public class InsertSort {
    private static void insertSort(int[] a) {
        int j;
        int tmp;
        for (int i = 1; i < a.length; i++) {
            tmp = a[i];
            for (j = i; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}
