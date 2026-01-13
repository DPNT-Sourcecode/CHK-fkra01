package io.accelerate.stock;

import java.util.ArrayList;

public class StockItem {
  String sku;

  public String getSku() {
    return sku;
  }

  Integer price;

  public Integer getPrice() {
    return price;
  }

  ArrayList<SpecialOffer> offers;

  public ArrayList<SpecialOffer> getOffers() {
    return offers;
  }

}
