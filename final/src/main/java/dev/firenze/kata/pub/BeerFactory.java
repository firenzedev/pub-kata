package dev.firenze.kata.pub;

public class BeerFactory {

  public static Beer create(Beer beer) {
    switch (beer.getName()) {
      case "royal ipa":
        return new IpaBeer(beer.getName(), beer.getQuality());
      case "belgian trappist tripel":
        return new TripelBeer(beer.getName(), beer.getQuality());
      case "barrel aged barley wine":
        return new BarleyWineBeer(beer.getName(), beer.getQuality());
      default:
        return new Beer(beer.getName(), beer.getQuality());
    }
  }

}
