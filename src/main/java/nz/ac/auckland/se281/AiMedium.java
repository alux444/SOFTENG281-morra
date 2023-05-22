package nz.ac.auckland.se281;

public class AiMedium extends Ai {

  private MorraGame game;
  private Strategy average;

  public AiMedium(MorraGame game) {
    super(new RandomStrategy()); // Initialize the strategy in the parent class
    this.average = new AverageStrategy(game);
    this.game = game;
  }

  @Override
  public void changeStrategy() {
    if (game.getRound() >= 4) {
      setStrategy(average);
    }
  }
}
