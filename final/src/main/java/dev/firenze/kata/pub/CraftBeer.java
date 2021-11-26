package dev.firenze.kata.pub;

public class CraftBeer extends Beer {

  public CraftBeer(String name, int quality) {
    super(name, quality);
  }

  public void updateQuality() {
    if (getQuality() > 3) {
      setQuality(getQuality() - 4);
    } else {
      setQuality(0);
    }
  }

  public int getDiscount() {
    if (getQuality() <= 20) {
      return 35;
    }

    return 0;
  }

}
