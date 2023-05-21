package nz.ac.auckland.se281;

public class RandomStrategy extends Strategy {

  @Override
  public int selectAiSum() {
    // calculate fingers and sum. fingers is a random number 1-5, sum is a random number 1-5 plus
    // the amount of fingers.
    return Utils.getRandomNumber(1, 5) + currentFingers;
  }
}
