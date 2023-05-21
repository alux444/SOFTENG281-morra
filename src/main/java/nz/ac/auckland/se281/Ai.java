package nz.ac.auckland.se281;

public abstract class Ai {
  // the ai class with the "setStrategy" option - implementing the strategy design pattern
  protected Strategy strategy;

  // ai constructor
  public Ai(Strategy strategy) {
    this.strategy = strategy;
  }

  // set strategy to change strategy
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  // shared method to play turn
  public int[] playTurn() {
    int[] choices = new int[2];
    choices[0] = strategy.selectAiFingers();
    choices[1] = strategy.selectAiSum();
    return choices;
  }

  // abstract method for changing strategy
  public abstract void changeStrategy();
}
