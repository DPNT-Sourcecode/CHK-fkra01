package io.accelerate.stock;

import java.util.List;

public class StockItem {

  public StockItem(String sku, Integer price, List<SpecialOffer> offers, List<String> dependents) {
    this.sku = sku;
    this.price = price;
    this.offers = offers;
    this.dependents = dependents;
  }

  List<String> dependents;

  public List<String> getDependents() {
    return dependents;
  }

  String sku;

  public String getSku() {
    return sku;
  }

  Integer price;

  public Integer getPrice() {
    return price;
  }

  List<SpecialOffer> offers;

  public List<SpecialOffer> getOffers() {
    return offers;
  }

}

