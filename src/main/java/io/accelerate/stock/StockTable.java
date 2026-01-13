package io.accelerate.stock;

import java.util.ArrayList;
import java.util.List;

public class StockTable {
  ArrayList<StockItem> items = new ArrayList<>();

  public ArrayList<StockItem> getItems() {
    return items;
  }

  public void addItem(StockItem item) {
    items.add(item);
  }

  // Default factory method for the given stock table - likely wouldnt exist in a
  // real project
  public static StockTable defaultTable() {
    var items = List.of(

        new StockItem("A", 50, List.of(new SpecialOffer(3, 130))),
        new StockItem("B", 30, List.of(new SpecialOffer(2, 45))),
        new StockItem("C", 20, List.of()),
        new StockItem("D", 15, List.of())

    );
    // Definitely cleaner ways to do this, but this isnt "production" code
    var table = new StockTable();
    for (var item : items) {
      table.addItem(item);
    }
    return table;

  }
}




