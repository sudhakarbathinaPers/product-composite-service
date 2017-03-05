package com.sudhakar.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Rating {

	@JsonProperty("product_id")
    private String product_id;
	
	@JsonProperty("rating")
	private String rating;
	
}
