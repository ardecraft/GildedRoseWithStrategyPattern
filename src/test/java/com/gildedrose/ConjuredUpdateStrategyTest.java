package com.gildedrose;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ConjuredUpdateStrategyTest {
    
    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(2, 10, 1, 8),
            Arguments.of(1, 10, 0, 8),
            Arguments.of(0, 10, -1, 6),
            Arguments.of(-1, 10, -2, 6),
            Arguments.of(2, 1, 1, 0),
            Arguments.of(-1, 1, -2, 0));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void updateQuality(int sellIn, int quality, int expectedSellIn, int expectedQuality) {

        Item[] items = new Item[] {
            new Item(ItemNames.CONJURED, sellIn, quality)
        };

        GildedRose testee = new GildedRose(items);

        testee.updateQuality();
        
        Assertions.assertEquals(expectedSellIn, items[0].sellIn);
        Assertions.assertEquals(expectedQuality, items[0].quality);
    }
}
