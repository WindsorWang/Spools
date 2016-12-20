package com.netpet.spools.algorithm.sort;

/**
 * 快速排序（英语：Quicksort），又称划分交换排序（partition-exchange sort），一种排序算法，最早由东尼·霍尔提出。
 * 在平均状况下，排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他Ο(n log n)算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
 *
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 *
 * Created by woncz on 2016/10/18.
 */
public class QuickSort {

    int[] arr;

    private void swap(int left, int right) {
        if (left == right)
            return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        System.out.println(this.toString());
    }

    private void quickSortRecursive(int start, int end) {
        if (start >= end)
            return;

        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] < mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;

            swap(left, right);
        }

        if (arr[left] > arr[end]) {
            swap(left, end);
        } else {
            left++;
        }
        quickSortRecursive(start, left - 1);
        quickSortRecursive(right + 1, end);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i] + ",");
            }
            sb.append(arr[arr.length - 1]);
        }
        return sb.toString();
    }

    public void sort(int[] array) {
        arr = array;
        System.out.println(this.toString());
        quickSortRecursive(0, array.length - 1);
    }


    public static void main(String[] args) {
        int[] array = new int[] {5, 8, 6, 4, 3, 9, 7};
        new QuickSort().sort(array);
    }
}
