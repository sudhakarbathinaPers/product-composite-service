package com.sudhakar.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductBasic {
	
	@JsonProperty("product_id")
	private String product_id;
	
	@JsonProperty("name")
	private String name;

	@Override
    public String toString() {
        return "Item [product_id=" + product_id + ", name=" + name +"]";
    }
}
