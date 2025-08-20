package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;

public class DefaultUpdateStrategyTest {
    
    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(3, 5, 2, 4),
            Arguments.of(1, 3, 0, 2),
            Arguments.of(0, 2, -1, 0),
            Arguments.of(-1, 0, -2, 0));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void updateQuality(int sellIn, int quality, int expectedSellIn, int expectedQuality) {

        Item item = new Item("some other category of items", sellIn, quality);

        GildedRose testee = new GildedRose(new Item[] { item });

        testee.updateQuality();

        Assertions.assertEquals(expectedSellIn, item.sellIn);
        Assertions.assertEquals(expectedQuality, item.quality);
    }
}
