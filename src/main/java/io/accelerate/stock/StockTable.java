package io.accelerate.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockTable {
  HashMap<String, StockItem> items = new HashMap<>();

  public StockItem getItem(String sku) {
    return items.get(sku);

  }

  public void addItem(StockItem item) {
    items.put(item.sku, item);
  }

  // Default factory method for the given stock table - likely wouldnt exist in a
  // real project
  public static StockTable defaultTable() {
    var items = List.of(

        new StockItem("A", 50, List.of(new SpecialOffer(3, "A", 130), new SpecialOffer(5, "A", 200))),
        new StockItem("B", 30, List.of(new SpecialOffer(2, "B", 45))),
        new StockItem("C", 20, null),
        new StockItem("D", 15, null),
        new StockItem("E", 40, List.of(new SpecialOffer(2, "B", 0)))

    );
    // Definitely cleaner ways to do this, but this isnt "production" code
    var table = new StockTable();
    for (var item : items) {
      table.addItem(item);
    }
    return table;

  }
}

