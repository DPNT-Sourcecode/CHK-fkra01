package io.accelerate.stock;

import java.util.ArrayList;

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
    var items = List.of();

  }
}



