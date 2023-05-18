package sopt.org.oop.Polymorphism;

public class ElectricCar extends Car implements Computer<Car> {
    boolean isTurn = false;
    int velocity = 0;

    public ElectricCar(boolean isTurn, int velocity) {
        this.isTurn = isTurn;
        this.velocity = velocity;
    }

    public Float add(Float a, Float b) {
        return a + b;
    }

    @Override
    public void turnOn() {
        this.isTurn = true;
    }

    @Override
    public void turnOff() {
        this.isTurn = false;
    }

    @Override
    public void accelerate(int force) throws Exception {
        if(isTurn)
            this.velocity += force;
        else {
            throw new Exception("차의 시동을 켜주세요");
        }
    }

    @Override
    public void brake(int force) throws Exception {
        if(isTurn)
            this.velocity -= force;
        else {
            throw new Exception("차의 시동을 켜주세요");
        }
    }

    @Override
    public int add(Car a, Car b) {
        return a.getVelocity() + b.getVelocity();
    }

    @Override
    public int sub(Car a, Car b) {
        return a.getVelocity() - b.getVelocity();
    }

    @Override
    public int mult(Car a, Car b) {
        return a.getVelocity() * b.getVelocity();
    }

    @Override
    public int div(Car a, Car b) {
        return a.getVelocity() / b.getVelocity();
    }
}
