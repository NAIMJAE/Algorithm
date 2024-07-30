package Test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 박싱 예시
        int primitiveInt = 10;
        Integer wrapperInt = primitiveInt; // 자동 박싱
        Integer anotherWrapperInt = Integer.valueOf(primitiveInt); // 수동 박싱

        // 언박싱 예시
        Integer wrapperInt2 = 20;
        int anotherPrimitiveInt = wrapperInt2; // 자동 언박싱
        int yetAnotherPrimitiveInt = wrapperInt2.intValue(); // 수동 언박싱

        // 자동 박싱과 언박싱의 조합
        Integer sum = wrapperInt + wrapperInt2; // 자동 언박싱 후 연산, 결과를 자동 박싱
    }
}
a

