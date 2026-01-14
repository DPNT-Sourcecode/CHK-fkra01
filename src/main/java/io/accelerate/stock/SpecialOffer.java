package io.accelerate.stock;

import java.util.List;

public record SpecialOffer(Integer multiple, String sku, Integer finalPrice, Integer selfNumAffected,
    List<String> grouped) {

}
