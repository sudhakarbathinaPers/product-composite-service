package com.sudhakar.store.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Composite {
	
	@JsonProperty("item")
	private Item item;
	
	@JsonProperty("price")
	private Price price;
	
	@JsonProperty("rating")
	private Rating rating;	
	
	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	

}
