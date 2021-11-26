package dev.firenze.kata.pub;

public class BarleyWineBeer extends Beer {

  public BarleyWineBeer(String name, int quality) {
    super(name, quality);
  }

  public void updateQuality() {
    if (getQuality() < 200) {
      setQuality(getQuality() + 1);
    }
  }

}
