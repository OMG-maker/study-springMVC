package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloData {
    private String username;
    private int age;

// cmd + N 으로 제네릭 바로 생성도 가능
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
