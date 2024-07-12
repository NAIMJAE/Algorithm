package GreedyAlgorithm.Beak2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i=(N-1); i>=1 ; i--) {
            while (arr[i] <= arr[i-1]) {
                arr[i-1] = arr[i-1] - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
