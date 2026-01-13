package io.accelerate.stock;

import java.util.List;

public class StockItem {

  public StockItem(String sku, Integer price, SpecialOffer offer) {
    this.sku = sku;
    this.price = price;
    this.offer = offer;
  }

  String sku;

  public String getSku() {
    return sku;
  }

  Integer price;

  public Integer getPrice() {
    return price;
  }

  SpecialOffer offer;

  public SpecialOffer getOffer() {
    return offer;
  }

}
