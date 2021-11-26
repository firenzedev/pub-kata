package dev.firenze.kata.pub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PubTest {

  @Test
  void beerQualityDecreasesBy2EveryDay() {
    Beer[] beers = new Beer[] {
        new Beer("bohemian lager", 30),
        new Beer("munich traditional", 45)
    };

    Pub pub = new Pub(beers);
    pub.dayPassed();

    assertEquals("bohemian lager", pub.getBeers()[0].getName());
    assertEquals(28, pub.getBeers()[0].getQuality());

    assertEquals("munich traditional", pub.getBeers()[1].getName());
    assertEquals(43, pub.getBeers()[1].getQuality());
  }

  @Test
  void ipaQualityDecreasesBy1EveryDay() {
    Beer[] beers = new Beer[] {
        new Beer("royal ipa", 30)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();
    assertEquals(29, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(28, pub.getBeers()[0].getQuality());
  }

  @Test
  void tripelQualityDoesNotDecrease() {
    Beer[] beers = new Beer[] {
        new Beer("belgian trappist tripel", 100)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();
    assertEquals(100, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(100, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(100, pub.getBeers()[0].getQuality());
  }

  @Test
  void barleyWineQualityIncreasesBy1EveryDay() {
    Beer[] beers = new Beer[]{
        new Beer("barrel aged barley wine", 100)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();
    assertEquals(101, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(102, pub.getBeers()[0].getQuality());
  }

  @Test
  void craftBeerQualityDecreasesBy4EveryDay() {
    Beer[] beers = new Beer[] {
        new Beer("special premium craft beer", 10)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();
    assertEquals(6, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(2, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(0, pub.getBeers()[0].getQuality());
  }

  @Test
  void qualityCannotBeLessThanZero() {
    Beer[] beers = new Beer[]{
        new Beer("bohemian lager", 1),
        new Beer("royal ipa", 1)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();
    assertEquals(0, pub.getBeers()[0].getQuality());
    assertEquals(0, pub.getBeers()[1].getQuality());

    pub.dayPassed();
    assertEquals(0, pub.getBeers()[0].getQuality());
    assertEquals(0, pub.getBeers()[1].getQuality());
  }

  @Test
  void qualityCannotBeGreaterThan200() {
    Beer[] beers = new Beer[]{
        new Beer("barrel aged barley wine", 200)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();
    assertEquals(200, pub.getBeers()[0].getQuality());

    pub.dayPassed();
    assertEquals(200, pub.getBeers()[0].getQuality());
  }

  @Test
  void beersWithQualityLessThan10Have50PercentDiscount() {
    Beer[] beers = new Beer[]{
        new Beer("bohemian lager", 10),
        new Beer("munich traditional", 13),
        new Beer("marzen special", 11)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();

    assertEquals(50, pub.getDiscounts().get("bohemian lager"));
    assertNull(pub.getDiscounts().get("munich traditional"));
    assertEquals(50, pub.getDiscounts().get("marzen special"));
  }

  @Test
  void ipaWithQualityLessThan10AndGreaterThan5HasNoDiscount() {
    Beer[] beers = new Beer[]{
        new Beer("royal ipa", 7)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();

    assertNull(pub.getDiscounts().get("royal ipa"));
  }

  @Test
  void ipaWithQualityLessThan5Have20PercentDiscount() {
    Beer[] beers = new Beer[]{
        new Beer("royal ipa", 5)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();

    assertEquals(20, pub.getDiscounts().get("royal ipa"));
  }

  @Test
  void tripelAndBarleyWineAreNeverDiscounted() {
    Beer[] beers = new Beer[]{
        new Beer("barrel aged barley wine", 1),
        new Beer("belgian trappist tripel", 1)
    };

    Pub pub = new Pub(beers);

    pub.dayPassed();

    assertNull(pub.getDiscounts().get("barrel aged barley wine"));
    assertNull(pub.getDiscounts().get("belgian trappist tripel"));
  }
}
