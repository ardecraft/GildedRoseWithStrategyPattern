package com.gildedrose;

class ConjuredUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        int qualityDecreaseAmount = item.sellIn >= 0 ? 2 : 4;
        item.quality = Math.max(0, item.quality - qualityDecreaseAmount);
    }
}