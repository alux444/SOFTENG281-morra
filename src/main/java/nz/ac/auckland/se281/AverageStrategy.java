package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy extends Strategy {

  private int currentFingers;
  private MorraGame currentGame;

  public AverageStrategy(MorraGame game) {
    this.currentGame = game;
  }

  public int selectAiFingers() {
    int random = super.selectAiFingers();
    this.currentFingers = random;
    return random;
  }

  @Override
  public int selectAiSum() {
    // first, get history of game so far.

    System.out.println(currentFingers);
    List<Integer> history = currentGame.getHistory();

    // gets the average
    int average = 0;
    for (int number : history) {
      average += number;
      System.out.println(number);
    }
    average = Math.round(average / history.size());
    System.out.println(average);

    // add average to the current fingers
    int averageSum = currentFingers + average;

    return averageSum;
  }
}
