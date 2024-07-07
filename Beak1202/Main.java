package Beak1202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 1202번 - 보석 도둑
 * https://www.acmicpc.net/problem/1202
 * 
 * <접근 방법>
 * - 우선순위 큐를 이용해야겠다는 생각은 했지만, 모든 가방 무게와 보석 무게 비교를 어떻게 할지 생각 못함
 * - 가방은 무게가 낮은순, 보석은 가격이 높은순으로 정렬하여 현재 가방에 들어갈 수 있는 가장 비싼 보석을 찾아내기
 */
class Jewel {
    int weight;
    int price;

    Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, price);
        }

        // 무게를 오름차순 정렬하되, 무게가 같을 경우 가격을 내림차순 정렬.
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if (o1.weight == o2.weight) {
                    return o2.price - o1.price;
                }
                return o1.weight - o2.weight;
            }
        });

        int[] bagArr = new int[K];
        for (int i=0 ; i<K ; i++) {
            bagArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagArr);

        // PriorityQueue에 들어가는 값들이 내림차순 정렬되게
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long count = 0;

        // 가방은 무게가 낮은순으로 정렬 / 보석은 가격이 높은순으로 정렬된 상태
        // 현재 가방의 무게와 보석의 가격을 전부 비교해서 가방에 넣을수 있는 보석만 골라냄
        // 이때 골라낸 보석의 가격을 PriorityQueue에 넣고 오름차순 정렬
        // 전부 비교후 priorityQueue에서 poll 하면 현재 가방에 넣을 수 있는 보석중 가장 비싼 가격이 나옴
        // 이거 반복 -> 근데 j++ 구문이 있어 앞선 for문에서 poll 했던 보석은 그 뒤로 나오지 않음
        for (int i=0, j=0 ; i<K ; i++) {
            System.out.println("i : " + i + " | j : " + j + " | pq : " + pq);
            while (j < N && bagArr[i] >= jewels[j].weight) {
                pq.offer(jewels[j++].price); // 여기 j++이 핵심
                System.out.println("i : " + i + " | j : " + j + " | pq : " + pq);
            }
            if (!pq.isEmpty()) {
                count += pq.poll();
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
