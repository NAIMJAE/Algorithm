package Test;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    public static void main(String[] args) {
        
        User userA = new User("xx111", "홍길동", 23);
        userA.changeAge(44);
        
        User userB = userA;

        final User userC = new User("xx222","김춘추", 23);
        userC.changeAge(30);

        final UserService userService = new UserService();

        ImList<String> newList = new ImList<>();
        newList.add("안녕");

    }
}

class User {
    private final String userPk;
    private String name;
    private int age;

    public User(String userPk, String name, int age) {
        this.userPk = userPk;
        this.name = name;
        this.age = age;
    }

    public void changeAge(int newAge) {
        this.age = newAge;
    }

    // public void changePk(String newPk) {
    //     this.userPk = newPk;
    // }
}

class UserService {

    private String name;

    public void loginProcess() {
        List<String> aa= new ArrayList<>();
    }

    public void logoutProcess() {}

    public void registerProcess() {}

    // public UserService() {}
    public UserService(String name) {
        this.name = name;
    }
}

class ImList<E> extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        System.out.println("Adding element: " + e);
        return super.add(e); // 원래 add() 기능 유지
    }
}

class Animal {
    private final String name;
    private final String color;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public final void sleep() { // ✅ 모든 동물이 동일한 sleep() 동작을 유지하도록 함
        System.out.println("동물이 잠을 잡니다.");
    }

    public void eat() { // ✅ 하위 클래스에서 오버라이딩 가능
        System.out.println(this.name + "이 먹이를 먹습니다.");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}

class Cat extends Animal {
    public Cat(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() { // ✅ 고양이만의 eat() 동작
        System.out.println(getName() + "이 생선을 먹습니다.");
    }
}

class Dog extends Animal {
    public Dog(String name, String color) {
        super(name, color);
    }

    @Override
    public void eat() { // ✅ 개만의 eat() 동작
        System.out.println(getName() + "이 사료를 먹습니다.");
    }
}