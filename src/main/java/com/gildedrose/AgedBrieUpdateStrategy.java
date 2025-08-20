package com.gildedrose;

class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        int qualityIncreaseAmount = item.sellIn >= 0 ? 1 : 2;
        item.quality = Math.min(50, item.quality + qualityIncreaseAmount);
    }
}