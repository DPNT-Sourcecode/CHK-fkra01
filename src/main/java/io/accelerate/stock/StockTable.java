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
}


