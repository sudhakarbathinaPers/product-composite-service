package com.sudhakar.store.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.store.model.Composite;
import com.sudhakar.store.service.ProductCompositeService;



@RestController
@RequestMapping("/products/v1")
public class ProductCompositeResource {
	
    private ProductCompositeService service;
    
    public ProductCompositeResource() {
        this(new ProductCompositeService());
	}
	
	public ProductCompositeResource(ProductCompositeService service) {
	        this.service = service;
	}
	

    @RequestMapping( path = "/{id}", method = RequestMethod.GET)
    public Composite getProductById(@PathVariable String id){
         Composite com = service.getProductComposite(id);
        return com;
    }	
 
}

