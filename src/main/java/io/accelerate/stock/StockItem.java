package io.accelerate.stock;

import java.util.List;

public class StockItem {

  public StockItem(String sku, Integer price, List<SpecialOffer> offers) {
    this.sku = sku;
    this.price = price;
    this.offers = offers;
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
