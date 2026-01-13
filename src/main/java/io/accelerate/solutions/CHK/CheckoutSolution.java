package io.accelerate.solutions.CHK;

import java.util.HashMap;

import io.accelerate.stock.StockItem;
import io.accelerate.stock.StockTable;

public class CheckoutSolution {
    private StockTable table = StockTable.defaultTable();

    public Integer checkout(String skus) {
        HashMap<StockItem, Integer> itemCounts = new HashMap<>();
        if (skus == "") {
            return 0;
        }
        for (String sku : skus.split("")) {
            var item = table.getItem(sku);
            if (item == null) {
                return -1;
            }
            var oldCount = itemCounts.putIfAbsent(item, 1);
            if (oldCount != null) {
                itemCounts.put(item, oldCount + 1);
            }
        }
        var total = 0;

        for (var itemCount : itemCounts.entrySet()) {
            var item = itemCount.getKey();
            var count = itemCount.getValue();
            if (item.getOffer() != null) {
                var offerCount = Math.floorDiv(count, item.getOffer().multiple());
                var regularCount = (count - offerCount * item.getOffer().multiple());
                total += offerCount * item.getOffer().finalPrice();
                total += regularCount * item.getPrice();

            } else {
                total += count * item.getPrice();
            }

        }
        return total;

    }
}



