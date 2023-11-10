package com.Test.Test.Controller;

import com.Test.Test.Model.Product;
import com.Test.Test.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String hello(){
        return "hola";
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/saveproducts")
    public String saveProducts(@RequestBody Product product){
        productRepository.save(product);
        return "Saved_Product";

    }
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable long id,@RequestBody Product product){
        Product updateProduct = productRepository.findById(id).get();
        updateProduct.setName(product.getName());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
        productRepository.save(updateProduct);
        return "producto actualizado";
    }




    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        Product deleteProduct = productRepository.findById(id).get();
        productRepository.delete(deleteProduct);
        return "producto eliminado";
    }
}
