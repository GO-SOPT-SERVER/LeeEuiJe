package sopt.org.oop.Polymorphism;

public abstract class Car {
    private boolean isTurn = false;
    private int velocity = 0;
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void accelerate(int force) throws Exception;
    public abstract void brake(int force) throws Exception;

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
