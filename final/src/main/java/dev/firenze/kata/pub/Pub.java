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
    // Another day has passed

    // Update quality of the beers
    for (Beer beer : beers) {
      beer.updateQuality();
    }

    for (int i = 0; i < beers.length; i++) {
      Beer beer = beers[i];

      if (beer.getDiscount() > 0) {
        discounts.put(beer.getName(), beer.getDiscount());
      } else {
        discounts.remove(beer.getName());
      }
    }
  }

  /**
   * Get beers
   *
   * @return list of beers
   */
  public Beer[] getBeers() {
    return beers;
  }

  public Map<String, Integer> getDiscounts() {
    return discounts;
  }

}
