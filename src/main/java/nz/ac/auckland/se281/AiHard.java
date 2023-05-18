package nz.ac.auckland.se281;

public class AiHard extends Ai {

  private Strategy strategy;
  private MorraGame game;

  public AiHard(MorraGame game) {
    this.strategy = new RandomStrategy();
    this.game = game;
  }

  @Override
  public int[] playTurn() {
    int[] choices = new int[2];
    choices[0] = strategy.selectAiFingers();
    choices[1] = strategy.selectAiSum();
    return choices;
  }

  @Override
  public void changeStrategy() {
    if (game.getRound() > 4) {
      this.strategy = new TopStrategy(game);
    }
  }
}
