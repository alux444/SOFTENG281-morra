package nz.ac.auckland.se281;

public class AiMaster extends Ai {

  private Strategy strategy;
  private MorraGame game;
  private Strategy random;
  private Strategy average;
  private Strategy top;

  public AiMaster(MorraGame game) {
    this.random = new RandomStrategy();
    this.average = new AverageStrategy(game);
    this.top = new TopStrategy(game);
    this.strategy = random;
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
    if (game.getRound() == 4) {
      this.strategy = new AverageStrategy(game);
    } else if (game.getRound() > 4) {
      this.strategy = (this.strategy instanceof TopStrategy) ? average : top;
    }
  }
}
