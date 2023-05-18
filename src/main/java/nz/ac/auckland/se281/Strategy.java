package nz.ac.auckland.se281;

public abstract class Strategy {

  public int randomFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  public abstract int selectAiFingers();

  public abstract int selectAiSum();
}
