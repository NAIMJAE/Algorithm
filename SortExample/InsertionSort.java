package SortExample;

import java.util.Arrays;

/*
 * 삽입 정렬 (InsertionSort)
 * - 작은 배열이나 이미 거의 정렬된 배열에서 효율적
 * - 코드가 간단하고 구현이 용이
 */
public class InsertionSort {
    
    int[] intArr = {4, 2, 6, 1, 3, 5};

    public void insertion (int[] intArr) {
        System.out.println("start : " + Arrays.toString(intArr));
        for (int i=1 ; i < intArr.length ; i++) {
            int key = intArr[i];
            int j = i - 1;
            while (j >= 0 && intArr[j] > key) {
                intArr[j+1] = intArr[j];
                j = j - 1;
                System.out.println("procedure : " + Arrays.toString(intArr));
            }
            intArr[j+1] = key;
            System.out.println("procedure : " + Arrays.toString(intArr));
        }
        System.out.println("end : " + Arrays.toString(intArr));
    }

    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        sorter.insertion(sorter.intArr);
    }
}
