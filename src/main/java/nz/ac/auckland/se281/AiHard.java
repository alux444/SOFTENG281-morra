package nz.ac.auckland.se281;

public class AiHard extends Ai {

  private MorraGame game;

  // hard ai starts as random strategy.
  public AiHard(MorraGame game) {
    super(new RandomStrategy());
    this.game = game;
  }

  // after round 4, will switch to top strategy
  @Override
  public void changeStrategy() {
    if (game.getRound() >= 4) {
      setStrategy(new TopStrategy(game));
    }
  }
}
