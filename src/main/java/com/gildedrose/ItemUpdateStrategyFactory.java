package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdateStrategyFactory {
    
    private Map<String, ItemUpdateStrategy> strategies = new HashMap<>();

    private ItemUpdateStrategy defaultStrategy = new DefaultUpdateStrategy();

    public ItemUpdateStrategyFactory() {
        strategies.put(ItemNames.AGED_BRIE, new AgedBrieUpdateStrategy());
        strategies.put(ItemNames.BACKSTAGE_PASSES, new BackstagePassesUpdateStrategy());
        strategies.put(ItemNames.CONJURED, new ConjuredUpdateStrategy());
        strategies.put(ItemNames.SULFURAS, new SulfurasUpdateStrategy());
    }

    public ItemUpdateStrategy getItemUpdateStrategy(Item item) {
        return strategies.getOrDefault(item.name, defaultStrategy);
    }
}
