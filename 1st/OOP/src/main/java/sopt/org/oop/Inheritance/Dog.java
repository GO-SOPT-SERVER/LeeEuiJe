package sopt.org.oop.Inheritance;

import sopt.org.oop.ClassAndInstance.Animal;

public class Dog extends Animal {
    private String gender;

    public Dog(String species, String name, int age, int health) {
        super(species, name, age, health);
    }

    public void walk() {
        System.out.println("강아지가 산책을 합니다.");
    }

    public void bark() {
        System.out.println("월월");
    }
}
