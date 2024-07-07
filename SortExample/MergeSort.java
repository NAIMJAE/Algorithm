package SortExample;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        //int[] testArr = {3, 2, 5, 6, 1, 10, 4, 7, 9, 8};
        int[] testArr = {3, 2, 5, 1};
        MergeSort ms = new MergeSort();
        ms.mergeSort(testArr, 0, testArr.length-1);
    }

    public void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            System.out.println("before arr : " +Arrays.toString(arr)+ " | start : " +start+ " | mid : " +mid+ " | end : " +end);
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
        System.out.println("arter arr : " +Arrays.toString(arr)+ " | start : " +start+ " | end : " +end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        System.out.println("merge arr : " +Arrays.toString(arr)+ " | start : " +start+ " | mid : " +mid+ " | end : " +end);
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i){
            left[i] = arr[start + i];
        }
        for (int j = 0; j < n2; ++j){
            right[j] = arr[mid + 1 + j];
        }
        System.out.println("arr : " +Arrays.toString(arr)+ " | left : " +Arrays.toString(left)+ " | right : " +Arrays.toString(right));

        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        System.out.println("arr : " +Arrays.toString(arr)+ " | left : " +Arrays.toString(left)+ " | right : " +Arrays.toString(right));

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        System.out.println("arr : " +Arrays.toString(arr)+ " | left : " +Arrays.toString(left)+ " | right : " +Arrays.toString(right));
    }
}
