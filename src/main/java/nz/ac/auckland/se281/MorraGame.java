package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class MorraGame {

  private Ai currentAi;
  private int pointsToWin;
  private String playerName;
  private int round;
  private List<Integer> history;

  private int playerPoints = 0;
  private int aiPoints = 0;

  MorraGame(Difficulty difficulty, int pointsToWin, String playerName) {

    // creates history arraylist
    this.history = new ArrayList<>();

    this.pointsToWin = pointsToWin;
    this.playerName = playerName;
    this.round = 1;

    // creates an ai of diffuculy based on input
    this.currentAi = AiFactory.createAi(difficulty, this);
  }

  // method to increment the round
  public void incrementRound() {
    this.round++;
  }

  public boolean playRound() {
    // printing round message and asking for input at start of play round
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    MessageCli.ASK_INPUT.printMessage();
    // get inputs through scanner, splits each input into an array for inputs
    String[] inputs = (Utils.scanner.nextLine()).split(" ");

    // first convert strings to an integer
    int inputFingers = Integer.parseInt(inputs[0]);
    int inputSum = Integer.parseInt(inputs[1]);

    // checks for validity, and if not valid, will again ask for valid inputs
    boolean valid = checkValidity(inputFingers, inputSum);

    while (!valid) {
      MessageCli.ASK_INPUT.printMessage();
      // get inputs through scanner, splits each input into an array for inputs
      inputs = (Utils.scanner.nextLine()).split(" ");
      inputFingers = Integer.parseInt(inputs[0]);
      inputSum = Integer.parseInt(inputs[1]);

      valid = checkValidity(inputFingers, inputSum);
    }

    // get ai choices by calling function from ai
    int[] aiChoices = currentAi.playTurn();

    // print ai choices
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(aiChoices[0]), Integer.toString(aiChoices[1]));

    // check result of the round
    checkResult(inputSum, aiChoices[1], (inputFingers + aiChoices[0]));

    // at the end of game, add human fingers to history
    history.add(inputFingers);

    // check if any player has won. return a true if any player has.
    if (playerPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage(playerName, Integer.toString(round));
      return true;
    } else if (aiPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(round));
      return true;
    }

    // at the end of the round, if there is no winner yet, increment. and check with ai if strategy
    // should be changed.
    incrementRound();
    currentAi.changeStrategy();
    return false;
  }

  // function to check for validity of input fingers and sums
  private boolean checkValidity(int fingers, int sum) {

    // returns a boolean false if any invalid conidtions are met
    if ((fingers > 5 || fingers < 1) || (sum > 10 || sum < 1)) {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }

    // otherwise will return a true
    MessageCli.PRINT_INFO_HAND.printMessage(
        playerName, Integer.toString(fingers), Integer.toString(sum));
    return true;
  }

  // method which checks results and prints results.
  private void checkResult(int human, int ai, int total) {
    if (human == ai) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (human == total) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      this.playerPoints++;
    } else if (ai == total) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      this.aiPoints++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  // method to return the arraylist of history of human played fingers
  public List<Integer> getHistory() {
    return this.history;
  }

  // method to get the current round.
  public int getRound() {
    return this.round;
  }

  // method to show the current stats.
  public void showStats() {
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playerPoints), Integer.toString(pointsToWin - playerPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", Integer.toString(aiPoints), Integer.toString(pointsToWin - aiPoints));
  }
}
