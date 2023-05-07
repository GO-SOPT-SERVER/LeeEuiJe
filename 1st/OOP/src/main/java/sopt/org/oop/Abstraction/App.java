package sopt.org.oop.Abstraction;

public class App {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit("datto", 20, 60, 100);
        Zookeeper zookeeper = new Zookeeper("euije", 100, 100);

        zookeeper.feedTo(rabbit);
        zookeeper.doSurgery(rabbit, "penguin");

        System.out.println("rabbit = " + rabbit);
        System.out.println("zookeeper = " + zookeeper);
    }
}
