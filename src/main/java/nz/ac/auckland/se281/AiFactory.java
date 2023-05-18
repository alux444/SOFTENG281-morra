package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty, MorraGame game) {
    // an ai factory class, which based off the difficulty input, will return an ai of that
    // difficulty. If there is an incorrect input, return a null and message.
    switch (difficulty) {
      case EASY:
        return new AiEasy();
      case MEDIUM:
        return new AiMedium(game);
      case HARD:
        return new AiHard(game);
      case MASTER:
        return new AiMaster(game);
      default:
        System.out.println("error in creating AI");
        return null;
    }
  }
}
