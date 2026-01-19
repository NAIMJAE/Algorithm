package part01.C_array.beak3273;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 3273번 - 두 수의 합
 * https://www.acmicpc.net/problem/3273
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] arr = new int[1000001];
        for (int i=0 ; i<str.length ; i++) {
            arr[Integer.parseInt(str[i])]++;
        }
        int X = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=0 ; i<=1000000 ; i++) {
            if (arr[i] == 0) { continue; }
            int M = X - i;
            if (M > 1000000) { continue; }
            if (M > i) {
                if (arr[M] > 0) { count++; }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
