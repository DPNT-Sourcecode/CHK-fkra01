package io.accelerate.solutions.CHK;

import java.util.HashMap;

import io.accelerate.stock.StockItem;
import io.accelerate.stock.StockTable;

public class CheckoutSolution {
    private StockTable table = StockTable.defaultTable();

    public Integer checkout(String skus) {
        HashMap<StockItem, Integer> itemCount = new HashMap<>();
        for (String sku : skus.split("")) {
            var item = table.getItem(sku);
            var oldCount = itemCount.putIfAbsent(item, 1);
            if (oldCount != null) {
                itemCount.put(item, oldCount++);
            }
        }

    }
}

