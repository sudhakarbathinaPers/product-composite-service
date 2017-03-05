package com.sudhakar.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Price {

	@JsonProperty("product_id")
    private String product_id;
	
	@JsonProperty("price")
	private String price;

}
