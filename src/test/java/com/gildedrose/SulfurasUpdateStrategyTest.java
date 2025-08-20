package com.gildedrose;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SulfurasUpdateStrategyTest {
    
    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(1, 80, 1, 80),
            Arguments.of(-1, 80, -1, 80));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void updateQuality(int sellIn, int quality, int expectedSellIn, int expectedQuality) {

        Item[] items = new Item[] {
            new Item(ItemNames.SULFURAS, sellIn, quality)
        };

        GildedRose testee = new GildedRose(items);

        testee.updateQuality();
        
        Assertions.assertEquals(expectedSellIn, items[0].sellIn);
        Assertions.assertEquals(expectedQuality, items[0].quality);
    }
}
