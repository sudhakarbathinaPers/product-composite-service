package com.sudhakar.store.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sudhakar.store.model.Composite;
import com.sudhakar.store.model.Item;
import com.sudhakar.store.model.Price;
import com.sudhakar.store.model.Rating;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ProductCompositeService {
	
	 private ProductCompositeRestClient restClient;

	 public ProductCompositeService() {
	        this(new ProductCompositeRestClient());
	 }

	 public ProductCompositeService(ProductCompositeRestClient restClient) {
	        this.restClient = restClient;
	 }
	 
	 public Composite getProductComposite(String productID) {
		 Observable<Item> getItem = getItemObservable(productID);
	        Observable<Price> getPrice = getPriceObservable(productID);
	        Observable<Rating> getRating = getRatingObservable(productID);      

	        System.err.println("Get user {}"+ Thread.currentThread().getName());

	        Observable<Composite> fullProduct = Observable.zip(Arrays.asList(getItem, getPrice, getRating), objects -> {

	        	Item item = (Item) objects[0];
	            Price price = (Price)objects[1];
	            Rating rating = (Rating)objects[2];

	            Composite composite = new Composite();
	            composite.setItem(item);
	            composite.setPrice(price);
	            composite.setRating(rating);

	            return composite;
	        });

	        return fullProduct.toBlocking().first();
	  }
	
   
   private Observable<Price> getPriceObservable(String partnumber) {
       return Observable.create((Subscriber<? super Price> s) -> s.onNext(restClient.getPrice(partnumber)))
               .onErrorReturn(throwable -> {
                   //log.error("Failed to retrieve {} followers", login, throwable);
                   return new Price();
               })
               .subscribeOn(Schedulers.computation());
   }
   
   private Observable<Item> getItemObservable(String partnumber) {
       return Observable.create((Subscriber<? super Item> s) -> s.onNext(restClient.getItem(partnumber)))
               .onErrorReturn(throwable -> {
                   //log.error("Failed to retrieve {} followers", login, throwable);
                   return new Item();
               })
               .subscribeOn(Schedulers.computation());
   }
   
   private Observable<Rating> getRatingObservable(String partnumber) {
       return Observable.create((Subscriber<? super Rating> s) -> s.onNext(restClient.getRatings(partnumber)))
               .onErrorReturn(throwable -> {
                   //log.error("Failed to retrieve {} followers", login, throwable);
                   return new Rating();
               })
               .subscribeOn(Schedulers.computation());
   }
   
   private Observable<List<Item>> getProductsObservable() {
       return Observable.create((Subscriber<? super List<Item>> s) -> s.onNext(restClient.getProductBasicList()))
               .onErrorReturn(throwable -> {
                   //log.error("Failed to retrieve {} followers", login, throwable);
                   return new ArrayList<Item>();
               })
               .subscribeOn(Schedulers.computation());
   }
      
}
