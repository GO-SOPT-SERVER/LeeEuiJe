package sopt.org.oop.Abstraction;

import sopt.org.oop.ClassAndInstance.Human;

public class Zookeeper extends Human {
    private int amountOfFeed;

    public Zookeeper(String name, int amountOfWater, int amountOfFeed) {
        super(name, amountOfWater);
        this.amountOfFeed = amountOfFeed;
    }

    public void feedTo(Rabbit rabbit) {
        rabbit.eatFeed(amountOfFeed);
    }

    public int getAmountOfFeed() {
        return amountOfFeed;
    }

    public void setAmountOfFeed(int amountOfFeed) {
        this.amountOfFeed = amountOfFeed;
    }

    @Override
    public String toString() {
        return "Zookeeper{" +
                "amountOfFeed=" + amountOfFeed +
                '}' + super.toString();
    }
}
