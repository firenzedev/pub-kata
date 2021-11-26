package dev.firenze.kata.pub;

public class Beer {

  private int quality;
  private String name;

  public Beer(String name, int quality) {
    this.name = name;
    this.quality = quality;
  }

  public String getName() {
    return name;
  }

  public int getQuality() {
    return quality;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }

  public void updateQuality() {
    if (getQuality() > 1) {
      setQuality(getQuality() - 2);
    } else {
      setQuality(0);
    }
  }

  public int getDiscount() {
    return 0;
  }

}
