package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy extends Strategy {

  private MorraGame currentGame;

  public AverageStrategy(MorraGame game) {
    this.currentGame = game;
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
    }
    average = Math.round((float) average / history.size());

    // add average to the current fingers
    int averageSum = currentFingers + average;

    return averageSum;
  }
}
