package DynamicProgramming.Beak2579;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.8]
 * 백준 2579번 - 계단 오르기
 * https://www.acmicpc.net/problem/2579
 * 
 * <접근 방식>
 * 
 * <풀이 방법>
 * 
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> exMap = new HashMap<>();
        exMap.put("홍길동", 27);
        exMap.put("김유신", 30);
        exMap.put("김춘추", 42);

        System.out.println("hashCode | Index |   Key   | value");
        printBucketIndexes(exMap);
    }

    private static void printBucketIndexes(Map<String, Integer> map) throws Exception {
        // 리플렉션을 통해 HashMap의 table 필드에 접근
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            int hashCode = key.hashCode();
            int adjustedHash = (hashCode ^ (hashCode >>> 16));
            int bucketIndex = (table.length - 1) & adjustedHash;

            System.out.println(hashCode + " |   " + bucketIndex + "   |  " + key + " | " + value);
        }
    }
}
