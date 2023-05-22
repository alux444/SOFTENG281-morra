package nz.ac.auckland.se281;

import java.util.List;

public class TopStrategy extends Strategy {

  private MorraGame currentGame;

  public TopStrategy(MorraGame game) {
    this.currentGame = game;
  }

  @Override
  public int selectAiSum() {
    // first, get history of game so far.

    System.out.println(currentFingers);
    List<Integer> history = currentGame.getHistory();

    // initialise an array where each index represents the number played - 1 (ie 0 = 1, 1=2..)
    int[] counts = {0, 0, 0, 0, 0};

    // count played numbers from history
    for (int number : history) {
      counts[number - 1]++;
    }

    // look for most frequently occurring number. as it is irrelevant which finger is choosed if
    // there is a tie, this loop results in choosing the higher more frequently occurring one
    int maxCount = 0;
    int maxVal = 0;

    for (int i = 0; i < 5; i++) {
      if (counts[i] > maxCount) {
        maxVal = i + 1;
        maxCount = counts[i];
      }
    }

    System.out.println("MAX" + maxVal);

    return currentFingers + maxVal;
  }
}
