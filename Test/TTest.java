package Test;

public class TTest {

    public static void main(String[] args) {
        Parent obj = new Child();
        obj.getName(); // 메서드 호출
        System.out.println(obj.name); // 필드 호출

        Child obj2 = new Child();
        obj2.getName(); // 메서드 호출
        System.out.println(obj2.name); // 필드 호출
    }
}
// 부모 = new 자식 관계에서 메서드 -> 자식 / 필드 -> 부모 // 부자 메자필부
// 자식 = new 자식 관계에서 메서드 -> 자식 / 필드 -> 자식 // 자자 메자필자

class Parent {
    String name = "parent";
    int age = 42;

    public void getName() {
        System.err.println(name);
    } 

    public void getAge() {
        System.err.println(age);
    } 
}

class Child extends Parent {
    String name = "child";
    int age = 23;

    public void getName() {
        System.err.println(name);
    } 
}