package dev.firenze.kata.pub;

import java.util.HashMap;
import java.util.Map;

public class Pub {

  private Beer[] beers;
  private Map<String, Integer> discounts;

  public Pub(Beer[] beers) {
    this.beers = beers;
    this.discounts = new HashMap<>();
  }

  public void dayPassed() {
    // Another day has passed

    // Update quality of the beers
    for (int i = 0; i < beers.length; i++) {
      Beer beer = beers[i];

      switch (beer.getName()) {
        case "royal ipa":
          Beer ipaBeer = new IpaBeer(beer.getName(), beer.getQuality());
          ipaBeer.updateQuality();
          beers[i] = ipaBeer;
          break;
        case "belgian trappist tripel":
          Beer tripelBeer = new TripelBeer(beer.getName(), beer.getQuality());
          tripelBeer.updateQuality();
          beers[i] = tripelBeer;
          break;
        case "barrel aged barley wine":
          Beer barleyWineBeer = new BarleyWineBeer(beer.getName(), beer.getQuality());
          barleyWineBeer.updateQuality();
          beers[i] = barleyWineBeer;
          break;
        default:
          Beer commonBeer = new Beer(beer.getName(), beer.getQuality());
          commonBeer.updateQuality();
          beers[i] = commonBeer;
          break;
      }
    }

    for (int i = 0; i < beers.length; i++) {
      Beer beer = beers[i];
      if (beer.getQuality() <= 10) {
        if (!beer.getName().equals("royal ipa")) {
          if (!beer.getName().equals("belgian trappist tripel") && !beer.getName().equals("barrel aged barley wine")) {
            if (discounts.get(beer.getName()) == null || discounts.get(beer.getName()) != 50) {
              // Discount is 40%
              discounts.put(beer.getName(), 50);
            } else {
              if (discounts.get(beer.getName()) == null) {
                discounts.remove(beer.getName());
              }
            }
          }
        } else {
          if (beer.getQuality() <= 5) {
            // Special rule for imperial stout
            if (discounts.get(beer.getName()) == null || discounts.get(beer.getName()) != 20) {
              discounts.put(beer.getName(), 20);
            } else {
              if (discounts.get(beer.getName()) == null) {
                discounts.remove(beer.getName());
              }
            }
          }
        }
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
