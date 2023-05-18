package nz.ac.auckland.se281;

public abstract class Strategy {

  public int selectAiFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  public abstract int selectAiSum();
}
