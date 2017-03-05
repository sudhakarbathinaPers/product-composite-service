package com.sudhakar.store.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.sudhakar.store.model.Item;
import com.sudhakar.store.model.Price;
import com.sudhakar.store.model.Rating;

public class ProductCompositeRestClient {

    public static final String API_PRICE = "http://localhost:9004/item/price/v1/";
    public static final String API_ITEM = "http://localhost:9000/item/basic/v1/";
    public static final String API_RATINGS = "http://localhost:9002/item/ratings/v1/";    
    
	private final RestTemplate restTemplate;
	  
	public ProductCompositeRestClient() {
	        this(new RestTemplate());
	}

	public ProductCompositeRestClient(RestTemplate restTemplate) {
	    this.restTemplate = restTemplate;
	}
	
    public List<Item> getProductBasicList() {
        System.err.println("Get Products {}"+Thread.currentThread().getName());
        return Arrays.asList(restTemplate.getForObject(API_ITEM, Item[].class));
    }	
    	    
    public Item getItem(String partnumber) {
        System.err.println("Get Item {}"+Thread.currentThread().getName());
        return restTemplate.getForObject(API_ITEM+partnumber, Item.class);
    }
    
    public Price getPrice(String partnumber) {
        System.err.println("Get Price {}"+Thread.currentThread().getName());
        return restTemplate.getForObject(API_PRICE+partnumber, Price.class);
    }
      
    public Rating getRatings(String partnumber) {
        System.err.println("Get Ratings {}"+Thread.currentThread().getName());
        Rating rating = restTemplate.getForObject(API_RATINGS+partnumber, Rating.class);
        return rating;
    }
    	
}
