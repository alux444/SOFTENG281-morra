package nz.ac.auckland.se281;

public abstract class Ai {
  // the ai class with the "setStrategy" option - implementing the strategy design pattern

  private Strategy strategy;

  // set strategy to change strategy
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  // abstract method for playing turn
  public abstract int[] playTurn();

  // abstract method for changing strategy
  public abstract void changeStrategy();
}
