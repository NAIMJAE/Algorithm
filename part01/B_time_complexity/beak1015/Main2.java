package part01.B_time_complexity.beak1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10158번 - 개미
 * https://www.acmicpc.net/problem/10158
 * - int x = (p + t) % (2 * w); 에서 (2 * w)는 x축에서 다시 원래의 위치로 돌아오는 주기
 * - x는 (2 * w)로 나누었기 때문에 w보다 큰 경우 존재 (x축의 왼쪽을 찍고 돌아오는 경우)
 * - 이 경우 x = 2 * w - x;를 통해 최종 x좌표 계산
 */
public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int t = Integer.parseInt(br.readLine());

        // x축 계산: 주기 2w
        int x = (p + t) % (2 * w);
        if (x > w) {
            x = 2 * w - x;
        }

        // y축 계산: 주기 2h
        int y = (q + t) % (2 * h);
        if (y > h) {
            y = 2 * h - y;
        }

        System.out.println(x + " " + y);
    }
}
