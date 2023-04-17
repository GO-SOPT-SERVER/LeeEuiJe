package sopt.org.oop.ClassAndInstance;

public class Animal {
    // 의문 1. 객체는 책임과 협력을 위한 존재인데, 해당 3개의 필드는 협력에 참여하지 않는다. 좋은 설계?
    // -> Human 클래스를 생성하여 사람이 동물을 수술하는 상황을 만들자
    private String species;
    private String name;
    private int age;
    private int health;

    public Animal(String species, String name, int age, int health) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.health = health;
    }

    public void speak() {
        System.out.println("동물 " + this.name + "이 소리를 냅니다.");
    }

    public void drink(int amountOfWater) {
        System.out.println("동물이 물을 마셔 체력을 " + amountOfWater + "회복합니다.");
        this.health += amountOfWater;
    }

    public boolean isSurgeryPossible() {
        return age >= 19 && health >= 80;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", health=" + health +
                '}';
    }
}