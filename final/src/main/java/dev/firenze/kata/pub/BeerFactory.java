package dev.firenze.kata.pub;

import java.util.Map;

public class BeerFactory {

  private static final Map<String, Class<? extends Beer>> SPECIAL_BEERS = Map.of(
      "royal ipa", IpaBeer.class,
      "belgian trappist tripel", TripelBeer.class,
      "barrel aged barley wine", BarleyWineBeer.class
  );

  public static Beer create(Beer beer) {
    Class<? extends Beer> beerClass = SPECIAL_BEERS.getOrDefault(beer.getName(), Beer.class);
    try {
      return beerClass.getDeclaredConstructor(String.class, int.class).newInstance(beer.getName(), beer.getQuality());
    } catch (ReflectiveOperationException e) {
      throw new IllegalArgumentException("Cannot create instance of " + beer.getName() + " beer");
    }
  }
}
