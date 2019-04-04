package org.yabo.utils.poi;

import java.util.*;

public class LeetCode969 {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> order = new ArrayList<>();
        int length = A.length;
        while (!ordered(A, length)) {
            int maxIndex = findMaxIndex(A, length);
            if (maxIndex != length - 1) {
                swap(A, maxIndex);
                order.add(maxIndex + 1);
                swap(A, length - 1);
                order.add(length);
            }
            length--;
        }
        return order;
    }

    private int findMaxIndex(int[] a, int length) {
        int index = 0, max = a[0];
        for (int i = 0; i < length; i++) {
            if (max < a[i]) {
                index = i;
                max = a[i];
            }
        }
        return index;
    }


    boolean ordered(int[] a, int length) {
        if (a == null || length <= 1) {
            return true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    void swap(int[] arr, int k) {
        int i = 0;
        while (i <= k) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i++;
            k--;
        }
    }
}
