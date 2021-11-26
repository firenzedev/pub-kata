package dev.firenze.kata.pub;

public class IpaBeer extends Beer {

  public IpaBeer(String name, int quality) {
    super(name, quality);
  }

  public void updateQuality() {
    if (getQuality() > 0) {
      setQuality(getQuality() - 1);
    }
  }

}
