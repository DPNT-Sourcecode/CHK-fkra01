package io.accelerate.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StockTable {
  HashMap<String, StockItem> items = new HashMap<>();

  public StockItem getItem(String sku) {
    return items.get(sku);

  }

  public void addItem(StockItem item) {
    items.put(item.sku, item);
  }

  public List<String> getProcessingOrder() {
    List<String> out = new ArrayList<>();
    List<String> dependents = new ArrayList<>();
    this.items.values()
        .stream()
        .map((x) -> x.dependents)
        .filter((x) -> x != null).forEach(dependents::addAll);
    var independents = this.items
        .values()
        .stream()
        .filter((x) -> !dependents.contains(x.getSku()))
        .map((x) -> x.getSku())
        .collect(Collectors.toList());
    out.addAll(independents);
    out.addAll(dependents);
    return out;

  }

  // Default factory method for the given stock table - likely wouldnt exist in a
  // real project
  public static StockTable defaultTable() {
    var items = List.of(

        new StockItem("A", 50, List.of(new SpecialOffer(3, "A", 130), new SpecialOffer(5, "A", 200)), null),
        new StockItem("B", 30, List.of(new SpecialOffer(2, "B", 45)), null),
        new StockItem("C", 20, null, null),
        new StockItem("D", 15, null, null),
        new StockItem("E", 40, List.of(new SpecialOffer(2, "B", 0)), List.of("B"))

    );
    // Definitely cleaner ways to do this, but this isnt "production" code
    var table = new StockTable();
    for (var item : items) {
      table.addItem(item);
    }
    return table;

  }
}
