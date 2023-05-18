package nz.ac.auckland.se281;

public abstract class Ai {
  // the ai class with the "setStrategy" option - implementing the strategy design pattern

  private Strategy strategy;

  public int[] playTurn() {
    int[] choices = new int[2];
    choices[0] = strategy.selectAiFingers();
    choices[1] = strategy.selectAiSum();
    return choices;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public abstract void changeStrategy();
}
