package nz.ac.auckland.se281;

public class AiMaster extends Ai {

  private MorraGame game;
  private Strategy average;
  private Strategy top;

  // master ai starts off with random strategy
  public AiMaster(MorraGame game) {
    super(new RandomStrategy());
    this.average = new AverageStrategy(game);
    this.top = new TopStrategy(game);
    this.game = game;
  }

  // at round 4, we will switch to average strategy.
  // otherwise, if strategies are instance of top or average after round 4, swap strategy
  @Override
  public void changeStrategy() {
    if (game.getRound() == 4) {
      this.strategy = new AverageStrategy(game);
    } else if (game.getRound() > 4) {
      this.strategy = (this.strategy instanceof TopStrategy) ? average : top;
    }
  }
}
