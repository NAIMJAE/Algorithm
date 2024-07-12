package String.Beak2179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
 * 백준 2179번 - 비슷한 단어
 * 
 * <접근 방법>
 * - 문자열을 입력받아서 char 타입으로 저장하기
 * - for 문 돌면서 charAt로 한자한자 비교해서 가장 많이 일치하는문자 찾기?
 * 
 * <풀이 방법>
 * - 이중 배열로 모든 문자를 순차적으로 비교
 * - 이중 배열로 비교하게 되면 같은 문자를 비교하는 경우가 생기기 때문에 continue 사용
 * - charAt()로 한글자씩 비교
 * - 한글자씩 비교하는 for문에서 길이 설정은 더 짧은 문자열을 기준으로
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map aa = new HashMap<>();
        String[] arr = new String[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = br.readLine();
        }

        int result = 0;
        int a = 0;
        int b = 0;
        for (int i=0 ; i<N-1 ; i++) {
            String str1 = arr[i];
            for (int j=0 ; j<N ; j++) {
                String str2 = arr[j];
                if(str1.equals(str2)) {
                    continue;
                }
                int count = 0;
                int len = 0;
                if (str1.length() > str2.length()) {
                    len = str2.length();
                }else {
                    len = str1.length();
                }
                for(int k=0 ; k<len ; k++) {
                    if (str1.charAt(k)!=(str2.charAt(k))) {
                        break;
                    }
                    count++;
                }

                if (result < count) {
                    result = count;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(arr[a]);
        System.out.println(arr[b]);
    }
}
