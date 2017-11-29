package main.sortMethod;

/**
 * 二分查找算法：
 */
public class BinarySearch {
    public static int binarySearch(int[] a, int v) {
        int mid;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >>> 1); // 移位运算的优先级比较低，要用括号
            if (a[mid] == v) { // 已经找到
                return mid;
            } else if (a[mid] < v) { // 可能在右边
                lo = mid + 1;
            } else { // 可能在左边
                hi = mid - 1;
            }
        }
        return -1; // 未找到
    }
}
