package com.gildedrose;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BackstagePassesUpdateStrategyTest {
    
    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(11, 50, 10, 50),
            Arguments.of(6, 50, 5, 50),
            Arguments.of(3, 50, 2, 50),
            Arguments.of(11, 35, 10, 36),
            Arguments.of(10, 35, 9, 37),
            Arguments.of(6, 35, 5, 37),
            Arguments.of(5, 35, 4, 38),
            Arguments.of(1, 35, 0, 38),
            Arguments.of(0, 35, -1, 0),
            Arguments.of(-1, 35, -2, 0));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void updateQuality(int sellIn, int quality, int expectedSellIn, int expectedQuality) {

        Item[] items = new Item[] {
            new Item(ItemNames.BACKSTAGE_PASSES, sellIn, quality)
        };

        GildedRose testee = new GildedRose(items);

        testee.updateQuality();
        
        Assertions.assertEquals(expectedSellIn, items[0].sellIn);
        Assertions.assertEquals(expectedQuality, items[0].quality);
    }
}
