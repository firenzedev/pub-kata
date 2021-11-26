package dev.firenze.kata.pub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pub {

  private Beer[] beers;
  private Map<String, Integer> discounts;

  public Pub(Beer[] beers) {
    this.beers = Arrays.stream(beers).map(BeerFactory::create).toArray(Beer[]::new);
    this.discounts = new HashMap<>();
  }

  public void dayPassed() {
    discounts = new HashMap<>();
    for (Beer beer : beers) {
      beer.updateQuality();
      if (beer.getDiscount() > 0) {
        discounts.put(beer.getName(), beer.getDiscount());
      }
    }
  }

  public Beer[] getBeers() {
    return beers;
  }

  public Map<String, Integer> getDiscounts() {
    return discounts;
  }

}
