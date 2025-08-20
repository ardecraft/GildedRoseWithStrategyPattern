package com.gildedrose;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AgedBrieUpdateStrategyTest {

    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(3, 45, 2, 46),
            Arguments.of(1, 47, 0, 48),
            Arguments.of(0, 48, -1, 50),
            Arguments.of(-1, 50, -2, 50));
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    void updateQuality(int sellIn, int quality, int expectedSellIn, int expectedQuality) {

        Item item = new Item(ItemNames.AGED_BRIE, sellIn, quality);

        GildedRose testee = new GildedRose(new Item[] { item });

        testee.updateQuality();

        Assertions.assertEquals(expectedSellIn, item.sellIn);
        Assertions.assertEquals(expectedQuality, item.quality);
    }
}