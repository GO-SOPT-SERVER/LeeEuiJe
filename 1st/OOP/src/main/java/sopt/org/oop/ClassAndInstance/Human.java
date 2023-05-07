package sopt.org.oop.ClassAndInstance;

public class Human {
    private String name;
    private int amountOfWater;

    public Human(String name, int amountOfWater) {
        this.name = name;
        this.amountOfWater = amountOfWater;
    }

    public void doSurgery(Animal animal, String toSpecies) {
        if(this.askToAnimal(animal)){
            animal.setSpecies(toSpecies);
            System.out.println(animal.getName() + "을 " + toSpecies + "로 바꾸는 수술을 완료하였습니다.");
            animal.speak();
        }
        else {
            System.out.println(animal.getName() + "을 " + toSpecies + "로 바꾸는 수술을 할 수 없습니다.");
        }
    }

    public boolean askToAnimal(Animal animal) {
        return animal.isSurgeryPossible();
    }

    public boolean giveWaterToAnimal(Animal animal) {
        int delta = 5;
        if(this.amountOfWater >= delta) {
            this.amountOfWater -= delta;
            animal.drink(delta);
            return true;
        }
        else
            return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public void setAmountOfWater(int amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", amountOfWater=" + amountOfWater +
                '}';
    }
}