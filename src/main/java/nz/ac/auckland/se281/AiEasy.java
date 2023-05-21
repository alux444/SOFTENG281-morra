package nz.ac.auckland.se281;

public class AiEasy extends Ai {

  // as easy ai only ever uses random strategy, simply assign strategy as random strategy
  public AiEasy() {
    super(new RandomStrategy());
  }

  @Override
  public void changeStrategy() {}
}
