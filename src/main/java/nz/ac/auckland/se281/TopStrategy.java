package nz.ac.auckland.se281;

import java.util.List;

public class TopStrategy extends Strategy {

  private int currentFingers;
  private MorraGame currentGame;

  public TopStrategy(MorraGame game) {
    this.currentGame = game;
  }

  public int selectAiFingers() {
    int random = randomFingers();
    this.currentFingers = random;
    return random;
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

    // look for most frequently occurring number
    int max = 0;
    for (int i = 0; i < 5; i++) {
      if (counts[i] > max) {
        max = i + 1;
      }
    }

    return currentFingers + max;
  }
}
