package nz.ac.auckland.se281;

public abstract class Strategy {

  protected int currentFingers;

  // abstract class with random fingers method, aswell as abstract methods for ai implementing their
  // own logic.
  public int selectAiFingers() {
    int rand = Utils.getRandomNumber(1, 5);
    this.currentFingers = rand;
    return rand;
  }

  public abstract int selectAiSum();
}
