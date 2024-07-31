package Recursion.Beak11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * [백준 Recursion 단계별로 풀기 step.7]
 * 백준 11729번 - 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 */
class Floor {
    int A;
    int B;

    Floor(int A, int B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "A=" + A +
                ", B=" + B +
                '}';
    }
}

public class Main {
    static List<Floor> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) {
            result.add(new Floor(1, 3));
        }else {
            result.add(new Floor(2, 3));
        }

        Hanoi(N);
    }

    static void Hanoi(int N) {
        if (N > 1) {
            Hanoi(N-1);
            System.out.println("현재 : "+N);
            int K = result.size();
            for (int i=0 ; i<K ; i++) {
                if (i==0) {
                    if (N % 2 == 1) {
                        result.add(new Floor(2, 3));
                    }else {
                        result.add(new Floor(1, 3));
                    }
                }
                if (N % 2 == 1) {
                    result.add(new Floor((result.get(i).A % 3) + 1 , (result.get(i).B % 3 ) + 1));
                }else {
                    result.add(new Floor(((result.get(i).A+1) % 3) + 1 , ((result.get(i).B+1) % 3 ) + 1));
                }
            }
            System.out.println(result.toString());
        }else {
            System.out.println("else"+N);
            
        }
    }
}
