package sopt.org.oop.Abstraction;

import sopt.org.oop.ClassAndInstance.Animal;

public class Rabbit extends Animal {
    private int amountOfKcal;

    public Rabbit(String name, int age, int health, int amountOfKcal) {
        super("rabbit", name, age, health);
        this.amountOfKcal = amountOfKcal;
    }

    public Rabbit(String name, int age, int health) {
        this(name, age, health, 0);
    }

    public void eatFeed(int amountOfFeed) {
        this.amountOfKcal += amountOfFeed * 40;
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("먕~");
    }

    @Override
    public void drink(int amountOfWater) {
        // 토끼는 평균 체중이 작아서 물을 조금만 마셔도 체력이 * 2로 회복된다.
        super.drink(amountOfWater * 2);
    }

    @Override
    public boolean isSurgeryPossible() {
        return super.getAge() >= 19 && super.getHealth() >= 50;
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "amountOfKcal=" + amountOfKcal +
                '}' + super.toString();
    }
}
