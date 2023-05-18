package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  MorraGame currentGame;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.currentGame = new MorraGame(difficulty, pointsToWin, options[0]);
  }

  public void play() {
    if (this.checkForGame()) {
      boolean gameFinished = currentGame.playRound();
      if (gameFinished) {
        this.currentGame = null;
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void showStats() {
    if (this.checkForGame()) {
      currentGame.showStats();
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public boolean checkForGame() {
    if (currentGame == null) {
      return false;
    }
    return true;
  }
}
