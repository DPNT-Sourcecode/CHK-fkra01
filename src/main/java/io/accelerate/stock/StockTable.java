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

        new StockItem("A", 50,
            List.of(new SpecialOffer(3, "A", 130, null, null), new SpecialOffer(5, "A", 200, null, null)),
            null),
        new StockItem("B", 30, List.of(new SpecialOffer(2, "B", 45, null, null)), null),
        new StockItem("C", 20, null, null),
        new StockItem("D", 15, null, null),
        new StockItem("E", 40, List.of(new SpecialOffer(2, "B", 0, null, null)), List.of("B")),
        new StockItem("F", 10, List.of(new SpecialOffer(2, "F", 0, 1, null)), null),
        new StockItem("G", 20, null, null),
        new StockItem("H", 10,
            List.of(new SpecialOffer(5, "H", 45, null, null), new SpecialOffer(10, "H", 80, null, null)),
            null),
        new StockItem("I", 35, null, null),
        new StockItem("J", 60, null, null),
        new StockItem("K", 80, List.of(new SpecialOffer(2, "K", 150, null, null)), null),
        new StockItem("L", 90, null, null),
        new StockItem("M", 15, null, null),
        new StockItem("N", 40, List.of(new SpecialOffer(3, "M", 0, null, null)), List.of("M")),
        new StockItem("O", 10, null, null),
        new StockItem("P", 50, List.of(new SpecialOffer(5, "P", 200, null, null)), null),
        new StockItem("Q", 30, List.of(new SpecialOffer(3, "Q", 80, null, null)), null),
        new StockItem("R", 50, List.of(new SpecialOffer(3, "Q", 0, null, null)), List.of("Q")),
        new StockItem("S", 30, List.of(new SpecialOffer(3, "S", 45, null, List.of("S", "T", "X", "Y", "Z"))), null),
        new StockItem("T", 20, List.of(new SpecialOffer(3, "S", 45, null, List.of("S", "T", "X", "Y", "Z"))), null),
        new StockItem("U", 40, List.of(new SpecialOffer(3, "U", 0, 1, null)), null),
        new StockItem("V", 50,
            List.of(new SpecialOffer(2, "V", 90, null, null), new SpecialOffer(3, "V", 130, null, null)),
            null),
        new StockItem("W", 20, null, null),

        new StockItem("X", 90, List.of(new SpecialOffer(3, "X", 45, null, List.of("S", "T", "X", "Y", "Z"))), null),
        new StockItem("Y", 10, List.of(new SpecialOffer(3, "Y", 45, null, List.of("S", "T", "X", "Y", "Z"))), null),
        new StockItem("Z", 50, List.of(new SpecialOffer(3, "Z", 45, null, List.of("S", "T", "X", "Y", "Z"))), null)

    );
    // Definitely cleaner ways to do this, but this isnt "production" code
    var table = new StockTable();
    for (var item : items) {
      table.addItem(item);
    }
    return table;

  }
}

