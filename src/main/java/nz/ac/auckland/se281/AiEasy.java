package nz.ac.auckland.se281;

public class AiEasy extends Ai {

  private Strategy strategy;

  public AiEasy() {
    this.strategy = new RandomStrategy();
  }

  @Override
  public int[] playTurn() {
    int[] choices = new int[2];
    choices[0] = strategy.selectAiFingers();
    choices[1] = strategy.selectAiSum();
    return choices;
  }

  @Override
  public void changeStrategy() {}
}
