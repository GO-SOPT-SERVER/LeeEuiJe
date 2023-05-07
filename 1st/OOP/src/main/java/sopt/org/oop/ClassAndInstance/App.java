package sopt.org.oop.ClassAndInstance;

public class App {
    public static void main(String[] args) {
        Human human1 = new Human("Euije", 20);
        Human human2 = new Human("Yk", 50);
        Human human3 = new Human("Dh", 30);

        Animal[] animals = new Animal[10];

        for(int i = 0; i < 5; i++) {
            animals[i] = new Animal("dog", "dog" + i,20, 100);
        }
        for(int i = 5; i < 10; i++){
            animals[i] = new Animal("cat", "cat" + (i - 5), 18, 5);
        }

        System.out.println("human1 = " + System.identityHashCode(human1));
        System.out.println("human2 = " + System.identityHashCode(human2));
        System.out.println("human3 = " + System.identityHashCode(human3));

        human1.doSurgery(animals[3], "pig");
        human1.giveWaterToAnimal(animals[3]);
        System.out.println("human1 = " + human1);
        System.out.println("animals[3] = " + animals[3]);

        human2.doSurgery(animals[7], "zebra");
        human2.giveWaterToAnimal(animals[7]);
        System.out.println("human1 = " + human1);
        System.out.println("animals[7] = " + animals[7]);
    }
}
