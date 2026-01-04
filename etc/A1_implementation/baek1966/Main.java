package A1_implementation.baek1966;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1966번 - 프린터 큐
 * https://www.acmicpc.net/problem/1966
 * - 큐 쓰는법 기억 안났음
 * - while문 루프내 조건 이상 -> h가 false인 경우 c++을 안 함
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<Integer> r = new ArrayList<>();

        for (int i=0 ; i<t ; i++) {
            String[] s = sc.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            Queue<Doc> q = new LinkedList<>();

            String[] w = sc.nextLine().split(" ");
            for (int j=0 ; j<w.length ; j++) {
                q.offer(new Doc(j, Integer.parseInt(w[j])));
            }
            
            int c = 0;
            while (true) {
                Doc f = q.poll();

                boolean h = false;
                for (Doc d : q) {
                    if (d.w > f.w) {
                        h = true;
                        break;
                    }
                }

                if (h) {
                    q.offer(f);
                } else {
                    c++;
                    if (f.i == m) {
                        r.add(c);
                        break;
                    }
                }
            }
        }

        for (Integer a : r) {
            System.out.println(a);
        }
    }
}

class Doc{
    int i;
    int w;

    public Doc(int i, int w) {
        this.i = i;
        this.w = w;
    }
}
