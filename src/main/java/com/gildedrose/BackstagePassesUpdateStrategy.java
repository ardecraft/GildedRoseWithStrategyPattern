package com.gildedrose;

/**
 * Updates the given item according to the following rules:

 *   - Quality of an item is never more than 50
 *   - Quality of an item is never negative
 *   - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
 *   - Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
 *     Quality drops to 0 after the concert
 */
class BackstagePassesUpdateStrategy implements ItemUpdateStrategy {
	
    @Override
    public void update(Item item) {
    	
    	if (item.sellIn <= 0) {
    		item.quality = 0;
    	}
    	else {
    		int qualityIncrement = getQualityIncrement(item);
    		item.quality = Math.min(item.quality + qualityIncrement, 50);
    	}
    	
    	item.sellIn--;
    }
    
    private int getQualityIncrement(Item item) {
    	
    	int qualityIncrement = item.sellIn <= 5
    			? 3
    			: item.sellIn <= 10
    				? 2
    				: 1;
    	
    	return qualityIncrement;
    }
}