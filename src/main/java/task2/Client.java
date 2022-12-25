package task2;

import lombok.Getter;
import lombok.Setter;

public class Client {
    @Getter
    private final int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private Gender sex;
    @Getter @Setter
    private String email;
    private static int count = 0;

    public Client(String name, int age, Gender sex, String email) {
        id = ++count;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }
}
