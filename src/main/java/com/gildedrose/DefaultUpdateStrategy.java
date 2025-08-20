package com.gildedrose;

class DefaultUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        int qualityDecreaseAmount = item.sellIn >= 0 ? 1 : 2;
        item.quality = Math.max(0, item.quality - qualityDecreaseAmount);
    }
}