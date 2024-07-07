package Baek2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 백준 2751번 - 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 * 
 * <접근 방법>
 * - 입력 받은 수를 배열에 넣고 병합 정렬을 통해 오름 차순으로 수 정렬
 * - Scanner를 쓰면 시간 초과 뜸
 * <입력 예제>
 * 5 / 5 4 3 2 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.print("수의 개수 : ");
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("입력한 수 : " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < size; i++) {
            bw.write(arr[i] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] mergeSort (int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }

    public static void merge (int[] arr, int start, int mid, int end) {
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
    }
}
