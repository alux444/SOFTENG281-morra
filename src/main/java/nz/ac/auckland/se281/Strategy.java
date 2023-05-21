package nz.ac.auckland.se281;

public abstract class Strategy {

  // abstract class with random fingers method, aswell as abstract methods for ai implementing their
  // own logic.
  public int randomFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  public abstract int selectAiFingers();

  public abstract int selectAiSum();
}
