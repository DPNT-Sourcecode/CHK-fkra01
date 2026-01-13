package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.accelerate.stock.StockItem;
import io.accelerate.stock.StockTable;
import io.accelerate.stock.*;

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

        HashMap<StockItem, Integer> accountedFor = new HashMap<>();

        for (var itemCount : itemCounts.entrySet()) {
            var item = itemCount.getKey();
            var count = itemCount.getValue() - accountedFor.getOrDefault(item, 0);
            // var offer = selectOffer(item.getOffers());
            if (item.getOffers() != null) {
                var offers = item.getOffers().stream()
                        .sorted((x, y) -> Integer.compare(x.multiple(), y.multiple()))
                        .collect(Collectors.toList()).reversed();
                for (var offer : offers) {
                    var offerCount = Math.floorDiv(count, offer.multiple());
                    if (offer.sku().equals(item.getSku())) {
                        total += offerCount * offer.finalPrice();
                        total += count * item.getPrice();
                    } else {
                        var relevantItem = table.getItem(offer.sku());
                        offerCount = Integer.min(offerCount, itemCounts.getOrDefault(relevantItem, 0));
                        var oldAccounted = accountedFor.putIfAbsent(item, offerCount);
                        if (oldAccounted != null) {
                            accountedFor.put(relevantItem, oldAccounted + offerCount);
                        }

                        total += offerCount * offer.finalPrice();
                        total += offerCount * offer.multiple() * item.getPrice();
                    }
                    count -= (offerCount * offer.multiple());

                }

            } else {

                total += count * item.getPrice();
            }
        }
        return total;

    }

    private SpecialOffer selectOffer(List<SpecialOffer> offers) {
        if (offers == null) {
            return null;
        }
        return offers.stream().max((x, y) -> Integer.compare(x.multiple(), y.multiple())).get();
    }

}

