package DataStructures.Beak1889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 밴준 1889번 - 선물 교환
 * https://www.acmicpc.net/problem/1889
 * 
 * 
 */
public class Main {
    public static class Gift{
        int one;
        int two;

        public Gift(int one, int two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public String toString() {
            return "Gift{one=" + one + ", two=" + two + "}";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Gift> student = new ArrayList<>(N+1);
        Gift reset = new Gift(2, 2);
        student.add(reset);

        for (int i=1; i<=N ; i++) {
            String[] input = br.readLine().split(" ");
            Gift gift = new Gift(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            student.add(gift);
        }

        boolean success = false;
        while (!success) {

            int[] arr = new int[N+1];

            for (int i=1 ; i<student.size() ; i++) {
                Gift gift = student.get(i);
                arr[gift.one]++;
                arr[gift.two]++;
                System.out.println("첫번째 for문" + Arrays.toString(arr));
            }

            int check = 0;
            for (int i=1 ; i<=N ; i++) {
                if (arr[i] == 2) {
                    check += arr[i];
                }
            }

            if (check != (student.size()-1)*2) {
                System.out.println((student.size()-1)*2);
                System.out.println(check);
                for (int i = student.size() - 1; i > 0; i--) {
                    if (arr[i] < 1) {
                        student.remove(i);
                    }
                }
            }else {
                System.out.println(check/2);
                for (int i=1 ; i<=N ; i++) {
                    if (arr[i] == 2) {
                        System.out.print(i+" ");
                    }
                }
                success = true;
            }
        }
    }
}
