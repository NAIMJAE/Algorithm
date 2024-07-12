package TimeMeasurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 작업 시작 시간 기록 (밀리초 단위)
        long startTime = System.currentTimeMillis();

        // 수행할 작업
        performTask();

        // 작업 종료 시간 기록 (밀리초 단위)
        long endTime = System.currentTimeMillis();

        // 소요된 시간 계산
        long duration = endTime - startTime;

        // 콘솔에 소요된 시간 출력
        System.out.println("작업 소요 시간: " + duration + " ms");
    }

    // 테스트 하고싶은 코드 performTask() 메서드 내에 입력
    public static void performTask() {

        String len = "JAVA,";
        //String len = "JAVA,SPRING,HTML";
        String[] arr = len.split(",");

        System.out.println("arr : " + Arrays.toString(arr));
        for (int i=0 ; i<arr.length ; i++) {
            System.out.println(arr[i]);
        }
        
/*
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i];
        }
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
 */
 
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(random.nextInt(10000));
        }
        int count = 0;
        for (int each : arrayList) {
            count += each;
        }
        Collections.sort(arrayList);
        //System.out.println(arrayList);
    }
}
